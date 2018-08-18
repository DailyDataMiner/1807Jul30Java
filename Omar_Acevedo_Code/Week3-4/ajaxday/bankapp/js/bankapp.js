window.onload = function() {

    $('#message').hide();
    $('#logIn').click(doCoolThigs);

}

function doCoolThigs() {

    let username = $('#username').val();
    let password = $('#password').val();

    if ( (username.length > 0) && (password.length > 0))  {

        $('#message').show();
        // $('#message').attr('hidden', 'true');

        useAjax(username, password);

    } else {

        var elem = $('#message');
        elem.html('Please fill out all form fields!');
        
        // v1
        $('#message').show();

        // v2
        // $('#message').removeAttr('hidden');
    }

}

function useAjax(username, password) {

//  Plain Javascript AJAX version

    // STEP 1 - OPEN REQUEST
    var xhr = new XMLHttpRequest();

    // STEP 2 - OPEN REQUEST
    xhr.onreadystatechange = function() {

        if (xhr.readyState == 4 && xhr.status == 200) {
            
            resp = xhr.responseText;

            userObj = JSON.parse(resp);
            
            console.log(userObj);

            if (userObj.length == 1) {
                if ( (userObj[0].password == password) ) {

                        $('#message').html('Logged in!');
  
                        $('#message').show();

                        $('#landingView').hide();
                        $('#welcome').show();

                        let firstname = userObj[0].fistName;
                        let lastname = userObj[0].lastName;
                        $('#welcomeMessage').html('Welcome '+firstname+
                                                  ' '+lastname+'!');

                } else {
                    alert('uh oh');
                    var elem = $('#message');
                    elem.html('you got it wrong!');
                    
                    // v1
                    $('#message').show();
            
                    // v2
                    // $('#message').removeAttr('hidden');  
                }
            }
       }
    }

    // STEP 3 - OPEN REQUEST
    var valueFromUser = "omarace";
    // var url = "http://localhost:3000/users";
    // var url = "http://localhost:3000/users?username=" + valueFromUser;
    var url = "http://localhost:3000/users?username=" + username;
    // var url = "http://localhost:3000/users";

    xhr.open("GET", url, true);
    // xhr.open("POST", url, true);
    // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    // xhr.setRequestHeader("Content-Type", "application/json");

/*
        if (xhr.readyState == 4 && xhr.status == 200) {
*/

    // var myObj = '{
    //     "id": 1,
    //     "fistName": "Omar",
    //     "lastName": "Acevedo",
    //     "username": "omarace",
    //     "password": "mypassword"
    //   };
    // json stringify

    // STEP 4 - SEND REQUEST
    // xhr.send("firstName=ramorm"); 
    // xhr.send(new Blob()); 
    // xhr.send(new Int8Array()); 
    // xhr.send(document);
    xhr.send();

}