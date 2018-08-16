window.onload = function(){
    //alert('Js is loaded');
    //add event listener to button
    document.getElementById('fibonacciButton').addEventListener(
        "click",fib,true);
    document.getElementById('bubbleButton').addEventListener(
        "click", bubbleSortInit, true);
    document.getElementById('reverseButton').addEventListener(
        "click", reverseString, true);
    document.getElementById('factorialButton').addEventListener(
        "click", factorial, true);
    document.getElementById('substringButton').addEventListener(
        "click", substring, true);
    document.getElementById('isEvenButton').addEventListener(
        "click", isEven, true);
    document.getElementById('isPalindromeButton').addEventListener(
        "click", isPalindrome, true);
    document.getElementById('personButton').addEventListener(
        "click", personMaker, true);
    document.getElementById('shapeButton').addEventListener(
        "click", printShape, true);
}

window.addEventListener("load", startTime);


/**1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
 */
function fib(n){

    n = parseInt(document.getElementById('fibonacciInput').value);
    var fibb = fibonacci(n);
    document.getElementById('fibonacciOutput').innerHTML = fibb;

}
function fibonacci(n) {
    if(n <= 2) {
        return 1;
    } else {
        return this.fibonacci(n - 1) + this.fibonacci(n - 2);
    }
  }

/**2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSortInit(){
    var input = document.getElementById("bubbleInput").value;
    var arr = input.split(',').map(Number);
    bubbleSort(arr);
}
function bubbleSort(arr){
    var swapped;

    do {
        swapped = false;
        for (var i=0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                var temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
    document.getElementById("bubbleOutput").innerHTML = arr;
}

/**3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String. */
function reverseString(input){
    var input = document.getElementById("reverseInput").value;
    document.getElementById("reverseOutput").innerHTML = input.split("").reverse().join("");
}

/**4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */
function factorial(someNum){
    var someNum = document.getElementById("factorialInput").value;
    var num = factorialize(someNum);
    document.getElementById("factorialOutput").innerHTML = num;
}

function factorialize(num) {
    if (num < 0) 
          return -1;
    else if (num == 0) 
        return 1;
    else {
        return (num * factorialize(num - 1));
    }
  }

  /**5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect. */
function substring(someStr, length, offset){
    var someStr = document.getElementById("substringTextInput").value;
    var length = parseInt(document.getElementById("substringLengthInput").value);
    var offset = parseInt(document.getElementById("substringOffsetInput").value);
    var newString = '';
    var arr = someStr.split(''); 
    if(offset < 0 || length < 0 || offset + length > someStr.length){
        alert("Numbers are either negative or when they're added they're bigger than string length");
        return;
    }
    for(let i = offset; i <= offset + length; i++){
        newString += arr[i];
    }
    document.getElementById("substringOutput").innerHTML = newString;

}

/**6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */
function isEven(someNum){
    var someNum = parseInt(document.getElementById("isEvenInput").value);
    if(Math.floor(someNum/2)*2 == someNum){
        document.getElementById("isEvenOutput").innerHTML = "True";
    } else {
        document.getElementById("isEvenOutput").innerHTML = "False";
    }
}

/**7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false */
function isPalindrome(someStr){
    var someStr = document.getElementById("isPalindromeInput").value;
    var str1 = someStr.split('').reverse().join("");
    if(someStr==str1){
        document.getElementById("isPalindromeOutput").innerHTML = "True";
    } else{
        document.getElementById("isPalindromeOutput").innerHTML = "False";
    }
}

/**8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape. */
function printShape(shape, height, character){
    var shape = document.querySelector('input[name="shapeInput"]:checked').value;
    var height = parseInt(document.getElementById("shapeHeightInput").value);
    var character = document.getElementById("shapeCharacterInput").value;
    if(shape==="square"){  
        var line = "";
        for(let i = 0; i < height; i++){
            line+=character;
        }
        for(let i = 0; i < height; i++){
            console.log(line);
        }
    }
    if(shape==="triangle"){
        var line = character;
        for(let i = 0; i < height; i++){
            console.log(line);
            line+=character;
        }
    }
    if(shape==="diamond"){
        var lenH = character.length;
        var line = " ";
        var split = Math.ceil(height/2);
        var splits = [split];
        for(let i = 0; i < split; i++ ){
            for(let i = 0; i <= height; i++){
                if(splits.includes(i)){
                    line+=character;
                } else {
                    line+=" ";
                }
            }
   
            splits.push(split+(i+1), split-(i+1)); 
            console.log(line)
            line = " ";
        }
        splits.pop();
        splits.pop();
        for(let i = 0; i < split; i++ ){
            for(let i = 0; i <= height; i++){
                if(splits.includes(i)){
                    line+=character;
                } else {
                    line+=" ";
                }
            }
   
            splits.pop();
            splits.pop();
            console.log(line)
            line = " ";
        }
    }
}


/**12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30); */
function person(name, age){
    this.name = name;
    this.age = age;
}

function personMaker(){
    var name = document.getElementById('personNameInput').value;
    var age  = parseInt(document.getElementById('personAgeInput').value);
    var p = new person(name, age);
    document.getElementById('personOutput').innerHTML =  p.name + " is " + p.age + " years old!";
}

/**
14. Display the current time on the top right of your HTML page, 
updating every second
 */
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById('clock').innerHTML = h + ":" + m + ":" + s;
    var t = setTimeout(startTime, 500);
}
function checkTime(i) {
    if (i < 10) {i = "0" + i}; 
    return i;
}