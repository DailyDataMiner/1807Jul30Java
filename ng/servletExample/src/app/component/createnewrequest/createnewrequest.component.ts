import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models/user.model';
import { Reimbursement } from '../../models/reimbursement.model';
import { RouterModule, Router } from '../../../../node_modules/@angular/router';


@Component({
  selector: 'app-createnewrequest',
  templateUrl: './createnewrequest.component.html',
  styleUrls: ['./createnewrequest.component.css']
})
export class CreatenewrequestComponent implements OnInit {

  private reimbAmount: number;
  private reimbSubmitted: string;
  private reimbResolved: string;
  private reimbDescription: string;
  private reimbAuthor: string;
  private reimbResolver: string;
  private reimbStatusId: string;
  private reimbTypeId: string;
  show = false;
  hidden = false;

  constructor(
    private authService: AuthService,
    private route: RouterModule,
    private router: Router
  ) { }

  ngOnInit() {
    this.reimbAuthor = this.authService.loggedInUser.username;
  }

  createNewReimbursement() {
    if (this.reimbAmount == null || this.reimbDescription == null || this.reimbTypeId == null) {
      alert('please enter in something.');
    } else {
      this.hidden = !this.hidden;
      this.show = !this.show;

      this.authService.createNewReimbursement(this.reimbAmount, this.reimbDescription,
        this.reimbTypeId, this.authService.loggedInUser.username).subscribe(
          data => {
            console.log(data);
            //   this.authService.loggedInUser = data;

            //   // console.log("(for testing) the username of data is " + data.username);
            //   // console.log("for testing: also the email of this user is: " + this.authService.loggedInUser.email);
            this.goBack();
          }
        )

    }

  }

  goBack() {
    this.authService.isLoggedIn = true; // JUST IN CASE
    this.router.navigate(['userinfo']);
  }

}
