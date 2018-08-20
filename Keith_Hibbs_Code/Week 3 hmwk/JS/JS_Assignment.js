//    "use strict"
window.onload = function(){

}
// 1. Fibonacci 
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.
function fib(n){
    let  x = 0;
	let  y = 1;
console.log("0 ");	
	for (let i = 1 ; i <= n ; i++ ) {
		 z = x;
		x += y;
		y = z;
		console.log(x + " ");
	}
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.
function bubbleSort(numArray) {
    	
	for (let i= 0; i <numArray.length, i++;) {
	for (let j = 1; j < (numArray.length -1); j++) {
if (arr[j-1] > arr[j]) {
	let x = arr[j-1];
arr[j-1] = arr[j];
arr[j] = x;

}	
	}

}
	console.log(Arrays.toString(arr));
};
// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String.
function reverseStr(someStr){
    let reversed = '';
    for (let i = someStr.length - 1; i >= 0; i--){
        reversed += someStr[i];
    }
    return reversed;
}
// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.
function factorial(someNum) {
    if (someNum == 0) return 1;
    let sum;
    sum = (SomeNum * factorial(someNum-1));
    return sum;
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
function isEven(x){
 return (x & 1) == 0;
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false
function isPalindrome(someStr){
    for (let i = 0; i<(someStr.length / 2); i++) {
        if (someStr[i] != someStr[someStr.length - i - 1]) {
return false;
        } 
    }
return true;
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.
function traverseObject(john){
console.log(`Johns's name is ${john.Name}, he is ${john.age}`)
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
// var john = new Person("John", 30);
function Person(name, age) {
    this.name=name;
    this.age=age;
}



// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
// var john = getPerson("John", 30);
function getPerson(name, age){
var john = {Name:"John", age:30};
};

// 15.  Descending order
// Your task is to make a function that can take any non-negative 
// integer as a argument and return it with its digits in descending 
// order. Essentially, rearrange the digits to create the highest possible number.
function Descending(numArray){


for (let i= 0; i <numArray.length, i++;) {
	for (let j = 1; j < (numArray.length -1); j++) {
if (arr[j-1] < arr[j]) {
	let x = arr[j-1];
arr[j-1] = arr[j];
arr[j] = x;

}	
    }
}}