window.onload = function() {

//    loadHomeView();

    $('#login').on('click', loadLoginView);
    
}



//function loadHomeView() {
	
//	$('#mainMenuNav').hide();
	
//	var xhr = new XMLHttpRequest();
//	
//    if(xhr.readyState == 4 && xhr.status == 200){
//    	console.log("PPPPPPPPPPPPP");
//
//    }  
//    xhr.open("GET", 'home.view', true);
//    xhr.send();      
//}

function loadLoginView() {
	
//	$('#loginInputsNav').hide();
//	$('#mainMenuNav').show();
	
	var username = $('#username').val();
	var password = $('#password').val();
	
	console.log("Loading LoginView");

//	var xhr = new XMLHttpRequest();
	    
//	xhr.onreadystatechange = function(){
	    //just showing what we're getting back for now
	    //console.log(xhr.responseText);
//	    if(xhr.readyState == 4 && xhr.status == 200){
	    	
//	    	console.log(xhr.responseText);
	    	
//	        $('#view').html(xhr.responseText);
//	        $('#form-control mr-sm-2').attr('hidden', 'true');
//	        $('#login').attr('hidden', 'true');
//	
//	        document.getElementById('buttonId').addEventListener("click", loginValues);
//	    }
//	}
	
	let usrObj = {
		username: username,
		password: password
	};
	
	usrObj = JSON.stringify(usrObj);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			
			console.log('data response from server -> ');
			console.log(xhr.responseText);
		
		}
	}
	
	xhr.open('POST', "login", true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(usrObj);
	
}

//function loginValues(uname, pword){
//	console.log('inside login Values');
//	var uname = document.getElementById('username').value;
//    var pword = document.getElementById('password').value;
//    getInfo(uname, pword);
//}

//function getInfo(uname, pword){
//    console.log('Loading credentials');
//	var xhr = new XMLHttpRequest();
//    var count = 0;
//    var uNum = 0;
//    xhr.onreadystatechange = function(){
//
//        if(xhr.readyState == 4 && xhr.status == 200){
//            var myObj = JSON.parse(this.responseText);
//            console.log(myObj);
//
//            myObj.forEach(function(arrayItem){
//            	if(arrayItem.username == uname){
//            		uNum = count;
//            	}
//            	count++;
//            })
//            
//            if(myObj[uNum].username == uname & myObj[uNum].password == pword){
//            	console.log(myObj[uNum].userroleid);
//            	if(myObj[uNum].userroleid == 2){
//            		employee(myObj[uNum]);
//            	}
//            } else{
//            	console.log(myObj[uNum].userroleid);
//            	console.log("Invalid username/password");
//        		loadLoginView;
//            }
//        }
//    }
//    xhr.open("GET", "login");
//    xhr.send();
//}