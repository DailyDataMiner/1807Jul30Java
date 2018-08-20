var fibOutput = document.getElementById('fibOutput');
function fibonacci(n){
    var first = 0;
    var second = 1;
    var newNum = 0;
    for(var i=1;i<n;i++){
        newNum = first + second;
        first = second;
        second = newNum;
    }
    console.log(second);
    fibOutput.innerHTML = second;
    document.getElementById('fibTextOutput').style.display = 'block';
}

var bubOutput = document.getElementById('bubOutput');
function bubbleSort(input){
    let numArray = JSON.parse("[" + input + "]");
    var temp;
    for(var i=0;i<numArray.length;i++){
        for(var j=0;j<(numArray.length-i);j++){
            if(numArray[j - 1] > numArray[j]){
                temp = numArray[j-1];
                numArray[j-1] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    bubOutput.innerHTML = numArray;
    document.getElementById('bubTextOutput').style.display = 'block';
    //return numArray;
}
var revStrOutput = document.getElementById('rStrOutput');
function reverseString(someStr){
    var retStr = someStr.split("").reverse().join("");
    revStrOutput.innerHTML = retStr;
    document.getElementById('rStrTextOutput').style.display = 'block';
}

var fNumOutput = document.getElementById('fNumOutput');
function factorial(someNum){
    var orig = someNum;
    var prev = someNum - 1;
    for(let i=someNum;i > 1;i--){
        someNum = someNum * prev;
        prev--;
    }
    fNumOutput.innerHTML = someNum;
    document.getElementById('fNumTextOutput').style.display = 'block';

}

var sStringOutput = document.getElementById('sStringOutput');
function subString(someStr, length, offset){
    var numLength = parseInt(length);
    var numOffset = parseInt(offset);
    var sub = someStr.substring(numOffset, numOffset + numLength);
    sStringOutput.innerHTML = sub;
    document.getElementById('sStringTextOutput').style.display = 'block';
}

var isEvenOutput = document.getElementById('isEvenOutput');
function isEven(someNum){
    numSomeNum = parseInt(someNum);
    if((numSomeNum & 1) == 0){
        isEvenOutput.innerHTML = 'true';
        document.getElementById('isEvenTextOutput').style.display = 'block';
    }
    else isEvenOutput.innerHTML = 'false';
    document.getElementById('isEvenTextOutput').style.display = 'block';
}

function Person(name, age){
    this.name = name;
    this.age = age;
}
var john = new Person("John", 30);
document.getElementById('displayPerson').innerHTML = 'Name: ' + john.name + " Age: " + john.age;



function getPerson(name, age){
    return new Person(name,age);
}
john = getPerson("John", 30);
document.getElementById('displayPerson2').innerHTML = john;
console.log("Using object literal: ",john);


function traverseObject(someObj){
    var propNames = Object.getOwnPropertyNames(someObj);
    var propValues = Object.values(someObj)
    for(let i=0;i<propNames.length;i++){
       var v = document.createElement('p');
       v.value = propNames[i] + " : " + propValues[i];
       document.getElementById('displayObject').innerHTML = document.getElementById('displayObject').innerHTML + "  " + v.value;
    }
}
traverseObject(john);


var deleteElementOutput = document.getElementById('delElOutput');
var length = document.getElementById('length');
var length2 = document.getElementById('length2');
function deleteElement(someArr){
    let numArray = someArr.split(',');
    length.innerHTML = numArray.length;
    numArray.splice(2, 1, null);
    length2.innerHTML = numArray.length;
    deleteElementOutput.innerHTML = numArray;
    document.getElementById('delElTextOutput').style.display = 'block';
    document.getElementById('firstLengthTextOutput').style.display = 'block';
    document.getElementById('secondLengthTextOutput').style.display = 'block';
}

