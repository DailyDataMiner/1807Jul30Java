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
  public loggedIn: boolean = false;

  private message: string;

  public servletUsername: string;
  private servletPassword: String;
  public servletFirst: string;
  public servletId: number;
  public servletRoleId: number;
  
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
      
        }else {
          this.loggedIn = true;
          console.log(data);
          console.log(this.loggedIn);
          this.servletUsername = data.username;
          this.servletPassword = data.password;
          this.servletFirst = data.fn;
          this.servletId = data.id;
          this.servletRoleId = data.roleid;
          console.log(this.servletRoleId);
          console.log(this.servletId);
          if (this.servletRoleId == 1){
          this.router.navigate(['/reimbursements', {
              firstname: this.servletFirst,
              roleid: this.servletRoleId,
              id:  this.servletId
              
          }]);
        } if(data.roleid == 2) {
          this.loggedIn = true;
          console.log(data);
          console.log(this.loggedIn);
          this.servletUsername = data.username;
          this.servletPassword = data.password;
          this.servletFirst = data.fn;
          this.servletId = data.id;
          this.servletRoleId = data.roleid;
          console.log(this.servletRoleId);
          console.log(this.servletId);
          
          this.router.navigate(['/employee', {
              firstname: this.servletFirst,
              roleid: this.servletRoleId,
              id: this.servletId
          }]);


        
      }
      
      }
        
        // 
        // this.servletLast = data.lastname;
        // this.servletEmail = data.email;
      }
    );
  }

  logout() {

    this.loggedIn = false;
    this.authService.logout;
  }

 
  
}