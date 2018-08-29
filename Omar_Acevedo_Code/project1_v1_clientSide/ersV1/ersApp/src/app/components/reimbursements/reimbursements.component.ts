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
  findReimbursements(type: string) {
    this.rService.getReimbursements().subscribe(
      reimb => {
        if (reimb !== null) {

          this.reimbursementsArr = reimb.filter(function(element, index, array) {
            
            type = (type == 'office') ? 'office supplies' : type;
            return (element.reimb_type.toUpperCase() == type.toUpperCase());

          });

        } else {
          console.log('Reimbursements were not loaded.');
        }
      }
    );
  }

  getExpenses(type) {
    console.log('getExpenses ' + type + ' fn');
    this.findReimbursements(type);
  }
  
  passTypeOfExpense(type) {
    console.log('passTypeOfExpense ' + type + ' fn');
    this.reimb_type = type;
  }

  addReimbursement() {
    console.log("addReimbursement fn");
   
    this.rService.postReimbursement(this.description, this.amount, this.reimb_type, this.receipt).subscribe(
      rData => {
        console.log('rData -> ');
        console.log(rData);

        this.description = '';
        this.amount = 0; 
        this.receipt = '';

      }
    );

  }

}
