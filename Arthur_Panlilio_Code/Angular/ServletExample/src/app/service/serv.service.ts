import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServService {

  constructor(private http: HttpClient) { 
  }

  login(username:string, password:string): Observable<any>{
    return this.http.post<any>("http://localhost:8888/AngularExample/login.ng", (username: string, password: string)=>(1+1));
  }


}
