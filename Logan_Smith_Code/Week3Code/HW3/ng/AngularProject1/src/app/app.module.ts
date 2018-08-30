import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { LoginComponent } from './components/login-page/login-page.component';
import { LoginService } from './services/login.service';
import { NavbarComponent } from './components/navbar/navbar.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { UserreimbService } from './services/userreimb.service';
import { DataService } from './services/data.service';
import { EdituserpageComponent } from './components/edituserpage/edituserpage.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { ViewUsersPageComponent } from './components/view-users-page/view-users-page.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    UserpageComponent,
    EdituserpageComponent,
    AdminpageComponent,
    ViewUsersPageComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    LoginService, 
    UserreimbService,
    DataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
