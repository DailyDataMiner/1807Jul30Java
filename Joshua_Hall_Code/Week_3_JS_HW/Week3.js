//Javascript Homework
//Due Monday 8/20 -- to be pushed by 5PM in your branch
/*
-----------------------------------------------------------------------------------
Create an HTML file that takes in input and carries out at least 8
of the following functions and manipulates the DOM to show the outcome.
(Can include #1, though we've completed it together in class)
Please put the question itself as a comment above each answer.
-----------------------------------------------------------------------------------
*/

window.onload = function () {
    $('#B1').on('click', function () { $('#A1').html(`${fib($('#I1').val())}`); });
    $('#B2').on('click', function () { $('#A2').html(`${bubbleSort($('#I2').val().split(" "))}`); });
    $('#B3').on('click', function () { $('#A3').html(`${reverseStr($('#I3').val())}`); });
    $('#B4').on('click', function () { $('#A4').html(`${factorial($('#I4').val())}`); });
    $('#B6').on('click', function () { $('#A6').html(`${isEven($('#I6').val())}`); });
    $('#B7').on('click', function () { $('#A7').html(`${isPalindrome($('#I7').val())}`); });
    $('#B10').on('click', function () { $('#A10').html(`${deleteElement($('#I10').val().split(" "))}`); });
    $('#B11').on('click', function () { $('#A11').html(`${spliceElement($('#I11').val().split(" "))}`); });
    $('#B15').on('click', function () { $('#A15').html(`${descending($('#I15').val())}`); });
}

/*
1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/
function fib(n) {
    var a = 0, b = 1, c = 0;
    for (var i = 1; i < n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/
function bubbleSort(numArray) {
    for (var j = numArray.length - 1; j > 0; j--) {
        for (var i = 0; i < j; i++) {
            if (numArray[i] > numArray[i + 1]) {
                let temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
            }
        }
    }
    return numArray;
}

/*
3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/
function reverseStr(someStr) {
    if (someStr.length > 1) {
        // split string in half and make the two halves swap positions
        var center = someStr.length / 2;
        someStr = someStr.concat(someStr.substring(0, center));
        someStr = someStr.substring(center);
        // the center shifts when you reverse Strings of odd length
        center += someStr.length % 2;
        // recursively call reverse function on each half-string
        someStr = someStr.replace(someStr.substring(0, center), reverseStr(someStr.substring(0, center)));
        someStr = someStr.substring(0, center) +
            someStr.substring(center).replace(someStr.substring(center), reverseStr(someStr.substring(center)));
    }
    return someStr;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/
function factorial(someNum) {
    return someNum <= 1 ? 1 : someNum * factorial(someNum - 1);
}

/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum) {
    return someNum == someNum >> 1 << 1;
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(someStr) {
    return someStr == reverseStr(someStr);
}

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape. Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *
*/

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/
function deleteElement(someArr) {
    console.log(someArr.length);
    delete someArr[3];
    console.log(someArr.length);
    return someArr;
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/
function spliceElement(someArr) {
    console.log(someArr.length);
    someArr.splice(3, 1);
    console.log(someArr.length);
    return someArr;
}

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);
*/

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable john:
	var john = getPerson("John", 30);
 */

/*
14. Display the current time on the top right of your HTML page, 
updating every second
*/

/*
15.  Descending order
Your task is to make a function that can take any non-negative 
integer as a argument and return it with its digits in descending 
order. Essentially, rearrange the digits to create the highest possible number.
 */

function descending(someNum) {
    return parseInt(reverseStr(bubbleSort(someNum.toString().split("")).join("")));
}