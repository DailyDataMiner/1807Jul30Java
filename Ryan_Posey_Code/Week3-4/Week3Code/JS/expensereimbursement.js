window.onload=function() {
	loadLoginView();
	$('#login').on('click', login);
}

function loadLoginView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			$('#view').html(xhr.responseText);
		}
	}
	xhr.open("GET", "login.view", true);
	xhr.send;
}

function login() {
	let username = $('#username').val();
    let password = $('#password').val();
    
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
    	if(xhr.readyState == 4 && xhr.status) {
    		var arr = JSON.parse(xhr.responseText);
    		if(arr.length==1) {
    			let user = arr[0];
    			if(user.password == password) {
                    console.log("logged in");
                }
            }
            else console.log("Invalid Credentials");
        }
        else console.log('Invalid username')
    }
}