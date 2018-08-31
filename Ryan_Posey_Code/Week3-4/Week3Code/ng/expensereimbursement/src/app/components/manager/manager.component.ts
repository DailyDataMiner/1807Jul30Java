import { Component, OnInit } from '@angular/core';
import { Time } from '@angular/common';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../models/user.model';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

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

  users: User[];

  constructor(private authService: AuthService, private route: ActivatedRoute, private router: Router) { }

  getAllReimbursements() {
    this.authService.getAll().subscribe(
      data => {
        this.reimbArr = data;
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

  logout() {
    this.router.navigateByUrl('/login');
  }

  approve(reimbID: number, resolver: number) {
    this.authService.approve(reimbID, resolver).subscribe(
      data => {
        console.log(data);
        this.getAllReimbursements();
      }
    );
  }

  deny(reimbID: number, resolver: number) {
    this.authService.deny(reimbID, resolver).subscribe(
      data => {
        console.log(data);
        this.getAllReimbursements();
      }
    );
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
      return 'No type';
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
  }

  ngOnInit() {
    this.getUsers();
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['servletUserID'];
      this.getAllReimbursements();
    })
  }

}
