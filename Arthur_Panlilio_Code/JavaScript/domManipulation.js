window.onload = function(){
    //alert('Js is loaded');
    //add event listener to button
    document.getElementById('login').addEventListener(
        "click", getUserInfo, true);

}

function getUserInfo(){
    console.log("in get user function")
    var uname = document.getElementById("username").value;
    var pw = document.getElementById("password").value;
    console.log(uname);
    console.log(pw);
}
