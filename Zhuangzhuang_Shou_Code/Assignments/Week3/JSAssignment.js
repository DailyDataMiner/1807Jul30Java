
window.onload = function()
{
    loadOptions();
    document.getElementById("submit-button").addEventListener("click", selectFunction, true);
    document.getElementById("select").addEventListener("change", changeInputPrompt, true);
}

//Populate selection drop-down
function loadOptions()
{
    let options = ["Fibonacci", "Bubble Sort", "Reverse String", "Factorial", "Substring", 
        "Even Number", "Palindrome", "Shapes", "Object Literal", "Delete Element", 
        "Splice Element", "Object Constructor", "Person Object", "Time", "Change Order"];
    
     for (let i = 0; i < options.length; i++)
     {
         let element = document.createElement("option");
         let optionString = i + 1 + ". " + options[i];
         element.value = i + 1;
         element.innerHTML = optionString;
         document.getElementById("select").appendChild(element);
     }   
}


//Set input placeholder based on selection
function changeInputPrompt()
{
    stopInterval();
    resetOutput();
    let selection = document.getElementById("select").value;
    switch(parseInt(selection))
    {
        case 1:
            setInputPrompt("Enter sequence index");
            break;
        case 2:
            setInputPrompt("Enter array size");
            break;
        case 3:
            setInputPrompt("Enter string");
            break;
        case 4:
            setInputPrompt("Enter number");
            break;
        case 5:
            setInputPrompt("Enter string, length, offset");
            break;
        case 6:
            setInputPrompt("Enter number");
            break;
        case 7:
            setInputPrompt("Enter string");
            break;
        case 8:
            setInputPrompt("Enter shape, height, character");
            break;
        case 9:
        case 10:
        case 11:
        case 12:
        case 13:
        case 14:
            setInputPrompt("No input required");
            break;
        case 15:
            setInputPrompt("Enter non-negative integer");
    }
}

//Execute function based on selection
function selectFunction()
{
    let selection = document.getElementById("select").value;
    let input = document.getElementById("input").value;
    switch(parseInt(selection))
    {
        case 1: 
            setOutput(fibNumbers(input));
            break;
        case 2: 
            setOutput(bubbleSort(input));
            break;
        case 3:
            setOutput(reverseStr(input));
            break;
        case 4:
            setOutput(factorial(input));
            break;
        case 5:
            {
                let inputArray = input.split(",");
                for (let i = 0; i < inputArray.length; i++)
                {
                    inputArray[i] = inputArray[i].trim();
                }
                setOutput(substring(inputArray[0], parseInt(inputArray[1]), parseInt(inputArray[2])));
            }
            break;
        case 6:
            setOutput(isEven(parseInt(input)));
            break;
        case 7:
            setOutput(isPalindrome(input));
            break;
        case 8:
            {
                let inputArray = input.split(",");
                for (let i = 0; i < inputArray.length; i++)
                {
                    inputArray[i] = inputArray[i].trim();
                }
                setOutput(printShape(inputArray[0], inputArray[1], inputArray[2]));
            }
            break;
        case 9:
            {
                let testObj = 
                {
                    prop1: "String",
                    prop2: 5,
                    prop3: [1, 2, 3],
                    prop4: function() {console.log("function");},
                    prop5: {type: "Object"}
                };
                setOutput(printObjectProperties(testObj));
            }
            break;
        case 10:
            {
                let testArr = [1, 2, 3, 4];
                setOutput(deleteElement(testArr));
            }
            break;
        case 11:
            {
                let testArr = [1, 2, 3, 4];
                setOutput(spliceElement(testArr));
            }
            break;
        case 12:
            setOutput(createPerson());
            break;
        case 13:
            setOutput(JSON.stringify(getPerson("John", 30)));
            break;
        case 14:
            intervalControl = setInterval(getCurrentTime, 1000);
            break;
        case 15:
            setOutput(reorderDigits(input));
            break;
        default:
            console.log("Default case");
    }
    resetInput();
}

/*
1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
*/

function fibNumbers(n)
{
    let num = 0;
    if (n < 1)
    {
        num = 0;
    }
    else if (n == 1)
    {
        num = 1;
    }
    else
    {
        let previous = 1;
        let previous2 = 0;
        let current = 0;
        for (let i = 2; i <= n; i++)
        {
            current = previous + previous2;
            previous2 = previous;
            previous = current;
        }
        num = current;
    }
    return num;
}

/*
2. Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array.
Return the sorted array.
*/

function bubbleSort(size)
{
    let array = [];
    for (let i = 0; i < size; i++)
    {
        array.push(generateRandomNumber());
    }
    let output = "Original Array: " + formatArray(array) + "<br>Sorted Array: ";
    let sorted = false;

    while (!sorted)
    {
        sorted = true;
        for (let i = 0; i < array.length - 1; i++)
        {
            if (array[i] < array[i + 1])
            {
                let temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                sorted = false;
            }
        }
    }
    output += formatArray(array);
    return output;
}

/*

3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
*/

function reverseStr(someStr)
{
    let reverseString = "";
    for (let i = someStr.length - 1; i >= 0; i--)
    {
        reverseString += someStr.substring(i, i + 1);
    }
    return reverseString;
}

/*
4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
*/

function factorial(num)
{
    if (num == 1)
    {
        return 1;
    }
    return num * factorial(num - 1);
}

/*
5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + 

length) inclusively.
If incorrect input is entered, use the alert function and 

describe why the input was incorrect.
*/

