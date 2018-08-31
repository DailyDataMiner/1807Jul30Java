import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DataService } from '../data/data.service';
import { User } from '../../models/user.model';
import { Reimbursement } from '../../models/reimbursement.model';
import { Observable } from 'rxjs';
import { ReimbursementDetails } from '../../models/reimbursement-details.model';
import { catchError } from 'rxjs/operators';
import { UserData } from '../../models/user-data.model';
import { ReimbursementResolveData } from '../../models/reimbursement-resolve-data.model';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient) { }

  getUser(id: number) {
    console.log(id);
    return this.http.get<User>('http://localhost:8085/ers_server/users?id=' + id, { withCredentials: true });
  }

  getAllUsers() {
    return this.http.get<User[]>('http://localhost:8085/ers_server/users', { withCredentials: true });
  }

  createUser(userData: UserData): Observable<User> {
    return this.http.post<User>('http://localhost:8085/ers_server/users', userData, { withCredentials: true });
  }

  editUser(userData: UserData): Observable<User> {
    return this.http.put<User>('http://localhost:8085/ers_server/users', userData, { withCredentials: true });
  }

  deleteUser(id: number) {
    return this.http.delete<User>('http://localhost:8085/ers_server/users?id=' + id, { withCredentials: true });
  }

  // only for admins
  getReimbursements(): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>('http://localhost:8085/ers_server/reimbursements', { withCredentials: true });
  }

  getReimbursementDetails(id: number): Observable<ReimbursementDetails> {
    return this.http.get<ReimbursementDetails>('http://localhost:8085/ers_server/reimbursements/details?id=' + id,
      { withCredentials: true });
  }

  getReimbursementById(id: number): Observable<Reimbursement> {
    return this.http.get<Reimbursement>('http://localhost:8085/ers_server/reimbursements?id=' + id, { withCredentials: true });
  }

  getReimbursementsByAuthor(username: string): Observable<Reimbursement[]> {
    return this.http.get<Reimbursement[]>('http://localhost:8085/ers_server/reimbursements?author=' + username, { withCredentials: true });
  }

  postReimbursement(ri: Reimbursement): Observable<Reimbursement> {
    return this.http.post<Reimbursement>('http://localhost:8085/ers_server/reimbursements', ri, { withCredentials: true });
  }

  resolveReimbursement(data: ReimbursementResolveData) {
    console.log(data);
    return this.http.put<Reimbursement>('http://localhost:8085/ers_server/reimbursements/resolve', data, { withCredentials: true });
  }
}
