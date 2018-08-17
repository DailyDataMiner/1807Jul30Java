window.onload = function(){
    $('#getInfo').on('click', doAJAX);
}


function doAJAX(){
    var string = $('#id').val();
    string =  string.replace(/\s+/g, '%20')

    //AJAX!!
    //Step 1 = create new XHR -XMLHttpRequest
    var xhr = new XMLHttpRequest();

    //Step 2 = define callback function
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //Define Functionality For Response
            resp = xhr.responseText;
            speak = JSON.parse(resp);
            document.getElementById("output").innerHTML = speak.yodish;
        } else if (xhr.status == 429){
            document.getElementById("output").innerHTML = "Made too many requests, you have. Try again later, you will. (429 error)"
        } else if (xhr.status == 500){
            document.getElementById("output").innerHTML = "Server Error!. (500 error)"
        }
    }
    //Step 3 = open request
    var url = `http://yoda-api.appspot.com/api/v1/yodish?text=${string}`;

    xhr.open("GET",url, true);
   
    //Step 4 = send request;
    xhr.send();
    
}