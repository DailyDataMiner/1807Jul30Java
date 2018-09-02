window.onload = function() {
	loadLogInView();
    
    $("#about").on("click", about);
    $("#logoutButton").on('click', loadLogInView);
    $('#home').on('click', loadHomeView);
    
    $('#myStatementButton').on('click', viewTable);
    
}



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
    
    

function about(){
	console.log("we are going to the about me page");
	
	var xhr = new XMLHttpRequest();
	
	
	xhr.onreadystatechange = function() {
		
		console.log("Im inside my about ajax");
		console.log(xhr.readyState);
		console.log(xhr.status);
		
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log("inside my ajax function");
			console.log(xhr.responseText);
			
			$('#viewLoader').html(xhr.responseText);
			
		}
	}
	
	xhr.open('GET', "about.view", true);
	xhr.send();
	
}

function loadHomeView() {
		
    console.log("Loading HomeView");

	var xhr = new XMLHttpRequest();
	
    
    xhr.onreadystatechange = function(){
    	
    	console.log('rs ' + xhr.readyState);
    	console.log('s ' + xhr.status);
    	
        if(xhr.readyState == 4 && xhr.status == 200){

        	console.log(xhr.responseText);
        	
        	$('#viewLoader').html(xhr.responseText);     	
        	
        
        }
    }

    
    xhr.open("GET", 'home.view', true);
    xhr.send();      
}



function loginValues(){
	console.log('inside login Values');
	
	var uname = $('#username').val();
    var pword = $('#password').val();
    // variable holding my drop down selection
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
    xhr.onreadystatechange = function(){

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
            		viewTable(myObj[uNum]);
            	} 
            	console.log('thats it?');
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




// unused param...
function viewTable(indexOfmyObj){

	var xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function(){

        if(xhr.readyState == 4 && xhr.status == 200){
        	
        	$('#viewLoader').html(xhr.responseText);   
//            var myObj = JSON.parse(xhr.responseText);

            $('nav').show();
            $('#viewLoader').html(xhr.responseText);
            $('#newReimbButton').on('click', newTicketView);

            populateUserTable();
            

            
//            count = 0;
//            console.log(myObj);
//            for(var b of myObj){
//
//            	console.log(myObj[count]);
//                addUserToTable(myObj[count]); 
//                count++;
//            }
        }

    }
//    xhr.open('GET', 'home.view', true);
    xhr.open("GET", 'table.view', true);
    xhr.send();
}

//function submitRequestForTicketView(){
//	
//	var xhr = new XHLHttpRequest();
//	
//	xhr.onreadystatechange = function(){
//		if(xhr.readyState == 4 && xhr.status == 200){
//			var myObj = JSON.parse(xhr.responseText);
//			
//		}
//	}
//	xhr.open('GET', 'tickets', true);
//	xhr.send();
//}



function populateUserTable(){
	
    
    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){
    	
        if(xhr.readyState == 4 && xhr.status == 200){
        	
            user = JSON.parse(xhr.responseText);
            
            console.log(user);
            for(var b of user){
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
    
    document.getElementById("entireTab").appendChild(row);
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


function newTicketView(){
    console.log("Loading newTicketView");

    var xhr = new XMLHttpRequest();
    
    xhr.onreadystatechange = function(){
    	
        if(xhr.readyState == 4 && xhr.status == 200){
        	
        	$('#viewLoader').html(xhr.responseText);     	

        }
}
    xhr.open("GET", 'newTicket.view', true);
    xhr.send();
	
}



function sendTicket(){


    var xhr = new XMLHttpRequest();
    
    var newObj = new Object();
    newObj.amt = amt;
    newObj.type = type;
    newObj.userid = o.userid;
    newObj.userroleid = o.userroleid;
    newObj.useremail = o.useremail;
    newObj.username = o.username;
    newObj.password = o.password;
    newObj.fname = o.firstname;
    newObj.lname = o.lastname;
    newObj.descrip = descrip;
    
    console.log(newObj);
    
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 ){
        }
    }
    xhr.open('POST', 'employee', true);
    xhr.send(JSON.stringify(newObj));
}