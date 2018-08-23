var myObj = (function() {
    var myVar = "a value here";
    function myFn() {
        console.log(myVar);
    }
    var myObj = {};
    myObj.show = function() {
        myFn();
    }
    return myObj;
})();

myObj.show();