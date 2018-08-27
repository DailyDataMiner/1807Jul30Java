import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8081/Project1/login.ng', {username: username, pw: password});
  }

  getReimbById(id: number): Observable<any> {
    return this.http.post<any>('http://localhost:8081/Project1/findBySome.ng', {emp_id: id});
  }

  submitNew(r_amount: number, r_desc: string, raid: number, rtid: number): Observable<any> {
    return this.http.post<any>('http://localhost:8081/Project1/findBySome.ng',
      {reimb_amount: r_amount, reimb_description: r_desc, author_id: raid, reimb_type_id: rtid});
  }
}
