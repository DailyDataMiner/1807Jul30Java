window.onload = function(){
   // alert('Revature Homework');
  //add event listener
//add event listener(event, function, propagate)
//var text = $("#fibbo").val();
//document.getElementById("enter").addEventListener("click",fib(text));



  var shaptyp=["Triangle","Square","Diamond"];
  for(let i=0; i < shaptyp.length; i++){
    var element = document.createElement("option");
    element.value = shaptyp[i];
    element.innerHTML = shaptyp[i];
    document.getElementById("shaptyp").appendChild(element);
}
  $('#enter').on('click', fib);
  $('#enterf').on('click', factorial);
  $('#enteri').on('click', isEven);
  $('#entevo').on('click', reverse);
  $('#entepi').on('click', palindrome);
  $('#entendo').on('click', descending);
  $('#enshap').on('click', shaping);
  $('#entersub').on('click', substringing);
  $('#endell').on('click', personing);
  $('#enbling').on('click', bubbling);
  
}
function fib(){
    let nn = $('#fibbo').val();
    var i=0;
    let n=0;
    var nextn=1;
    var sum=0;

while (i < nn){
    sum = n + nextn;
    n = nextn;
    nextn = sum;
    i++;
 }
 $('#result').html(n);

}

function factorial() {
    let numba = $('#facto').val();
    let factor = 1;
    let ial = 1;
    while(ial <= numba){
        factor = factor * ial;
        ial++;
    }
    $('#resultf').html(factor);
}
function isEven() {
     let numer = $('#even').val(); 
     var checking = true;
    for(var i=1; i <= numer; i++ ) {
        checking = !checking;		
    }
    if(checking){  $('#resulti').html(" Even ");}
    else {$('#resulti').html("Not Even ");}
}
function reverse(){
    let word = $('#revo').val(); 
    let rword = word.split("").reverse().join("");
    $('#relevo').html(rword);
    
}
function palindrome(){
    let wordi = $('#pali').val(); 
    let rwordi = wordi.split("").reverse().join("");
    if(wordi == rwordi){
    $('#resupi').html(wordi + " is a Palindrome");
    } else { $('#resupi').html(wordi + " is not a Palindrome");}

}
function descending(){
    let lista = $('#desco').val();
    let nlista= lista.split(" ");
    for(var b=0; b< nlista.length; b++) { nlista[b] = +nlista[b]; }    
        var swap = true;
                for(var np =1; np < nlista.length && swap; np++) {
                    swap = false;
                    for(var i= 0; i < nlista.length - np; i++) {
                        if(nlista[i] < nlista[i+1]) {
                            var temp = nlista[i];
                            nlista[i] = nlista[i + 1];
                            nlista[i + 1] = temp;
                            swap = true;        
                        }
                    }	
                }
       
                $('#resultado').html(nlista.toString());
    
}
function shaping(){
    var el = document.getElementById("shaptyp");
      var shape = el.options[el.selectedIndex].value
      let limit = $('#rown').val();
      let symbolbe= $('#symb').val();

if(shape == "Triangle"){
  var i, j;
  for(i=1; i <= limit; i++)
   {
    for(j=1; j<=i; j++)
   {
     document.write(symbolbe);
    }
      document.write('<br/>');
   }
}
if(shape == "Square"){
    for(i=1; i <= limit; i++){
     for(j=1; j<= limit; j++){
      document.write(symbolbe);
     }
     document.write('<br/>');
    }

}
if(shape == "Diamond"){
   var space = limit - 1;

        for (var i = 0; i < limit; i++)
        {
            for (var j = 0; j < space; j++)
                document.write("&nbsp");

            for (var j = 0; j <= i; j++)
             document.write(symbolbe);
     
             document.write('<br/>');
            space--;
        }
        space = 0;
     
        for (var i = limit; i > 0; i--)
        {
            for (var j = 0; j < space; j++)
                document.write("&nbsp");
    
            for (var j = 0; j < i; j++)
            document.write(symbolbe);
            document.write('<br/>');
            space++;
        }
    }

}
function substringing(){
    var word = $('#yword').val();
    var length = $('#ylength').val();
    var offset = $('#yoffset').val();
    if(isNaN(length) || isNaN(offset))
          alert("You must enter a number for the length or the offset.");
    $('#resultsub').html(word.substring(offset,length));
   
}
function bubbling(){
    let lista = $('#bubble').val();
    let nlista= lista.split(" ");
    for(var b=0; b< nlista.length; b++) { nlista[b] = +nlista[b]; }    
        var swap = true;
                for(var np =1; np < nlista.length && swap; np++) {
                    swap = false;
                    for(var i= 0; i < nlista.length - np; i++) {
                        if(nlista[i] > nlista[i+1]) {
                            var temp = nlista[i];
                            nlista[i] = nlista[i + 1];
                            nlista[i + 1] = temp;
                            swap = true;        
                        }
                    }	
                }
       
                $('#bubleresult').html(nlista.toString());

}
function Person(name, age) {
    this.name = name;
    this.age = age;
                   
} 
function personing(){
    var john = new Person($('#nome').val(),$('#idade').val());
    document.getElementById("resultobj").innerHTML = john.name + " is " + john.age + " years old."; 
}







