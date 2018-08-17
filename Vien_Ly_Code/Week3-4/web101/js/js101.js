/**
 * @author Gin
 * @name core-js-concept
 */

 /**
  * JS is loosely type -- types are dynamically allocated
  * - declare variables with var, let, const
  * - supports prototypal inheritance
  * - var types, scopes, type coercion, hoisting, semicolon injection, anonymous functions, template literals, callbacks, arrow notations, IIFE
  */

function tof (cond) {
    cond ? console.log('truthy') : console.log('falsy');
}

/**
 * TYPE COERCION
 * loosely typed programming language that is intepreted and not compiled
 * JS has to accomodate functions that operate on variables of different types
 * JS use type coercion in order to do so
 * FALSY: 0, NaN, null, undefined, "", false
 * 
 * When comparing variables/literals, we can use == or ===
 * === checks types
 */

 /**
  * OBJECTS
  */

var obj = {
    name: "Gin",
    age: 26,
    sayHi: function() {
        console.log(this.name + ' says hi');
    }
}

// THIS CONTEXT
// this keyword changes depending on if strict mode is on
// to keep the context of this, use call() or apply()
// BIND -- ECMAScript 5 introduced Function.prototype.bind. Calling f.bind(someObject) creates a new function with the same body and scope as f, but where this occurs in the original function, in the new function it is permanently bound to the first argument of bind, regardless of how the function is being used.
// ARROW FUNCTIONS -- In arrow functions, this retains the value of the enclosing lexical context's this. In global code, it will be set to the global object:

function scopes(cond) {
    var functionvar = "var declaration in a function";
    let functionlet = "let declaration in a function";
    const functionconst = "let declaration in a function";

    if(cond) {
        var blockV = 'blockVar'; // always function/global scopes
        let blockL = 'blockLet';
        const blockC = 'blockConst';
        console.log(`IN IF BLOCK --- var ${blockV} let ${blockL} const ${blockC}`)
        //blockC = 5; cannot reassign const
        console.log(`changed value of blockC = ${blockC}`);
    }

    console.log(functionvar);
    console.log(functionlet);
    console.log(functionconst);
    console.log(blockV);
    // console.log(blockL); blockscoped
    // console.log(blockC); blockscoped
    var functionVar;
    console.log(functionVar);
    noDeclaration = 'this variable was never declared but is used in a function';
    console.log(noDeclaration);
}

/*
OPERATORS
*/
let currentSession = null;
let userInfo = {
    username: "vien",
    password: "123"
}

let getUser = curr;
// default operator Session && userInfo
// if first operand is truthy, return it, else return second operand
