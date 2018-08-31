var cook;


window.onload=function(){
	//loadHomeView();
	$('#login').off()
	$('#login').on('click', login);
	$('#about').off();
	$('#about').on('click', showAbout);
	$('#contact').off();
	$('#contact').on('click', showContact);
	$('#navItem').off();
	$('#navItem').on('click', logout);
	console.log('onload');
	cook = getCookieState();
	loadInitDefaultView();

}

function showContact(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText)
		}
	}
	xhr.open('GET','contact.view',true);
	xhr.send();
}


//Login
function login(){
    let uname = $('#username').val();
    let pword = $('#password').val();
    console.log('login');
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

//login is valid
function validLog(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#logout').off();
			$('#logout').on('click',logout);
			logInorOut();
			populateUserInfo();
		}
		
	}
	
	xhr.open('GET','profile.view',true);
	xhr.send();
}

//populates the users info
function populateUserInfo(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			user = JSON.parse(xhr.responseText);
			let name = (user.firstname + " " + user.lastname);
			let uname = user.username;
			let email = user.email;
			let role = user.roleId;
			document.cookie = "log = " + role;
			cook = getCookieState();
			console.log('populating profile');
			if(getCookie('log') != null && getCookie('log') != '0'){
				$('#view').html(cook);
			} else {
				$('#view').html(xhr.responseText);
			}
			turnOnViewLink(role);

			$('#fullnameInfo').html(name);
			$('#usernameInfo').html(uname);
			$('#emailInfo').html( email);
			
		}
	}
	xhr.open('GET','user',true);
	xhr.send();
}

//shows about page
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

//logs out
function logout(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			html = '';
			$('#view').html(xhr.responseText);
			console.log("logging out");
			$('#login').off();
			$('#login').on('click', login);	
			setNavItem('Login');
			$('#registerLink').off();
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
			console.log('loading default view')
			if(getCookie('log') != null){
				$('#view').html(cook);
			} else {
				$('#view').html(xhr.responseText);
			}
			$('#login').off();
			$('#login').on('click', login);
			$('#logout').off();
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
				$('#registerLink').off();	
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
	console.log("showing register");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('form').submit(false);
			$('#register').off();
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
					$('#regModal').modal();
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


function viewReimManager(pen){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			if(pen==5){
				pendingReim(pen);
			} else{
				populateReim();
			}
		}
		
	}
	xhr.open("Get","reimuser.view",true);
	xhr.send();

}


function pendingReim(pen){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){	
			getCurrUser(String(xhr.responseText), pen);			
		}
		
	}
	xhr.open("Get","reimbursementPending",true);
	xhr.send();
}

function populateReim(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){	
			getCurrUser(String(xhr.responseText));			
		}
		
	}
	xhr.open("Get","reimbursement",true);
	xhr.send();
}

function getCurrUser(view, pen){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){	
			showReim(view, JSON.parse(String(xhr.responseText)), pen);			
		}		
	}
	xhr.open("Get","user",true);
	xhr.send();
}

