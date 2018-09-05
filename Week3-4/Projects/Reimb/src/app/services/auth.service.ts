import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public username: string;
  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any>{
    return this.http.post<any>("http://localhost:8081/Reimb/login", {username: username, password: password});
  }
  
  checkSession(): Observable<any> {
    return this.http.get<any>("http://localhost:8081/Reimb/checksesh");
  }

  logout() {
    return this.http.get<any>("http://localhost:8081/Reimb/logout");
  }
}
