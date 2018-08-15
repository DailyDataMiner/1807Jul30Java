/**
 * @author Arthur Panlilio
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

 /*
    JavaScript is a scripting language for client-side operations(
        though there are frameworks that enable server-side JS)
        -loosely typed-- variable types are dynamically allocated
        -delcare variales with var, let, const
        -supports prototypal inheritance
        -impportant related concepts: var types, scopes type coercion,
        hoisting, semicolon injection, anonymous functions, 
        template literals, callback functions, IIFE, arrow notation...
    )
 */

function tOrf(cond){
    console.log(typeof(cond));
        if(cond) {console.log(
            "condition is truthy");}
        
        else{
            console.log("condition is falsy");}}

/* -- TYPE COERCION
As a loosely typed programming language that is interpreted
and not compiled, JS has to accomodate functions that
operate on variables of different types.
JS uses type coercion in order to do so

Falsy - 0, NaN, null, undefined, '', false
Truthy - Everything else

When comparing variables/literals we can use the == or === operators
== uses type coercion
== prevents type coercion
*/

var obj = {
    name: 'Genesis',
    age: 70,
    saysHi: function(){
        console.log(name + " says hi!");
    }
}