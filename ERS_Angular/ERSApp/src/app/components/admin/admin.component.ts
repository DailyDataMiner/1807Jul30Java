import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  user: User;
  emps: Reimbursement[];

  private id: number;
  private statusid: number;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(data => {
      this.authService.user = data;
      console.log(this.authService.user);
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.displayAllTable();
    }
    });
  }

  displayAllTable() {
    this.authService.allTable()
    .subscribe(data => {this.emps = data;
    });
  }

  updateRequest() {
    this.authService.updateRequest(this.id, this.statusid)
    .subscribe(data => {
      this.displayAllTable();
    });
  }
}
