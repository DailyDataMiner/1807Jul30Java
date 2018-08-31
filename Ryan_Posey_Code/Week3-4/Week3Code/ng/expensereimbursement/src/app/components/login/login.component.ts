import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private servletUserID: number;
  private servletUsername: string;
  private servletFirstname: string;
  private servletLastname: string;
  private servletEmail: string;
  private servletRole_Id: number;

  servletData: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe (
      data => {
        console.log(data);
        this.servletFirstname = data.firstname;
        this.servletLastname = data.lastname;
        this.servletUsername = data.username;
        this.servletEmail = data.email;
        this.servletUserID = data.id;
        this.servletRole_Id = data.role_id;

        if(this.servletRole_Id == 1) {
          this.router.navigate(['/employee', this.servletUserID]);
        }
        else if(this.servletRole_Id == 2) {
          this.router.navigate(['/manager', this.servletUserID]);
        }
        else {
          this.router.navigateByUrl('/login');
        }
      }
    );
  }

}
