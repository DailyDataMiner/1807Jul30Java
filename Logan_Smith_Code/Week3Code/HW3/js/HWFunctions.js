let currentFunction = 0;

var fibonacci = function (n) {
    let output = "";

    let fibonacci1 = 1;
    let fibonacci2 = 0;
    let fibonacci3 = 3;

    for (let i = 1; i <= n; i++) {
        output += fibonacci2 + " ";
        fibonacci3 = fibonacci2;
        fibonacci2 = fibonacci1;
        fibonacci1 = fibonacci1 + fibonacci3;
    }
    return output;
}

var bubbleSort = function (numArray) {
    for (var i = 0; i <= numArray.length - 1; i++) {
        var finished = true;
        for (var j = 1; j <= numArray.length - 1; j++) {
            if (numArray[j - 1] > numArray[j]) {
                var placeholder = numArray[j];
                numArray[j] = numArray[j - 1];
                numArray[j - 1] = placeholder;
                finished = false;
            }
        }
        if (finished == true) {
            break;
        }
    }
    return numArray;
}

var reverseStr = function (someStr) {
    for (i = someStr.length - 2; i >= 0; i--) {
        someStr = someStr.substring(0, i) + someStr.substring(i + 1, someStr.length) + someStr.substring(i, i + 1);
    }
    return someStr;
}

var factorial = function (someNum) {
    if (someNum == 0) {
        return 1;
    }
    else {
        return someNum * factorial(someNum - 1);
    }
}

var substring = function (someStr, length, offset) {
    if ((typeof someStr) != "string") {
        alert("You did not enter a string.");
        return null;
    }
    if (+length != length) {
        alert("You did not enter a number for the length!");
    }
    if (+offset != offset) {
        alert("You did not enter a number for the offset!");
    }
    return someStr.substring(offset, offset + length);
}

var isEven = function (someNum) {
    let checker = someNum;
    someNum = parseInt(someNum / 2);
    someNum = someNum * 2;
    if (someNum == checker) {
        return "true";
    }
    return "false";
}

var isPalindrome = function (someStr) {
    let isPalindrome = "true";
    someStr = someStr.toLowerCase();
    for (let i = 0; i < (someStr.length / 2); i++) {
        if (someStr.charAt(i) != someStr.charAt(someStr.length - 1 - i)) {
            isPalindrome = "false";
        }
    }
    return isPalindrome;
}

var printShape = function (shape, height, character) {
    let outputLine = "";
    switch (shape) {
        case "Square":
            for (let i = 0; i < height; i++) {
                for (let j = 0; j < height; j++) {
                    outputLine += character;
                }
                outputLine += "\n";
            }
            break;
        case "Triangle":
            for (let i = 0; i < height; i++) {
                for (let j = i; j >= 0; j--) {
                    outputLine += character;
                }
                outputLine += "\n";
            }
            break;
        case "Diamond":
            for (let j = 1; j <= height; j += 2) {
                for (let k = 0; k < (height - j / 2 - height / 2); k++) {
                    outputLine += " ";
                }
                for (let i = 1; i <= j; i++) {
                    outputLine += character;
                }
                outputLine += "\n";
            }
            for (let j = height - 2; j >= 0; j -= 2) {
                for (let k = 0; k < (height - j / 2 - height / 2); k++) {
                    outputLine += " ";
                }
                for (let i = 1; i <= j; i++) {
                    outputLine += character;
                }
                outputLine += "\n";
            }
            break;
    }
    console.log(outputLine);
}

var pug = {
    name: "Tori",
    size: "Medium",
    age: 10,
    powerLevel: 9000
}

var traceObj = function (someObj) {
    let looper = 0;
    let output = [];
    for (var a in someObj) {
        output[looper] = a + ": " + someObj[a] + " ";
        looper++;
    }
    return output;
}

var deleteElement = function (someArray) {
    console.log(someArray.length);
    delete someArray[3];
    return someArray.length;

}

function runFunction() {
    var sFun = $("#functionSelector").val();
    var output;
    var input;
    var input2;
    var input3;
    switch (sFun) {
        case "1":
            input = prompt("What number of fibonnaci do you want to go to?");
            output = fibonacci(+input);
            break;
        case "2":
            input = prompt("Please enter an array to be sorted, with only a , between numbers.").split(",");
            for (var i = 0; i < input.length; i++) {
                input[i] = +input[i];
            }
            output = bubbleSort(input);
            for (let i = 0; i < output.length; i++) {
                output[i] = output[i] + " ";
            }
            break;
        case "3":
            input = prompt("Please enter a string to be reversed.");
            output = reverseStr(input);
            break;
        case "4":
            input = prompt("Please input a number to factorial.");
            output = factorial(input);
            break;
        case "5":
            input = prompt("Please enter a string to substring.");
            input2 = prompt("Please enter the length of the substring.");
            input3 = prompt("Please enter the offset of the substring.");
            output = substring(input, input2, input3);
            break;
        case "6":
            input = prompt("Please enter a number to check if even.");
            output = isEven(input);
            break;
        case "7":
            input = prompt("Please enter a string to check if palindrome.");
            output = isPalindrome(input);
            break;
        case "8":
            input = prompt("Please enter: Square, Triangle, or Diamond.");
            input2 = prompt("Please enter the size of the shape.");
            input3 = prompt("Please enter the character of the shape.");
            output = printShape(input, +input2, input3);
            return;
        case "9":
            alert("Tracing a pug!");
            output = traceObj(pug);
            break;
        case "10":
            input = prompt("Please enter an array, with a , between each element.").split(",");
            output = deleteElement(input);
            break;
    }
    $("#inputfield").html(output);
}



window.onload = function () {
    $("#outputbutton").on(
        "click", runFunction);
}