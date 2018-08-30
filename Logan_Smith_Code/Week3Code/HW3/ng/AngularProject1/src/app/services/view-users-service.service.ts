import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Router } from '@angular/router';
import { DataService } from '../services/data.service';

@Injectable({
  providedIn: 'root'
})
export class ViewUsersServiceService {

  constructor(private http: HttpClient, private router: Router, private data: DataService) { }

  getAssociates(): Observable<any[]> {
    return this.http.post<any[]>('http://localhost:8084/LSProject1/getAssociates.ng', 0);
  }
  promoteAssociate(): Observable<any[]> {
    return this.http.post<any[]>('http://localhost:8084/LSProject1/promoteAssociate.ng', this.data.viewUser.id);
  }
  addUser(iusername:string, ipassword:string, iemail:string): Observable<any[]> {
    return this.http.post<any[]>('http://localhost:8084/LSProject1/addUser.ng', 
    {username: iusername, password: ipassword, email: iemail, userRole: "Associate"});
  }
}
