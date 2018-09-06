import { Component, OnInit } from '@angular/core';
import { Timestamp } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { Reimbursement } from '../../model/reimbursement.model';
import { User } from '../../model/user.model';
import { Router } from '../../../../node_modules/@angular/router';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[] = [];
  users: User[] = [];
  // myUser: User;

  // new reimbursement
  private amount: number;
  private description: string;
  private type_id: number;
  private admin_id: number;
  message: string;
  types: String[] = ['Lodging', 'Travel', 'Food', 'Other'];
  statuses: String[] = ['Pending', 'Approved', 'Denied'];

  constructor(private route: ActivatedRoute, private router: Router, public http: AuthService) { }

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        this.http.user.id = params['loggedUserId'];
        this.http.user.username = params['loggedUsername'];
        this.http.user.firstname = params['loggedFirstname'];
        this.http.user.lastname = params['loggedLastname'];
        this.http.user.email = params['loggedEmail'];
        this.http.user.roleId = params['loggedUserRoleId'];
      });
    this.admin_id = this.http.user.roleId;
    console.log('loggedUserRoleId -> ' + this.http.user.roleId);
    if (this.http.user.roleId < 2) {
      this.getReimbursementsByUser();
    } else if (this.http.user.roleId > 1) {
      this.getAllReimbursements();
    }
  }

  public getAllReimbursements() {
    console.log('getting all reimbursements');
    this.http.getReimbursements().subscribe(
      t => {
        if (t != null) {
          this.reimbursements = t;
          console.log(this.reimbursements);
        } else {}
      }
    );
  }

  getReimbursementsByUser() {
    console.log('getting reimbursements by user id');
    this.http.getReimbursementsByUser(this.http.user.id).subscribe(
      t => {
        if (t != null) {
          this.reimbursements = t;
          console.log(this.reimbursements);
        } else {}
      }
    );
  }

  addNewReimbursement() {
    if (this.amount <= 0) {
      this.message = 'Please enter a positive amount';
    } else {
      this.http.addReimbursement(this.amount, this.description, this.http.user.id,
        parseInt(this.type_id)).subscribe(
          d => {
            this.reimbursements = d;
          }
        );
        console.log('user id = ' + this.http.user.id);
    }
    if (this.http.user.roleId < 2) {
      this.getReimbursementsByUser();
    } else if (this.http.user.roleId > 1) {
      this.getAllReimbursements();
    }
  }

  updateReimbStatus(event: any) {
    console.log(event.target.value);
    this.type_id = parseInt(event.target.value);
  }

  setApproved(reimbId: number) {
    this.http.updateReimbursement(reimbId, this.http.user.id, 2).subscribe(
      d => {
        this.reimbursements = d;
      }
    );
      // function(data) {
        // if (this.http.user.roleId < 2) {
          // this.getReimbursementsByUser();
        // } else if (this.http.user.roleId > 1) {
          // this.getAllReimbursements();
        // }
      // });
    if (this.http.user.roleId < 2) {
      console.log('getting reimbursements by user');
      this.getReimbursementsByUser();
    } else if (this.http.user.roleId > 1) {
      this.getAllReimbursements();
      console.log('getting all reimbursements');
    }
  }

  setDenied(reimbId: number) {
    this.http.updateReimbursement(reimbId, this.http.user.id, 3).subscribe(
      d => {
        this.reimbursements = d;
      }
    );
    if (this.http.user.roleId < 2) {
      this.getReimbursementsByUser();
    } else if (this.http.user.roleId > 1) {
      this.getAllReimbursements();
    }
  }

  typeConvert(type: string) {
    console.log('in type convert');
    switch (type) {
      case 'Lodging': { return 1; }
      case 'Travel': { return 2; }
      case 'Food': { return 3; }
      default: { return 4; }
    }
  }

  str2num(type: string) {
    console.log('in num2str');
    switch (type) {
      case '1': { return 1; }
      case '2': { return 2; }
      case '3': { return 3; }
      default: { return 4; }
    }
  }

  num2type(type: number) {
    switch (type) {
      case 1: { return 'Lodging'; }
      case 2: { return 'Travel'; }
      case 3: { return 'Food'; }
      default: { return 'Education'; }
    }
  }

  accountNavigate() {
    this.router.navigate(['/account', {
      loggedUserId: this.http.user.id,
      loggedUsername: this.http.user.username,
      loggedFirstname: this.http.user.firstname,
      loggedLastname: this.http.user.lastname,
      loggedEmail: this.http.user.email,
      loggedUserRoleId: this.http.user.roleId
    }]);
  }
}
