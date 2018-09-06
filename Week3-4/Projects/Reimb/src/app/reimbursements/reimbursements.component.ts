import { Component, OnInit } from '@angular/core';
import { Reimbursement } from './../models/reimbursement.model';
import { ReimbService } from './../services/reimb.service';
import { AuthService } from '../services/auth.service';
import { Router, ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  private reimbursements: Reimbursement[] = [];
  //private reimbursements2: Reimbursement[] = [];
  private statusid: any;
  private typeid: any;
  private id: any;
  servletData: any;
  newReimb: Reimbursement = new Reimbursement();
  private fn: string;
  private rid: number;
  private ida: number;

  constructor(private router: Router, private reimbSrv: ReimbService, private authSrv: AuthService, private route: ActivatedRoute) {
   
  }

  ngOnInit() {
    this.authSrv.checkSession();
    console.log("reimbursementinit");
    this.getReimbursements();
    this.route.params.subscribe(
      params => {
        this.fn = params['fn'];
        this.rid = params['rid'];
        this.ida = params['ida'];
        console.log(this.ida);
         
  })
}

  addnewReimbursement() {
    this.reimbSrv.getReimbursements();
  }

  getPending() {
    console.log("in Pending method");
    this.reimbSrv.getPending().subscribe(
      data => {
        console.log("pending");
        console.log(data);
        this.reimbursements = data;
        });
    }

 getApproved() {
    console.log("in Approve method");
    this.reimbSrv.getApproved().subscribe(
      data => {
        console.log(data);
        this.reimbursements = data;
        });
    } 

  getDenied() {
      console.log("in Denied method");
      this.reimbSrv.getDenied().subscribe(
        data => {
          console.log(data);
          this.reimbursements = data;
          });
      } 
    
    

   // return this.reimbSrv.getReimbursements.filter.map(r => r.statusid === statusid);
    //return this.genres.filter(g => g.id === id )[0].name;

getReimbursements(){
    console.log("in reimbursement method");
    this.reimbSrv.getReimbursements().subscribe(
      data => {
        console.log(data);
        this.reimbursements = data;
        });
    }

  approve(){
    console.log();
    console.log("approve request");
    this.statusid = 2;
    if (this.id === undefined){
      alert("Must choose a row");
  } else {
    this.reimbSrv.updateStatus(this.id, this.statusid)
      .subscribe(data => {
        this.getReimbursements();
      })
  }
  }

  deny(){
    console.log("deny request");
    this.statusid = 3;
    if (this.id === undefined){
      alert("Must choose a row");
  } else {
    this.reimbSrv.updateStatus(this.id, this.statusid)
      .subscribe(data => {
        this.getReimbursements() ;
      })
  }
  }

  onSelect( id: number ) {
    this.id = id;
    console.log(id);
  }

  passOnR() {
    console.log("In passOnR");
    
    this.router.navigate(['/reimbursements', {
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
  
}

