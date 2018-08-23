/**
 * Intro to TS:
 *  In onder to understand Angular, we must first understand TypeScript.
 *  - script typing, arrow notation, interfaces, classes, constructors,
 *      acces modifiers, properties, modules*
 * 
 * TS is a superset of jS, meaning that any valid JS code is also valid TS code.
 * TS code, however, must be TRANSPILED into JS code. 
 * 
 * TS Data Types - one of the main features of TS that sets it apart from JS 
 * is its (optional) use of strong typing. The types are as folles:
 *  - number, boolean, string, void, null, undefined, never any
 * A variable initialized with undefined means that the car has no value or ojbect assigned to it,
 * whereas null means that it has been set to an object whose value is undefined.
 * 
 */

 // STRICT TYPING
 let greeting: string;
 greeting = 'hello there';

 let a: number;
 let b: boolean;
 let c: string;
 let d: object;
 let e: string[];   // strictly typed arrays
 let tup: [1, 'this is a string', {}];
 let f: null;
 let g: any;
 let h: never;

 function add(a: number, b: number): number {
     return a + b;
 }

 let test = add(5, 6);
//  let test = add('this is', 'a string');

function neverReturns(a: string): never {
    while (true) {

    }
}

function anyReturn(a: any): any {
    return undefined;
}

// TS supports Enum data type
enum DaysOfWeek {
    MONDAY      = 0,
    TUESDAY     = 1,
    WEDNESDAY   = 2,
    THURSDAY    = 3,
    FRIDAY      = 4,
    SATURDAY    = 5,
    SUNDAY      = 6
};

let today = DaysOfWeek.THURSDAY;
let tomorrow = DaysOfWeek[4];

// ARROW NOTATION
let sayHi = function(welcome: string) {
    console.log(`${welcome}!!!! ${9+10}`);
}

// let sayHi_an = (welcome: string) => `${welcome}`;
let sayHi_an = (welcome: string) => console.log(`${welcome})`);
sayHi_an('hi');

interface Human {
    name: string;
    age: number;
    speakV1(): void;
    speakV2(): void;
    hairColor?: string; // optional properties
}

let omar: Human = {
    name: 'Omar',
    age: 28,
    speakV1: () => console.log('TS is fun'),
    speakV2: () => {
        console.log('Using multiple lines in speak method');
        console.log('Using multiple lines in speak method');
    },
    hairColor: 'blackish/brownish'
};

//  Classes
class Point {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    // in classes, functions are called methods
    getDistance() {
        return Math.sqrt(this.x * this.x  + this.y * this.y);
    }
}

//  Inheritance
class Point3D extends Point {
    z: number;
    constructor(x: number, y: number, z: number) {
        super(x, y);
        this.z = z;
    }

    // overriding getDistance() method
    getDistance() {
        let dist = super.getDistance();
        return Math.sqrt(dist * dist + this.z * this.z);
    }
}

let pointA = new Point(10, 10);
console.log(pointA.getDistance());

let pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());