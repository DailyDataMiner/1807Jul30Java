var date = new Date();


var seconds = date.getSeconds();
var minutes = date.getMinutes();
var hour = date.getHours();
if(hour >= 12){
    hour -= 12;
}
hour = (60*hour)+minutes
$('#hourHand').css('transform','rotate('+ hour*.5 +'deg)');
$('#minuteHand').css('transform','rotate('+minutes*6 +'deg)');
$('#secondHand').css('transform','rotate('+ seconds*6 +'deg)');

var hrC = hour*.5;
var minC = minutes*6;
var secC = seconds*6;

setInterval(rotate, 1000);

function rotate(){
    if(minC >= 360){
        minC = 0;
    }
    if(secC >= 360){
        secC = 0;
    }
    hrC += .01;
    minC += .1;
    secC += 1;
    $('#hourHand').css('transform','rotate('+ hrC +'deg)');
    $('#minuteHand').css('transform','rotate('+ minC +'deg)');
    $('#secondHand').css('transform','rotate('+ secC +'deg)');
}