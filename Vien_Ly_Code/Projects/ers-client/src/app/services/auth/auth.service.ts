import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';

import { DataService } from '../data/data.service';

import { User } from '../../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean;
  redirectUrl: string;

  constructor(private http: HttpClient, private dataService: DataService) {
    this.isLoggedIn = false;
  }

  login(username: string, password: string): Observable<User> {
    this.isLoggedIn = true;
    return this.http.post<User>('http://localhost:8085/ers_server/login',
      { username: username, password: password },
      { withCredentials: true });
  }

  logout() {
    this.isLoggedIn = false;
    return this.http.post('http://localhost:8085/ers_server/logout', { }, { withCredentials: true });
  }

  getCurrentUser(): Observable<User> {
    return this.http.get<User>('http://localhost:8085/ers_server/login', { withCredentials: true });
  }
}
