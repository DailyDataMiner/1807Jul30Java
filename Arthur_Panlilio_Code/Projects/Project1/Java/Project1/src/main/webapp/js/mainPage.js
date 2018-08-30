var cook;

window.onload=function(){
	//loadHomeView();
	$('#login').on('click', login);
	$('#about').on('click', showAbout);
	$('#navItem').on('click', logout);
	console.log("cookie " + getCookie('log'));
	cook = getCookieState();
	loadInitDefaultView();
}




function login(){
    let uname = $('#username').val();
    let pword = $('#password').val();
    console.log(`The username is: ${uname}, and the password is: ${pword}`);
    var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){

		if(xhr.readyState == 4 && xhr.status == 200){	
			//var users = JSON.parse(xhr.responseText);

			let resp = xhr.responseText;
			if(resp=='invalid'){
				$('#username').val("");
				$('#password').val("");
				$('#loginError').css('color', 'red');
				$('#loginError').html("invalid username or password");
				$('#loginError').removeAttr('hidden');
			}
			if(resp=='valid'){
				validLog();
			}
		}
	}
	xhr.open('POST', 'Login', true);
	xhr.send(JSON.stringify({ "Username": uname, Password: pword }));
}

function validLog(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			
			$('#logout').on('click',logout);
			logInorOut();
			populateUserInfo();
		}
		
	}
	
	xhr.open('GET','profile.view',true);
	xhr.send();
}

function populateUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			let name = (user.firstname + " " + user.lastname);
			let uname = user.username;
			let email = user.email;
			let role = user.role;
			document.cookie = "log = " + role;
			cook = getCookieState();
			console.log('cookie in the validlog ' + getCookie('log'));
			if(getCookie('log') != null && getCookie('log') != '0'){
				console.log("profile loaddd");
				$('#view').html(cook);
			} else {
				$('#view').html(xhr.responseText);
			}
			turnOnViewLink(role);

			$('#fullnameInfo').html(name);
			$('#usernameInfo').html('<i>alias</i> ' + uname);
			$('#emailInfo').html('<i>Letter Address</i> ' + email);
			$('#roleInfo').html('<i>'+role+'<i>');
		}
	}
	xhr.open('GET','user',true);
	xhr.send();
}


function showAbout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);		
		}
		
	}
	xhr.open("Get","about.view",true);
	xhr.send();
}

function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			html = '';
			$('#view').html(xhr.responseText);
			console.log("logging out" + xhr.responseText);
			$('#login').on('click', login);	
			setNavItem('Login');
			$('#registerLink').on('click', showRegister);
			turnOnProfileLink(false);
			turnOnViewLink('0');
			document.cookie = "log = 0";
			
		}		
	}
	xhr.open("Get","Logout",true);
	xhr.send();
}




function loadInitDefaultView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText)
			if(getCookie('log') != null){
				$('#view').html(cook);
			} else {
				$('#view').html(xhr.responseText);
			}
			$('#login').on('click', login);
			$('#logout').on('click', logout);
			logInorOut();		
		}
		
	}
	xhr.open("Get","login.view",true);
	xhr.send();
}

function logInorOut(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let resp = xhr.responseText;
			if(resp=='in'){
				turnOnProfileLink(false);
				setNavItem('Login');	
				$('#registerLink').on('click', showRegister);			
			} else {
				setNavItem('Logout')
				populateUserInfo();
				turnOnProfileLink(true);
			}
			
		}
		
	}
	xhr.open('POST', 'Logout', true);
	xhr.send();
}

function showRegister(){
	console.log("AAAAA");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('form').submit(false);
			$('#register').on('click', registerButton);

		}
		
	}
	xhr.open("Get","register.view",true);
	xhr.send();
}

function registerButton(){

	
	if($('#usernameReg').val() && $('#passwordReg').val() &&
	 $('#firstnameReg').val() && $('#lastnameReg').val() && $('#emailReg').val().includes('@')
	 && $("input[name=roleRadio]:checked").val()
	){
		let uname = $('#usernameReg').val();
		let pwd = $('#passwordReg').val();
		let fname = $('#firstnameReg').val();
		let lname = $('#lastnameReg').val();
		let e = $('#emailReg').val();
		let rId = $('input[name=roleRadio]:checked').val();
		
		var user = {
				username: uname,
				password: pwd,
				firstname: fname,
				lastname: lname,
				email: e,
				roleId : rId
		};

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 ){
				if(xhr.responseText=='valid'){
					alert("Registered.");
					logout()
				} else {
					$('#usernameReg').val("");
					$('#passwordReg').val("");
					$('#registerError').html("Username already taken");
					$('#registerError').removeAttr('hidden');
				}
			}
		}

		xhr.open('POST', 'Register', true);
		xhr.send(JSON.stringify(user));
	}
}

