import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login(){
    console.log(`value of username: ${this.username}`);
    console.log(`Value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(
      function(data) {
      console.log(data);
      this.servletData = data;
      }
    );
  }

}
