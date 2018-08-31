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
  reimbId: number;


  servletData: any;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {
    this.getReimbursements();
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

   approveRequest(reimbId: number) {
    console.log(reimbId)
    this.authService.approveRequest(reimbId).subscribe(
      data => {

      console.log(data);

      this.authService.isLoggedIn = true; // JUST IN CASE
      this.router.navigate(['userinfo']);

    });
  }

  denyRequest(reimbId: number) {
    console.log(reimbId)
    this.authService.denyRequest(reimbId).subscribe(
      data => {

      console.log(data);

      this.authService.isLoggedIn = true; // JUST IN CASE
      this.router.navigate(['userinfo']);

    });
  }

}
