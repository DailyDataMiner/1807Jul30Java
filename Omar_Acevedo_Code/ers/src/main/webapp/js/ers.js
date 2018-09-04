window.onload = function() {
	
	g_userId = 0;
	
//	loadLogInView();
	loadHomeView();
	
    $('#home').on('click', loadHomeView);
    $("#about").on("click", loadAboutView);
    $('#myStatementButton').on('click', viewTable);
//    $("#logoutButton").on('click', loadLogInView);
    
}


// 		 Load Home View
function loadHomeView() {
	
    console.log("Loading HomeView");

	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#viewLoader').html(xhr.responseText);     	   	
        }
    }
    xhr.open("GET", 'home.view', true);
    xhr.send();      
}

//		Load About View
function loadAboutView() {
	
    console.log("Loading AboutView");

	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
        	$('#viewLoader').html(xhr.responseText);     	   	
        }
    }
    xhr.open("GET", 'about.view', true);
    xhr.send();      
}


//		 Show statements
//function viewTable(obj){
function viewTable() {
	
	console.log("======================")
//	console.log(obj);
	
	var xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function() {

        if(xhr.readyState == 4 && xhr.status == 200) {
        	
        	console.log('gonna get statements');
        	console.log(xhr.responseText);
        	
        	$('#viewLoader').html(xhr.responseText);   

        	/*
            $('nav').show();
            $('#viewLoader').html(xhr.responseText);
  
            // event handler for statements
            $('#myStatementButton').on('click', populateUserTable); 
            
            // event handler for ticket submission

 */
            // js to control drop down
	    	$(".dropdown-menu li a").click(function () {
	    	  var selText = $(this).text();
	    	  $(this).closest('.form-group').find('#expenseTypeTxt').val(selText);
	    	});
	    	  
            $('#newTicketButton').on('click', function(){
            	
            	console.log(' inside the click function');
            	
            	// Expense type
            	var type = $('#expenseTypeTxt').val();
            	
            	// Expense description
            	var descrip = $('#descriptionText').val();
            	
            	// Expense cash
            	var cash = $('#cashMoneyYall').val();
            	
//            	sendTicket(obj, type, descrip, cash);
            	sendTicket(type, descrip, cash);
            	
            	$('#expenseTypeTxt').val('');
            	$('#descriptionText').val('');
            	$('#cashMoneyYall').val('');

            })
            
  //         $('#newTicketButton').on('click', sendTicket);
	    	  
	    	  
	    	  // Here, we make another AJAX call to get JSON data of tickets
	    	  
	    	  populateTicketsTable();
	    	  
	    	  // End of JSON get request

        }

    }
    xhr.open("GET", 'table.view', true);
    xhr.send();
}


//function populateUserTable() {
function populateTicketsTable() {
	
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){
    	
        if(xhr.readyState == 4 && xhr.status == 200){
        	
//            user = JSON.parse(xhr.responseText);
            tickets = JSON.parse(xhr.responseText);
            
            console.log(tickets);
            
            $('#entireTab tbody').html('');
            for(var b of tickets){
                addUserToTable(b); 
            }
            
        }

}
    xhr.open("GET", 'ticket', true);
    xhr.send();
}

function addUserToTable(b){
	
    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");
    var cell4 = document.createElement("td");
    var cell5 = document.createElement("td");
    var cell6 = document.createElement("td");
    var cell7 = document.createElement("td");  
    
    cell1.innerHTML = b.firstName;
    cell2.innerHTML = b.lastName;
    cell3.innerHTML = b.cash;
    cell4.innerHTML = b.submit;
    cell5.innerHTML = b.resolved;
    cell6.innerHTML = b.description;
    cell7.innerHTML = b.status;
    
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    
//    $('#entireTab tbody').html('');
//    document.getElementById("entireTab").appendChild(row);
    document.getElementById("entireTab").getElementsByTagName('tbody')[0].appendChild(row);
//    $('#entireTab tbody').append(row);
}


/*  
 * 
 * Post ticket data
 * 
 * */

// Function below is being called by click event of $('#newTicketButton') element.
//function sendTicket(obj, type, description, cash){
function sendTicket(type, description, cash){
			//object, type, descrip, cash
	
	if(type == 'Lodging')
		type = 1;
	else if(type == 'Food')
		type = 2;
	else (type = 3)
	
	console.log(type);
	
    var xhr = new XMLHttpRequest();
    
    var newObj = new Object();
    newObj.cash = cash;
    newObj.type = type;
    newObj.description = description;
    
    newObj.userId = 1;
//    newObj.userId = obj.userId;
    
//    newObj.roleId = obj.roleId;
//    newObj.email = obj.email;
//    newObj.userName = obj.userName;
//    newObj.password = obj.password;
//    newObj.firstName = obj.firstName;
//    newObj.lastName = obj.lastName;
    
    console.log('js object');
    console.log(newObj);
    
    var strObj = JSON.stringify(newObj);
    
	console.log('json object');
	console.log(strObj);
	
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
        	
			console.log('data response from server');
			console.log(xhr.responseText);
			
            tickets = JSON.parse(xhr.responseText);
            
            console.log(tickets);
            
            $('#entireTab tbody').html('');
            for(var b of tickets){
                addUserToTable(b); 
            }

        }
    }
    xhr.open('POST', 'employee', true);
	xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(strObj);
}

