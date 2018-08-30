import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { Reimbursement } from '../../models/reimbursement.model';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  public loggedUserId: number;
  public loggedUserName: string;
  private sub: any;

  reimbursementsArr: Reimbursement[] = [];
  currentClass = "";
  foodTicketCount: number = 0;
  officeTicketCount: number = 0;
  transportationTicketCount: number = 0;

  description: string;
  amount: number;
  reimb_type: string;
  receipt: string;

  constructor(private rService: ReimbursementService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.currentClass = "active";

    this.sub = this.route.params.subscribe(
      params => {
                  this.loggedUserId = +params['loggedUserId']; // (+) converts string 'loggedUserId' to a number
                  this.loggedUserName = params['loggedUserName'];
                  // In a real app: dispatch action to load the details here.
      });
   
    console.log("loggedUserId -> " + this.loggedUserId);
    console.log("loggedUserName -> " + this.loggedUserName);


    // # of tickets to show at init on each expense type block, ... still a work in progress
    // this.findReimbursements('food');
    // this.findReimbursements('office');
    // this.findReimbursements('transportation');
    // this.foodTicketCount = this.findReimbursements('food');
    // this.officeTicketCount = this.findReimbursements('office');
    // this.ticketCount = this.reimbursementsArr.length;
    
  }
  
  getTicketCount(type) {
    // this.ticketCount = 10;
    return 10;
    // return
  }

// try the aws s3 thing to store images (image link)

// This function is called by getExpenses fn
  findReimbursements(type: string, loggedUserName: string): number {
    this.rService.getReimbursements().subscribe(
      reimb => {
        if (reimb !== null) {

          this.reimbursementsArr = reimb.filter(function(element, index, array) {
            
            console.log(element);
            console.log(loggedUserName.toLowerCase());
            // console.log(element.created_byId);
            type = (type.toLowerCase() == 'office') ? 'office supplies' : type;
            
            if (  ( element.reimb_type.toUpperCase() == type.toUpperCase() ) && 
                  ( element.created_by.toLowerCase() == loggedUserName.toLowerCase() ) ) {
                    return true;
            } else {
              return false;
            }

            // return (element.reimb_type.toUpperCase() == type.toUpperCase()) || (type == '');

          });

          // this.foodTicketCount = this.reimbursementsArr.length;
          // this.officeTicketCount = this.reimbursementsArr.length;
          // this.transportationTicketCount = this.reimbursementsArr.length;
          // return this.reimbursementsArr.length;
          
        } else {
          console.log('Reimbursements were not loaded.');
        }
      }
    );
    return this.reimbursementsArr.length;
  }

  // Called by click event on html [ "View" button ]
  getExpenses(type) {
    console.log('getExpenses ' + type + ' fn');
    this.findReimbursements(type, this.loggedUserName);
    this.reimb_type = type;
  }
  
  passTypeOfExpense(type) {
    console.log('passTypeOfExpense ' + type + ' fn');
    this.reimb_type = type;
  }

  addReimbursement() {
    console.log("addReimbursement fn");
   
    this.rService.postReimbursement(this.description, this.amount, this.reimb_type, this.receipt, this.loggedUserId).subscribe(
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
