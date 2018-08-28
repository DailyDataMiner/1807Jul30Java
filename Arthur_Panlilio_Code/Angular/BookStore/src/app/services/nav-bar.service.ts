import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NavBarService {

  constructor(private http: HttpClient) { }

  onGoToAccount(): Observable<any> {
    return this.http.get<any>("http://localhost:8888/BookStore/home.view");
  }
}
