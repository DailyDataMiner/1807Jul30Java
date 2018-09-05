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
  reim: Reimbursement[];

  private amount: number;
  private description: string;
  private requestType: string;
  private requestTypeStr: string;

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

  


//   submit() {
   
//       this.authService.getReimb(this.amount, this.description,
//          this.requestType, this.authService.user.username)
//          .subscribe(data => {
//           this.displayUserTable();
//       });
//     }
//   }
// }
}
