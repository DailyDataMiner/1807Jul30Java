import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../models/book.model'

import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) {}

  public handleError(error: Response ){
    return Observable.throw(error.statusText);
  }

  public getBooks():Observable<Book[]> {
    return this.http.get('http://localhost:8081/bookstore/books')
  }
}
