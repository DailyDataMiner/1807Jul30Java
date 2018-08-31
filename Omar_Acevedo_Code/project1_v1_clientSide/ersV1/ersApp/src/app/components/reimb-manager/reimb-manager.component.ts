import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ReimbursementService } from '../../services/reimbursement.service';
import { ActivatedRoute } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement.model';

@Component({
  selector: 'app-reimb-manager',
  templateUrl: './reimb-manager.component.html',
  styleUrls: ['./reimb-manager.component.css']
})
export class ReimbManagerComponent implements OnInit {

  public loggedUserId: number;
  public loggedUserName: string;
  private user_role_name: string;
  private sub: any;
  private employeeSearch: string = "";

  //https://codeburst.io/create-a-search-pipe-to-dynamically-filter-results-with-angular-4-21fd3a5bec5c  
  reimbursementsArr: Reimbursement[] = [];
  selectedStatusId: string = "";
  
  reimbStatus = [{
    id: '2',
    name: 'APPROVED'
   },
   {
    id: '3',
    name: 'DENIED',
    code: 'CAD'
   },
   {
    id: '1',
    name: 'PENDING'
   }];

   
  constructor(private rService: ReimbursementService, 
              private route: ActivatedRoute,
              private fb: FormBuilder) { }


/*
  - Update reimbursment Status
  Function to handle select element's change event */
  updateReimbStatus (event: any, ticket_id: any) {

    this.selectedStatusId = event.target.value;

    // do a post request
    this.rService.updateReimbursementStatus(this.selectedStatusId, ticket_id, this.loggedUserId).subscribe(
      rStatus => {
        console.log('Service: updateReimbursementStatus fn ------>' + rStatus);
      }
    );

  }

/*
  Init */
  ngOnInit() {

  //  Get parameters from login route 
    this.sub = this.route.params.subscribe(
      params => {
                  this.loggedUserId = +params['loggedUserId']; // (+) converts string 'loggedUserId' to a number
                  this.loggedUserName = params['loggedUserName'];
                  this.user_role_name = params['user_role_name'];
                  // In a real app: dispatch action to load the details here.
      });

    this.findReimbursements('', '');

  } // ngOnInit end
  

  findReimbursements(type: string, loggedUserName: string): number {
    this.rService.getReimbursements().subscribe(
      reimb => {
        if (reimb !== null) {

          this.reimbursementsArr = reimb.filter(function(element, index, array) {
            return true;
          });

        } else {
          console.log('Reimbursements were not loaded.');
        }
      }
    );
    return this.reimbursementsArr.length;
  }
  
}
