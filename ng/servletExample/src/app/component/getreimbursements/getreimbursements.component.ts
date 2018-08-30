import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Reimbursement } from '../../models/reimbursement.model';
import { RouterModule, Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-getreimbursements',
  templateUrl: './getreimbursements.component.html',
  styleUrls: ['./getreimbursements.component.css']
})
export class GetreimbursementsComponent implements OnInit {

  show = false;
  hidden = false;
  reimbursements: Reimbursement[] = [];

  servletData: any;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {
  }

  getReimbursements() {
    this.authService.getReimbursements().subscribe(
      data => {
        if (data != null) {
          console.log(data);
          this.authService.allReimbursements = data;
          this.reimbursements = this.authService.allReimbursements;
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

  resolveReimbursement() {

  }

}
