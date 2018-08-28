import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../models/user.model';

// @Injectable({
//   providedIn: 'root'
// })
@Injectable()
export class AuthService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    return this.http.post<any>("http://localhost:8081/ERS/login", {username: username, password: password});
  }

  getUsers() {
    return this.http.get<User[]>('http://localhost:8081/ERS/findallusers');
  }

}
