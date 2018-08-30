import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Reimbursement } from '../../models/reimbursement.model';
import { RouterModule, Router } from '../../../../node_modules/@angular/router';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-getreimbursementsbyuser',
  templateUrl: './getreimbursementsbyuser.component.html',
  styleUrls: ['./getreimbursementsbyuser.component.css']
})
export class GetreimbursementsbyuserComponent implements OnInit {

  show = false;
  hidden = false;
  reimbursements: Reimbursement[] = [];
  // user: User;

  servletData: any;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {
    this.getUsersReimbursements();
  }

  getUsersReimbursements() {
    this.authService.getReimbursementsByUser(this.authService.loggedInUser.username).subscribe(
      data => {
        if (data != null) {
          console.log(data);
          console.log(this.authService.loggedInUser.username);
          this.authService.allUsersReimbursements = data;
          this.reimbursements = this.authService.allUsersReimbursements;
          console.log('loaded reimbursements');
        }
        else {
          console.error('Error loading reimbursements');
        }
      }
    );
  }

  goBack() {
    this.authService.isLoggedIn = true; // JUST IN CASE
    this.router.navigate(['userinfo']);
  }

}
