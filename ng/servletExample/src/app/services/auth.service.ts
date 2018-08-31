import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user.model';
import { Reimbursement } from '../models/reimbursement.model';

// @Injectable({
//   providedIn: 'root'
// })
@Injectable()
export class AuthService {
  loggedInUser: User;
  allUsers: User[] = [];
  reimbursement: Reimbursement;
  allReimbursements: Reimbursement[] = [];
  allUsersReimbursements: Reimbursement[] = [];

  isLoggedIn: boolean;

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    return this.http.post<User>("http://localhost:8081/ERS/login", {username: username, password: password});
  }

  getUsers() {
    return this.http.get<User[]>('http://localhost:8081/ERS/findallusers');
  }

  getReimbursementsByUser(username: string) {
    return this.http.post<Reimbursement[]>('http://localhost:8081/ERS/findusersreimbursements', {username: username});
  }

  getReimbursements() {
    return this.http.get<Reimbursement[]>('http://localhost:8081/ERS/findallreimbursements');
  }

  createNewUser(username: string, password: string, firstname: string, lastname: string, email: string){
    return this.http.post<User>("http://localhost:8081/ERS//createnewuser", {username: username, password: password, firstname: firstname, lastname: lastname, email: email});
  }

  createNewReimbursement(reimbAmount: number, reimbDescription: string, reimbTypeId: string, reimbAuthor: string) {
    return this.http.post<Reimbursement>("http://localhost:8081/ERS//createnewreimbursement", {reimbAmount: reimbAmount, reimbDescription: reimbDescription, reimbTypeId: reimbTypeId, reimbAuthor: reimbAuthor});
  }

  approveRequest(reimbId: number) {
    return this.http.post<Reimbursement>("http://localhost:8081/ERS//approverequest", {reimbId: reimbId});
  }

  denyRequest(reimbId: number) {
    return this.http.post<Reimbursement>("http://localhost:8081/ERS//denyrequest", {reimbId: reimbId});
  }

}
