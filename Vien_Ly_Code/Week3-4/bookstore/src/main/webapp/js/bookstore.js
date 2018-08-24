/**
 * 
 */

$(document).ready(() => {
	loadHomeView();
	$("#homeNav").on("click", loadHomeView);
	$("#booksNav").on("click", loadBookView);
	$("#authorsNav").on("click", loadAuthorView);
	$("#genresNav").on("click", loadGenreView);

})

function loadHomeView() {
	$("#homeNav").addClass("active").siblings().removeClass("active");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$("#view").html(xhr.responseText);
		}
	}

	xhr.open("GET", "home.view");
	xhr.send();
	
}

function loadBookView() {
	$("#booksNav").addClass("active").siblings().removeClass("active");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$("#view").html(xhr.responseText);
			populateBooks();
		}
	}

	xhr.open("GET", "book.view");
	xhr.send();
}

function populateBooks() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let books = JSON.parse(xhr.responseText);
			for (let book of books) {
				appendBookRow(book);
			}
		}
	}

	xhr.open("GET", "books");
	xhr.send();
}

function appendBookRow(b) {
	console.log(b);
	let row = document.createElement("tr");
	
	for (let col of ["isbn", "title", "price", "genreId"]) {
		let cell = document.createElement("td");
		cell.textContent = b[col];
		row.appendChild(cell);
	}
	
	document.getElementById("bookTableBody").appendChild(row);
	
}

function loadAuthorView() {
	$("#authorsNav").addClass("active").siblings().removeClass("active");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$("#view").html(xhr.responseText);
		}
	}

	xhr.open("GET", "author.view");
	xhr.send();
}

function loadGenreView() {
	$("#genresNav").addClass("active").siblings().removeClass("active");
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$("#view").html(xhr.responseText);
		}
	}

	xhr.open("GET", "genre.view");
	xhr.send();
}