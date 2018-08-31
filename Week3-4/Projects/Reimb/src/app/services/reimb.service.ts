import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Reimbursement } from '../models/reimbursement.model';
import { Observable } from 'rxjs';


@Injectable()
export class ReimbService {

  constructor(private http: HttpClient) {}

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getReimbursements() {
    return this.http.
      get<Reimbursement[]>('http://localhost:8081/Reimb/reimbursement');
  }

}