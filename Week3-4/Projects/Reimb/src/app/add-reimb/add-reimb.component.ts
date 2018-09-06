import { Component, OnInit } from '@angular/core';
import { ReimbService } from './../services/reimb.service'
import { Reimbursement } from './../models/reimbursement.model';
import { AuthService } from '../services/auth.service';
import { Users } from '../models/users.model';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-reimb',
  templateUrl: './add-reimb.component.html',
  styleUrls: ['./add-reimb.component.css']
})
export class AddReimbComponent implements OnInit {


  constructor(private router: Router, private reimbSrv: ReimbService, private authSrv: AuthService, private route: ActivatedRoute) { }

  private reimbursements: Reimbursement[] = [];
  newReimb: Reimbursement = new Reimbursement();
  private users: Users;

  private id: number;
  private amount: number;
  private description: string;
  private typeid: any;
  public user: number;

  private fn: string;
  private rid: number;
  private ida: number;

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        this.fn = params['fn'];
        this.rid = params['rid'];
        this.ida = params['ida'];
      })
  }

  addNewReimb(){
    console.log("in reimbursement method");

    this.reimbSrv.addReimb(this.amount, this.description, this.ida, this.typeid).subscribe(
      data => {
        console.log(data);
        this.reimbursements = data;
        });
    }

    passOnR() {
      if (this.rid == 1){
      this.router.navigate(['/reimbursements', {
        fn: this.fn,
        rid: this.rid,
        ida:  this.ida
     
      
      }])}
    else {
      this.router.navigate(['employee', {
        fn: this.fn,
        rid: this.rid,
        ida:  this.ida
      }])}

    }
  
    passOnA() {
      this.router.navigate(['/add_reimb', {
        fn: this.fn,
        rid: this.rid,
        ida:  this.ida
      
      }])
    }
}