///////////////////////////////////////////////////////////////////////////////////////

/*  
 * 
 * Log In Section
 * 
 * */

function loadLogInView() {
	
	console.log("inside my login div");
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		console.log("inside my login function");
		
		if(xhr.readyState == 4 && xhr.status == 200){
			
			$('nav').hide();

			console.log("inside my login ajax");
			
			$('#viewLoader').html(xhr.responseText);
			
		    $('#loginViewButton').on('click', loginValues);
		    
		}
		
	}	
	xhr.open('GET', 'login.view', true);
	xhr.send();
}

function loginValues() {
	console.log('inside login Values');
	
	//user data
	var uname = $('#username').val();
    var pword = $('#password').val();
    
    // variable holding my drop down selection for manager or employee
    var dropDownSelect = document.getElementById("inlineFormCustomSelect").value;
  
    console.log(dropDownSelect + " The dropdown selection!");
    
    console.log(uname);
    console.log(pword);
    
    getInfo(uname, pword);
}


function getInfo(uname, pword){
    console.log('Loading credentials');
	var xhr = new XMLHttpRequest();
    var count = 0;
    var uNum = 0;
    xhr.onreadystatechange = function() {

        if(xhr.readyState == 4 && xhr.status == 200){
        	
            var myObj = JSON.parse(this.responseText);
            console.log(myObj);
            
            myObj.forEach(function(arrayItem){
            	if(arrayItem.userName == uname){
            		uNum = count;
            	}
            	count++;
            });
                    
            if(myObj[uNum].userName == uname & myObj[uNum].password == pword){
            	console.log(myObj[uNum].roleId);
            	
            	if(myObj[uNum].roleId == 1){
            		
//            		viewTable(myObj[uNum]);
            		
            		$('nav').show();
            		loadHomeView();
            		
            	} else {
//            	
            		viewManagerTable(myObj[uNum]);     
            	
            	}
            	
            }else{
            	console.log(myObj[uNum].roleId);
            	alert("Invalid username/password");
            	loadLogInView();
            }
        }
    }
    xhr.open("GET", "http://localhost:8081/ers/login");
    xhr.send();
}

///////////////////////////////////////////////////////////////////////////////////////

function viewManagerTable(){
	console.log("need to implement this")
}

function submitUser(){
    var ui = $('#userId').val();
    var uri = $('#userRoleId').val();
    var ue = $('#userEmail').val();
    var un = $('#userName').val();
    var p = $('#password').val();
    var fn = $('#firstname').val();
    var ln = $('#lastname').val();

    var users = {
            firstname: fn, 
            lastname: ln,
            password: p,
            useremail: ue,
            username: un,
            userroleid: uri,
            usersid: ui
    };

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
            console.log(xhr.responseText);
            let b = JSON.parse(xhr.responseText);
            addUserToTable(b);
        }
    }
        xhr.open('POST', 'user', true);
        xhr.send(JSON.stringify(users));
}


//function newTicketView(){
//    console.log("Loading newTicketView");
//
//    var xhr = new XMLHttpRequest();
//    
//    xhr.onreadystatechange = function(){
//    	
//        if(xhr.readyState == 4 && xhr.status == 200){
//        	
//        	$('#viewLoader').html(xhr.responseText);     	
//
//        }
//}
//    xhr.open("GET", 'newTicket.view', true);
//    xhr.send();
//	
//}
////////////////////////////////////////////////////////////////
//function createTicket(x, y, z) {
//	   console.log('Loading createTicket to submit');
//		var xhr = new XMLHttpRequest();
//	    var count = 0;
//	    var uNum = 0;
//	    
//	    
//	    
//	    xhr.onreadystatechange = function(){
//
//	        if(xhr.readyState == 4 && xhr.status == 200){
//	        	
//	            var myObj = JSON.parse(this.responseText);
//	            console.log(myObj);
//	            
//	            myObj.forEach(function(arrayItem){
//	            	if(arrayItem.userName == uname){
//	            		uNum = count;
//	            	}
//	            	count++;
//	            });
//	            console.log(myObj[uNum]);  
//	            sendTicket(myObj[uNum]);
//	        }
//	    }
//	    xhr.open("GET", "http://localhost:8081/ers/login");
//	    xhr.send();	
//}

