import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { DataService } from '../services/data.service';

@Injectable({
  providedIn: 'root'
})
export class AdminreimbService {

  constructor(private http: HttpClient, private data: DataService) { }

  getReimbs(): Observable<any[]> {
    return this.http.post<any[]>('http://localhost:8084/LSProject1/adminPage.ng', 0);
}
approveReimb(): Observable<any[]> {
  return this.http.post<any[]>('http://localhost:8084/LSProject1/updateReimb.ng', {reimbID: this.data.currentReimb.id, reimbResolver: this.data.user.id, reimbStatus: 'Approved'});
}
denyReimb(): Observable<any[]> {
  return this.http.post<any[]>('http://localhost:8084/LSProject1/updateReimb.ng', {reimbID: this.data.currentReimb.id, reimbResolver: this.data.user.id, reimbStatus: 'Denied'});
}
}
