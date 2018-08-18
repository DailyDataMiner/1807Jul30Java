/**
 * @author  Omar Acevedo
 * @name    Core-JS-Concepts
 * 
 */


 function truthyFalsy(cond) {
     if (cont) {
        console.log("condition is truthy");
     } else {
         console.log("condition is falsy");
     }
 }

 // Objects
 var obj = {
     name:  "Omar",
     age: 28,
     saysHi: function() {
         console.log(this.name + " says hi.");
     }
 };

 