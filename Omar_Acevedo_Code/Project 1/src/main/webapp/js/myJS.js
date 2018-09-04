window.onload = function() {
	
	loadHomeView();
	
//	$('#aboutme').on('click', aboutMe);
	document.getElementById('aboutme').addEventListener('click', aboutMe);
	document.getElementById('contactus').addEventListener('click', contactUs);	
	
}

function contactUs() {
	console.log('in contact us');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if ( xhr.readyState == 4 && xhr.status == 200 ) {
			console.log('in contact us xhr');
			console.log(xhr.responseText);	
			document.getElementById('content').innerHTML = xhr.responseText;
		}
	}
	xhr.open('GET', 'contactus.view', true);
	xhr.send();	
}

function aboutMe() {
	console.log('in contact us');
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if ( xhr.readyState == 4 && xhr.status == 200 ) {
			console.log('in about me xhr');
			console.log(xhr.responseText);	
			document.getElementById('content').innerHTML = xhr.responseText;
		}
	}
	xhr.open('GET', 'about.view', true);
	xhr.send();	
}

function loadHomeView() {
	
	console.log("we are in the homeview");
	
	var xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function() {
	
		if ( xhr.readyState == 4 && xhr.status == 200 ) {	
			console.log(xhr.responseText);
			document.getElementById('content').innerHTML = xhr.responseText;
		}
	}
	
	xhr.open('GET', 'home.view', true);
	xhr.send();
	
}