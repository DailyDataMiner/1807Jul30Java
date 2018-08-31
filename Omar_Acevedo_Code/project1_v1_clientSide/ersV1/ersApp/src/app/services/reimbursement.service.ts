import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Reimbursement } from '../models/reimbursement.model';
import { Observable } from '../../../node_modules/rxjs';
// import { Observable } from 'rxjs/Observable';
// import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class ReimbursementService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  // public getReimbursements(): Observable<any> {
  //   return this.http.get<Reimbursement[]>("http://localhost:8080/project1_v1/reimbursements");
  // }

  // Get Reimbursement data
  public getReimbursements() {
    return this.http.get<Reimbursement[]>("http://localhost:8080/project1_v1/reimbursements");
  }
  
  // Post Reimbursement data
  public postReimbursement(description: string, amount: number, 
                           reimb_type: string, receipt: string,
                           created_by_id: number): Observable<any> {
    return this.http.post<any>("http://localhost:8080/project1_v1/reimbursements", 
                                {description: description, amount: amount, reimb_type: reimb_type, receipt: receipt, created_by_id: created_by_id});
  }

  public updateReimbursementStatus(reimb_status: string, ticket_id: number, resolver: number): Observable<any> {
    console.log("reimb_status -> " + reimb_status);
    console.log("ticket_id -> " + ticket_id);
    console.log("resolver -> " + resolver);
    return this.http.post<any>("http://localhost:8080/project1_v1/reimbursements",
                            {action: 'updateStatus', reimb_status: reimb_status, ticket_id: ticket_id, resolver: resolver});
  }

}