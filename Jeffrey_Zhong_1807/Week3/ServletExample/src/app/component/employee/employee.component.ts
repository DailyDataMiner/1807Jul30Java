import { Component, OnInit } from '@angular/core';
import { Time } from '../../../../node_modules/@angular/common';
import { AuthService } from '../../auth.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router'; 


@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) {

      // Instance of should be: 
      // NavigationEnd
      // NavigationCancel
      // NavigationError
      // RoutesRecognized
   
  }

  private rbID: number;
  private amount: number;
  private submitted: Time;
  private resolved: Time;
  private description: string;
  private receipt: Blob;
  private author: number;
  private resolver: number;
  private statusID: number;
  private typeID: number;
  public rbarray: any[];
  servletData: any;
  id: number;
  private sub: any;

  submitReimbursement(){
  this.authService.submitReimbursement(1,100,2,'testfromAnguler').subscribe(
    data => {
      
      this.rbarray = data
        this.rbID= data.rbID;
        this.amount= data.amount;
        this.submitted= data.submitted;
        this.resolved= data.resolved;
        this.description= data.description;
        this.receipt= data.receipt;
        this.author= data.author;
        this.resolver= data.resolver;
        this.statusID= data.statusID;
        this.typeID= data.typeID;
        console.log('submitted');
        console.log(this.rbarray);
 })
};

  getReimbursement() {
    this.authService.getReimbursement(this.id).subscribe(
      data => {
        
        this.rbarray = data
          this.rbID= data.rbID;
          this.amount= data.amount;
          this.submitted= data.submitted;
          this.resolved= data.resolved;
          this.description= data.description;
          this.receipt= data.receipt;
          this.author= data.author;
          this.resolver= data.resolver;
          this.statusID= data.statusID;
          this.typeID= data.typeID;
         

          console.log(this.rbarray);
        
        // this.rbID = data.rbID
        // this.servletFirst = data.firstname;
        // this.servletLast = data.lastname;
        // this.servletUsername = data.username;
        // this.servletEmail = data.email;
        // this.servletEmpID = data.empID;
        // this.servletroleID = data.roleID;
      }
    );
  }


  ngOnInit() {
 
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['servletEmpID']; // (+) converts string 'id' to a number
      this.getReimbursement();
      // In a real app: dispatch action to load the details here.
   });
  }

}
