window.onload = () => {
    $("#login").on("click", login);
    $("#registerButton").on("click", displayRegister);
    $("#regUsername").on("blur", validateUsername);
    $("#register").on("click", register);
}

function register() {
    console.log("registering");
    let fn = $("#firstname").val();
    let ln = $("#lastname").val();
    let uname = $("#regUsername").val();
    let pwd = $("#regPassword").val();

    let user = {
        first: fn,
        last: ln,
        username: uname,
        password: pwd
    };

    let reqBody = JSON.stringify(user);

    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 201) {
            let user = JSON.parse(xhr.responseText);
            userSession(user);

        }

    }
    xhr.open("POST", "http://localhost:3000/users", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(reqBody);

}

function validateUsername() {
    console.log('blurred');
    let username = $("#regUsername").val();
    console.log(username);
    let url = `http://localhost:3000/users?username=${username.toLowerCase()}`;
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let found = JSON.parse(xhr.responseText);
            if (found.length > 0) {
                displayError("user already exists");
            }
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
}

function displayRegister() {
    console.log("reg");
    $("#loginPanel").addClass("d-none");
    $("#registerPanel").removeClass("d-none");
}

function login() {
    console.log('asd');
    let errorMessage = $("#message");

    let username = $("#username").val();
    let password = $("#password").val();
    let url = `http://localhost:3000/users?username=${username.toLowerCase()}`;
    console.log(url);
    if (username.length > 0 && password.length > 0) {
        errorMessage.addClass("d-none");

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = () => {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                let arr = JSON.parse(xhr.responseText);

                if (arr.length == 1) {
                    let user = arr[0];
                    if (user.password == password) {
                        userSession(user);
                    } else {
                        displayError("wrong password");
                    }
                }
            }
        }

        xhr.open("GET", url, true);
        xhr.send();

    } else {
        displayError("fill out credentials")
    }
}

function displayError(message) {
    $("#message").text(message);
    $("#message").removeClass("d-none");
}

function userSession(user) {
    $("#landingView").addClass("d-none");
    $("#userView h5").text(`Welcome ${user.first} ${user.last}`);
    $("#userView").removeClass("d-none");
}
