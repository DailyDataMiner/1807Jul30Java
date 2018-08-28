/*
Intro to TS:

In Order to understand Angular, we must first understand TypeScript.

- strict typing, arrow notation, interfaces, classes, constructors, 
access modifiers, properties, modules*

TS is a superset of JS, meaning that any valid JS code is also valid
TS code. TS code, however, must be TRANSPILED into JS code. 

TS Data Types - one of the main features of TS that sets it apart from
JS is its (optional) use of strong typing. The types are as follows:
    -number, boolean, string, void, null, undefined, never, any

- a variable initialized with undefined meands taht the var has no value
or object assigned to it
whereas null means taht it has been set to an object whose value is undefined
*/

//STRICT TYPING
let greeting: string;
greeting = 'hello';

let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[]; //strictly typed arrays
let tup: [1, 'this',{}];//a TUPLE is a heterogenous array
let f: null;
//f = 5; //reassignment does not compile
let g: any;
let h: never;
//return type of functions that never return. type guards that are never true

//Return Types
function add(a, b){
    return a + b;
}

let test = add(5, 6);
let test2 = add('hi', 'uajpp');

function neverReturns(a: string):never{ //never reaches end of method
    while(true){

    }
}

function anyReturn(a: any):any{
    return undefined;
}

//TS supports Enum data type
enum DaysOfWeek{
    MONDAY = 0,
    TUESDAY = 1,
    WEDNESDAY = 2,
    THURSDAY = 3,
    FRIDAY = 4,
    SATURDAY = 5,
    SUNDAY = 6
};

let today = DaysOfWeek.THURSDAY;
let tomorrow;
tomorrow = DaysOfWeek[4]; 

//ARROW NOTATION
let sayHi = function(welcome: string){
    console.log(` ${welcome}!!!!`);
}

let sayHelloo = (welcome:string) => console.log(` ${welcome}!!!!`);
sayHelloo("hi");


//Interfaces
interface Human{
    name: string;
    age: number;
    hairColor?: string; //optional properties

    speak(): void;
}

let gen: Human = {
    name: 'my name',
    age: 100,
    speak: ()=>{
        console.log('arrow notation');
        console.log('TS is fun');
    },
    hairColor: `brown`
}


/*
*Classes
*/
class Point{
    x: number;
    y: number;

    constructor(x:number, y:number){
        this.x = x;
        this.y = y;
    }

    //in classes functions are called methods

    getDistance(){
        return Math.sqrt(this.x*this.x +this.y*this.y);
    }

}

let pointA = new Point(10, 10);
console.log(pointA.getDistance());

//inheritance
class Point3D extends Point{
    z: number;

    constructor(x:number, y:number, z:number){
        super(x,y);
        this.z = z;
    }

    //Overriding getDistance() method
    getDistance(){
        let dist = super.getDistance();
        return Math.sqrt(dist*dist + this.z*this.z);
    }
    
}

let pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());


class car{
    readonly brand: string;
}
let cr = new car();

//cr.brand = "a";
class car2{
    readonly brand: string;
    constructor(brand: string){
        this.brand = brand;
    }
}


class Calculator{
    static add(a: number, b:number):number{
        return a+b;
    }
}

abstract class Account{
    abstract generateReports():void;
}

class CheckingAccount extends Account{
    generateReports(){
        console.log('concrete');
    }

}