function showReim(views, user, pen){
	if(user.roleId == 1){
		$('#viewAllRe').attr('hidden','true');
		$('#viewAllRe').addClass('disabled');
		$('#viewAllRe').off();
	 } else {
		if(pen != 5){
			$('#viewAllRe').html('<u>view pending reimbursements</u>')
			$('#viewAllRe').removeAttr('hidden');
			$('#viewAllRe').removeClass('disabled');
			$('#viewAllRe').off();
			$('#viewAllRe').on('click', function(){
				viewReimManager(5);
			})
		} else {
			$('#viewAllRe').html('<u>view all reimbursements</u>')
			$('#viewAllRe').removeAttr('hidden');
			$('#viewAllRe').removeClass('disabled');
			$('#viewAllRe').off();
			$('#viewAllRe').on('click', function(){
				viewReimManager(false);
			})
		}

	 }
	 if(views==''){
		 return;
	 }
	var oTable = $("#myTable").DataTable({
		aaData:JSON.parse(views),
			aoColumns: [
			{ mData: "id" },
			{ mData: "amount", "sType": "numeric", mRender:function(data, type){
				if(type == 'sort') return data;
				let money = convert(data);
				let m = '';
				if(money.po > 0){
					m += '£'+money.po+" ";
				}
				if(money.cr > 0){
					m += 'cr'+money.cr+" ";
				}
				if(money.sh > 0){
					m +='s'+money.sh+" ";
				}
				if(money.pe > 0){
					m += 'd'+money.pe;
				}
				return (m.length > 6) ? m.substring(0, 6) + "...": m;
			} },
			{ mData: "authorData",mRender:function(data){
				return data.username;
			 }  },
			 { mData: "typeId",mRender:function(data){
				switch(data){
					case 1:
						return "Travel";
					case 2:
						return "Lodging";
					case 3:
						return "Food";
					case 4:
						return "Unfortunate Incident";
					case 5:
						return "Plunder";
					case 6:
						return "Other";
					default:
						return "?";
				}
			 } },
			 { mData: "description", mRender:function(data){
				if(data != null){
					return (data.length > 6) ? data.substring(0, 6) + "...": data ;
				} else {
					return 'N/A';
				}
			} },
			{ mData: "submitted","sType": "date-uk2" , mRender:function(data, type, full, meta){
				return data.dayOfMonth+'-'+data.monthValue+'-'+data.year;
			 } },
			 { mData: "statusId",mRender:function(data){
				return (data == 1) ? "Pending" : (data == 2) ?  "Denied": "Approved";
			 } },
			{ mData: "response", mRender:function(data){
				return (data == null) ? "N/A": (data.length > 6) ? data.substring(0, 6) + "...": data;
			 }},
			
			{ mData: "resolverData",mRender:function(data){
				return (data != null) ? data.username : "N/A";
			 } },
				
			{ mData: "resolved","sType": "date-uk2", mRender:function(data){
				return (data != null) ?  data.dayOfMonth+'-'+data.monthValue+'-'+data.year: "N/A" ;
			} }
		],
		"aoColumnDefs":
		 [{ "bVisible": false, "aTargets": [7] , "bSearchable": false}]
	  });
	$('#myTable').on('click', 'tbody tr', function(){
		var oData = oTable.fnGetData(this);
		var rowId = oTable.attr("id");
		showPaper(oData);
		$('#paperCloseButton').on('click', function(){
			$('#paper').addClass('disabled');
			$('#paper').attr('hidden', 'true');
			$('#rResponse').addClass('disabled');
			$('#rResponse').attr('hidden', 'true');
		})
		if(oData.statusId == 1){
			$('#seal').attr('src','');
			if(user.roleId==2){			
				showResponseInput(false);
				disableButtons(false);
				$('#paperApproveButton').on('click', function(){
					$('#mngrSign').html(user.firstname+user.lastname);
					disableButtons(true);
					showResponseInput(true, oData.id, user.id, 3, 1, null, null, oData, rowId, oTable);
					$('#seal').attr('src','res/images/approvedSeal.png');
				});
				$('#paperDenyButton').on('click', function(){
					$('#mngrSign').html(user.firstname+user.lastname);
					disableButtons(true);
					showResponseInput(true, oData.id, user.id, 2, 1, null, null, oData, rowId, oTable);
					$('#seal').attr('src','res/images/deniedSeal.png');
				});
			} else {
				showResponseInput(false);
				disableButtons(true);
			}
		} else {
			showResponseInput(true, null, null, null, oData.statusId, oData.response, oData.resolverData, oData, rowId, oTable);
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

function showResponseInput(x, re, us, status, stat, resp, resol, oData, rowId, oTable){
	if(x){
		$('#submitResponseButton').off()
		$('#submitResponseButton').on('click', function(){submitResponse(re, us, status, oData, rowId, oTable )});
		$('#rResponse').removeAttr('hidden');
		$('#rResponse').removeClass('disabled');
		$('#responseInput').val('');
		if(stat == 1){
			$('#responseStuff').removeAttr('hidden');
			$('#responseStuff').removeClass('disabled');
			$('#responseHolder').attr('hidden', 'true');
			$('#responseHolder').addClass('disabled');
			$('#responseBody').html('');	
			$('#responseSign').html('');
		}
		if(stat > 1){
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

function submitResponse(rId, uId, stat, oData, rowId, oTable){
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
			$('#upModal').modal();
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
	$('#reEmail').html(oData.email);
	$('#reName').html(oData.authorData.firstname + " " + oData.authorData.lastname);
	$('#reUName').html(oData.authorData.username);
	$('#reDate').html(oData.submitted.dayOfMonth +"" + getNumberEnder(oData.submitted.dayOfMonth) + 
	 "  of " + formatString(String(oData.submitted.month)) + " " + oData.submitted.year);

	 let money = convert(oData.amount);
				let m = '';
				if(money.po > 0){
					m += '£'+money.po + " ";
				}
				if(money.cr > 0){
					m += 'cr'+money.cr + " ";
				}
				if(money.sh > 0){
					m +='s'+money.sh + " ";
				}
				if(money.pe > 0){
					m += 'd'+money.pe;
				}
	$('#reAmount').html(m);
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
	if(enable==true){
		console.log('enable');
		$('#navItemProfile').html('Profile');
		$('#navItemProfile').removeAttr('hidden');
		$('#navItemProfile').removeClass('disabled');
		$('#navItemProfile').off();
		$('#navItemProfile').on('click', validLog);
	} else {
		$('#navItemProfile').html('');
		$('#navItemProfile').attr('hidden', 'true');
		$('#navItemProfile').addClass('disabled');
		$('#navItemProfile').off();
	}
}


function turnOnViewLink(lvl){


	switch(lvl) {
		case 1:
			console.log('enableEmployeeview');
			$('#navItemViewReim').html('My Reimbursements');
			$('#navItemViewReim').removeAttr('hidden');
			$('#navItemViewReim').removeClass('disabled');		
			$('#navItemViewReim').off();
			$('#navItemViewReim').on('click', viewReimEmployee);

			$('#navItemSubmitReim').removeAttr('hidden');
			$('#navItemSubmitReim').html('Submit Reimbursement')
			$('#navItemSubmitReim').removeClass('disabled');
			$('#navItemSubmitReim').off();
			$('#navItemSubmitReim').on('click', viewReimSubmit);
			break;
		case 2:
			console.log('enableManagerView');
			$('#navItemViewReim').html('View Reimbursements');
			$('#navItemViewReim').removeAttr('hidden');
			$('#navItemViewReim').removeClass('disabled');			
			$('#navItemViewReim').off();
			$('#navItemViewReim').on('click', viewReimManager);

			$('#navItemSubmitReim').attr('hidden', 'true');
			$('#navItemSubmitReim').html('')
			$('#navItemSubmitReim').addClass('disabled');
			$('#navItemSubmitReim').off();
			break;
		default:
			console.log('disable');
			$('#navItemViewReim').html('');
			$('#navItemViewReim').attr('hidden', 'true');
			$('#navItemViewReim').addClass('disabled');
			$('#navItemViewReim').off();
			$('#navItemViewReim').off('click', viewReimEmployee);

			$('#navItemSubmitReim').attr('hidden', 'true');
			$('#navItemSubmitReim').html('')
			$('#navItemSubmitReim').addClass('disabled');
			$('#navItemSubmitReim').off();
		}
	}

function viewReimSubmit(){
	console.log("SubmitView");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			$('#view').html(xhr.responseText);
			$('#reSubmitButton').off();
			$('#reSubmitButton').on('click',reimSubmit);
		}
		
	}
	xhr.open("Get","submit.view",true);
	xhr.send();
}

function reimSubmit(){
	if($('#amountReSub').val() > 0){
		let amt = $('#amountReSub').val();
		let typ = $('#typeReSub').val();
		let desc = $('#reRespSub').val();
		var reim = {
				amount: amt,
				typeId: typ,
				description: desc
		};
		var xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				$('#subModal').modal();
				viewReimEmployee();
			}
			
		}
		xhr.open("POST","reimbursement",true);
		xhr.send(JSON.stringify(reim));
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
	} else if (getCookie('log') == 1){
		path = '<div class="containter">'+
			'        <div class="row">'+
			'            <div class="col-3"></div>'+
			'            <div class="col-6 align-center text-center">'+
			'              <div  style="padding-top:25px"><h1 style="font-size:80px">GREETINGS</h1></div>'+
			'              <h1 id="usernameInfo"></h1>'+
			'          </div>'+
			'          <div class="col-3"></div>'+
			'      </div>'+
			'  </div>'+
			''+
			'<div class="container">'+
			'        <div class="row">'+
			'            <div class="col-5">'+
			'                <div style="padding:50px">'+
			'                    <div class="container" style="margin-top:60px">'+
			'                        <div class="row">  '+
			'							<div class="col-12">' +
			'                            <h1 id="fullnameInfo"></h1>'+
			'							 <br>'+
			'                            <h1><span id="roleInfo">Privateer</span></h1>'+
			'							 <br>'+
			'                            <h1><span id="emailInfo"></span> </h1>'+
			'								</div>' +
			'    '+
			'                        </div>'+
			'                    </div>'+
			'                </div>'+
			'            </div>'+
			''+
			'                <div class="container" style="position:absolute; top:-180px; left: 18px">'+
			'                    <img class="pocketwatch" id="face" src="res/images/pocketwatch2.png" alt="">'+
			'                    <img id="hourHand" src="res/images/hourhand.png" alt="" style="transform-origin: 50% 100%; position: absolute;'+
			'                    top: 476px;'+
			'                    left: 1281px;">'+
			'                    <img id="minuteHand" src="res/images/smallhand.png" alt="" style="transform-origin: 50% 100%; position: absolute;'+
			'                    top: 430px;'+
			'                    left: 1276px;">'+
			'                    <img id="secondHand" src="res/images/smallesthand.png" alt="" style="transform-origin: 50% 100%; position: absolute;'+
			'                    top: 459px;'+
			'                    left: 1275.2px;">'+
			'            </div>'+
			'        '+
			'        </div>'+
			'    </div>';
	} else if (getCookie('log') ==  2){
		path = '<div class="containter">'+
		'        <div class="row">'+
		'            <div class="col-3"></div>'+
		'            <div class="col-6 align-center text-center">'+
		'              <div  style="padding-top:25px"><h1 style="font-size:80px">GREETINGS</h1></div>'+
		'              <h1 id="usernameInfo"></h1>'+
		'          </div>'+
		'          <div class="col-3"></div>'+
		'      </div>'+
		'  </div>'+
		''+
		'<div class="container">'+
		'        <div class="row">'+
		'            <div class="col-5">'+
		'                <div style="padding:50px">'+
		'                    <div class="container" style="margin-top:60px">'+
		'                        <div class="row">  '+
		'							<div class="col-12">' +
		'                            <h1 id="fullnameInfo"></h1>'+
		'							 <br>'+
		'                            <h1><span id="roleInfo">Financier</span></h1>'+
		'                            <h1><span id="emailInfo"></span> </h1>'+
		'							 <br>'+
		'							</div>' +
		'    '+
		'                        </div>'+
		'                    </div>'+
		'                </div>'+
		'            </div>'+
		''+
		'                <div class="container" style="position:absolute; top:-180px; left: 18px">'+
		'                    <img class="pocketwatch" id="face" src="res/images/pocketwatch2.png" alt="">'+
		'                    <img id="hourHand" src="res/images/hourhand.png" alt="" style="transform-origin: 50% 100%; position: absolute;'+
		'                    top: 476px;'+
		'                    left: 1281px;">'+
		'                    <img id="minuteHand" src="res/images/smallhand.png" alt="" style="transform-origin: 50% 100%; position: absolute;'+
		'                    top: 430px;'+
		'                    left: 1276px;">'+
		'                    <img id="secondHand" src="res/images/smallesthand.png" alt="" style="transform-origin: 50% 100%; position: absolute;'+
		'                    top: 459px;'+
		'                    left: 1275.2px;">'+
		'            </div>'+
		'        '+
		'        </div>'+
		'    </div>';
			
		
	

	}


	return path;
}

function convert(num){
	let pennies = num * 1.2;
	let pounds = 0;
	let crowns = 0;
	let shillings = 0;
	if(pennies >= 240){
	  pounds = Math.floor(pennies/240);
	  pennies = pennies%256;
	} 
	if(pennies >= 60){
	  crowns = Math.floor(pennies/60);
	  pennies = pennies%60;
	}
	if(pennies >= 12) {
	  shillings = Math.floor(pennies/12);
	  pennies = pennies%12;
	}
	var money = {
	  po : pounds,
	  cr : crowns,
	  sh : shillings,
	  pe : Math.floor(pennies)
	};
	return money;
  
  }