/* 1. Fibonacci 
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence. */

    $("#calcFib").on('click', function(){
        var num = $("#fibNum").val()-1;
        let myFibNum = fib(num);
        $("#fib").html(myFibNum);
    });
    function fib(n) {
        if (n <= 1) { return n; }
        else { return (fib(n-1) + fib(n-2)); }
    };


/* 2. Bubble Sort
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array.
    Return the sorted array. */


/* 3. Reverse String
    Define function: reverseStr(someStr)
    Reverse and return the String. */


/* 4. Factorial
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum. */
    $("#calcFact").on('click', function(){
        var num = $("#fact").val();
        let myFact = fact(num);
        alert(myFact);
    });
    function fact(n) {
        if (n<=1) { return 1; }
        else { return n*fact(n-1); }
    }


/* 5. Substring
    Define function substring(someStr, length, offset)
    Return the substring contained between offset and (offset + length) inclusively.
    If incorrect input is entered, use the alert function and describe why the input was incorrect. */


/* 6. Even Number
    Define function: isEven(someNum)
    Return true if even, false if odd.
    Do not use % operator. */
    $("#calcIsEven").on('click', function(){
        var num = $("#isEvenNum").val();
        let myNum = isEven(num);
        alert(myNum);
    });
    function isEven(n) {
        if (((n/2) - Math.floor(n/2)) == 0) {
            return true;
        } else { return false; };
    }


/* 7. Palindrome
    Define function isPalindrome(someStr)
    Return true if someStr is a palindrome, otherwise return false */


/* 8. Shapes
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
     * */

     
/* 9. Object literal
    Define function traverseObject(someObj)
    Print every property and it's value. */


/* 10. Delete Element
    Define function deleteElement(someArr)
    Print length
    Delete the third element in the array.
    Print length
    The lengths should be the same. */


/* 11. Splice Element
    Define function spliceElement(someArr)
    Print length
    Splice the third element in the array.
    Print length
    The lengths should be one less than the original length. */


/* 12. Defining an object using a constructor
    Define a function Person(name, age)
    The following line should set a Person object to the variable john:
        var john = new Person("John", 30); */


/* 13. Defining an object using an object literal
    Define function getPerson(name, age)
    The following line should set a Person object to the variable john:
        var john = getPerson("John", 30); */
        

/* 14. Display the current time on the top right of your HTML page, 
    updating every second */


/* 15.  Descending order
    Your task is to make a function that can take any non-negative 
    integer as a argument and return it with its digits in descending 
    order. Essentially, rearrange the digits to create the highest possible number. */

    function descendingNum(n) {
        var numDigits = number.toString().length;
        for (let i=0; i<numDigits; i++) {

        }
    }