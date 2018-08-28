import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book.model'
import { BookstoreService } from '../../services/bookstore.service';

@Component({
  selector: 'app-book-component',
  templateUrl: './book-component.component.html',
  styleUrls: ['./book-component.component.css']
})
export class BookComponentComponent implements OnInit {

  books: Book[] =[];

  constructor(private bsService: BookstoreService) { }

  ngOnInit() {
    this.getBooks();
  }

  getBooks() {
    this.bsService.getBooks().subscribe(
      t => {
        if(t != null) {
          this.books = t;
          console.log(this.books);
        }
        else {
          console.error("Error: Unable to load books.");
        }
      }
    )
  }

}
