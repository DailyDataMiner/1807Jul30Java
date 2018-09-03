import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model'
import { AuthService } from '../../services/auth.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: User;
  emp: Reimbursement[];

  private amount: number;
  private description: string;
  private requestType: number;
  private requestTypeStr: string;

  constructor(private authService: AuthService) { }


  ngOnInit() {
    this.authService.getCurrentUser()
    .subscribe(data => { this.authService.user = data;
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.displayUserTable();
    } });
  }

  displayUserTable(){
    this.authService.getReimb(this.authService.user.username)
    .subscribe(data => { this.emp = data});
  }

  
}
