'use strict';
// BAREBONE JS PRACTICE
window.onload = function () {
    document.getElementById('fibSubmit').addEventListener(
        "click", fibonacci, true);

    document.getElementById("sortSubmit").addEventListener(
        "click", bubbleSort, true);

    document.getElementById("strReverseSubmit").addEventListener(
        "click", strReverse, true);

    document.getElementById("factSubmit").addEventListener(
        "click", factorial, true);

    document.getElementById("substrSubmit").addEventListener(
        "click", substr, true);
}

function substr() {
    let str = document.getElementById("substrInput").value;
    let start = parseInt(document.getElementById("substrStart").value);
    let length = parseInt(document.getElementById("substrLength").value);

    document.getElementById("substrOutput").value = str.substr(start, length);
}

function factorial() {
    let n = parseInt(document.getElementById("factInput").value);
    document.getElementById("factOutput").value = factorialHelper(n);
}

function factorialHelper(n) {
    let result = n;
    if (n === 0 || n === 1)
        return 1;
    while (n > 1) {
        n--;
        result *= n;
    }
    return result;
}

function strReverse() {
    let str = document.getElementById("strReverseInput").value;
    document.getElementById("strReverseOutput").value = str.split("").reverse().join("");
}

function fibonacci() {
    let n = parseInt(document.getElementById("fibInput").value);
    document.getElementById("fibOutput").value = fibHelper(n);
}

function fibHelper(n) {
    let arr = [0, 1];
    for (let i = 2; i < n + 1; i++) {
        arr.push(arr[i - 2] + arr[i - 1]);
    }
    return arr[n];
}

// recursive method, not ideal for web browsers, stack overflows quickly
function fibHelperR(n) {
    if (n < 2) {
        return n;
    }
    return fibHelper(n - 1) + fibHelper(n - 2);
}

function bubbleSort() {
    let arr = document.getElementById("sortInput").value.split(",").map(Number);
    document.getElementById("sortOutput").value = bubbleSortHelper(arr).join(",");
}

function bubbleSortHelper(array) {
    var swapped;
    do {
        swapped = false;
        for (let i = 0; i < array.length; i++) {
            if (array[i] && array[i + 1] && array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                swapped = true;
            }
        }
    } while (swapped);
    return array;
}

function swap(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function traverseObject(someObj) {
    for (let prop in someObj) {
        console.log(`${prop}: ${someObj[prop]}`);
    }
}

let car = { type: "Fiat", model: "500", color: "white" };
traverseObject(car);

function deleteElement(someArr) {
    console.log(someArr);
    delete someArr[2];
    console.log(someArr);
}
let testArr0 = [1, 2, 3, 4, 5, 6];
deleteElement(testArr0);

function spliceElement(someArr) {
    console.log(someArr);
    console.log(someArr.length);
    console.log(someArr.splice(2, 1));
    console.log(someArr);
    console.log(someArr.length);
}

let testArr1 = [1, 2, 3, 4, 5, 6];
spliceElement(testArr1);

function Person(name, age) {
    this.name = name;
    this.age = age;
}

let John = new Person("John", 30);