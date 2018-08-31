import { Component, OnInit } from '@angular/core';
import { Time } from '../../../../node_modules/@angular/common';
import { AuthService } from '../../auth.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

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
  public employee: any[]
  servletData: any;
  id: number;
  private sub: any;
  private orderbool: boolean;
  private length: number;

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) { }

  getEmployee(){
    this.authService.getAllEmployee().subscribe(
      data => { 
        this.employee = data;
        length = this.employee.length;

        console.log(this.employee);
      })
  }

  getEmployeeByID(idd :number){
    for(let i = 0; i< length; i++){
      if(this.employee[i].empID == idd){
        return this.employee[i].firstname + ' ' + this.employee[i].lastname;
      }
    }
  
  }


  getAllReimbursementOrder(order: string) {
    if (this.orderbool) {
      this.authService.getAllReimbursementOrder(order).subscribe(
        data => {

          this.rbarray = data
          this.rbID = data.rbID;
          this.amount = data.amount;
          this.submitted = data.submitted;
          this.resolved = data.resolved;
          this.description = data.description;
          this.receipt = data.receipt;
          this.author = data.author;
          this.resolver = data.resolver;
          this.statusID = data.statusID;
          this.typeID = data.typeID;

          this.orderbool = false;

         

        }
      );
    }
    else {
      this.authService.getAllReimbursementOrder(order + " desc").subscribe(
        data => {

          this.rbarray = data
          this.rbID = data.rbID;
          this.amount = data.amount;
          this.submitted = data.submitted;
          this.resolved = data.resolved;
          this.description = data.description;
          this.receipt = data.receipt;
          this.author = data.author;
          this.resolver = data.resolver;
          this.statusID = data.statusID;
          this.typeID = data.typeID;

          this.orderbool = true;
        }

      );

    }
  }

  logout() {
    this.router.navigateByUrl('login');
  }

  approve(rbID: number, resolverID: number) {
    this.authService.approveReimbursement(rbID, resolverID).subscribe(
      data => {
        this.getAllReimbursement();
      })
  };

  deny(rbID: number, resolverID: number) {
    this.authService.denyReimbursement(rbID, resolverID).subscribe(
      data => {
        this.getAllReimbursement();
      })
  };

  convertTypeID(tid: number) {
    if (tid == 1) {
      return 'Lodging';
    }
    else if (tid == 2) {
      return 'Travel';
    }
    else if (tid == 3) {
      return 'Food';
    }
    else if (tid == 4) {
      return 'Certification';
    }
    else if (tid == 5) {
      return 'Maternity Leave';
    }
    else {
      return 'No type';
    }
  }

  convertStatusID(tid: number) {
    if (tid == 1) {
      return 'Pending';
    }
    else if (tid == 2) {
      return 'Approved';
    }
    else if (tid == 3) {
      return 'Denied';
    }
    else if (tid == 4) {
      return 'Revised';
    }
    else {
      return 'No status';
    }
  }





  getAllReimbursement() {
    this.authService.getAllReimbursement().subscribe(
      data => {

        this.rbarray = data
        this.rbID = data.rbID;
        this.amount = data.amount;
        this.submitted = data.submitted;
        this.resolved = data.resolved;
        this.description = data.description;
        this.receipt = data.receipt;
        this.author = data.author;
        this.resolver = data.resolver;
        this.statusID = data.statusID;
        this.typeID = data.typeID;
        // console.log(this.rbarray)

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

  testing(id: number) {
    console.log(id);
  }


  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['servletEmpID']; // (+) converts string 'id' to a number
      this.getAllReimbursement();
      this.getEmployee();
    })

  }



}
