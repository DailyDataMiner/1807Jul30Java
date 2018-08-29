import { Component, OnInit } from '@angular/core';
import { BookstoreService } from '../../services/bookstore.service';
import {Book} from '../../model/book.model';


@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  books: Book[] = [];

  constructor(private bsService: BookstoreService) {
    console.log('IN BOOK COMPONENT CONSTUCTOR')
   }

  ngOnInit() {
    this.getBooks();
    console.log('IN BOOK COMPONENT NG ON INIT')
  }

  // getGenreById(id: number): string{

  //   const genre = this.

  // }

  getBooks() {
    this.bsService.getBooks().subscribe(
      t =>{
        if (t != null){
          this.books = t;
          console.log('loaded books');
        }else {
          console.log('Error loading books');
        }
      }


    );    
  }

}
