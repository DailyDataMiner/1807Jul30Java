import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    /* Declaations array - holds chasses that are related to view.
    There can be three types of classes listed here:
     components, directives, and pipes */
    AppComponent,
    HomeComponent,
    NavbarComponent
  ],
  /* We can also have exports:[]
  Exports are classes that need to be accessible to the components
  of other modules. However, we're not making a multi-modular app at the 
  moment, so we do not need anyting in teh exports array */
  imports: [
    /* 
    Imports are modules whose classes are needed by classes within this 
    current module */
    BrowserModule
  ],
  /* Providers are services that use the @injectible keyword */
  providers: [],
  /* Bootstrap refers to the root component which is the main view of the 
  angular app */
  bootstrap: [AppComponent]
})
export class AppModule { }
