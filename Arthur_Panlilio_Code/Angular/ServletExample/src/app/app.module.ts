import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';

import { HttpClientModule }    from '@angular/common/http';
import { ServService } from './service/serv.service';

import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServService],
  bootstrap: [AppComponent]
})
export class AppModule { }
