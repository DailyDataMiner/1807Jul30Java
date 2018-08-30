import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { DataService } from '../../services/data.service'

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private servletUserID: number;
  private servletUsername: string;
  private servletFirstName: string;
  private servletLastName: string;
  private servletEmail: string;
  private servletUserRole: string;

  servletData: any;

  constructor(private loginService: LoginService, private router: Router, private dataService: DataService) { }

  ngOnInit() {
  }


  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.loginService.postLogin(this.username, this.password).subscribe(
      data => {
        console.log(data);
        if (data != null) {
          this.servletUserID = Number.parseInt(data.userID);
          this.servletUsername = data.username;
          this.servletFirstName = data.firstname;
          this.servletLastName = data.lastname;
          this.servletEmail = data.email;
          this.servletUserRole = data.userRole.userRoleName;
          this.dataService.setUser([this.servletUserID, this.servletUsername, this.servletFirstName, this.servletLastName, this.servletEmail, this.servletUserRole
          ]);
          if (this.dataService.user.role == "Associate") {
            this.router.navigate(['/userPage']);
          }
          else if (this.dataService.user.role == "Admin") {
            this.router.navigate(['/adminPage']);
          }
        }
      }
    );
  }
}