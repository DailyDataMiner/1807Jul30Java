window.onload = function() {
    //this.alert("JS is loaded");

    document.getElementById("loginbutton").addEventListener(
        "click", getUserInfo);
}

    function getUserInfo() {
        console.log("In get user function");
        var uname = document.getElementById("username").value;
        var pass = document.getElementById("password").value;
    }
