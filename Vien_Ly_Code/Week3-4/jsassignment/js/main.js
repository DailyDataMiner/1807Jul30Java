window.onload = function() {
    document.getElementById('fibSubmit').addEventListener(
        "click", fibonacci, true);

    document.getElementById("sortSubmit").addEventListener(
        "click", bubbleSort, true);
      
    document.getElementById("strReverseSubmit").addEventListener(
        "click", strReverse, true);
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
