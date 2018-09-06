import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Reimbursement } from '../../model/reimbursement.model'
import { AuthService } from '../../services/auth.service';
import { ReqObj } from '../../model/ReqObj.model'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: User;
  reim: Reimbursement;
  req: ReqObj;

  private amount: number;
  private description: string;
  private type: string;
  private resolver: string;

  constructor(private authService: AuthService) { }


  ngOnInit() {
    this.authService.getCurrentUser()
    .subscribe(data => { this.authService.user = data;
    if (this.authService.user !== null) {
      this.user = this.authService.user;
      this.GetReimb();
    } });
  }

GetReimb(){
  this.authService.getReimb(this.authService.user.username)
  .subscribe(data => { this.reim = data;
  });

}

    createReimb(){   
      // if (this.reim.amount == null || this.reim.type == null) {
      //   alert('Please give me data');
      // } else { 
      //   this.req.Resolver = this.authService.user.username;
      //   this.authService.addReimb(this.req).subscribe();
      // }
      }
    }