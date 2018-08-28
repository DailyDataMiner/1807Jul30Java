import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { Observable } from '../../../node_modules/rxjs';
import { Observable } from 'rxjs/Observable';
// import { Observable } from 'rxjs';
import { Book } from '../models/book.model';
// import { Observable } from 'rxjs';
import 'rxjs/Rx';
// import 'rxjs/Rx/Rx';
// import { Observable } from 'rxjs';
// import { Observable } from 'rxjs';
// import { map, filter, switchMap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

  public getBooks() {
    return this.http.get<Book[]>("http://localhost:8080/bookstore-jdbc/books");
  }

  // public getBooks(): Observable<Book[]> {
    
  //   return this.http.get("http://localhost:8080/bookstore-jdbc/books")
  //     .catch<any>(this.handleError);

  // }
   
}