
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { User } from '../../model/user.model';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  user: User;
  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;
  private servletRole: string;
  servletData: any;

  constructor(private authService: AuthService, private route: Router) { }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(data => {this.authService.user = data;
    if (this.authService.user !== null) {
      this.route.navigate(['user']);
    }
    })
  }

  login() {
  if (this.username == null || this.password == null) {
    alert('Please give me data');
  } else {
    this.authService.login(this.username, this.password)
    .subscribe(user => { this.authService.user = user});
    if (this.authService.user.role == 'EMPLOYEE') {
      this.route.navigate(['user']);
    } else if (this.authService.user.role == 'FINANCE MANAGER') {
      this.route.navigate(['admin']);
    } else {
      error =>{ alert('Please Try Again');
    }
  }
}

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.servletFirst = data.firstname;
        this.servletLast = data.lastname;
        this.servletUsername = data.username;
        this.servletEmail = data.email;
        this.servletRole = data.role
      }
    );

}
}