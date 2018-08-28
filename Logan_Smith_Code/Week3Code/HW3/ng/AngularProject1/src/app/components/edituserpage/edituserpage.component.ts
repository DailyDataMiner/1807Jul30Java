import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';

@Component({
  selector: 'app-edituserpage',
  templateUrl: './edituserpage.component.html',
  styleUrls: ['./edituserpage.component.css']
})
export class EdituserpageComponent implements OnInit {

  constructor(private data: DataService) { }

  username: string = this.data.user.username;
  firstname: string = this.data.user.firstname;
  lastname: string = this.data.user.lastname;
  email: string = this.data.user.email;

  ngOnInit() {
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
}