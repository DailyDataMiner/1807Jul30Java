window.onload = function () {
    $("#getInfo").on('click', doAJAX);
    $("#getInfoForTest").on("click", doAJAX) //added
}

function doAJAX() {
    var idforSW = $("#swID").val(); //input field to determine what to access

    var idforTEST = $("#testID").val(); //added

    //AJAX
    //Step 1 - create new XHR
    let xhr = new XMLHttpRequest();


    //Step 2 - define callback function
    xhr.onreadystatechange = function () {
       console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            //Define functionality for response
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
        }
    }

    //Step 3 - open request
     var url = `https://swapi.co/api/people/${idforSW}/`; //original

    //var url = `https://swapi.co/api/people/${idforTEST}/`; //added

    xhr.open("GET", url, true);

    //Step 4 - Send Request
    xhr.send(); // empty body, so no argument
}

