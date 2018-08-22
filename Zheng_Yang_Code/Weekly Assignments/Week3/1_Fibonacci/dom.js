window.onload = function(){

    /*1. Fibonacci 
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence. */
    document.getElementById("disFib").addEventListener(
        "click", calculate, true);
    
 }


//  get summary of two numbers
 function calculate(){
  
    /*1. Fibonacci 
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence. */
    console.log("fib(n)");
    var fib = document.getElementById("fib").value;
    var number = +fib;
    //display javascript text on div
    

    
    var previous_first = 0, previous_second = 1, next = 1;
    var dis = '';
    for(var i = 2; i <= number; i++) {
        next = previous_first + previous_second;
        previous_first = previous_second;
        previous_second = next;
        dis += next + ',';
    }
    document.getElementById("yourOutputDiv").innerHTML = 1 + ',' +  dis;


}


