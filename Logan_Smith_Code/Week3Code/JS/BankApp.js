window.onload = function () {
    $("#login").on("click", logIn);
    $("#registerView").on("click", showRegisterView);
}

function showRegisterView() {
    $("#login").detach();
    $("#registerView").detach();
    $("#firstname").removeAttr("hidden");
    $("#lastname").removeAttr("hidden");
    $("#register").removeAttr("hidden");
    $("#register").on("click", register);
    $("#username").on("blur", validateUsername);
}

function validateUsername() {
    let username = $("#username").val();
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            var arr = JSON.parse(xhr.responseText);
            if (arr.length == 1) {
                var elem = $("#message");
                elem.html("Username taken!");
                elem.removeAttr("hidden");
            }
            else {
                $("#message").attr("hidden", "true");
            }
        }
    }
    xhr.open("GET", `http://localhost:3000/users?username=${username.toLowerCase()}`, true);
    xhr.send();
}

function register() {
    let un = $("#username").val();
    let pw = $("#password").val();
    let fn = $("#firstname").val();
    let ln = $("#lastname").val();
    let user = {
        firstName: fn,
        lastName: ln,
        username: un,
        password: pw
    }
    let reqBody = JSON.stringify(user);
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 201) {
            console.log("Reached!");
            let user = JSON.parse(xhr.responseText);
            $("#landingView").attr("hidden", true);
            $("#homeView").removeAttr("hidden");
            $("#greeting").html(`Welcome ${user.firstName}!`);
        }
    }
    xhr.open("POST", "http://localhost:3000/users", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(reqBody);
}

function logIn() {
    let username = $("#username").val();
    let password = $("#password").val();
    if (username.length > 0 && password.length > 0) {
        $("#message").attr("hidden", "true");

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var arr = JSON.parse(xhr.responseText);
                if (arr.length == 1) {
                    let user = arr[0];
                    if (user.password == password) {
                        console.log("Logged In!");
                        $("#landingView").attr("hidden", true);
                        $("#homeView").removeAttr("hidden");
                        $("#greeting").html(`Welcome ${user.firstName}!`);
                    }
                    else {
                        var elem = $("#message");
                        elem.html("Incorrect username and password!");
                        elem.removeAttr("hidden");
                    }
                }
                else {
                    var elem = $("#message");
                    elem.html("User does not exist!");
                    elem.removeAttr("hidden");
                }
            }
        }
        xhr.open("GET", `http://localhost:3000/users?username=${username.toLowerCase()}`, true);
        xhr.send();

    }
    else {
        var elem = $("#message");
        elem.html("Please input a Username and Password!");
        elem.removeAttr("hidden");
    }
}