import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Book} from '../model/book.model';
import {Genre} from '../model/genre.model';
import {Observable} from 'rxjs/Observable';

import 'rxjs/Rx';


@Injectable({
  providedIn: 'root'
})
export class BookstoreService {

  constructor(private http: HttpClient) { }

  public handleError( error: Response){
    return Observable.throw(error.statusText);

  }

  public getBooks(): Observable<Book[]>{

    return this.http.get<Book[]>('http//localhost8082/bookstore/books');

  }
}
