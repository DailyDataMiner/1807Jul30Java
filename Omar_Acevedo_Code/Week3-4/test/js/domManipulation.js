window.onload = function() {
    alert('hey');
    document.getElementById("yay1").addEventListener("click", getUserInfo, true);

}

function getUserInfo() {
    var uname = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    alert(uname);
    alert(password);
}

function createObject() {
    // var 
}