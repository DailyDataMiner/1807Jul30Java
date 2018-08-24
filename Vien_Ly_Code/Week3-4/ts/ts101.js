/*
    Strong typing (optional)
        number, bolean, string, void, null, undefined, never, any
        variable init as undefined means that var has no value or object assigned to it
        where as null means that it has been set to an object whose value is undefined
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
var greeting = 'hello';
var a;
var b;
var c;
var d;
var e;
var tup;
var f;
var g;
var h; // return type of function that never return, type guards that are never true
function add(a, b) {
    return a + b;
}
function neverReturn(a) {
    while (true) {
    }
}
/*
    TS ENUM
*/
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
var today = DaysOfWeek.FRIDAY;
/*
    ARROWS
*/
var sayHello = function (welcome) {
    console.log(welcome + "!");
};
var sayHi = function (welcome) {
    console.log(welcome + "!");
};
var gin = {
    name: 'gin',
    age: 26,
    speak: function () { return console.log('learning ts'); }
};
/*
    CLASS
*/
var Point = /** @class */ (function () {
    function Point(x, y) {
        this.x = x;
        this.y = y;
    }
    Point.prototype.getDistance = function () {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    };
    return Point;
}());
var ptA = new Point(10, 10);
console.log(ptA.getDistance());
/*
    INHERITANCE
*/
var Point3D = /** @class */ (function (_super) {
    __extends(Point3D, _super);
    function Point3D(x, y, z) {
        var _this = _super.call(this, x, y) || this;
        _this.z = z;
        return _this;
    }
    Point3D.prototype.getDistance = function () {
        var d = _super.prototype.getDistance.call(this);
        return Math.sqrt(Math.pow(d, 2) + Math.pow(this.z, 2));
    };
    return Point3D;
}(Point));
