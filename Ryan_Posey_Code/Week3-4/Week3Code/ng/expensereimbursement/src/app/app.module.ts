import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AuthService } from './services/auth.service';
import { AppRoutingModule } from './app-routing.module';
import { EmployeeComponent } from './components/employee/employee.component';
import { ManagerComponent } from './components/manager/manager.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeComponent,
    ManagerComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
