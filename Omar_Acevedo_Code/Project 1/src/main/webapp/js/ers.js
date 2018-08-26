/**
 * 
 */
window.onload = function() {
	alert('hello there!');	
	
	loadPartials();

}

//Define function events for buttons, ... and such
function getExpenses(type) {
	console.log('in getExpenses (' + type + ') fn');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
//			$('#foodExpenseDataGoesHere').html(xhr.responseText);
//			getActualFoodExpenseData();
			
			foodReimbursements = JSON.parse(xhr.responseText);
			
			for (var fbRow of foodReimbursements) {
				addReimbursement(fbRow);
			}
		}
	}
	xhr.open('GET', 'reimbursements?type='+type, true);
	xhr.send();
}

//Add Reimbursement
function addReimbursement(b) {
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

//
//function foodExpensesView() {
//	console.log('foodExpensesView fn');
//	let xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			$('#foodExpenseDataGoesHere').html(xhr.responseText);
//			
//			getActualFoodExpenseData();
//			
//		}
//	}
//	xhr.open('GET', 'foodDataView.specificView', true);
//	xhr.send();
//}
//
//function getActualFoodExpenseData() {
//	console.log('getActualFoodExpenseData fn');
//	let xhr = new XMLHttpRequest();
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState == 4 && xhr.status == 200) {
//			
//			foodExpenseDataObj = JSON.parse(xhr.responseText);
//			console.log('foodExpenseDataObj');
//			console.log(foodExpenseDataObj);
//			//$('#foodDataView').html();
//			
//		}
//	}
//	xhr.open('GET', 'foodExpenses', true);	// tickets... ?
//	xhr.send();
//}

function foodExpensesEdit() {
	console.log('foodExpensesEdit fn');
}

// Load partial pages
function loadPartials() {
	
	load('header');
	load('main');
	load('footer');
	
}

function load(partialName) {
	
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$(partialName).html(xhr.responseText);
		}
	}
	xhr.open('GET', partialName+'.view', true);
	xhr.send();
	
}