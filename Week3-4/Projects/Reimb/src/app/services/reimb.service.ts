import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reimbursement } from '../models/reimbursement.model';
import { Observable } from 'rxjs';
import { AddReimbComponent } from '../add-reimb/add-reimb.component' 
import { Users } from '../models/users.model';


@Injectable({
  providedIn: 'root'
})
export class ReimbService {
  
  users: Users;
  reimb: Reimbursement[];

  constructor(private http: HttpClient) {}

  public username: string;

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getReimbursementById(userid: number) {
    return this.http.
      post<Reimbursement[]>('http://localhost:8081/Reimb/empreimb', {author: userid});
  }
  public getReimbursements() {
    return this.http.
      get<Reimbursement[]>('http://localhost:8081/Reimb/reimbursement');
  }

  public addReimb(amount: number, description: string, typeid: any) {
    return this.http.post<any>('http://localhost:8081/Reimb/add', {amount: amount, description: description, typeid: typeid});
  }

  login(username: string, password: string): Observable<any>{
    return this.http.post<any>("http://localhost:8081/Reimb/login", {username: username, password: password});
  }

  public getPending(): Observable<any>{
    return this.http.get<Reimbursement[]>('http://localhost:8081/Reimb/pending');
  }
  public getApproved(): Observable<any>{
    return this.http.get<Reimbursement[]>('http://localhost:8081/Reimb/approved');
  }
  public getDenied(): Observable<any>{
    return this.http.get<Reimbursement[]>('http://localhost:8081/Reimb/denied');
  }

  public updateStatus(id: number, statusid: number): Observable<any> {
    return this.http.post<any>('http://localhost:8081/Reimb/update', {id: id, statusid: statusid})
  }

}