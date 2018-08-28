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
  }

  getUsers() {
    this.authService.getUsers().subscribe(
      data => {
        if (data != null) {
          console.log(data);
          this.users = data;
          console.log('loaded users');
        }
        else {
          console.error('Error loading users');
        }
      }
    )
  }
}