function isValidEmailAddress(emailAddress) {
    var pattern = new RegExp(/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
    return pattern.test(emailAddress);
};



function viewReimEmployee(){
	
}

function viewReimManager(){
	console.log("viewreimManager");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			populateReim();
		}
		
	}
	xhr.open("Get","reimuser.view",true);
	xhr.send();

}

function populateReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			let reims = JSON.parse(xhr.responseText);
			let show = xhr.responseText.substring(1, xhr.responseText.length-1);
		
			getCurrUser(String(xhr.responseText));
			
		}
		
	}
	xhr.open("Get","reimbursement",true);
	xhr.send();
}

function getCurrUser(view){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){	
			showReim(view, JSON.parse(String(xhr.responseText)));			
		}		
	}
	xhr.open("Get","user",true);
	xhr.send();
}

function showReim(views, user){
	console.log(user);
	var oTable = $("#myTable").dataTable({
		aaData:JSON.parse(views),
			aoColumns: [
			{ mData: "id" },
			{ mData: "amount" },
			{ mData: "submitted", mRender:function(data, type, full, meta){
				return data.year+ data.month + data.dayOfMonth;
			 } },
			{ mData: "response", mRender:function(data){
				return (data == null) ? "N/A": (data.length > 25) ? data.substring(0, 25) + "...": data;
			 }},
			{ mData: "authorData",mRender:function(data){
				return data.firstname + " "+ data.lastname;
			 }  },
			{ mData: "resolverData",mRender:function(data){
				return (data != null) ? data.firstname + " " + data.lastname : "N/A";
			 } },
			{ mData: "status" },
			{ mData: "type" },
			{ mData: "description", mRender:function(data){
				console.log("LENGTH: "  + data.length);
				return (data.length > 25) ? data.substring(0, 25) + "...": data ;
			} },
			{ mData: "resolved", mRender:function(data){
				return (data != null) ?  data.year+ data.month + data.dayOfMonth: "N/A" ;
			} }
		],
		"aoColumnDefs":
		 [{ "bVisible": false, "aTargets": [3] , "bSearchable": false}]
	  });
	$('#myTable').on('click', 'tbody tr', function(){
		var oData = oTable.fnGetData(this);
		showPaper(oData);
		$('#paperCloseButton').on('click', function(){
			$('#paper').addClass('disabled');
			$('#paper').attr('hidden', 'true');
			$('#rResponse').addClass('disabled');
			$('#rResponse').attr('hidden', 'true');
		})
		if(oData.statusId == 1){
			$('#seal').attr('src','');
			showResponseInput(false);
			disableButtons(false);
			$('#paperApproveButton').on('click', function(){
				$('#mngrSign').html(user.firstname+user.lastname);
				disableButtons(true);
				showResponseInput(true, oData.id, user.id, 3, 1);
				$('#seal').attr('src','res/images/approvedSeal.png');
			});
			$('#paperDenyButton').on('click', function(){
				$('#mngrSign').html(user.firstname+user.lastname);
				disableButtons(true);
				showResponseInput(true, oData.id, user.id, 2, 1);
				$('#seal').attr('src','res/images/deniedSeal.png');
			});
		} else {
			showResponseInput(true, null, null, null, oData.statusId, oData.response, oData.resolverData);
			disableButtons(true);
			$('#mngrSign').html(oData.resolverData.firstname+oData.resolverData.lastname);
	
			if(oData.statusId == 2){
				$('#seal').attr('src','res/images/deniedSeal.png');
			} else if (oData.statusId == 3){
				$('#seal').attr('src','res/images/approvedSeal.png');
			} 
		}
	})
} 

function disableButtons(x){
	if(x){
		$('#paperDenyButton').attr('hidden','true');
		$('#paperDenyButton').addClass('disabled');
		$('#paperApproveButton').attr('hidden', 'true');
		$('#paperApproveButton').addClass('disabled');
	} else {		
		$('#paperDenyButton').removeAttr('hidden');
		$('#paperDenyButton').removeClass('disabled');
		$('#paperApproveButton').removeAttr('hidden');
		$('#paperApproveButton').removeClass('disabled');	
	}
}

