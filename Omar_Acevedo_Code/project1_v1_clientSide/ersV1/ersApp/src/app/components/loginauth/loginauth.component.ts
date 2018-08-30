import { Component, OnInit } from '@angular/core';
import { LoginauthService } from '../../services/loginauth/loginauth.service';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-loginauth',
  templateUrl: './loginauth.component.html',
  styleUrls: ['./loginauth.component.css']
})
export class LoginauthComponent implements OnInit {

  private username: string;
  private password: string;
  public loggedUserId: number;
  public loggedUserName: string;

  constructor(private router: Router, private loginAuthService: LoginauthService) { }

  ngOnInit() {
  }

// on submit
  doLogin() {
    
    this.loginAuthService.login(this.username, this.password).subscribe(
      loginData => {

        console.log(loginData);
        
        if (loginData.user_id > 0) {

            this.loggedUserId = loginData.user_id;
            this.loggedUserName = loginData.username;

            if (loginData.user_role_id == 10) { // Normal employee

              // this.router.navigate(['/home']);
              this.router.navigate(['/reimbursements', {
                                                          loggedUserId: this.loggedUserId, 
                                                          loggedUserName: this.loggedUserName 
              }]);
              
            } else {

              this.router.navigate(['/reimbursementManager', {
                loggedUserId: this.loggedUserId, 
                loggedUserName: this.loggedUserName 
              }]);
              
            }
              
        } else {
          this.router.navigate(['/login']);
        }

        // return true;

        //  some way make (give a true value) to some [structural attribute?] 
        //  to display {redirect?} the home page
      }
    );

    // return true;
  }

}
