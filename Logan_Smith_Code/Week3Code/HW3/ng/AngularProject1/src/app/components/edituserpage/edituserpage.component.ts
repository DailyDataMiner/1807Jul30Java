import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import {Location} from '@angular/common';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edituserpage',
  templateUrl: './edituserpage.component.html',
  styleUrls: ['./edituserpage.component.css']
})
export class EdituserpageComponent implements OnInit {

  constructor(private data: DataService, private location: Location, private loginService: LoginService, private router: Router) { }

  username: string = this.data.user.username;
  firstname: string = this.data.user.firstname;
  lastname: string = this.data.user.lastname;
  email: string = this.data.user.email;

  password: string;
  ipassword1: string;
  ipassword2: string;

  ngOnInit() {
    if (this.data.user == null) {
      this.router.navigate(['/']);
    }
  }

  update() {
    this.data.user.username = this.username;
    this.data.user.firstname = this.firstname;
    this.data.user.lastname = this.lastname;
    this.data.user.email = this.email;
    this.data.userUpdateUser(this.username, this.firstname, this.lastname, this.email).subscribe(
      data => {
        console.log(data);
        if (data != null) {
          alert("Update successful!");
        }
      }
    );
  }

  updatePassword() {
    let toConfirm = prompt("Are you sure you want to change your password? \n Enter CONFIRM if so.");
    if (toConfirm == "CONFIRM") {
      if (this.ipassword1 != this.ipassword2) {
          alert("New passwords do not match.");
      }
      else {
        this.loginService.checkLogin(this.password).subscribe(
          t => {
            console.log(t);
            if (t != null) {
              this.data.updateUserPassword(this.ipassword1).subscribe(
                v => {
                  if (v != null) {
                    this.password="";
                    this.ipassword1 = "";
                    this.ipassword2 = "";
                    alert("Password updated!");
                  }
                }
              )
            }
            else {
              alert("Incorrect Password.");
            }
          }
        );
      }
    }
  }

  toBack() {
    this.location.back();
  }
}