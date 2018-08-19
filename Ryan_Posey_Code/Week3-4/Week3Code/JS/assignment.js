window.onload = function() {
    //fibonacci
    $("#fib").on('click', function() {
        $('#fibInputModal').modal('toggle');
        $('#fibClose').on('click', function() {
            $('#fibInputModal').modal('toggle');
        })
        $('#fibCalculate').on('click', function() {
            let fibInput = $('#fibInput').val();
            let fibOutput = fibonacci(fibInput);
            $('#output').text(`Output: ${fibOutput}`);
            $('#fibInputModal').modal('toggle');
        })
    })
    // bubble sort
    $("#bubble").on('click', function() {
        $('#bubbleInputModal').modal('toggle');
        $('#bubbleClose').on('click', function() {
            $('#bubbleInputModal').modal('toggle');
        })
        $('#bubbleCalculate').on('click', function() {
            let bubbleArr = [];
            for(let i = 1; i <= 5; i++) {
                bubbleArr.push($(`#bubbleInput${i}`).val());
            }
            console.log(bubbleArr);
            let bubbleOutput = bubbleSort(bubbleArr);
            $('#output').text(`Output: ${bubbleOutput}`);
            $('#bubbleInputModal').modal('toggle');
        })
    })
    // reverse string
    $("#reverse").on('click', function() {
        $('#reverseInputModal').modal('toggle');
        $('#reverseClose').on('click', function() {
            $('#reverseInputModal').modal('toggle');
        })
        $('#reverseCalculate').on('click', function() {
            let reverseInput = $('#reverseInput').val();
            let reverseOutput = reverseStr(reverseInput);
            $('#output').text(`Output: ${reverseOutput}`);
            $('#reverseInputModal').modal('toggle');
        })
    })
    // factorial
    $("#fact").on('click', function() {
        $('#factInputModal').modal('toggle');
        $('#factClose').on('click', function() {
            $('#factInputModal').modal('toggle');
        })
        $('#factCalculate').on('click', function() {
            let factInput = $('#factInput').val();
            let factOutput = factorial(factInput);
            $('#output').text(`Output: ${factOutput}`);
            $('#factInputModal').modal('toggle');
        })
    })
    //Substring
    $("#sub").on('click', function() {
        $('#subInputModal').modal('toggle');
        $('#subClose').on('click', function() {
            $('#subInputModal').modal('toggle');
        })
        $('#subCalculate').on('click', function() {
            let subStr = $('#subInput').val();
            let subOffset = $('#subOffset').val();
            let subOutput = substring(subStr, subStr.length, subOffset);
            $('#output').text(`Output: ${subOutput}`);
            $('#subInputModal').modal('toggle');
        })
    })
    //Is Even
    $("#even").on('click', function() {
        $('#evenInputModal').modal('toggle');
        $('#evenClose').on('click', function() {
            $('#evenInputModal').modal('toggle');
        })
        $('#evenCalculate').on('click', function() {
            let evenInput = $('#evenInput').val();
            let evenOutput = isEven(evenInput);
            $('#output').text(`Output: ${evenOutput}`);
            $('#evenInputModal').modal('toggle');
        })
    })
    //Palindrome
    $("#palin").on('click', function() {
        $('#palinInputModal').modal('toggle');
        $('#palinClose').on('click', function() {
            $('#palinInputModal').modal('toggle');
        })
        $('#palinCalculate').on('click', function() {
            let palinInput = $('#palinInput').val();
            let palinOutput = isPalindrome(palinInput);
            $('#output').text(`Output: ${palinOutput}`);
            $('#palinInputModal').modal('toggle');
        })
    })
}
/*
1. reverseonacci 
Define function: reverse(n)
Return the nth number in the reverseonacci sequence.
*/

function fibonacci(n) {
    var x = 0;
    var y = 1
    if(n <= 2) { return n-1 };
    for(var i = 1; i < n; i++) {
        var temp = y;
        y = temp + x;
        x = temp;
    }
    return y;
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function swapIndex(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function bubbleSort(numArray) {
    for(var i = 0; i < numArray.length; i++) {
        for(var j = 0; j < numArray.length; j++) {
            if(numArray[j - 1] > numArray[j]) {
                swapIndex(numArray, j - 1, j);
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
    var splitStr = someStr.split("");
    var reverseArr = splitStr.reverse();
    var reversed = reverseArr.join("");
    return reversed;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

function factorial(someNum) {
    if(someNum == 0) return 1;
    else return (someNum * factorial(someNum - 1));
}

/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.
*/

function substring(someStr, length, offset) {
    return someStr.substring(offset, offset+length);
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum) {
    if(someNum % 2 == 0) return true;
    else return false; 
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(someStr) {
    for(var i = 0; i < someStr.length; i++) {
        if(someStr.charAt(i) !== someStr.charAt(someStr.length - 1 - i)) {
            return false;
        }
    }
    return true;
}