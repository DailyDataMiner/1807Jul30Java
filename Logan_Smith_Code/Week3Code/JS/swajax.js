window.onload = function () {
    $('#getInfo').on("click", doAjax);
}
//$('#')
function doAjax() {
    var id = $('#id').val();

    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
            resp = xhr.responseText;
            dog = JSON.parse(resp);
            document.getElementById("dogimg").setAttribute('src', dog.message);
            console.log(dog);
        }
    }

    var url = `https://dog.ceo/api/breed/pug/images/random`;
    xhr.open("GET", url, true);

    xhr.send();
}