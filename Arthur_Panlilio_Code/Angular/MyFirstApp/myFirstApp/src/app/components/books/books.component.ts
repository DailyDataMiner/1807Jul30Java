import { Component, OnInit } from '@angular/core';
import { BookstoreService } from '../../services/bookstore.service';
import { Book } from '../models/book.model';
import { Genre } from '../models/genre.model';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books: Book[] = [];
  genres: Genre[] = [];
 private isbn: string;
  private title: string;
  private price: number;
  private genre: number;

  servletData: any;

  constructor(private bsService: BookstoreService) {
    console.log("IN BOOK COMPONENT CONSTRUCTOR");
   }

  ngOnInit() {
    console.log('in BOOK COMPONENT NG ON INIT');
    this.getGenres();
    this.getBooks();
  }

  getGenreById(id: number):string{
    return this.genres.filter(g =>  g.id === id)[0].name;
  }

  //Subscribe to Observable from book store service
  getBooks(){
    this.bsService.getBooks().subscribe(
      t => {
        if(t != null){
          this.books = t;
          console.log('loaded books');
        } else {
          console.error('Error loading books');
        }
      }
    );
  }

  addBook(){
    console.log(`Value of username: ${this.isbn}`);
    console.log(`Value of password: ${this.title}`);
    this.bsService.addBook(this.isbn, this.title, this.price, this.genre).subscribe(
      data => {
        this.isbn = data.isbn;
        this.title = data.title;
        this.price = data.price;
        this.genre = data.genre;
      }
    );
  }

  getGenres(){
    this.bsService.getGenres().subscribe(
      t => {
        if(t != null){
          this.genres = t;
          console.log('loaded books');
        } else {
          console.error('Error loading books');
        }
      }
    );
  }
  

}
