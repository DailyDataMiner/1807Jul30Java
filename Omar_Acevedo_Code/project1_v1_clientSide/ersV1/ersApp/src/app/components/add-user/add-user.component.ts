import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,private router: Router, private userService: UserService) { }

  addForm: FormGroup;

  ngOnInit() {

    this.addForm = this.formBuilder.group({
      user_id: [],
      username: ['', Validators.required],
      email: ['', Validators.required],
      firstname: ['', Validators.required],
      lastname: ['', Validators.required]
    });

  }

  onSubmit() {
    console.log(this.addForm.value);
    this.userService.createUser(this.addForm.value)
      .subscribe( data => {
        this.router.navigate(['listusers']);
      });
  }

}
