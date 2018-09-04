import { Component, OnInit } from '@angular/core';
import { User } from '../../../models/user.model';
import { UserService } from '../../../services/user.service';
import { NgForm } from '../../../../../node_modules/@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  user: User;
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.resetForm();
  }

  resetForm(form?: NgForm) {
    if (form != null)
      form.reset();
    this.user = {
      username: '',
      password: '',
      email: '',
      firstname: '',
      lastname: '',
      user_id: 0
    }
  }

  OnSubmit(form: NgForm) {
    // this.userService.registerUser(form.value).subscribe...
    this.userService.createUser(form.value).subscribe(
      (data: any) => {

        console.log("OnSubmit -> ");
        console.log(data);
        console.log(data.succeeded);

        if (data.succeeded == true) {
          this.resetForm(form);
          // display user registration successful in html
          console.log('display user registration successful in html');
        } else {
          console.log('display user registration error in html');
        }
      }
    );
  }

}
