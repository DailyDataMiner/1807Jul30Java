window.onload = function() {
    //alert('JS is loaded!');
    //ADD event listener to button
    //addEventListener(event, function, propagate)
    document.getElementById("login").addEventListener(
        "click", getUserInfo, true);
}

function getUserInfo() {
    var uname = getElementById("username").value;
    var pw = getElementById("password").value;
    console.log(uname);
    console.log(pw);
}