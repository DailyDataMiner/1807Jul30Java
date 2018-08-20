window.onload = function(){
 alert   ('JS is loaded');
 this.document.getElementById("login").addEventListener("click", getUserInfo, true);

}
 function getUserInfo(){
// console.log
    var uname = document.getElementById("username");
var pw = document.getElementById("password");
console.log(uname);
console.log(pw);
}