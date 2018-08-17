/**
 * @author Tiffannie Mac Donald
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

/*
JavaScript is a scripting language for a client-side operations(though there are frameworks
that enable server-side JS)
-loosely type- the variable types are dynamically allocated
-declare variables with var, let, const
-JS supports prototypal inheritance
-important concepts: var types, scopes, type coercion, hoisting, semicolon injection
    anonymous functions, template literals, arrow notation, callback functions, IIFE ...
*/

function truthyFalsy(cond)
    if(cond){
        console.log("condition is truthy");
    }
    else {
        console.log("Condition is falsy");
    }

/* --TYPE COERCION
As a loosely typed programming language that is interpreted and not compiled, JS has to 
accomodate functions that operate on variables of different types. JS uses type
coercion in order to do so 

FALSY - 0, NaN, null, undefined, ''.false anything that returns false
TRUTHY- everything else

When comparing variables/literals we can use == or === operators
== uses type coercion
=== prevents typer coercion

object literal is denoted by {}

*/

var obj = {
    name: 'Gen', age:70, sayHi: function(){
        console.log(this.name + ' says hi')
    }
}
// access object properties
obj.name;

// delete properties
// delete obj.name;

function scopes(){
    var functionvar = "this is declared using var in a function";
    let functionlet = "this is declared using let in a function";
    const functionConst = "declared using const in a function";
    // javascript will interpret and guess where a semicolon is
    //put the semicolon there to avoid it injecting a ; where its unneeded
    if(cond){
        var blockV = "block var";
        var blockL = "block let";
        var blockC = "block const";
        console.log(`IN IF BLOCK --- var ${blockV},let ${blockL}, const ${blockC}`);
    }
    console.log(functionvar);
    console.log(functionlet);
    console.log(functionConst);
    console.log(blockV);
    console.log(blockL);
    console.log(blockC);

    
}