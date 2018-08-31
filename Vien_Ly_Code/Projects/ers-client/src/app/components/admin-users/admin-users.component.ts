import { Component, OnInit, ViewChild } from '@angular/core';
import { HttpService } from '../../services/http/http.service';
import { User } from '../../models/user.model';
import { UserDetailsComponent } from '../user-details/user-details.component';
import { AddUserComponent } from '../add-user/add-user.component';
import { UserData } from '../../models/user-data.model';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin-users.component.html',
  styleUrls: ['./admin-users.component.css']
})
export class AdminUsersComponent implements OnInit {

  users: User[];

  @ViewChild(UserDetailsComponent)
  detailsModal: UserDetailsComponent;

  @ViewChild(AddUserComponent)
  addUserModal: AddUserComponent;

  constructor(private httpService: HttpService) { }

  ngOnInit() {
    this.fetchUsers();
  }

  fetchUsers() {
    console.log('fetching');
    this.httpService.getAllUsers().subscribe(users => {
      this.users = users.sort((a, b) => {
        return a.username.localeCompare(b.username);
      });
    });
  }

  openUserDetailsModal(u: User) {
    console.log(this.detailsModal);
    this.detailsModal.open(u);
  }

  openAddUserModal() {
    this.addUserModal.open();
  }

  createUser(userData: UserData) {
    this.httpService.createUser(userData).subscribe(user => {
      console.log(user);
      this.fetchUsers();
    });
  }
}
