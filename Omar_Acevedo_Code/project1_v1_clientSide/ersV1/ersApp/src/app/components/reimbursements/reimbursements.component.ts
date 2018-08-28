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

  constructor(private rService: ReimbursementService) { }

  ngOnInit() {
    this.currentClass = "active";

    this.findReimbursements();

  }

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
  }
  
  addExpenses(type) {
    console.log('addExpenses ' + type + ' expenses');
  }

}
