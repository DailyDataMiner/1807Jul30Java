window.onload = function(){
 

function fib(num) {
    // console.log(num);
    if (num <= 1) return 1;
    else{
        return fib(num - 1) + fib(num - 2);
    }
}
$("#output").on('click', function(){
    var myN = $('#nth').val();
    var result = fib(myN);
    $('#result').val(result);
});
    
//-------------------------------------------------------------------------

function reverseStr(someStr){
    if (someStr === "") 
        return "";

    else 
        return reverseStr(someStr.substr(1)) + someStr.charAt(0);
}
$("#reverse").on('click', function(){
    var myN = $('#str').val();
    var result = reverseStr(myN);
    $('#reverseResult').val(result);
});

//-------------------------------------------------------------------------

function factorial(num){
    if (num === 0 || num === 1)
        return 1;
        else{
            for (var i = num - 1; i >= 1; i--) {
                num *= i;
            }
        }                       
  return num;
}
$("#bfactorial").on('click', function(){
    var myN = $('#infactorial').val();
    var result = factorial(myN);
    $('#outfactorial').val(result);
});

//-------------------------------------------------------------------------

function substringy(str, offset){
    var strlength = str.length;
    console.log(strlength);
    var someStr = str.substring(offset,strlength);
    console.log(someStr);
    return someStr;
}

$("#boffset").on('click', function(){
    var str1 = $('#fulltext').val();
    var offset1 = $('#inoffset').val();
    var result = substringy(str1, offset1);
    $('#outoffset').val(result);
});

//-------------------------------------------------------------------------

function isEven(snum){
    if (snum == 0)
        return true;
    else if (snum == 1)
        return false;
    else if (snum < 0)
        return isEven(-snum);
    else
        return isEven(snum- 2);
}

$("#bint").on('click', function(){
    var num = $('#inint').val();
    var result = isEven(num);
    if (result == true)
        $('#outint').val("Yes");
    else
        $('#outint').val("No");
});

//-------------------------------------------------------------------------

$("#bpali").on('click', function(){
    var num = $('#inpali').val();
    var result = reverseStr(num);
    if (result == num)
        $('#outpali').val("Yes");
    else
        $('#outpali').val("No");
});


//-------------------------------------------------------------------------

function bignum(intval){
    var intvalstr =  intval.toString();
    var arr = [];
    var after = "";
    for (var i=0; i<intvalstr.length; i++){
        arr[i] = intvalstr[i];
    }
    arr = arr.reverse(arr.sort());
    for (var j=0; j<arr.length; j++){
        after += arr[j];
        console.log(after);
    }
    return after;        

}

    



$("#bbn").on('click', function(){
    var num = $('#inbn').val();
    var result = bignum(num);
    $('#outbn').val(result);
       
});






//-------------------------------------------------------------------------
function updateClock() {
    var now = new Date(), // current date
        months = ['January', 'February', '...']; // you get the idea
        time = now.getHours() + ':' + now.getMinutes()  + ':' + now.getSeconds(), // again, you get the idea

        // a cleaner way than string concatenation
        date = [now.getDate(), 
                months[now.getMonth()],
                now.getFullYear()].join(' ');

    // set the content of the element with the ID time to the formatted string
    document.getElementById('time').innerHTML = [date, time].join(' / ');

    // call this function again in 1000ms
    setTimeout(updateClock, 1000);
}
updateClock(); // initial call


    
}
