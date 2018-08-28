import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { AuthService } from './services/auth.service';
import { GetusersComponent } from './component/getusers/getusers.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GetusersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule // Gives us ngModel
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }