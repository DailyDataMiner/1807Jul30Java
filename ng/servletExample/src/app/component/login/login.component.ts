import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';


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
  
  // private servletUsername: string;
  // private servletFirst: string;
  // private servletLast: string;
  // private servletEmail: string;
  // private servletRole: string;

  // private rid: number;
  // private amount: number;
  // private sdate: Date;
  // private rdate: Date;
  // private info: String;
  // private recpt: Blob;
  // private resolver: string;
  // private status: number;
  // private type: number;

  user: User;

  servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login() {
    if (this.username == null || this.password == null) {
      alert('please enter in something.');
    } else {
      this.hidden = !this.hidden;
      this.show = !this.show;

      this.authService.login(this.username, this.password).subscribe(
        data => {
          console.log(data);
          this.user = data;
          console.log("(for testing) the username of data is " + data.username);
        }
      );
    }
  }

  create() {

  }

}
