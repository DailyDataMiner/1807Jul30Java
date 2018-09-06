import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ReimbService } from '../services/reimb.service';
import { Reimbursement } from './../models/reimbursement.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private fn: string;
  private rid: number;
  private ida: number;
  private reimbursements: Reimbursement[] = [];

  constructor(private route: ActivatedRoute, private router: Router, private ReimbSrv: ReimbService) { }

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        this.fn = params['fn'];
        this.rid = params['rid'];
        this.ida = params['ida '];
      });
    
  }

  passOnR() {
    console.log("In passOnR");
    
    this.router.navigate(['/home', {
      fn: this.fn,
      rid: this.rid,
      ida:  this.ida
    }])
  }

  passOnA() {
    console.log("In passOnA")
    this.router.navigate(['/add_reimb', {
      fn: this.fn,
      rid: this.rid,
      ida:  this.ida
    
    }])
  }
  getReimbursementById(){
    this.ReimbSrv.getReimbursementById(this.ida).subscribe(
      data => {
        this.reimbursements = data;
      }
    )
  }
  

}
