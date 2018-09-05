import { Component, OnInit } from '@angular/core';
import { ReimbService } from './../services/reimb.service'
import { Reimbursement } from './../models/reimbursement.model';

@Component({
  selector: 'app-add-reimb',
  templateUrl: './add-reimb.component.html',
  styleUrls: ['./add-reimb.component.css']
})
export class AddReimbComponent implements OnInit {


  constructor(private reimbSrv: ReimbService) { }

  private reimbursements: Reimbursement[] = [];
  newReimb: Reimbursement = new Reimbursement();

  private id: number;
  private amount: number;
  private description: string;
  private typeid: any;
  public user: string;

  ngOnInit() {
  }

  addNewReimb(){
    console.log("in reimbursement method");
    this.reimbSrv.addReimb(this.amount, this.description, this.typeid).subscribe(
      data => {
        console.log(data);
        this.reimbursements = data;
        });
    }
}
