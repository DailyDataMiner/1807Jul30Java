// $(document).ready(function() {

// });

window.onload = function() {
    // $('#namesList').click(passLiToTextBox);
    prepareClickEventsToList();
    $('#getInfo').on('click', getInfo);
}

function prepareClickEventsToList() {

    for (var i = 0; i < $('#namesList li').length; i++) {
        
        var id = $('#namesList li')[i].id;
        $('#namesList li')[i].addEventListener('click', getData, true);
    }

}
function getData() {
    var id = this.id;

}

function getInfo() {
    
    var id = $('#id').val();
//  Plain Javascript AJAX version


    // STEP 1 - OPEN REQUEST
    var xhr = new XMLHttpRequest();


    // STEP 2 - OPEN REQUEST
    xhr.onreadystatechange = function() {

        if (xhr.readyState == 4 && xhr.status == 200) {
            
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);

            console.log(swPerson);
        }

    }


    // STEP 3 - OPEN REQUEST
    // var url = `https://swapi.co/api/planets/${id}/`;
    // var url = `https://swapi.co/api/people/${id}/`;
    var url = "http://localhost:3000/users";

    // var url = "http://pokeapi.co/api/v2/pokemon/1/";
    // var url = "https://swapi.co/api/planets/"+ id +"/";

    xhr.open("GET", url, true);

    // STEP 4 - SEND REQUEST
    xhr.send();
    

// jQuery AJAX version    
    // $.ajax({
    //     url: "https://swapi.co/api/planets/1/",
    //     type: "get",
    //     success: function(data) {
    //         console.log(data);
    //     },
    //     error: function() {
    //         console.log(err);
    //     }
    // });
}