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

}
