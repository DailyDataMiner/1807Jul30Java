import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data/data.service';
import { AuthService } from '../../services/auth/auth.service';
import { User } from '../../models/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private username: string;
  private password: string;
  private user: User;

  private error: string;

  constructor(private dataService: DataService, private authService: AuthService, private router: Router) {
  }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(user => {
      console.log(user);
      if (user) {
        console.log('already logged in');
        this.router.navigate(['/home']);
      }
    });
  }

  login() {
    console.log(`value of username: ${this.username}`);
    console.log(`value of password: ${this.password}`);

    this.authService.login(this.username, this.password).subscribe(user => {
      this.dataService.user = user;
      this.user = this.dataService.user;
      this.router.navigate(['/home']);
      console.log(this.user);
    });
  }
}
