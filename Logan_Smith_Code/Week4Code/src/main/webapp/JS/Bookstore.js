/**
 * 
 */

window.onload=function() {
	loadHomeView();
	$('#homeNav').on('click', loadHomeView);
	$('#booksNav').on('click', loadBooksView);
	//$('#genresNav').on('click', loadGenresView);
}

function loadHomeView() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			//just showing what we're getting back for now
			//console.log(xhr.responseText);
			if(xhr.readyState == 4 && xhr.status == 200){
				$('#view').html(xhr.responseText);
			}
			
		}
		xhr.open("GET", "loadHome");
		xhr.send();
}
	function loadBooksView() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				$('#view').html(xhr.responseText);
				populateBookTable();
			}
		}
		xhr.open("GET", "loadBooks");
		xhr.send();
	}
	
	function populateBookTable() {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200){
				var books = JSON.parse(xhr.responseText);
				for (var b of books) {
					addBook(b);
				}
			}
		}
		xhr.open("GET", "books");
		xhr.send();
	}
	
	function addBook(b) {
		var row = document.createElement("tr");
		var cell1 = document.createElement("td");
		var cell2 = document.createElement("td");
		var cell3 = document.createElement("td");
		var cell4 = document.createElement("td");
		
		cell1.innerHTML = b.id;
		cell2.innerHTML = b.title;
		cell3.innerHTML = b.price;
		cell4.innerHTML = b.genreid;
		
		row.appendChild(cell1);
		row.appendChild(cell2);
		row.appendChild(cell3);
		row.appendChild(cell4);
		
		document.getElementById("BookTable").appendChild(row);
	}