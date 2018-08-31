import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ReimbursementService } from '../../services/reimbursement.service';
import { ActivatedRoute } from '@angular/router';
import { Reimbursement } from '../../models/reimbursement.model';
// import { FormGroup } from '../../../../node_modules/@angular/forms';
// import { FormBuilder } from '@angular/forms';

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
  // this.employeeSearch = "hola";
  
  reimbursementsArr: Reimbursement[] = [];
  selectedStatusId: string = "";
  
  // countryForm: FormGroup;
  // countries = ['USA', 'Canada', 'Uk'];
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
  
  //event handler for the select element's change event
  updateReimbStatus (event: any, ticket_id: any) {

    //update reimbursment
    this.selectedStatusId = event.target.value;

    console.log(this.selectedStatusId);
    console.log("ticket id -> " + ticket_id);

    // do a post request
    this.rService.updateReimbursementStatus(this.selectedStatusId, ticket_id, this.loggedUserId).subscribe(
      rStatus => {
        console.log('------>' + rStatus);
      }
    );

  }

  ngOnInit() {

    this.sub = this.route.params.subscribe(
      params => {
                  this.loggedUserId = +params['loggedUserId']; // (+) converts string 'loggedUserId' to a number
                  this.loggedUserName = params['loggedUserName'];
                  this.user_role_name = params['user_role_name'];
                  // In a real app: dispatch action to load the details here.
      });
      
    console.log("loggedUserId -> " + this.loggedUserId);
    console.log("loggedUserName -> " + this.loggedUserName);
    console.log("user_role_name -> " + this.user_role_name);

    this.findReimbursements('', '');

    // do the select part, for the status of the reimbursements
    // this.countryForm = this.fb.group({
    //   countryControl: ['Canada']
    // });

    // this.countryForm = this.fb.group({
    //   countryControl: [this.countries[1]]
    // });

  }

  // This function is called by getExpenses fn
  findReimbursements(type: string, loggedUserName: string): number {
    this.rService.getReimbursements().subscribe(
      reimb => {
        if (reimb !== null) {

          this.reimbursementsArr = reimb.filter(function(element, index, array) {
            
            console.log(element);
            console.log(loggedUserName.toLowerCase());
            // console.log(element.created_byId);
            // type = (type.toLowerCase() == 'office') ? 'office supplies' : type;
            
            // if (  ( element.reimb_type.toUpperCase() == type.toUpperCase() ) && 
            //       ( element.created_by.toLowerCase() == loggedUserName.toLowerCase() ) ) {
            //         return true;
            // } else {
            //   return false;
            // }
            return true;
          });
        } else {
          console.log('Reimbursements were not loaded.');
        }
      }
    );
    return this.reimbursementsArr.length;
  }
  
  // this.reimbursementsArr.filter(function() {
  //   return true;
  // });

}
