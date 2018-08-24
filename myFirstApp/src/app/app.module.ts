import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    /*Declarations array - holds classes that are related to view. Thre can be three types of
    rclasses listed here: components, directives and pipes.
    */
    AppComponent,
    NavbarComponent,
    HomeComponent,

  ], /*
  exports []
  classes that need to be accessible to the componnets of other moduels. However, we're not making a m
  multimodule app at the moment, so we do not need anyting in the exports array
  */
  imports: [
    /*
    modules whos classes are needed by classes within this current module
    */
    BrowserModule
    /*
    Providers - services that use (@injectable)
     */
  ],
  providers: [],
  /*
  Refers to the root component which is the main view of the angular app
  */
  bootstrap: [AppComponent]
})
export class AppModule { }
