import { Component, OnInit } from '@angular/core';
import { Reimbursement } from './../models/reimbursement.model';
import { ReimbService } from './../services/reimb.service';


@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  private reimbursements: Reimbursement[] = [];
  private statusid: any;
  private typeid: any;

  servletData: any;

  constructor(private reimbSrv: ReimbService) {
   
  }

  ngOnInit() {
    console.log("reimbursementinit");
    this.getReimbursements();
  }

  addnewReimbursement() {
    this.reimbSrv.getReimbursements();
  }

  getReimbursements(){
    console.log("in reimbursement method");
    this.reimbSrv.getReimbursements().subscribe(
      data => {
        console.log(data);
        this.reimbursements = data;
        for (let entry of this.reimbursements){
            if(entry.statusid == "1"){
              entry.statusid = "PENDING";
            }
            if(entry.statusid == "2"){
              entry.statusid = "APPROVED";
            }
            if(entry.statusid == "3"){
              entry.statusid = "DENIED";
            }
            if(entry.typeid == "1"){
              entry.typeid = "Lodging";
            }
            if(entry.typeid == "2"){
              entry.typeid = "Travel";
            }
            if(entry.typeid == "3"){
              entry.typeid = "Food";
            }
            if(entry.typeid == "4"){
              entry.typeid = "Training";
            }
            if(entry.typeid == "5"){
              entry.typeid = "Misc";
            }
            
          }
        });
    }
}
