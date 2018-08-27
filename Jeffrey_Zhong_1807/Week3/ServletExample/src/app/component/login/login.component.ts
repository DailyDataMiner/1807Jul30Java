import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth.service';
import { Router } from '@angular/router'; 


@Component({
  selector: 'williams-login-component',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  
  private username: string;
  private password: string;

  private servletEmpID: number;
  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;
  private servletroleID: number;

  servletData: any;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    
  }
 


  login() {
    console.log(`Value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.servletFirst = data.firstname;
        this.servletLast = data.lastname;
        this.servletUsername = data.username;
        this.servletEmail = data.email;
        this.servletEmpID = data.empID;
        this.servletroleID = data.roleID;
        

        
        if (this.servletroleID == 1){
          this.router.navigate(['/employee', this.servletEmpID]);
        }
         else if(this.servletroleID == 2){
            this.router.navigate(['/table', this.servletEmpID]);
          }
          else{
            this.router.navigateByUrl('/login');
          }     
         }
    );
  }

  // authenticate(num: number){
  //   console.log(num)
  //   if (num = 1){
  //     console.log(1)
  //     this.router.navigateByUrl('/employee');
  //   }
  //    else if(num = 2){
  //     console.log(2)
  //       this.router.navigateByUrl('/table');
  //       this.authService.getAllReimbursement();
  //     }
  //     else{
  //       console.log(3)
  //       this.router.navigateByUrl('/login');
  //     }

    
  // }
}