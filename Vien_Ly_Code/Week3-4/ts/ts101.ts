/*
    Strong typing (optional)
        number, bolean, string, void, null, undefined, never, any
        variable init as undefined means that var has no value or object assigned to it
        where as null means that it has been set to an object whose value is undefined
*/

let greeting: string = 'hello';
let a: number;
let b: boolean;
let c: string;
let d: object;
let e: string[];
let tup: [1, 'string', {}];
let f: null;
let g: any;
let h: never; // return type of function that never return, type guards that are never true

function add(a: number, b: number): number {
    return a + b;
}

function neverReturn(a: string): never {
    while (true) {

    }
}

/*
    TS ENUM
*/

enum DaysOfWeek {
    MONDAY = 0,
    TUESDAY = 1,
    WEDNESDAY = 2,
    THURSDAY = 3,
    FRIDAY = 4,
    SATURDAY = 5,
    SUNDAY = 6
};

let today = DaysOfWeek.FRIDAY;

/*
    ARROWS
*/

let sayHello = function (welcome: String) {
    console.log(`${welcome}!`);
}

let sayHi = (welcome: String) => {
    console.log(`${welcome}!`);
}

/*
    INTERFACES
*/
interface Human {
    name: String;
    age: number;
    hairColor?: String; //optional
    speak(): void;
}

let gin: Human = {
    name: 'gin',
    age: 26,
    speak: () => console.log('learning ts')
}

/*
    CLASS
*/
class Point {
    x: number;
    y: number;

    constructor(x: number, y: number) {
        this.x = x;
        this.y = y;
    }

    getDistance() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
}

let ptA: Point = new Point(10, 10);
console.log(ptA.getDistance());


/*
    INHERITANCE
*/
class Point3D extends Point {
    z: number;

    constructor(x: number, y: number, z: number) {
        super(x, y);
        this.z = z;
    }

    getDistance() {
        let d = super.getDistance();
        return Math.sqrt(Math.pow(d, 2) + Math.pow(this.z, 2));
    }
}

