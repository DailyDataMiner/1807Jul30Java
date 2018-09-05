import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model'
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  user: User;
  reim: Reimbursement[];

  private amount: number;
  private description: string;
  private requestType: string;
  private requestTypeStr: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(data => {
      this.authService.user = data;
      console.log(this.authService.user);
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.getAllReimb();
    }
    });
  }

  getAllReimb(){
    this.authService.getAllReimb()
    .subscribe(data => {this.user = data;
    });
  }
}