import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';
import { RouterModule, Router } from '@angular/router';

@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  user: User;
  users: User[];
  private isAdmin: boolean;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {

    if (this.authService.loggedInUser.roleid === 'Admin') {
      this.isAdmin = true;
    }
    this.allUsers();

  }

  allUsers() {
    this.authService.getUsers().subscribe(
      data => {
        this.users = data;
        console.log(data);
      }
    );
  }

  createUser() {
    this.router.navigate(['createnewuser']);
  }

  createReimbursement() {
    this.router.navigate(['createnewrequest']);
  }

  goToReimbursements() {
    this.router.navigate(['getreimbursements']);
  }

  viewUserReimbursements() {
    this.router.navigate(['getreimbursementsbyuser']);
  }

  logout() {
    this.router.navigate(['login']);
  }

}
