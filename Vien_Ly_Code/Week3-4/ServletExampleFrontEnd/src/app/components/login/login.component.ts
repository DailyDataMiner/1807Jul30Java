import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private username: string;
  private password: string;
  public servletData: any;


  constructor(private authService: AuthService) { }

  ngOnInit() {
  }


  login() {
    console.log(`value of username: ${this.username}`);
    console.log(`value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(data => {
      this.servletData = data;
    });

  }

}
