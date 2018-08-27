import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { AuthService } from './auth.service';
import { TableComponent } from './component/table/table.component';
import { AppRoutingModule } from './/app-routing.module';
import { Router } from '@angular/router';
import { EmployeeComponent } from './component/employee/employee.component'; 



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    TableComponent,
    EmployeeComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
     // Gives us ngModel
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }