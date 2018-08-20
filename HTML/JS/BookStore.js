window.onload = function(){
loadGenres();
document.getElementById("addBook").addEventListener("click", addBook);
}

    function loadGenres(){
        var genres=["Cooking", "Fiction", "History", "Non-Fiction"];
        for( let i = 0; i < genres.length; i++) {
            var element = document.createElement("option");
            element.value = genres[i];
            element.innerHTML = genres[i];
            document.getElementById("genres").appendChild(element);

        }
    }

    function addBook(){
        var isbn = document.getElementById("isbn").value;
    var title = document.getElementById("title").value;
    var price = document.getElementById("price").value;
    var el = document.getElementById("genres");
    var genre = el.options[el.selectedIndex].value;
    
var row = document.getElementById.createElement("tr");
var cell1 = document.getElementById.createElement("td");
var cell2 = document.getElementById.createElement("td");
var cell3 = document.getElementById.createElement("td");
var cell4 = document.getElementById.createElement("td");
var cell5 = document.getElementById.createElement("td");

cell1.innerHTML = id;
cell2.innerHTML = isbn;
cell3.innerHTML = title;
cell4.innerHTML = price;
cell5.innerHTML = genre;

row.appendChild(cell1);
row.appendChild(cell2);
row.appendChild(cell3);
row.appendChild(cell4);
row.appendChild(cell5);
    
document.getElementById("booksTable").appendChild(row);




}