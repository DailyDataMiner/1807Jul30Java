/**
 * @author Genesis Bonds
 * @name Core-JS-Concepts
 * @since 8/14/18
 */

 /*
 JavaScript is a scripting language for client side operations
    (though there are frameworks that enable server side JS)
    -loosely typed -- variable types are dynamically allocated
    -decalre variables with var, let, const
    -supports prototypal inhereitance
    -important related concepts: var types, scopes, type cocerion, 
    hoisting, semicolong injection, anonymous functions,
    template literals, callback functions, IIFE, arrow notation...
 */

 //cannot reassign variable of type const
 
 //let and const alllow for the use of block scope
        var functionvar = "this is declared using var in a function]";
        let functionlet = this is delcared using let in a function";
        const funionaConst = "declared using const in a function";
        inf(cond){
            var blockW = "black var";
            let block1= "block let";
            const blockC = "block const";
            console.log(`IN IF BLOCK ---var $(block`)
        }
    }

 function truthyFalsy(cond){//if true
    if(cond){
        console.log(//same as sysout; jsut browser console
        "condition is truthy");
    }
    else {console.log("condition is falsy");
}}
/*--Type COCERION
As a losely typed programming language that is interpreted 
and not compiled, JS has to accomodate functions that 
operate on variables of different types.
JS uses type cocerion in order to do so

Falsy - 0, NaN, null, undefined, '', false
Truthy - everything else

When comparing variables/literals we can use == or === operators
== uses type cocerions 
=== prevents

 */

 //OBJECTS

 var obj = {
     name: 'Genesis',
     age: 70,
     saysHi: function(){
         console.log(this.name + 'says hi!');
     } 
    
 }
 //how to access object porperties:
 obj.name
 obj["name"]

 //delete properties:
 delete obj.name



















































































///-------------------------Operators
var currentSession = null;
var userInfo = {username: "gbonds", password: 123};

var getUser = currSession && userInfo;

/** DEFUALT OPERATOR |Session && userInfo;
 * 
 * if the first operand is truthy, return it
 * otherwis return the second operand
 * 
 */


 var earlyLeave = 1;
 var regularLevae = 530;
 var timeOUt = earlyLeave || regularLeave;








