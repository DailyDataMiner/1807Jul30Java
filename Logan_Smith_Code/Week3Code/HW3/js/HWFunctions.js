var bubbleSort = function(numArray) {
    for (var i = 0; i <= numArray.length-1; i++) {
        var finished = true;
        for (var j = 1; j <= numArray.length-1; j++) {
            if (numArray[j-1] > numArray[j]) {
                var placeholder = numArray[j];
                numArray[j] = numArray[j-1];
                numArray[j-1] = placeholder;
                finished = false;
            }
        }
        if (finished == true) {
            break;
        }
    }
    return numArray;
}

var reverseStr = function(someStr) {
    for (i = someStr.length-2; i >= 0; i--) {
        someStr = someStr.substring(0, i) + someStr.substring(i+1, someStr.length) + someStr.substring(i, i+1);
    }
    return someStr;
}

var factorial = function(someNum) {
    if (someNum == 0) {
        return 1;
    }
    else {
        return someNum*factorial(someNum-1);
    }
}
/*
public int factorialCalculator(int size) {
		int output = 1; // Final output
		for (int i = 1; i <= size; i++) { // Loops through the size
			output = output*i; // output is multiplied
		}
		return output; // returns output
	}
*/