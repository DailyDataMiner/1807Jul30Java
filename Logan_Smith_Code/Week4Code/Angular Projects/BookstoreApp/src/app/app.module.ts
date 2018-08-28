import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BookComponentComponent } from './Components/book-component/book-component.component';
import { NavbarComponentComponent } from './Components/navbar-component/navbar-component.component';
import { AppRoutingModule } from './/app-routing.module';
import { HomeComponent } from './Components/home/home.component';
import { AuthorComponent } from './Components/author/author.component';
import { GenreComponent } from './Components/genre/genre.component';
import { HttpClient } from '../../node_modules/@types/selenium-webdriver/http';
import { HttpClientModule } from '@angular/common/http';
import { BookstoreService } from './services/bookstore.service';

@NgModule({
  declarations: [
    AppComponent,
    BookComponentComponent,
    NavbarComponentComponent,
    HomeComponent,
    AuthorComponent,
    GenreComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BookstoreService],
  bootstrap: [AppComponent]
})
export class AppModule { }
