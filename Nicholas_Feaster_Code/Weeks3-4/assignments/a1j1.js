
/**
 * 
 * 1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
 */
function fib(i) {
    var n = 0;
    var o = 1;
    var faker = [n, o];
    var b = n + o;
    faker.push(b);
    faker[0] = faker[1]
    faker[1] = b;
    i--;
    return faker[1];
}
/**
 * 
 * 3. Reverse String
Define function: reverseStr(someStr)
Reverse and return the String.
 */
function gnirtS(words) {
    let i = word.length();
    while (i > -1) {
        console.log(words.charAt[i])
        i--;
    }

}
/**
 * 
 * 4. Factorial
Define function: factorial(someNum)
Use recursion to compute and return the factorial of someNum.
 */
function bubblin(numArray) {
    for (let i; i < numArray.length; i++) {
        for (let j; j < numArray.length; j++) {
            let next = i + 1;
            if (numArray[next] < numArray[j]) {
                let bet = numArray[next];
                numArray[next] = numArray[j]
                numArray[j] = numArray[bet]
            }
        }
    }
    console.log(numArray);
}

/**
 * 
 * 1. Fibonacci 
Define function: fib(n) 
Return the nth number in the fibonacci sequence.
 */
function bang(sumNum) {
    let k = 1;
    if (sumNum > 0) {
        k = sumNum * bang(sumNum - 1);
    }
    else {
        return 1;
    }
    return sumNum;
}
/**
 * 
 * 5. Substring
Define function substring(someStr, length, offset)
Return the substring contained between offset and (offset + length) inclusively.
If incorrect input is entered, use the alert function and describe why the input was incorrect.

 */
function surgeon(someStr, length, offset) {

    var carrot = someStr.substring(offset, length + offset);
    return carrot;


}
/**
 * 
 * 6. Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
 */
function isEven(N6) {
    let t1 = N6 / 2;
    let t2 = t1;
    t2 = Math.floor(t1);
    if (t2 == t1) {
        return true;
    }
    else {
        return false;
    }
}
/**
 * 
 * 7. Palindrome
Define function isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false
 */
function Palindrome(hanheldString) {
    let t3 = Math.floor(hanheldString.length() / 2);
    let t4 = hanheldString.length - 1
    let first = 0;
    while (first !== t3)
        if (hanheldString[first] !== hanheldString[t4]) {
            return false;
        }
        else {
            first++;
            t4--;
        }
}
/**
 12. Defining an object using a constructor
Define a function Person(name, age)
The following line should set a Person object to the variable john:
	var john = new Person("John", 30);.
 */
function Person(name,age){
    this.name = name;
    this.age = age;
}