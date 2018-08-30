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

  public getReimbursements() {
    return this.http.get<Reimbursement[]>("http://localhost:8080/project1_v1/reimbursements");
  }

  public postReimbursement(description: string, amount: number, 
                           reimb_type: string, receipt: string,
                           created_by_id: number): Observable<any> {
    return this.http.post<any>("http://localhost:8080/project1_v1/reimbursements", 
                                {description: description, amount: amount, reimb_type: reimb_type, receipt: receipt, created_by_id: created_by_id});
  }

}