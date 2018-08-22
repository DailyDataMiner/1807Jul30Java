window.onload = function(){

    /*1. Fibonacci 
    Define function: fib(n) 
    Return the nth number in the fibonacci sequence. */
    document.getElementById("disFib").addEventListener(
        "click", bubbleSort, true);
    
 }



function bubbleSort()
{
    var swapped;
    var a = [33, 103, 3, 726, 200, 984, 198, 764, 9];

    do {
        swapped = false;
        for (var i=0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
    document.getElementById("yourOutputDiv").innerHTML = a;
}







