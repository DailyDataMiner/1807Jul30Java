import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';
import { RouterModule, Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  show = false;
  hidden = false;

  // user: User;

  servletData: any;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {
  }

  login() {
    if (this.username == null || this.password == null) {
      alert('please enter in something.');
    } 
    else {

      this.hidden = !this.hidden;
      this.show = !this.show;

      this.authService.login(this.username, this.password).subscribe(
        data => {
          console.log(data);
          this.authService.loggedInUser = data;

          this.authService.isLoggedIn = true;
          this.router.navigate(['userinfo']);

          // if (data != null) {
            // this.authService.isLoggedIn = true;
          //   this.router.navigate(['userinfo']);
          // }

          // console.log("(for testing) the username of data is " + data.username);
          // console.log("for testing: also the email of this user is: " + this.authService.loggedInUser.email);
        }

      );

    }

  }

}
