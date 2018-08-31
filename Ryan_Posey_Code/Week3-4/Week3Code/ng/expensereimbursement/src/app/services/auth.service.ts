import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../components/models/user.model';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>("http://localhost:8872/Project1/login.ng", {username: username, password: password});
  }
  getAll(): Observable<any> {
    return this.http.post<any>("http://localhost:8872/Project1/getAllReimbs.ng", {});
  }
  getOne(u_id: number): Observable<any> {
    return this.http.post<any>("http://localhost:8872/Project1/getReimbs.ng", {id: u_id});
  }
  add(author: number, amount: number, type: number, description: string): Observable<any> {
    return this.http.post<any>("http://localhost:8872/Project1/addReimb.ng", {author_id: author, amount: amount, type_id: type, description: description});
  }
  approve(r_id: number, res_id): Observable<any> {
    return this.http.post<any>("http://localhost:8872/Project1/approveReimb.ng", {id: r_id, resolver_id: res_id});
  }
  deny(r_id: number, res_id): Observable<any> {
    return this.http.post<any>("http://localhost:8872/Project1/denyReimb.ng", {id: r_id, resolver_id: res_id});
  }
  getUsers(): Observable<any> {
    return this.http.get<User[]>("http://localhost:8872/Project1/getUsers.ng", {});
  }
}
