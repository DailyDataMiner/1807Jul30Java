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
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// STRICT TYPING
var greeting;
greeting = 'hello there';
var a;
var b;
var c;
var d;
var e; // strictly typed arrays
var tup;
var f;
var g;
var h;
function add(a, b) {
    return a + b;
}
var test = add(5, 6);
//  let test = add('this is', 'a string');
function neverReturns(a) {
    while (true) {
    }
}
function anyReturn(a) {
    return undefined;
}
// TS supports Enum data type
var DaysOfWeek;
(function (DaysOfWeek) {
    DaysOfWeek[DaysOfWeek["MONDAY"] = 0] = "MONDAY";
    DaysOfWeek[DaysOfWeek["TUESDAY"] = 1] = "TUESDAY";
    DaysOfWeek[DaysOfWeek["WEDNESDAY"] = 2] = "WEDNESDAY";
    DaysOfWeek[DaysOfWeek["THURSDAY"] = 3] = "THURSDAY";
    DaysOfWeek[DaysOfWeek["FRIDAY"] = 4] = "FRIDAY";
    DaysOfWeek[DaysOfWeek["SATURDAY"] = 5] = "SATURDAY";
    DaysOfWeek[DaysOfWeek["SUNDAY"] = 6] = "SUNDAY";
})(DaysOfWeek || (DaysOfWeek = {}));
;
var today = DaysOfWeek.THURSDAY;
var tomorrow = DaysOfWeek[4];
// ARROW NOTATION
var sayHi = function (welcome) {
    console.log(welcome + "!!!! " + (9 + 10));
};
// let sayHi_an = (welcome: string) => `${welcome}`;
var sayHi_an = function (welcome) { return console.log(welcome + ")"); };
sayHi_an('hi');
var omar = {
    name: 'Omar',
    age: 28,
    speakV1: function () { return console.log('TS is fun'); },
    speakV2: function () {
        console.log('Using multiple lines in speak method');
        console.log('Using multiple lines in speak method');
    },
    hairColor: 'blackish/brownish'
};
//  Classes
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    // in classes, functions are called methods
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
//  Inheritance
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    // overriding getDistance() method
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
var pointA = new Point(10, 10);
console.log(pointA.getDistance());
var pointZ = new Point3D(1, 2, 3);
console.log(pointZ.getDistance());
