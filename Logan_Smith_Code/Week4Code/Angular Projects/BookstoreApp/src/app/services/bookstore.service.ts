import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { observable, Observable } from '../../../node_modules/rxjs';
import { Book } from '../models/book.model';

@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) { }

public handleError(error: Response) {
  return Observable.throw(error.statusText);
}

public getBooks():Observable<Book[]> {
  return this.http.get<Book[]>('http://localhost:8086/BookstoreConnection/books');
}


}
