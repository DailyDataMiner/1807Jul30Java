import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';

@NgModule({
  declarations: [
    /*Delcarations array - holds classes that are related to view. There can be three types of
    classes listed here: components, directives, and pipes
    */
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SquarerootPipe
  ],
  /*
exports:[]
  -classes that need to be accessible to the components
  of other modules. HOwever, we're not making a multi-modular
  app at the moment, so we do not need anying the exports array.
  */
  imports: [
    /*Modules whose classes are needed by classes within this current module

    */
    BrowserModule
  ],
  providers: [], //providers - services(@Injectable)
  //Refers to the root component which is the main view of the angular app
  bootstrap: [AppComponent]
})
export class AppModule { }
