window.onload = function() {
        //WHEN LOGIN BUTTON IS CLICKED, LOAD LOGIN FUNCTION
        $('#loginButton').on('click', loadTestLoginView);

        $('#usersTestButton').on('click', loadUsersView);

    }

    function loadTestLoginView(){
        let username = $("#loginUsername").val(); //GET USERNAME FROM USER INPUT
        let password = $("#loginPassword").val(); //GET PASSWORD FROM USER INPUT
        
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if(xhr.readyState == 4 && xhr.status == 200) {
                
                document.getElementById("view").innerHTML = xhr.responseText;

                $('#toggleAddUserInfo').on('click', function() {
                    
                    document.getElementById("addUsersInfoView").removeAttribute("hidden"); //UNHIDES THE ADDUSERS FORM WHEN ADDUSERS IS CLICKED
                    document.getElementById("toggleAddUserInfo").remove(); //REMOVES BUTTON WHEN CLICKED
                    
                });
                
//                $('#addUserInfo').on('click', submitUser);

               testLogin();
            }
        }
        xhr.open("GET", "testlogin.view"); //all GET requests ending in .view are handled by the LoadViewsServlet....FYI
        xhr.send();
    }
    
    function testLogin(){
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if(xhr.readyState == 4 && xhr.status == 200){
                loggedInUser = JSON.parse(xhr.responseText);
                console.log(loggedInUser);
                for(var u of loggedInUser){
                    addUserToTable(u); // helper function to create elements
                }
            }
        }
        xhr.open("POST", "login");
        xhr.send();
    }

function login(){
    let username = $("#loginUsername").val(); //GET USERNAME FROM USER INPUT
    let password = $("#loginPassword").val(); //GET PASSWORD FROM USER INPUT

    if (username.length > 0 && password.length > 0) {
        //send ajax request to get user by username
        $("#message").attr("hidden", "true"); //MESSAGE STAYS HIDDEN

        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                console.log(xhr.responseText);
                var user = JSON.parse(xhr.responseText); //MAKING JSON USER OUT OF RESPONSE
                if (arr.length == 1) {
                    //got back user
                    let user = arr[0];
                    if (user.password = password) {
                        //successful login
                        $("#message").attr("hidden", "true");
                        console.log("logged in");
                        $("#landingView").attr("hidden", true);
                        $("#homeView").removeAttr("hidden");
                        $("#greeting").html(`Welcome ${user.firstName}`)
                    }
                    else {
                        var elem = $("#message");
                        elem.removeAttr("hidden");
                        elem.html("Invalid credentials!");
                    }
                }
                else {
                    //do not have user by username OR there ismore than 1
                    //which is also bad
                    var elem = $("#message");
                    elem.removeAttr("hidden");
                    elem.html("Sorry, you have an invalid username!");
                }
            }
        }
        xhr.open("POST", 'login' , true);
        xhr.send();

    }
    else {
        //tell user to not attempt to submit enpty fields
        var elem = $("#message");
        elem.removeAttr("hidden");
        elem.html("Please fill out all form fields!");
    }
}

function loadLoginView() {

    var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
//			document.getElementById("view").innerHTML = xhr.responseText;
            $('#view').html(xhr.responseText); //jQuery Version..?
            
		}
	}
	xhr.open("GET", "login.view", true);
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
				document.getElementById("addUsersView").removeAttribute("hidden"); //UNHIDES THE ADDUSERS FORM WHEN ADDUSERS IS CLICKED
				document.getElementById("toggleAdd").remove(); //REMOVES ADDUSERS BUTTON WHEN CLICKED
				
			});
			
			$('#addUser').on('click', submitUser);
//				
			// once view is loaded, populate table and add eventlisteners
			populateUsersTable();
		}
	}
	xhr.open("GET", "testusers.view");
	xhr.send();
}

function submitUser(){
	//var ui = $('#userid').val();
    var un = $('#username').val();
    var up = $('#userpassword').val();
    var fn = $('#firstname').val();
	var ln = $('#lastname').val();
    var em = $('#email').val();
	var ri = $('#roleid').val();

	var user = {
			//userId: ui, 
            username: un,
			userpassword: up,
            firstname: fn,
			lastname: ln,
			email: em,
			roleid: ri
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
        var cell6 = document.createElement("td");
        var cell7 = document.createElement("td");
	    console.log( 'adding user' + u);
        cell1.innerHTML = u.userid;
        cell2.innerHTML = u.username;
	    cell3.innerHTML = u.userpassword;
	    cell4.innerHTML = u.firstname;
	    cell5.innerHTML = u.lastname;
        cell6.innerHTML = u.email;
        cell7.innerHTML = u.roleid;
        
	    row.appendChild(cell1);
	    row.appendChild(cell2);
	    row.appendChild(cell3);
	    row.appendChild(cell4);
        row.appendChild(cell5);
        row.appendChild(cell6);
	    row.appendChild(cell7);
	    
	    document.getElementById("testUsersTable").appendChild(row);
}