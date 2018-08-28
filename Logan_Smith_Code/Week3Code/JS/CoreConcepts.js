/**
 * @author Logan Smith
 * @name Core-Concepts
 * 
 */
/*

JavaScript is a scripting language for client side operations (though there are frameworks that enable server side JS)
Loosely Types: Variable types are dynamically allocated.
We declare variables with var, let, const
supports prototypal inheritance
important related concepts: var types, scopes, type coercia, hoisting, semicolor injection, anonymous functions, teplate literals,
IIFE, arrow notation

*/

function truthyFalsy(cond){
    if(cond){
        console.log("condition is truthy");
    }
    else {
        console.log("condition is falsy");
    }

}
/*
Type coercion:
As a loosely typed programming language that is interpreted and not compiled, JavaScript must operate on functions
of different types. Uses type coercion to do so.
Falsy: 0, NaN, null, undefined, '', false
Truthy: Eveything else

When comparing variables/literals we can use == or === operators
== uses type coercion
=== does not use type coercion
*/

var obj = {
    name: "Logan",
    age: "10",
    saysHi: function() {
        console.log(this.name + " says hoi!")
    }

}

obj.name

delete obj.name

function scopes(cond) {
    var functionVar = "this is declaring using var in a function";
    var functionLet = "this is declared using a let in a function";
    var functionConst = "this is declared using a const in a function";
if (cond) {
    var blockVar = "block var";
    let blockLet = "block let"
    const blockConst = "block const";
    console.log(`In if block ---- var ${blockVar} let ${blockLet} const ${blockConst}`);
}
console.log(functionVar);
console.log(functionLet);
console.log(functionConst);
console.log(blockVar);
//console.log(blockLet);
//console.log(blockConst);
}

//var guard = function(a, b) {return a && b;}
//guard will print a if a is false, will print b if a is true
//var default = function(a, b){ return a || b; }
//default will print a if a is tre, will print b if a is false

var currentSession = null;
var userInfo = {username: 'lsmith', password: 131};
var getUser = currentSession && userInfo;
var earlyLeave = 1;
var regularLeave = 530;
var timeout = earlyLeave || regularLeave;