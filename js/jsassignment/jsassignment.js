window.onload = function () {
    // getTime();
}

//this thing is going to "listen" for a click on the fibonacciButton, and then trigger theFibonacciSequenceFunction whenit "hears" one:
document.getElementById("fibonacciButton").addEventListener("click", theFibonacciSequenceFunction, true);

function theFibonacciSequenceFunction() {
    let fibonacciInput = document.getElementById("fibonacciN").value;
    console.log(fibonacciInput);
    let fibR = 0;
    let fib1 = 0;
    let fib2 = 1;

    for (var i = 1; i < fibonacciInput; i++) {
        fibR = fib1 + fib2;
        fib2 = fib1;
        fib1 = fibR;
    }
    document.getElementById("fibonacciResult").innerHTML = fibR;
}

//gonna get the bubbleSortButton and listen for when it's clicked: when it is, run theBubbleSortFunction
document.getElementById("bubbleSortButton").addEventListener("click", theBubbleSortFunction, true);

function theBubbleSortFunction() {
    //this thing is going to get the array input of the element "bubbleSortInput" and split it when there are spaces:
    let bubInput = (document.getElementById("bubbleSortInput").value).split(" ");

    for (var i = 0; i < bubInput.length; i++) {               //for loop that repeats as many times as the array has elements
        for (var j = 0; j < bubInput.length - 1; j++) {       //inner for loop

            if (bubInput[j] > bubInput[j + 1]) {              //if the former element is greater than the latter,
                let holder = parseInt(bubInput[j + 1]);     //set your temporary variable equal to the value of the former element
                bubInput[j + 1] = parseInt(bubInput[j]);    //set your former element equal to the latter element
                bubInput[j] = holder;                       //set your latter element equal to the previous value of the
            }                                               //first element, which was stored in holder
        }
    }
    document.getElementById("bubbleSortResult").innerHTML = bubInput;
}

document.getElementById("reverseButton").addEventListener("click", theReverseStringFunction, true);

function theReverseStringFunction() {
    let arrayedInput = (document.getElementById("reverseInput").value).split("");
    let reversedString = "";

    for (let i = arrayedInput.length - 1; i >= 0; i--) {
        reversedString += arrayedInput[i];
    }
    //changing the innerHTML of the element reversedStringOutput to the value of reversedString
    document.getElementById("reversedStringOutput").innerHTML = reversedString;
}

document.getElementById("factorialButton").addEventListener("click", theFactorialFunction, true);

function theFactorialFunction() {
    let f = parseInt(document.getElementById("factorialInput").value);

    function factorial(n) {
        let result = n;
        if (n === 0 || n === 1)
            return 1;
        while (n > 1) {
            n--;
            result *= n;
        }
        return result;
    }
    document.getElementById("factorialOutput").innerHTML = factorial(f);
}

document.getElementById("substringButton").addEventListener("click", theSubstringFunction, true);

function theSubstringFunction() {
    var length = parseInt(document.getElementById("substringUserLength").value);
    var offset = parseInt(document.getElementById("substringUserOffset").value);
    var substring = (document.getElementById("substringUserInput").value).substring(offset, offset + length);
    document.getElementById("substringOutput").innerHTML = substring;
}

document.getElementById("evenButton").addEventListener("click", theEvenTesterFunction, true);

function theEvenTesterFunction() {
    let theNumber = document.getElementById("evenInput").value;
    let evenTest;
    if (theNumber % 2 === 0) {
        evenTest = "Your number is even! :)"
    }
    else {
        evenTest = "Your number is not even! :("
    }
    document.getElementById("evenOutput").innerHTML = evenTest;
}

document.getElementById("palindromeButton").addEventListener("click", thePalindromeFunction, true);

function thePalindromeFunction() {

    let arrayedInput = (document.getElementById("palindromeInput").value).split("");
    let reversedString = "";
    let theAnswer;

    for (let i = arrayedInput.length - 1; i >= 0; i--) {
        reversedString += arrayedInput[i];
    }

    let otherArray = reversedString.split("");

    if (JSON.stringify(otherArray) == JSON.stringify(arrayedInput)) {
        theAnswer = "It's a palindrome!!!";
    }
    else {
        theAnswer = "Nope!";
    }
    document.getElementById("palindromeOutput").innerHTML = theAnswer;
}

document.getElementById("shapeInputs").addEventListener("click", shapeSelector, true);

let selectedShape;

function shapeSelector() {
    selectedShape = document.querySelector('input[name = shape]:checked').value;
    document.getElementById("shapeResult").innerHTML = 'Your selected shape: ' + selectedShape;
}

document.getElementById("shapeButton").addEventListener("click", theShapePrinterFunction, true);

function theShapePrinterFunction() {

    let shape = selectedShape;
    let height = document.getElementById("heightOptionInput").value;
    let character = document.getElementById("characterOptionInput").value;


        let printer = "";
        document.getElementById("shapeOutput").innerHTML += printer;
        switch (shape) {
            case "Square":
                for (let i = 0; i < height; i++) {
                    for (let j = 0; j < height; j++) {
                        printer += character;
                        document.getElementById("shapeOutput").innerHTML += character;
                    }
                    printer += "\n";
                    document.getElementById("shapeOutput").innerHTML += "<br />";
                }
                break;
            case "Triangle":
                for (let i = 0; i < height; i++) {
                    for (let j = i; j >= 0; j--) {
                        printer += character;
                        document.getElementById("shapeOutput").innerHTML += character;
                    }
                    printer += "\n";
                    document.getElementById("shapeOutput").innerHTML += "<br />";
                }
                break;
            case "Diamond":
                for (let j = 1; j <= height; j += 2) {
                    for (let k = 0; k < (height - j / 2 - height / 2); k++) {
                        printer += " ";
                        document.getElementById("shapeOutput").innerHTML += " ";
                    }
                    for (let i = 1; i <= j; i++) {
                        printer += character;
                        document.getElementById("shapeOutput").innerHTML += character;
                    }
                    printer += "\n";
                    document.getElementById("shapeOutput").innerHTML += "<br />";
                }
                for (let j = height - 2; j >= 0; j -= 2) {
                    for (let k = 0; k < (height - j / 2 - height / 2); k++) {
                        printer += " ";
                        document.getElementById("shapeOutput").innerHTML += " ";
                    }
                    for (let i = 1; i <= j; i++) {
                        printer += character;
                        document.getElementById("shapeOutput").innerHTML += character;
                    }
                    printer += "\n";
                    document.getElementById("shapeOutput").innerHTML += "<br />";
                }
                break;
        }
        console.log(printer);
        // document.getElementById("shapeOutput").innerHTML = printer;
}


// function getTime() {
//     let now = new Date().toLocaleTimeString();
//     document.getElementById("JustInCaseYouNeedToKnowTheTime").innerHTML = now;
//     setTimeout(getTime, 1000);
// }
