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
        let reversedStr = "";
        for (var i = someStr.length-1; i >= 0; i--) {
            reversedStr += someStr[i];
        }
        return reversedStr;
    }

    $('#doReverseStr').click(function() {
        var userStr = $('#userStr').val();
        userStr = reverseStr(userStr);
        $('#reversedStr').html(userStr);
    });

    $('#userStr').click(function() {
        $(this).val('');
    });


/** Exercise 4 ****************************************************/
/*    4. Factorial
    Define function: factorial(someNum)
    Use recursion to compute and return the factorial of someNum.   */
//  n = n * (n-1)
    function factorial(someNum) {
        return ( someNum == 1 ) ? someNum : someNum * factorial(someNum-1);
    }
    
    $('#doFactorial').click(function() {
        var factorialParam = $('#factorialParam').val();
        factorialParam = factorial(factorialParam);
        $('#factorialResult').html(factorialParam);
    });

    $('#factorialParam').click(function() {
        $(this).val('');
    });
    
    
/*    5. Substring
    Define function substring(someStr, length, offset)
    Return the substring contained between offset and (offset + length) inclusively.
    If incorrect input is entered, use the alert function and describe why 
    the input was incorrect. */
    function substring(someStr, length, offset) {
        let len = length-1;
        let subStr = "";
        for (var i = offset; i <= len; i++) {
            subStr += someStr[i];
        }
        return subStr;
    }


//  Disable length text input.
    $('#stringParam_len').attr('disabled', true);


//  Get substring on button click.
    $('#doSubstring').click(function() {
        
        var stringParam = $('#stringParam').val();
        var stringParam_offset = $('#stringParam_offset').val();


//      Get global variable thisLen (length of string input).
        var stringParam_len = thisLen;


//      Call substring function.
        substringVal = substring(stringParam, stringParam_len, stringParam_offset);
        

//      Put values in results box.
        $('#subsStringResult').html(substringVal);
    });


//  Get length of string input  ( for each key up ).
    $('#stringParam').keyup(function() {
        thisLen = $(this).val().length;
        $('#stringParam_len').val(thisLen);
    });

    
//  Clear fields (string, length, and offset ) when string input is clicked.
    $('#stringParam').focus(function() {
        $(this).val('');
        $('#stringParam_len').val('');
        $('#stringParam_offset').val('');
    });


//  Clear inputs when offset input is clicked.
    $('#stringParam_offset').focus(function() {
        $(this).val('');
    });


//  If it's not a number, disable button and tell user.
    $('#stringParam_offset').blur(function() {

        if (isNaN($(this).val())) {
            $('#doSubstring').attr('disabled', true);
            alert('Hey, enter a number.');
            $(this).val('');
            $(this).focus();
            return;
        } else if ($(this).val() < 0) {
            $('#doSubstring').attr('disabled', true);
            alert('Hey, enter a positive number.');
            $(this).val('');
            $(this).focus();
            return;
        } else {
            if (!$('#doSubstring').prop('disabled')) {
                $('#doSubstring').attr('disabled', false);
            }
        }
    });

//  Disable button whenever 
    $('#stringParam_offset').keyup(function() {
        $('#doSubstring').attr('disabled', false);
    });
    

/*    6. Even Number
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
