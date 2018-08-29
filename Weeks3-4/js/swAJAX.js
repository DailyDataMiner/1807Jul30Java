window.onload = function(){
    $("#getInfo").on('click', doAJAX)
}

function doAJAX(){
    var id =$('id').val();

    //AJAX!!!!!!
    //Step 1 - create new XHR 
    var xhr = new XMLHttpRequest();

    //STEP 2 - define callback function 
    xhr.onreadystatechange = function(){
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //DEFINE FUNCTIONALITY FOR RESPONSE 
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }
    }

    //Step 3 - OPEN

    var url = 'https://swapi.co/api/people/$(id)/';
    xhr.open("GET", url,true);

    //SEND 4 - SEND REQUEST
    xhr.send();
}