import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';
import { AppRoutingModule } from './app-routing.module';
import { BookstoreComponent } from './components/bookstore/bookstore.component';
import { BooksComponent } from './components/books/books.component';
import { GenresComponent } from './components/genres/genres.component';
import { AuthorsComponent } from './components/authors/authors.component';
import { BooksService } from './services/books.service';
import { HttpClientModule } from '@angular/common/http';
// import { Observable, Subject, ReplaySubject, from, of, range } from 'rxjs';
// import { map, filter, switchMap } from 'rxjs/operators';

@NgModule({
  declarations: [
    /*
      Declarations array - holds classes that are
      related to view. There can be three types of 
      classes listed are: components, directives, and pipes. 
    */
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SquarerootPipe,
    BookstoreComponent,
    BooksComponent,
    GenresComponent,
    AuthorsComponent
  ],
  /* 
    exports: []
    classes that need to be accessible to the components
    of the modules. However, we're not making a
    multi-modular app at the moment, so we do not need 
    anything in the exports array
  */
  imports: [
    /*
      modules whose classes are needed by classes within
      this current module
    */
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  /*
    Providers - services(@Injectable)
  */
  providers: [
    BooksService
  ],
  /*
    Refers to the root component which is the main view 
    of the angular app
  */
  bootstrap: [AppComponent]
})
export class AppModule { }
