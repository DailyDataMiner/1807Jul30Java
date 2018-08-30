import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';
import { DataService } from './data.service';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient, private router: Router, private data: DataService) { }

  postLogin(username: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8084/LSProject1/login.ng', {username: username, password: password});
}
checkLogin(password: string): Observable<any> {
  return this.http.post<any>('http://localhost:8084/LSProject1/checkLogin.ng', {username: this.data.user.username, password: password});
}

routeRedirector(userRole: string) {

if (userRole == "Associate") {
  this.router.navigate(['/userPage']);
}
else if (userRole == "Admin") {
  this.router.navigate(['/adminPage']);
}

}


}