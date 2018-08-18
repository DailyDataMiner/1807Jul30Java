window.onload = function() {
    loadGenres();
    document.getElementById("addBook").addEventListener("click", addBook);
}

function loadGenres() {
    var genres = ["Cooking", "Fiction", "History", "Non-Fiction"];
    for (let i = 0; i < genres.length; i++) {
        var element = document.createElement("option");
        element.value = genres[i];
        element.innerHTML = genres[i];
        document.getElementById("genres").appendChild(element);
    }
}
var count = 0;
function addBook() {

    var title = document.getElementById("title").value;
    var isbn = document.getElementById("isbn").value;
    var price = document.getElementById("isbn").value;

    var genres = document.getElementById("genres");
    var genre = genres.options[genres.selectedIndex].value;
    var id = ++count;

    var bookObj = {
        id: id,
        isbn: isbn,
        title: title,
        price: price,
        genre: genre
    };
    
    createTableRow(bookObj);

    var inputs = document.getElementsByClassName("bookInputs");
    for (var i = 0; i < inputs.length; i++) {
        
        inputs[i].value = "";

    }

    console.log(bookObj);

}

function createTableRow(bookObj) {

    // Let's append a row to booksTable
    /*
                      <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                  </tr>
    */
   var booksTable = document.getElementById("booksTable");
//    booksTable.insertRow("tr").insertCell("td").innerHTML = "hey";

   var row = document.createElement("tr");
   var cell1 = document.createElement("td");
   var cell2 = document.createElement("td");
   var cell3 = document.createElement("td");
   var cell4 = document.createElement("td");
   var cell5 = document.createElement("td");
   
   cell1.innerHTML = bookObj.id;
   cell2.innerHTML = bookObj.isbn;
   cell3.innerHTML = bookObj.title;
   cell4.innerHTML = bookObj.price;
   cell5.innerHTML = bookObj.genre;

   row.appendChild(cell1);
   row.appendChild(cell2);
   row.appendChild(cell3);
   row.appendChild(cell4);
   row.appendChild(cell5);
   
    booksTable.append(row);
}