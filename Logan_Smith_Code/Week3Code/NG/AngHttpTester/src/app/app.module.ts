import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { SendoffComponent } from './components/sendoff/sendoff.component';
import { OffserviceService } from './services/offservice.service';
//import { OffService } from 'offservice.service';

@NgModule({
  declarations: [
    AppComponent,
    SendoffComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule // Gives us ngModel
  ],
  providers: [OffserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
