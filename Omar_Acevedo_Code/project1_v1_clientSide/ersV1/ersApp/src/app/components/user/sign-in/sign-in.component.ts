import { Component, OnInit } from '@angular/core';
import { User } from '../../../models/user.model';
import { UserService } from '../../../services/user.service';
import { NgForm } from '../../../../../node_modules/@angular/forms';
import { Router } from '../../../../../node_modules/@angular/router';
import { HttpErrorResponse } from '../../../../../node_modules/@angular/common/http';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent implements OnInit {

  user: User;
  isLoginError : boolean = false;

  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.reset();
    this.user = {
      username: '',
      password: '',
      firstname: '',
      lastname: '',
      email: '',
      user_id: 0
    }
  }

  doLogin(form: NgForm) {
    console.log("hey");
    console.log(form.value);
  }

  OnSubmit(username, password) {
    this.userService.userAuthentication(username, password).subscribe(
      (data: any) => {
        localStorage.setItem('userToken', data.access_token);
        this.router.navigate(['/home']);
      },
      (err: HttpErrorResponse) => {
        this.isLoginError = true;
      }
    );
  }

}
