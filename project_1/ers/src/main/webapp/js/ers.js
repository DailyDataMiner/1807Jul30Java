window.onload = function() {
    loadHomeView();
    $('#log').on('click', loadLoginView);
	 $('#home').on('click', loadHomeView);
	// $('#entireTab').empty() 


}

function loadHomeView() {
    var x = document.getElementById("showlogin");
    x.style.display = "none";

    console.log("Loading HomeView");
    
    
	var xhr = new XMLHttpRequest();
	
	console.log(xhr.readyState);
	console.log(xhr.status);
	
    if(xhr.readyState == 4 && xhr.status == 200){

    }  
    xhr.open("GET", 'home.view', true);
    xhr.send();      
}

function loadLoginView(){
 //   $('#showlogin').attr(hidden, "true");
    var x = document.getElementById("showlogin");   //show/hide login
        x.style.display = "block";

    console.log("Loading LoginView")

	var xhr = new XMLHttpRequest();
    
	xhr.onreadystatechange = function(){
    //just showing what we're getting back for now
    //console.log(xhr.responseText);
    if(xhr.readyState == 4 && xhr.status == 200){
        $('#view').html(xhr.responseText);

        $('#login').on('click', loginValues);
 //       $('#showlogin').attr('hidden', 'false');

     //   document.getElementById('#login').addEventListener("click", loginValues);
    }
}
xhr.open("GET", "login.view");
xhr.send(); 
}

function loginValues(uname, pword){
	console.log('inside login Values');
	var uname = document.getElementById('username').value;
    var pword = document.getElementById('password').value;

    console.log(uname);
    console.log(pword);
    
    getInfo(uname, pword);
}

function getUser(uname, pword){
    console.log('Checking One Persons Credentials');
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            var myObj = JSON.parse(this.responseText);

        	
        }
    }
    xhr.open("GET", "http://localhost:8081/ers/login");
    xhr.send();   
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
            })
            
            if(myObj[uNum].userName == uname & myObj[uNum].password == pword){
            	console.log(myObj[uNum].roleId);
            	
            	if(myObj[uNum].roleId == 1){
            		employee(myObj[uNum]);
            	} 
            }else{
            	console.log(myObj[uNum].roleId);
            	Alert("Invalid username/password");
        		loadLoginView;
            }
        }
    }
    xhr.open("GET", "http://localhost:8081/ers/login");
    xhr.send();
}



function employee(o){
	var xhr = new XMLHttpRequest();
	
    xhr.onreadystatechange = function(){

        if(xhr.readyState == 4 && xhr.status == 200){
            var myObj = JSON.parse(xhr.responseText);

            count = 0;
            console.log(myObj);
            for(var b of myObj){

            	console.log(myObj[count]);
                addUserToTable(myObj[count]); //helper function to create elements **********************************************************
                count++;
            }
        }

    }
    xhr.open("GET", "http://localhost:8081/ers/ticket");
    xhr.send();
}



function populateUserTable(){
    var x = document.getElementById("entireTab");   // show table
    x.style.display = "none";
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            user = JSON.parse(xhr.responseText);
            console.log(user);
            for(var b of user){
                addUserToTable(b); //helper function to create elements **********************************************************
            }
        }

}
    xhr.open("GET", "user");
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
    
    document.getElementById("userTable").appendChild(row);
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

function sendTicket(o, type, amt, descrip){

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