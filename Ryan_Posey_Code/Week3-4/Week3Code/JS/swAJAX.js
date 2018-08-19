window.onload = function() {
    $("#getInfo").on('click', doAJAX);
}

function doAJAX() {
    var id = $('#id').val();

    // AJAX!!
    // Step 1 - create new XHR
    var xhr = new XMLHttpRequest();

    // Step 2 - define callback function
    xhr.onreadystatechange = function() {
        console.log(xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200) {
            // Define functionality for response
            resp = xhr.responseText;
            pokemon = JSON.parse(resp);
            document.getElementById("sprite").setAttribute('src', pokemon.sprites.front_default)
            document.getElementById("name").textContent = pokemon.name.charAt(0).toUpperCase() + pokemon.name.sl;
        }
    }

    // Step 3 - Open request
    var url = `https://pokeapi.co/api/v2/pokemon/${id}/`
    xhr.open("GET", url, true);

    // Step 4 - Send request
    xhr.send();
}