import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book.model';
import { BooksService } from '../../services/books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];

  constructor(private bsService: BooksService) { }

  ngOnInit() {
    this.getBooks();
  }
  
  // getGenreById(): string {
    // const genre = this.
  // }

  // Subscribe to Observable from book store service
  getBooks() {
    this.bsService.getBooks().subscribe(
      t => {
        if (t !== null) {
          this.books = t;
          console.log('Loaded books');
        } else {
          console.error('Error loading books');
        }
      }
    );
  }

}
