import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AuthService } from './services/auth.service';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { ReimbursementsComponent } from './reimbursements/reimbursements.component';
import { ReimbService } from './services/reimb.service';
import { AppRoutingModule } from './app-routing.module';
import { EmployeeComponent } from './employee/employee.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    ReimbursementsComponent,
    EmployeeComponent
  ],
  imports: [
    BrowserModule, 
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [AuthService, ReimbService],
  bootstrap: [AppComponent]
})
export class AppModule { }
