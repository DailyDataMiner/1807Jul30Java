import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Reimbursement } from '../../models/reimbursement.model';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  reimbursementsArr: Reimbursement[] = [];
  currentClass = "";

  description: string;
  amount: number;
  reimb_type: string;
  receipt: string;

  constructor(private rService: ReimbursementService) { }

  ngOnInit() {
    this.currentClass = "active";

    // this.findReimbursements();
    
  }
  
// try the aws s3 thing to store images (image link)
  findReimbursements() {
    this.rService.getReimbursements().subscribe(
      reimb => {
        if (reimb !== null) {
          this.reimbursementsArr = reimb;
          console.log('Reimbursements were loaded.');
          console.log(this.reimbursementsArr);
        } else {
          console.log('Reimbursements were not loaded.');
        }
      }
    );
  }

  getExpenses(type) {
    console.log('getExpenses ' + type + ' expenses');
    this.findReimbursements();
  }
  
  addExpenses(type) {
    console.log('addExpenses ' + type + ' expenses');
  }
  addReimbursement() {
    console.log("add");

    console.log(this.description);
    console.log(this.amount);
    console.log(this.reimb_type);
    this.reimb_type = "food";
    console.log(this.receipt);
    console.log('-----');
    
    this.rService.postReimbursement(this.description, this.amount, this.reimb_type, this.receipt).subscribe(
      rData => {
        console.log('rData -> ');
        console.log(rData);
      }
    );

  }

}
