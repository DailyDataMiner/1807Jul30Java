window.onload = function() {
    loadGenres();
    this.document.getElementById("addBook").addEventListener("click", addBook);
}

function loadGenres() {
var genres =["Adult Fiction", "YA Fiction", "Horror", "Detective"];
for (let i = 0; i < genres.length; i++) {
    var element = document.createElement("option");
    element.value = genres[i];
    element.innerHTML = genres[i];
    document.getElementById("genres").appendChild(element);
}
}

var count = 1;

function addBook() {
var ispn = document.getElementById("ispn").value;
var price = document.getElementById("price").value;
var title = document.getElementById("title").value;
var temporaryE = document.getElementById("genres");
var genre = temporaryE.options[temporaryE.selectedIndex].value;
var id = ++count;

var row = document.createElement("tr");
var cellData1 = document.createElement("td");
var cellData2 = document.createElement("td");
var cellData3 = document.createElement("td");
var cellData4 = document.createElement("td");
var cellData5 = document.createElement("td");

cellData1.innerHTML = id;
cellData2.innerHTML = ispn;
cellData3.innerHTML = title;
cellData4.innerHTML = price;
cellData5.innerHTML = genre;

row.appendChild(cellData1);
row.appendChild(cellData2);
row.appendChild(cellData3);
row.appendChild(cellData4);
row.appendChild(cellData5);

document.getElementById("Books Table").appendChild(row);

}