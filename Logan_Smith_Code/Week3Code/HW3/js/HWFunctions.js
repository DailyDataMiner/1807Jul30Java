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
    if ((typeof length) != "number") {
        alert("You did not enter a number for the length!");
    }
    if ((typeof offset) != "number") {
        alert("You did not enter a number for the offset!");
    }
    return someStr.substring(offset, offset + length + 1);
}

var isEven = function (someNum) {
    let checker = someNum;
    someNum = parseInt(someNum / 2);
    someNum = someNum * 2;
    if (someNum == checker) {
        return true;
    }
    return false;
}

var isPalindrome = function (someStr) {
    let isPalindrome = true;
    someStr = someStr.toLowerCase();
    for (let i = 0; i < (someStr.length / 2); i++) {
        if (someStr.charAt(i) != someStr.charAt(someStr.length - 1 - i)) {
            isPalindrome = false;
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

var traceObj = function(someObj) {
    for (var a in someObj) {
        console.log(a + ": " + someObj[a]);
    }
}

var deleteElement = function(someArray) {
    console.log(someArray.length);
    delete someArray[3];
    console.log(someArray.length);
}