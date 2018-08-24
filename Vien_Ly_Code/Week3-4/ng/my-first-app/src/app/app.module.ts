import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SquarerootPipe } from './pipes/squareroot.pipe';
import { LoginComponent } from './components/login/login.component';

@NgModule({
  declarations: [
    /*
    classes that are related to views
      components
      directives
      pipe
    */
    AppComponent,
    HomeComponent,
    NavbarComponent,
    SquarerootPipe,
    LoginComponent,
  ],
  exports: [
    /*
    classes that need to be accessible to components of other modules
    However, we're not making multi-modular app at the moment
    */
  ],
  imports: [
    /*
    modules whose classes are needed within this current module
    */
    BrowserModule,
    FormsModule
  ],
  providers: [
    /*
    services (@Injectable)
    */
  ],
  /*
  refers to root component which is the main view of the angular app
  */
  bootstrap: [AppComponent]
})
export class AppModule { }
