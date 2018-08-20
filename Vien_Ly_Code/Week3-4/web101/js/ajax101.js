window.onload = function () {
    $("#getSWInfo").on("click", getSWInfo);
    $("#getDogPicture").on("click", getDog);
}

function getSWInfo() {
    let id = $("#swID").val();

    // 1. new XML request object
    let xhr = new XMLHttpRequest();
    // 2. define callback
    xhr.onreadystatechange = () => {
        console.log(xhr.readyState);
        if (xhr.readyState == 4 && xhr.status == 200) {
            resp = xhr.responseText;
            swPerson = JSON.parse(resp);
            console.log(swPerson);
        }
    }
    // 3. open request
    let url = `https://swapi.co/api/people/${id}/`;
    xhr.open("GET", url, true);

    // 4. send request
    xhr.send();
}

function getDog() {
    let breed = $("#breed").val();
    let result = "";
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 && xhr.status == 200) {
            let resp = xhr.responseText;
            let dog = JSON.parse(resp);
            result = dog["message"];
            console.log(result);
            $("#dogPicture").attr("src", result);
        }
    }

    let url = `https://dog.ceo/api/breed/${breed}/images/random`;
    xhr.open("GET", url, true);

    xhr.send();
}