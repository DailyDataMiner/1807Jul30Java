window.onload = function () {
    $("#logIn").on("click", logIn);
}

function logIn() {
    //Log in function
    let username = $("#username").val();
    let password = $("#password").val();
    if (username.length > 0 && password.length > 0) {
        //send ajax request to get user by username
        $("#message").attr("hidden", "true");

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                var user = JSON.parse(xhr.responseText);
                if (arr.length == 1) {
                    //got back user
                    let user = arr[0];
                    if (user.password = password) {
                        //successful login
                        $("#message").attr("hidden", "true");
                        console.log("logged in");
                        $("#landingView").attr("hidden", true);
                        $("#homeView").removeAttr("hidden");
                        $("#greeting").html(`Welcome ${user.firstName}`)
                    }
                    else {
                        var elem = $("#message");
                        elem.removeAttr("hidden");
                        elem.html("Invalid credentials!");
                    }
                }
                else {
                    //do not have user by username OR there ismore than 1
                    //which is also bad
                    var elem = $("#message");
                    elem.removeAttr("hidden");
                    elem.html("Sorry, you have an invalid username!");
                }
            }
        }

        xhr.open("GET", `https://localhost:3000/users?username=${username.toLowerCase()}`, true);
        xhr.send();


    }
    else {
        //tell user to not attempt to submit enpty fields
        var elem = $("#message");
        elem.removeAttr("hidden");
        elem.html("Please fill out all form fields!");
        //innerHTML = text is vanilla JS.  html(text) is jQuery version

    }
}