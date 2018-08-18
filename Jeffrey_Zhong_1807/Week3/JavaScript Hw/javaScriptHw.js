window.onload = function(){
    getTime();
}


document.getElementById("Fib").addEventListener("click", fibonacci, true);

function fibonacci() {
    var fibvalue = document.getElementById("FibIn").value;
    var value1 = 0;
    var value2 = 0;
    var value3 = 1;

    for (var i = 0; i < fibvalue; i++) {
        value1 = value2 + value3;
        value3 = value2;
        value2 = value1;

    }

    document.getElementById("FibOut").innerHTML = value1;
}

document.getElementById("BSB").addEventListener("click", bubblesort, true);

function bubblesort() {

    var BSi = (document.getElementById("BSI").value).split(" ");
    for (let i = 0; i < BSi.length; i++) {
        for (let i = 0; i < BSi.length - 1; i++) {


            if (BSi[i] > BSi[i + 1]) {
                let temp = parseInt(BSi[i + 1]);
                BSi[i + 1] = parseInt(BSi[i]);
                BSi[i] = temp;

            }
        }
    }
    document.getElementById("BSout").innerHTML = BSi;
}

document.getElementById("rsbut").addEventListener("click", reverse, true);

function reverse() {
    let revstring = "";
   let rsArr = (document.getElementById("rsin").value).split("");
   for(let i = rsArr.length-1; i >= 0; i--){
        revstring += rsArr[i];
   }

    
    document.getElementById("rsout").innerHTML = revstring;
}


document.getElementById("factbut").addEventListener("click", fact, true);

function fact() {
    factorial(parseInt(document.getElementById("factin").value));
}


    function factorial(num) {
      let sum;
    if (num == 0) 
      return 1;
    
    else {  
        sum = (num * factorial(num - 1));
        
    }
    document.getElementById("factout").innerHTML = sum;
    return sum;
}



document.getElementById("ssbut").addEventListener("click", substrings, true);

function substrings() { 
var length = parseInt(document.getElementById("ssl").value)
var offset = parseInt(document.getElementById("sso").value)
var ss = (document.getElementById("ssS").value).substring(length,length + offset)
document.getElementById("ssout").innerHTML = ss;

}


document.getElementById("evenbut").addEventListener("click", evennumber, true);

function evennumber() {
    let num = document.getElementById("evenin").value;
    num = num / 2;
   
    if((String(num).includes(".")) ==true){
        document.getElementById("evenout").innerHTML = false;
    }
    else{
        document.getElementById("evenout").innerHTML = true;
    }
}

function Person(name, age){
    this.Name = name;
    this.Age = age;
}
var john = new Person("John", 30);


function getPerson(name, age){
   var person = {Name : name, Age : age};
   return person;
}


function getTime(){
    let now = new Date().toLocaleTimeString();
    document.getElementById("time").innerHTML = now;
    setTimeout(getTime, 1000);
}



$("#dobut").on('click', descendingOrder)
    
function descendingOrder(){
    let num = $("#doin").val();
    arrnum = num.split("");

    for (let i = 0; i < arrnum.length; i++) {
        for (let i = 0; i < arrnum.length - 1; i++) {


            if (arrnum[i] < arrnum[i + 1]) {
                let temp = parseInt(arrnum[i + 1]);
                arrnum[i + 1] = parseInt(arrnum[i]);
                arrnum[i] = temp;

            }
        }
    }
    var numsort = ""
    for (let i = 0; i < arrnum.length; i++) {
        numsort = numsort + arrnum[i];
    }
    document.getElementById("doout").innerHTML = numsort;



}









