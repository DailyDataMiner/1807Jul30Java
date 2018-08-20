window.onload = function(){
    $("#getInfo").on('click', doAJAX);
}

function doAJAX(){
    var id = $('#swId').val();

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){

        if(xhr.readyState == 4 &&xhr.status == 200){

            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }   
    }
    
    var url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);

    xhr.send();
}