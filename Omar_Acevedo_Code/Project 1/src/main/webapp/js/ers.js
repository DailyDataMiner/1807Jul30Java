/**
 * 
 */
window.onload = function() {
	alert('hello there!');	
	
	loadPartials();

}

//Define function events for buttons, ... and such

function foodExpensesView() {
	console.log('foodExpensesView fn');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			$('#foodExpenseDataGoesHere').html(xhr.responseText);
			
			getActualFoodExpenseData();
			
		}
	}
	xhr.open('GET', 'foodDataView.specificView', true);
	xhr.send();
}

function getActualFoodExpenseData() {
	console.log('getActualFoodExpenseData fn');
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			foodExpenseDataObj = JSON.parse(xhr.responseText);
			console.log('foodExpenseDataObj');
			console.log(foodExpenseDataObj);
			//$('#foodDataView').html();
			
		}
	}
	xhr.open('GET', 'foodExpenses', true);	// tickets... ?
	xhr.send();
}

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