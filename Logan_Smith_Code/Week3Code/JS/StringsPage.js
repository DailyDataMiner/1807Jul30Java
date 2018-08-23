window.onload = function () {
    doAjax();
    $('#newString').on("click", doAjax);
}
//$('#')
function doAjax() {
    var id = $('#id').val();

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            resp = xhr.responseText;
            stringResponse = JSON.parse(resp);
            document.getElementById("stringOfTheDay").innerHTML = stringResponse.quote;
            document.getElementById("authorOfTheDay").innerHTML = stringResponse.author;
        }
    }

    var url = `https://talaikis.com/api/quotes/random/`;
    xhr.open("GET", url, true);

    xhr.send();
}