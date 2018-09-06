import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';
import { Reimbursement } from '../model/reimbursement.model';
import { ReqObj } from '../model/ReqObj.model'
import { UpObj } from '../model/UpObj.model'
@Injectable({providedIn: 'root'})
export class AuthService {

user: User;
emp: Reimbursement;
req: ReqObj;
up: UpObj;
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>("http://localhost:8888/Project1/login.ng", {username: username, password: password},
  {withCredentials: true});
  }
  getCurrentUser(): Observable<any>{
    return this.http.post<any>('http://localhost:8888/Project1/checksession.ng',
    null, {withCredentials: true});
  }
  logout(): Observable<any> {
    return this.http.post<any>('http://localhost:8888/Project1/logout.ng',
     null, {withCredentials : true});
  }
  getReimb(username: string): Observable<any> {
    return this.http.post<any>('http://localhost:8888/Project1/GetRiemb.ng', {username: username} 
    , {withCredentials : true});
  }
  getAllReimb(): Observable<any> {
    return this.http.post<any>('http://localhost:8888/Project1/allreimbursements.ng',
   {withCredentials : true} );
  }
//   addReimb(req): Observable<any>{
//     return this.http.post<any>('http://localhost:8888.Project1/addReib.ng',
//     null, {withCredentials : true} );
//   }
//   updateReimb(up): Observable<any>{
//     return this.http.post<any>('http://localhost:8888.Project1/updateReimb',
//     null, {withCredentials : true} );
//   }
}