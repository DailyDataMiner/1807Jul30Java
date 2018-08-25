window.onload = function() {
	
//	document.getElementById("accountNav")
//	.addEventListener("click", loadAccountsView(), true);
	
	$('#accountNav').on('click', loadAccountsView);
	$('#test1').on('click', loadAccountsView);
	$('#usersTestNav').on('click', loadUsersView);
	
}

function loadAccountsView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
//			document.getElementById("view").innerHTML = xhr.responseText;
			$('#view').html(xhr.responseText); //jQuery Version..?
		}
	}
	xhr.open("GET", "home.view", true);
	xhr.send();
}

function loadUsersView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			
			document.getElementById("view").innerHTML = xhr.responseText;
			//$('#view').html(xhr.responseText); //changing innerHTML of view to be the responseText
//			
			//document.getElementById("toggleAdd").addEventListener("click", aFunction(), true);
			$('#toggleAdd').on('click', function() {
				
				//$('#addUsersView').removeAttr('hidden');
				//$('#toggleAdd').remove();
				document.getElementById("addUsersView").removeAttribute("hidden");
				document.getElementById("toggleAdd").remove();
				
			});
			
			$('#addUser').on('click', submitUser);
//				
			// once view is loaded, populate table and add eventlisteners
			populateUsersTable();
		}
	}
	xhr.open("GET", "users.view");
	xhr.send();
}

function aFunction(){
			
}

function submitUser(){
	//var ui = $('#userid').val();
	var fn = $('#firstname').val();
	var ln = $('#lastname').val();
	var un = $('#username').val();
	var up = $('#userpassword').val();

	var user = {
			//userId: ui, 
			firstname: fn,
			lastname: ln,
			username: un,
			userpassword: up
	};
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			console.log(xhr.responseText);
			let u = JSON.parse(xhr.responseText);
			addUserToTable(u);
		}
	}
		xhr.open('POST', 'testusers', true);
		xhr.send(JSON.stringify(user));
	}

function populateUsersTable(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			users = JSON.parse(xhr.responseText);
			console.log(users);
			for(var u of users){
				addUserToTable(u); // helper function to create elements
			}
		}
	}
	xhr.open("GET", "testusers");
	xhr.send();
}

function addUserToTable(u){
	 var row = document.createElement("tr");
	    var cell1 = document.createElement("td");
	    var cell2 = document.createElement("td");
	    var cell3 = document.createElement("td");
	    var cell4 = document.createElement("td");
	    var cell5 = document.createElement("td");
	    console.log(u);
	    cell1.innerHTML = u.userid;
	    cell2.innerHTML = u.firstname;
	    cell3.innerHTML = u.lastname;
	    cell4.innerHTML = u.username;
	    cell5.innerHTML = u.userpassword;
	    
	    row.appendChild(cell1);
	    row.appendChild(cell2);
	    row.appendChild(cell3);
	    row.appendChild(cell4);
	    row.appendChild(cell5);
	    
	    document.getElementById("testUsersTable").appendChild(row);
}