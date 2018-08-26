/**
 * 
 */
window.onload = function() {
	alert('hello there!');	
	
	loadPartials();
	var gReimbursements;
	var gType;
	
}

//Define function events for buttons, ... and such
function getExpenses(type) {
	console.log('in getExpenses (' + type + ') fn');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
//			We first get the data
			gReimbursements = JSON.parse(xhr.responseText);
			console.log(gReimbursements);
			
//			Then, we get the foodExpenses data table view to put inside modal
			load('reimbursementsDataView');

		}
	}
	xhr.open('GET', 'reimbursements?type='+type, true);
	xhr.send();
}


function addExpenses(type) {
	gType = type;
	load('reimbursementsFormView');
}

function addRequest() {
	console.log('addRequest gType -> ' + gType);
	
	let reimbursementObj = {
			description: $('#description').val(),
			amount: $('#amount').val(),
			receipt: $('#receipt').val()
	};
	
	reimbursementObj = JSON.stringify(reimbursementObj);
	
	console.log(' --- > ');
	console.log(reimbursementObj);
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('data response from server -> ');
			console.log(reimbursementObj);
//			load('reimbursementsFormView');
		}
	}
	xhr.open('POST', 'reimbursements?type='+gType, true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(reimbursementObj);
	
}

function _addExpenses(type) {
	console.log('addExpenses fn -> ' + type);
	
	
//	let bookObj = {
//			isbn:	$("#isbn_id").val(),
//			title: 	$("#title_id").val(),
//			price: 	$("#price_id").val(),
//			genre_id: 	$("#genre_id").val(),
//			author_id: 1
//	};
		
	reimbursementObj = JSON.stringify(reimbursementObj);
		
	console.log(' --- > ');
	console.log(reimbursementObj);
	
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log('data response from server -> ');
			console.log(reimbursementObj);
			load('reimbursementsFormView');
		}
	}
	xhr.open('POST', 'reimbursements?type='+type, true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(reimbursementObj);
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
						
			if ($('#'+partialName+'').html() !== undefined) {
				$('#'+partialName+'').html(xhr.responseText);
				
				if (partialName == 'reimbursementsDataView') {
					for (var fbRow of gReimbursements) {
						generateRows(fbRow);
					}
				}
				
			} else {
				$(partialName).html(xhr.responseText);
			}
		}
	}
	xhr.open('GET', partialName+'.view', true);
	xhr.send();
	
}

//Add Reimbursement rows
function generateRows(b) {
	
	var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    var cell7 = document.createElement("td");
    var cell8 = document.createElement("td");
    var cell9 = document.createElement("td");
    console.log(b);
    cell1.innerHTML = b.ticket_id;
    cell2.innerHTML = b.ticket_status;
    cell3.innerHTML = b.created_on;
    cell4.innerHTML = b.description;
    cell5.innerHTML = b.reimb_type;
    cell6.innerHTML = b.amount;
    cell7.innerHTML = b.reimb_status;
    cell8.innerHTML = b.resolver;
    cell9.innerHTML = b.receipt;
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    row.appendChild(cell8);
    row.appendChild(cell9);
    
    document.getElementById("reimbursementsDataViewRows").appendChild(row);
}