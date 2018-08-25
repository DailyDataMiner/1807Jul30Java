/*
Intro to TS:

In order to understand Angular, we must first understand Typescript.

-stric typing, arrow notation, interfaces, classes constructors,
access modifires, properties, modules*

TS is a superset of JS, mean that any valid JS code is also valid
TS code. TS code, hoever, must be TRANSPILED into JS code.

TS Data Types - one of the main featrues of TS that sets it apart
from JS is ists (optional) use of strong typing. The types are as follows:
-number, boolean, string, void, null, undefined, never, any
-a variable initialized with undefined means that the car has no value or object assigned to it
where null means that it has been set to an object whose value is undefined

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
//Strict Typing
var greeting;
greeting = 'hello';
var a;
var b;
var c;
var d;
var e; //strictly typed arrays
var tup; //a Tuple is a heterogeneous array
var f; //means f can't be reassigned to any other value
var g;
var h; //return type of functions that never return. Type guards that are never true;
//Return Types
function add(a, b) {
    return a + b;
}
var test = add(5, 6);
function neverReturns(a) {
    while (true) {
    }
}
function anyReturn(a) {
    return undefined;
}
//TS supports Enum data type
var DaysOfWeek;
(function (DaysOfWeek) {
    DaysOfWeek[DaysOfWeek["MONDAY"] = 0] = "MONDAY";
    DaysOfWeek[DaysOfWeek["TUESDAY"] = 1] = "TUESDAY";
    DaysOfWeek[DaysOfWeek["WENDNESDAY"] = 2] = "WENDNESDAY";
    DaysOfWeek[DaysOfWeek["THURSDAY"] = 3] = "THURSDAY";
    DaysOfWeek[DaysOfWeek["FRIDAY"] = 4] = "FRIDAY";
    DaysOfWeek[DaysOfWeek["SATURDAY"] = 5] = "SATURDAY";
    DaysOfWeek[DaysOfWeek["SUNDAY"] = 6] = "SUNDAY";
})(DaysOfWeek || (DaysOfWeek = {}));
;
var today = DaysOfWeek.THURSDAY;
var tomorrow = DaysOfWeek[4];
//Arrow Notation
var sayHi = function (welcome) {
    console.log(" " + welcome + " !!!! " + (9 + 10)); //evaluates inside the ${}
};
var sayHelloo = function (welcome) { return console.log(welcome + "!!!!"); };
sayHelloo('hi');
var Mike = {
    name: 'my name',
    age: 100,
    speak: function () { return console.log('TS is fun'); }
};
//Classes
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    //in classes, fucntions are called methods
    Point.prototype.getDistance = function () {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    };
    return Point;
}());
//inheritance
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    //overriding getDistance() method
    Point3D.prototype.getDistance = function () {
        var dist = _super.prototype.getDistance.call(this);
        return Math.sqrt(dist * dist + this.z * this.z);
    };
    return Point3D;
}(Point));
