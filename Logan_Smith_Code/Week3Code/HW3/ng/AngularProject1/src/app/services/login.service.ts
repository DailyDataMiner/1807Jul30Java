import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class LoginService {

  constructor(private http: HttpClient, private router: Router) { }

  postLogin(username: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8084/LSProject1/login.ng', {username: username, password: password});
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