import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';
import { ViewUsersServiceService } from '../../services/view-users-service.service';

@Component({
  selector: 'app-view-users-page',
  templateUrl: './view-users-page.component.html',
  styleUrls: ['./view-users-page.component.css']
})
export class ViewUsersPageComponent implements OnInit {

  constructor(private router: Router, private data: DataService, private location: Location, private viewUsersService: ViewUsersServiceService) { }

  iusername: string;
  ipassword: string;
  iemail: string;
  toAddToggle: boolean = false;

  ngOnInit() {
    if (this.data.user == null) {
      this.router.navigate(['/']);
    }
    else {
    this.getUsers();
    }
  }

  back() {
    this.location.back();
  }

  getUsers() {
    this.viewUsersService.getAssociates().subscribe(
      t => {
        console.log(t);
        this.data.users = [];
        if (t != null) {
          for (let a = 0; a < t.length; a++) {
            let servletUserID = Number.parseInt(t[a].userID);
            let servletUsername = t[a].username;
            let servletFirstName = t[a].firstname;
            let servletLastName = t[a].lastname;
            let servletEmail = t[a].email;
            let servletUserRole = t[a].userRole.userRoleName;
            this.data.insertUser([servletUserID, servletUsername, servletFirstName, servletLastName, servletEmail, servletUserRole]);
          }
        }
      }
    );
  }

  addUser() {
    this.viewUsersService.addUser(this.iusername, this.ipassword, this.iemail).subscribe(
      t => {
        if (t != null) {
          console.log(t);
          this.iusername = "";
          this.ipassword = "";
          this.iemail = "";
          this.toggleToAdd();
          this.getUsers();
          alert("User added!");
        }
      }
    )
  }
  setViewUser(i: number) {
    this.data.setViewUser(i);
  }
  toggleToAdd() {
    this.toAddToggle = !this.toAddToggle;
  }

  promoteUser() {
    this.viewUsersService.promoteAssociate().subscribe(
      t => {
        if (t != null) {
          alert("User promoted!");
        }
      }
    )
  }

}
