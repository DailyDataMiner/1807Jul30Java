import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { AddReimbComponent } from './add-reimb/add-reimb.component'
import { ReimbursementsComponent } from './reimbursements/reimbursements.component';
import { EmployeeComponent } from './employee/employee.component';
// import { BookstoreComponent } from './components/bookstore/bookstore.component';
// import { BooksComponent } from './components/books/books.component';
// import { GenresComponent } from './components/genres/genres.component';
// import { AuthorsComponent } from './components/authors/authors.component';

/*
ROUTES!
Routing is the mechanism used to navigate between views or pages of your
Angular app. Much like a browser manages displaying different plages based
on links clicked, the Angular Router is used to manage such navigation
in your application. It is a module, RouterModule, that defines a service
and special directives and components for use
*/

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'logout', component: LoginComponent },
    { path: 'home', component: HomeComponent },
    { path: 'login', component: LoginComponent },
    { path: 'reimbursements', component: ReimbursementsComponent },
    { path: 'add_reimb', component: AddReimbComponent},
    { path: 'employee', component: EmployeeComponent}
    // { path: 'manager', component: BookstoreComponent },
    // { path: 'books', component: BooksComponent },
    // { path: 'genres', component: GenresComponent },
    // { path: 'authors', component: AuthorsComponent }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}