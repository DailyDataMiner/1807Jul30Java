import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Time } from '@angular/common';
import { User } from '../models/user.model';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) { }

  private reimbID: number;
  private amount: number;
  private submitted: Time;
  private resolved: Time;
  private description: string;
  private receipt: Blob;
  private author: number;
  private resolver: number;
  private statusID: number;
  private typeID: number;

  public reimbArr: any[];

  servletData: any;

  id: number;

  private sub: any;

  private type: string;

  users: User[] = [];

  addReimbursement() {
    this.authService.add(this.id, this.amount, this.typeConvert(this.type), this.description).subscribe(
      data => {
        console.log(data);
        this.getReimbursements();
      }
    )
  }

  getReimbursements() {
    this.authService.getOne(this.id).subscribe(
      data => {
        this.reimbArr = data
          this.reimbID = data.id;
          this.amount = data.amount;
          this.submitted = data.submitted;
          this.resolved = data.resolved;
          this.description = data.description;
          this.receipt = data.receipt;
          this.author = data.author_id;
          this.resolver = data.resolver_id;
          this.statusID = data.status_id;
          this.typeID = data.type_id;

          console.log(this.reimbArr);
      }
    );
  }

  getUsers() {
    this.authService.getUsers().subscribe(
      t => {
        if(t != null) {
          this.users = t;
          console.log(t);
        }
        else {
          console.error('Error getting users');
        }
      }
    )
  }

  getUserById(u_id: number){
    return this.users.filter(u => u.id === u_id)[0].firstname + ' ' +  this.users.filter(u => u.id === u_id)[0].lastname;
  }

  typeConvert(type : String){
    if(type == 'Lodging'){
      return 1;
    }
    else if(type == 'Travel'){
      return 2;
    }
    else if(type == 'Food'){
      return 3;
    }
  }

  typeIDConvert(tid : number){
    if(tid == 1){
      return 'Lodging';
    }
    else if(tid == 2){
      return 'Travel';
    }
    else if(tid == 3){
      return 'Food';
    }
    else {
      return 'None';
    }
  }

  statusIDConvert(tid : number){
    if(tid == 1){
      return 'Pending';
    }
    else if(tid == 2){
      return 'Approved';
    }
    else if(tid == 3){
      return 'Denied';
    }
    else {
      return 'No status';
    }
  }

  logout() {
    this.router.navigateByUrl('/login');
  }

  ngOnInit() {
    this.getUsers();
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['servletUserID'];
      this.getReimbursements();
   });
  }
}