function showResponseInput(x, re, us, status, stat, resp, resol){
	if(x){
		$('#submitResponseButton').off()
		$('#submitResponseButton').on('click', function(){submitResponse(re, us, status)});
		$('#rResponse').removeAttr('hidden');
		$('#rResponse').removeClass('disabled');
		$('#responseInput').val('');
		console.log(stat);
		if(stat == 1){
			console.log("show buttons");
			$('#responseStuff').removeAttr('hidden');
			$('#responseStuff').removeClass('disabled');
			$('#responseHolder').attr('hidden', 'true');
			$('#responseHolder').addClass('disabled');
			$('#responseBody').html('');	
			$('#responseSign').html('');
		}
		if(stat > 1){
			console.log("hide buttons");
			$('#responseStuff').attr('hidden', 'true');
			$('#responseStuff').addClass('disabled');
			$('#responseHolder').removeAttr('hidden');
			$('#responseHolder').removeClass('disabled');
			$('#responseBody').html(resp);
			$('#responseSign').html('t. ' + resol.username);	
		}
	}else{
		$('#submitResponseButton').off();
		$('#rResponse').attr('hidden', 'true');
		$('#rResponse').addClass('disabled');
		$('#responseInput').val('');
		$('#responseStuff').attr('hidden');
		$('#responseStuff').addClass('disabled');
		$('#responseHolder').attr('hidden');
		$('#responseHolder').addClass('disabled');
		
	}
}

function submitResponse(rId, uId, stat){
	console.log('submit');
	var xhr = new XMLHttpRequest();
	res = $('#responseInput').val();
	var info = {
		id: rId,
		rId: uId,
		status: stat,
		response: res
	}
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			viewReimManager();
		}
		
	}
	xhr.open("POST","reimbursementUpdate",true);
	xhr.send(JSON.stringify(info));
}

function showPaper(oData){
	
	$('#paper').removeAttr('hidden');
	$('#paper').removeClass('disabled');
	$('#reID').html(oData.id);
	$('#reName').html(oData.authorData.firstname + " " + oData.authorData.lastname);
	$('#reUName').html(oData.authorData.username);
	$('#reDate').html(oData.submitted.dayOfMonth +"" + getNumberEnder(oData.submitted.dayOfMonth) + 
	 "  of " + formatString(String(oData.submitted.month)) + " " + oData.submitted.year);
	$('#reAmount').html(oData.amount);
	$('#reDescription').html(oData.description);
	$('#userSign').html(oData.authorData.firstname + oData.authorData.lastname);
	if(oData.resolver != null){
		$('#mngrSign').html(oData.resolver.firstname + oData.resolver.lastname);
	}
	
}

function setNavItem(set){
	$('#navItem').html(set);
	$('#navItem').removeAttr('hidden');
	$('#navItem').removeClass('disabled');
	
	
}

function turnOnProfileLink(enable){
	console.log('turnonProfleLink');
	if(enable==true){
		console.log('enable');
		$('#navItemProfile').html('Profile');
		$('#navItemProfile').removeAttr('hidden');
		$('#navItemProfile').removeClass('disabled');
		$('#navItemProfile').on('click', validLog);
	} else {
		console.log('disable');
		$('#navItemProfile').html('');
		$('#navItemProfile').attr('hidden', 'true');
		$('#navItemProfile').addClass('disabled');
		$('#navItemProfile').off();
	}
}


function turnOnViewLink(lvl){
	console.log('turnonViews ' + lvl);


	switch(lvl) {
		case'Employee':
			console.log('enableEmployeeview');
			$('#navItemViewReim').html('My Reimbursements');
			$('#navItemViewReim').removeAttr('hidden');
			$('#navItemViewReim').removeClass('disabled');
			$('#navItemViewReim').off();
			$('#navItemViewReim').on('click', viewReimEmployee);
			break;
		case 'FinanceManager':
			console.log('enableManagerView');
			$('#navItemViewReim').html('View Reimbursements');
			$('#navItemViewReim').removeAttr('hidden');
			$('#navItemViewReim').removeClass('disabled');
			$('#navItemViewReim').off();
			$('#navItemViewReim').on('click', viewReimManager);
			break;
		default:
			console.log('disable');
			$('#navItemViewReim').html('');
			$('#navItemViewReim').attr('hidden', 'true');
			$('#navItemViewReim').addClass('disabled');
			$('#navItemViewReim').off();
			$('#navItemViewReim').off('click', viewReimEmployee);
		}
	}




