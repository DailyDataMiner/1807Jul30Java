/*
window.onload = function(){
    var x = new Human("bob");
    var y = new Human("frank");
    Human.prototype.stuff = ["a","b","c"];//adding a shared array to the prototype
    x.stuff.push("d");
    console.log(x.stuff);//Prints [a,b,c,d]
    console.log(y.stuff);//Prints [a,b,c,d]
}

function Human(name) {
	this.name; 
}

*/












window.onload = function(){  
    var x = new Human("bob");
    var y = new Human("frank");
    x.stuff.push("d");
    console.log(x.stuff);//Prints [a,b,c,d]
    console.log(y.stuff);//Prints [a,b,c]
}

function Human(name){
    this.name;
    this.stuff = ["a","b","c"];//Adds an array for each instance
}
