import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { DataService } from '../services/data.service';
import { Reimb } from '../models/reimb.model';

@Injectable({
  providedIn: 'root'
})
export class UserreimbService {

  constructor(private http: HttpClient, private data: DataService) { }

  getReimbsbyUserID(id:number): Observable<any[]> {
    console.log("userID" + this.data.getUser().getUserID());
    return this.http.post<any[]>('http://localhost:8084/LSProject1/userPage.ng', this.data.getUser().getUserID());
}
}
