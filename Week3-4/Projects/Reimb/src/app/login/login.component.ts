import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { Users } from '../models/users.model'
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  private loggedIn: boolean = false;
  private message: string;

  private servletUsername: string;
  private servletPassword: String;
  public servletFirst: string;
  // private servletLast: string;
  // private servletEmail: string;

  servletData: any;

  constructor(private authService: AuthService, private router: Router) {}


  ngOnInit() {
  }



  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => { 
        if (data == null ){
      console.log(data);
      console.log(this.loggedIn);
      this.servletUsername = "Invalid Credentials";
      
        }else{
          this.loggedIn = true;
          
          console.log(this.loggedIn);
          this.servletUsername = data.username;
          this.servletPassword = data.password;
          this.servletFirst = data.fn;
          this.router.navigate(['/home', {
              firstname: this.servletFirst
          }]);
        }
        
        // 
        // this.servletLast = data.lastname;
        // this.servletEmail = data.email;
      }
    );
  }

  logout() {

    this.loggedIn = false;
  }

 
  
}