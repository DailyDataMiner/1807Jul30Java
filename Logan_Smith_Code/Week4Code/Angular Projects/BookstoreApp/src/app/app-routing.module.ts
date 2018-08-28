import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { BookComponentComponent } from '../app/Components/book-component/book-component.component';
import { AuthorComponent } from '../app/Components/author/author.component';
import { GenreComponent } from '../app/Components/genre/genre.component';
import {  } from '../app/Components/home/home.component';

export const appRoutes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'books', component:BookComponentComponent},
  { path: 'authors', component:AuthorComponent},
  { path: 'genres', component:GenreComponent},
 ];

@NgModule({
  imports: [ RouterModule.forRoot(appRoutes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }