/**
 * 	Single JS script for entire bookstore app.
 * 	Separate functionality into methods and keep as
 * 	organized as possible.. as this will get lengthy
 */

window.onload = function() {
	loadStuff();
}

function loadStuff() {
	
	$('#homeNav').click(loadHomeView);
	
	$('#booksNav').click(loadBooksView);
//	$('#addBook').click(addBooksView);
//	$('#addBook').click(function() {
//		alert('hola');
//	});
//	$('#addBookBtn').click(addBookAction);
//	$('#addBookBtn').addEventHandler('click', addBookAction, true);
	
//	document.getElementById('addBookBtn').addEventListener('click', addBookAction, true);
//	if (document.getElementById("addBookBtn") == null) {
//		alert(1);
//	} else {
//		alert(2);
//	}
//	document.getElementById("addBookBtn").addEventListener("click", function(){
//	    alert('yes?');
//	});
	
	$('#authorsNav').click(loadAuthorView);
	$('#genresNav').click(loadGenresView);
	
}

// Add Books View
//function addBooksView(e) {
//	console.log(e);
	
//	$('#bookAddForm').html('<h4>book form</h4>');	
//	$('#bookAddForm').toggle('<h4>book form</h4>');
//}

// Show add form

// Add book action
function addBookAction() {
	
	let bookObj = {
		isbn:	$("#isbn_id").val(),
		title: 	$("#title_id").val(),
		price: 	$("#price_id").val(),
		genre_id: 	$("#genre_id").val(),
		author_id: 1
	};
	
	bookObj = JSON.stringify(bookObj);
	
	console.log(' --- > ');
	console.log(bookObj);
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {			
			console.log('data response from server');
			console.log(xhr.responseText);
		}
	};
	xhr.open('POST', 'books', true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(bookObj);
	
}

// Home View
function loadHomeView() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
	
}

// Books View
function loadBooksView() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			
			console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
			
			populateBookTable();
			
		}
		
	}
	xhr.open("GET", "books.view", true);
	xhr.send();
	
}

// Populate Books html table
function populateBookTable() {
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			books = JSON.parse(xhr.responseText);
			
			console.log(books);
			
			for(var b of books) {
				addBook(b); //helper function to create elements
			}
		}
		
	}
	xhr.open("GET", "books", true);
	xhr.send();
}

// Add Book
function addBook(b) {
	var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    console.log(b);
    cell1.innerHTML = b.isbn;
    cell2.innerHTML = b.title;
    cell3.innerHTML = b.price;
    cell4.innerHTML = b.genre_id;
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    
    document.getElementById("bookTable").appendChild(row);
}


/*****************************************************************/

// Authors View
function loadAuthorView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "authors.view", true);
	xhr.send();	
}

// Genre View
function loadGenresView() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log(xhr.responseText);
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "genre.view", true);
	xhr.send();
	
}