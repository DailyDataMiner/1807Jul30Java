import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

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
          console.log(reimb);
        }
      }
    );
  }

}
