import { Component, OnInit } from '@angular/core';
import { Time } from '../../../../node_modules/@angular/common';
import { AuthService } from '../../auth.service';

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
  servletData: any;

  constructor(private authService: AuthService) { }

  getAllReimbursement() {
    this.authService.getAllReimbursement().subscribe(
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


  ngOnInit() {
    this.getAllReimbursement();
    }

 

}