function substring(string, length, offset)
{
    let subString = "";
    if (arguments.length != 3)
    {
        alert("Incorrect number of arguments");
    }
    else if (string == null || length == null || offset == null)
    {
        alert("No null arguments allowed");
    }
    else if (!typeof string === "string" || !typeof length === "number" || !typeof offset === "number")
    {
        alert("Incorrect argument types");
    }
    else if (parseInt(offset) + parseInt(length) > string.length)
    {
        alert("String length is not long enough for the specified length and offset");
    }
    else
    {
        console.log(offset + length);
        for (let i = offset; i < offset + length; i++)
        {
            subString += string.charAt(i);
            console.log(subString);
        }
    }
    return subString;
}

/*
6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(num)
{
    let testNum = Math.abs(num);
    while (testNum > 1)
    {
        testNum -= 2;
    }
    if (testNum == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

/*
7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
*/

function isPalindrome(str)
{
    return str == reverseStr(str);
}

/*
8. Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", 

"Diamond".
height is a Number and is the height of the shape. Assume the 

number is odd.
character is a String that represents the contents of the 

shape. Assume this String contains just one character.
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

function printShape(shape, height, character)
{
    let shapeHeight = parseInt(height);
    let shapeString = "";
    switch (shape)
    {
        case "Square":
            for (let i = 1; i <= shapeHeight; i++)
            {
                for (let j = 1; j <= shapeHeight; j++)
                {
                    shapeString += character;
                }
                shapeString += "<br>";
            }
            break;
        case "Triangle":
            for (let i = 1; i <= shapeHeight; i++)
            {
                for (let j = 1; j <= i; j++)
                {
                    shapeString += character;
                }
                shapeString += "<br>";
            }
            break;
        case "Diamond":
            {
                let space = "&nbsp&nbsp";
                let numOfSpaces = 0;
                let numOfChars = 0;
                let spaceString = "";
                let charString = "";
                for (let i = 1; i <= shapeHeight/2 + 1; i++)
                {
                    spaceString = "";
                    charString = "";
                    numOfSpaces = shapeHeight - (2 * (i - 1) + 1);
                    numOfChars = shapeHeight - numOfSpaces;
                    for (let j = 1; j <= numOfSpaces/2; j++)
                    {
                        spaceString += space;
                    }
                    for (let j = 1; j <= numOfChars; j++)
                    {
                        charString += character;
                    }
                    shapeString += spaceString + charString + spaceString + "<br>";
                }
                for (let i = shapeHeight/2 + 1; i < shapeHeight; i++)
                {
                    spaceString = "";
                    charString = "";
                    numOfSpaces = 2 * i - shapeHeight;
                    numOfChars = shapeHeight - numOfSpaces;
                    for (let j = 1; j <= numOfSpaces/2; j++)
                    {
                        spaceString += space;
                    }
                    for (let j = 1; j <= numOfChars; j++)
                    {
                        charString += character;
                    }
                    shapeString += spaceString + charString + spaceString + "<br>";
                }
            }
            break;
    }
    return shapeString;
}

/*
9. Object literal
Define function traverseObject(someObj)
Print every property and it's value.
*/

function printObjectProperties(obj)
{
    let propString = "";
    for (let prop in obj)
    {
        propString += prop + ": " + obj[prop] + "<br>";
    }
    return propString;
}

/*
10. Delete Element
Define function deleteElement(someArr)
Print length
Delete the third element in the array.
Print length
The lengths should be the same.
*/

function deleteElement(arr)
{
    let resultString = "Initial length: ";
    resultString += arr.length + "<br>";
    delete arr[2];
    resultString += "Length after deleting 3rd element: " + arr.length;
    return resultString;
}

/*
11. Splice Element
Define function spliceElement(someArr)
Print length
Splice the third element in the array.
Print length
The lengths should be one less than the original length.
*/

function spliceElement(arr)
{
    let resultString = "Initial length: ";
    resultString += arr.length + "<br>";
    arr.splice(2, 1);
    resultString += "Length after splicing 3rd element: " + arr.length;
    return resultString;
}

/*
12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable 

john:
	var john = new Person("John", 30);
*/

function Person(name, age)
{
    this.name = name;
    this.age = age;
}

function createPerson()
{
    let person = new Person("John", 30);
    return "Name: " + person.name + ", Age: " + person.age;
}

/*
13. Defining an object using an object literal
Define function getPerson(name, age)
The following line should set a Person object to the variable

john:
	var john = getPerson("John", 30);
*/

function getPerson(name, age)
{
    return {Name: name, Age: age};
}

/*
14. Display the current time on the top right of your HTML 
page, updating every second
*/

var intervalControl;

function stopInterval()
{
    clearInterval(intervalControl);
}

function getCurrentTime()
{
    let date = new Date();
    let dateString = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    document.getElementById("output").innerHTML = dateString;
}

/*
15.  Descending order
Your task is to make a function that can take any non-negative 
integer as a argument and return it with its digits in 

descending 
order. Essentially, rearrange the digits to create the highest 

possible number.
*/

function reorderDigits(num)
{
    console.log("Executing reorderDigits");
    let reordered = num.toString().split("").sort().reverse().join("");
    return reordered;
}


//Utility functions

function generateRandomNumber()
{
    return Math.floor(Math.random() * 101);
}

function formatArray(unformattedArray)
{
    let string = "[";
    for (let i = 0; i < unformattedArray.length; i++)
    {
        string += unformattedArray[i] + ", ";
    }
    string = string.substring(0, string.length - 2);
    string += "]";
    return string;
}

function setOutput(value)
{
    document.getElementById("output").innerHTML = value;
}

function setInputPrompt(value)
{
    document.getElementById("input").placeholder = value;
}

function resetOutput()
{
    document.getElementById("output").innerHTML = "Output";
}

function resetInput()
{
    document.getElementById("input").value = "";
}