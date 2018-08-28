import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book } from '../components/models/book.model';
import { Genre } from '../components/models/genre.model';
import { Observable } from 'rxjs/Observable';

import 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) { }

  public handleError(error: Response){
    return Observable.throw(error.statusText);
  }

  public getBooks():Observable<Book[]>{
    return this.http.
    get<Book[]>('http://localhost:8888/BookStore/books');
  }

  public getGenres():Observable<Genre[]>{
    return this.http.
    get<Genre[]>('http://localhost:8888/BookStore/genres');
  }

  public addBook(isbn: string, title: string, price: number, genreId: number): Observable<any> {
    return this.http.post<any>("http://localhost:8888/BookStore/books", {isbn: isbn, title: title, price: price, genreId: genreId});
  }


}
