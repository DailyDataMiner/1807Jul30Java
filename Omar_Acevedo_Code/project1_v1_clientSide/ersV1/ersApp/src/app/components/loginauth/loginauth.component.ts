import { Component, OnInit } from '@angular/core';
import { LoginauthService } from '../../services/loginauth/loginauth.service';

@Component({
  selector: 'app-loginauth',
  templateUrl: './loginauth.component.html',
  styleUrls: ['./loginauth.component.css']
})
export class LoginauthComponent implements OnInit {

  constructor(private loginAuthService: LoginauthService) { }

  ngOnInit() {
  }

  doLogin() {
    this.loginAuthService.login('omar', 'password').subscribe(
      loginData => {
        console.log(loginData);
        //  some way make (give a true value) to some [structural attribute?] 
        //  to display {redirect?} the home page
      }
    );
  }

}
