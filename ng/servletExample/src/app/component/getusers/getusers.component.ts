import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-getusers',
  templateUrl: './getusers.component.html',
  styleUrls: ['./getusers.component.css']
})
export class GetusersComponent implements OnInit {

  show = false;
  hidden = false;
  users: User[] = [];

  servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.authService.getUsers().subscribe(
      data => {
        if (data != null) {
          console.log(data);
          this.authService.allUsers = data;
          this.users = this.authService.allUsers; // I don't know why, but this is the only way I can print to the screen

          // console.log(this.authService.allUsers[1]); FOR TESTING
          // console.log(this.users[2]); FOR TESTING

          console.log('loaded users');
        }
        else {
          console.error('Error loading users');
        }
      }
    );
  }
}
