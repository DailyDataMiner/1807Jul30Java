window.onload = function() {
    loadGenres();
    document.getElementById("addBook").addEventListener("click", addBook);
}

function loadGenres() {
    let genres = ["Cooking", "Fiction", "History", "Non-Fiction"];
    genres.forEach(genre => {
        let element = document.createElement("option");
        element.value = genre;  // data
        element.innerHTML = genre; // what goes inside the tag
        document.getElementById("genres").appendChild(element);
    })
}

var count = 1;

function addBook() {
    let title = document.getElementById("title").value;
    let isbn = document.getElementById("isbn").value;
    let price = document.getElementById("price").value;
    let genres = document.getElementById("genres");
    let genre = genres.options[genres.selectedIndex].value;
    console.log(genre);

    let id = ++count;

    let row = document.createElement("tr");
    let cellId = document.createElement("td");
    let cellIsbn = document.createElement("td");
    let cellTitle = document.createElement("td");
    let cellPrice = document.createElement("td");
    let cellGenre = document.createElement("td");

    cellId.innerHTML = id;
    cellIsbn.innerHTML = isbn;
    cellTitle.innerHTML = title;
    cellPrice.innerHTML = price;
    cellGenre.innerHTML = genre;

    row.appendChild(cellId);
    row.appendChild(cellIsbn);
    row.appendChild(cellTitle);
    row.appendChild(cellPrice);
    row.appendChild(cellGenre);

    document.getElementById("booksTable").appendChild(row);
}