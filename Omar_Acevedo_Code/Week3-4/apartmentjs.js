$(document).ready(function() {
    
/** Exercise 1 ****************************************************/
/*
    1. Fibonacci 
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence.    */

    function fibo(n) {
        return ( (n <= 1) ? n : (fibo(n-1) + fibo(n-2)) );
    }

    // $('#doFibo').click(function() {
    $('#doFibo').on('click', function() {

        let n = $('#fiboParam').val();
        let fiboResult = fibo(n);
        
        $('#fiboResult').html(fiboResult);
        
    });

    //  Clear texbox
    $('#fiboParam').click(function() {
        $(this).val('');
    });


/** Exercise 2 ****************************************************/
/*
    2. Bubble Sort
    Define function: bubbleSort(numArray)
    Use the bubble sort algorithm to sort the array.
    Return the sorted array.    */

    function bubbleSort(numArray) {
        for  (var i = 0; i < numArray.length - 1; i++) {
            var swapped = false;
            for (var j = 0; j < numArray.length - 1; j++) {
                if ( numArray[j] > numArray[j + 1] ) {
                    var temp = numArray[j + 1];
                    numArray[j + 1] = numArray[j];
                    numArray[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    $('#doBubbleSort').click(function() {

        let myStr = $('#numArray').val();
        let myArr = [];

        for (var i = 0; i < myStr.length; i++) {
            myArr.push(myStr[i]);
        }

        bubbleSort(myArr);


        $('#bubbleSortResult').html(myArr);
    });

    $('#numArray').click(function() {
        $(this).val('');
    });

/** Exercise 3 ****************************************************/
/*
    3. Reverse String
    Define function: reverseStr(someStr)
    Reverse and return the String.  */

    function reverseStr(someStr) {
        for (var i = userStr.length; i >= 0; i--) {
            console.log(userStr[i]);
        }
    }

    $('#doReverseStr').click(function() {
        let userStr = $('#userStr').val();
        alert(userStr);
    });



/** Exercise 4 ****************************************************/
/*    4. Factorial
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum.   */
    
/*    5. Substring
    Define function substring(someStr, length, offset)
    Return the substring contained between offset and (offset + length) inclusively.
    If incorrect input is entered, use the alert function and describe why the input was incorrect.
    
    6. Even Number
    Define function: isEven(someNum)
    Return true if even, false if odd.
    Do not use % operator.
    
    7. Palindrome
    Define function isPalindrome(someStr)
    Return true if someStr is a palindrome, otherwise return false
    
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
    
    9. Object literal
    Define function traverseObject(someObj)
    Print every property and it's value.
    
    10. Delete Element
    Define function deleteElement(someArr)
    Print length
    Delete the third element in the array.
    Print length
    The lengths should be the same.
    
    11. Splice Element
    Define function spliceElement(someArr)
    Print length
    Splice the third element in the array.
    Print length
    The lengths should be one less than the original length.
    
    12. Defining an object using a constructor
    Define a function Person(name, age)
    The following line should set a Person object to the variable john:
        var john = new Person("John", 30);
    
    13. Defining an object using an object literal
    Define function getPerson(name, age)
    The following line should set a Person object to the variable john:
        var john = getPerson("John", 30);
     
    14. Display the current time on the top right of your HTML page, 
    updating every second
    
    15.  Descending order
    Your task is to make a function that can take any non-negative 
    integer as a argument and return it with its digits in descending 
    order. Essentially, rearrange the digits to create the highest possible number.
*/

/********************************************************/
// Test ajax
    // $.ajax({
    //     url: 'https://swapi.co/api/planets/1/',
    //     type: 'get',
    //     success: function(data) {
    //         console.log(data); 
    //     },
    //     error: function(err) {
    //         console.log(err);   
    //     }
    // });
//
});

