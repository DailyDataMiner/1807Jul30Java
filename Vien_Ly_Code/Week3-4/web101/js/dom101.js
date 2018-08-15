window.onload = function() {
    this.alert('JS is loaded');
    document.getElementById('login').addEventListener(
        "click", getUserInfo, true);
}

function getUserInfo() {
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    console.log(username);
    console.log(password);
    alert("whats up");
}