function getCookie(a) {
    var b = document.cookie.match('(^|;)\\s*' + a + '\\s*=\\s*([^;]+)');
    return b ? b.pop() : '';
}

function getNumberEnder(no){
	no = String(no);
	no = no.substring(no.length-1,no.length);
	switch(no){
		case ('1'):
			return 'st';
		case ('2'):
			return 'nd';
		case ('3'):
			return 'rd';
		default:
			return 'th';
	}
}

function formatString(str) {
	return str
	.replace(/(\B)[^ ]*/g,match =>(match.toLowerCase()))
	.replace(/^[^ ]/g,match=>(match.toUpperCase()));
  }
  





function getCookieState(){
	let path = '';
	if(getCookie('log') == '0'){
		path = '<div class="container-fluid">'+
		'    <div class="row">'+
		'        <div class="col-3" ></div>'+
		'        <div class="col-6 text-center">'+
		'            <img src="res/images/crest.gif" alt="Crest" style="width:140px;height:140px;">'+
		'            <div class="text-center">'+
		'                <h1 style=" margin-top:50px; font-size:3vw; letter-spacing:9px;">Revature & Co.</h1>'+
		'                <h1 style="font-size:2vw; letter-spacing:9px; opacity:.8;">Privateer Reimbursements</h1>'+
		'                <h3 style="margin-left:15px; font-size:1vw; letter-spacing:9px; opacity:.8;">EST<sup>D</sup> 1653</h3>'+
		'            </div>'+
		'        </div>'+
		'        <div class="col-3" ></div>'+
		'    </div>'+
		'</div>'+
		'<div class="text-center align-center" style="padding:50px">'+
		'    <div class="row">'+
		'        <div class="col-5"></div>'+
		'        <div class="col-2 col-md-offset-3">'+
		'            '+
		'            <div class="form-group">'+
		'                <input type="text" placeholder="Username" id="username"  name="username" class="form-control justify-content-center">'+
		'                <input type="password" placeholder="Password" id="password" name="password"'+
		'                class="form-control justify-content-center" style="margin-top:2px" >'+
		'                <div style="padding:10px">'+
		'                    <button class="old" id="login" style="color:rgb(68, 7, 7);font-size:15px; border-radius:15px; width:115px; background-image:url(res/images/wax.jpg)" >Login</button>'+
		'                </div>'+
		'                <div style="color:red" hidden="true" id="loginError"></div>'+
		'                <a id="registerLink"><u><b>Register</b> an Account</u><a>'+
		'            </div>'+
		'        </div>'+
		'        '+
		'    </div>'+
		'</div>';
	} else if (getCookie('log') == 'Employee'){
		path = '<div class="text-center align-center" style="padding:50px">'+
		'    <div class="container" style="margin-top:60px">'+
		'        <div class="row">'+
		'            <div class="col-2"></div>'+
		'            <div class="col-8">'+
		'                <h1 id="fullnameInfo"></h1>'+
		'                <h5><span id="usernameInfo"></span> </h5>'+
		'                <h3><span id="emailInfo"></span></h3>'+
		'                <h5 id="roleInfo"></h5>'+
		'            </div>'+
		'            <div class="col-2"></div>'+
		'        </div>'+
		'    </div>'+
		'</div>';
	

	} else if (getCookie('log') == 'FinanceManager'){
		path = '<div class="text-center align-center" style="padding:50px">'+
		'    <div class="container" style="margin-top:60px">'+
		'        <div class="row">'+
		'            <div class="col-2"></div>'+
		'            <div class="col-8">'+
		'                <h1 id="fullnameInfo"></h1>'+
		'                <h5><span id="usernameInfo"></span> </h5>'+
		'                <h3><span id="emailInfo"></span></h3>'+
		'                <h5 id="roleInfo"></h5>'+
		'            </div><h1>I AM A MANAGER</h1>'+
		'            <div class="col-2"></div>'+
		'        </div>'+
		'    </div>'+
		'</div>';
	

	}


	return path;
}