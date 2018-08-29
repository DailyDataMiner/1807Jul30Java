import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
//import { HttpClientModule } from '@angular/common/http'; 
import { HttpModule } from '@angular/http';
import {enableProdMode} from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';

import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { ReimbursementService} from './services/reimbursement.service';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { NewEmployeeComponent } from './components/new-employee/new-employee.component';
import { LogoutComponent } from './components/logout/logout.component';

import { LandingComponent } from './components/landing/landing.component'
import { EmployeeService } from './services/employee.service';
import { HttpeeService } from './services/httpee.service';
// import { RouterModule, Routes} from '@angular/router';
// import { EmployeeService } from './services/employee.service';

enableProdMode();

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,  
    NavbarComponent,
    HomeComponent,
    ReimbursementComponent,
    NewEmployeeComponent,
    LogoutComponent,
    LandingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule, // Gives us ngModel
    AppRoutingModule
  ],
  providers: [LoginService,
  ReimbursementService, 
  EmployeeService,
  HttpeeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
