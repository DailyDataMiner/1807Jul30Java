// BAREBONE JS PRACTICE
window.onload = function() {
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
    console.log(typeof(n));
    document.getElementById("fibOutput").value = fibHelper(n);
    console.log(fibHelper(n));
}

function fibHelper(n) {
    let arr = [0, 1];
    for (let i = 2; i < n + 1; i++) {
        arr.push(arr[i - 2] + arr[i -1]);
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
    console.log('hello');
    let arr = document.getElementById("sortInput").value.split(",").map(Number);
    console.log(typeof(arr[0]));
    console.log(arr);
    document.getElementById("sortOutput").value = bubbleSortHelper(arr).join(",");
}

function bubbleSortHelper(array) {
    var swapped;
    do {
        swapped = false;
        for(let i = 0; i < array.length; i++) {
            if(array[i] && array[i + 1] && array[i] > array[i + 1]) {
                swap(array, i, i + 1);
                swapped = true;
            }
        }
    } while(swapped);
    return array;
}

function swap(array, i, j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
}

function printShape(shape, height, character) {
    let input = shape.toLowerCase();
    switch(input) {
        case("square"):
            printSquare(height, character);
            break;
        case("triangle"):
            printTriangle(height, character);
            break;
        case("diamond"):
            printDiamond(height, character);
            break;
    }
}

function printSquare(height, character) {
    for(let i = 0; i < height; i++) {
        for (let j = 0; j < height; j++) {
            console.log(character);
        }
        console.log("\n");
    }
}

function printTriangle(height, character) {
    for(let i = 1; i <= height; i ++) {
        for (let j = 1; j <= i; j++) {
            console.log(character);
        }
        console.log("\n");
    }
}

function printDiamond(height, character) {

}