import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormControl, FormBuilder, Validators } from '@angular/forms';

import { AppComponent } from './app.component';
import { SearchEmployeePipe } from './pipes/search-employee.pipe';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AppRoutingModule } from './app-routing.module';
import { HomeComponent } from './components/home/home.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { ReimbursementService } from './services/reimbursement.service';
import { HttpClientModule } from '../../node_modules/@angular/common/http';
import { LoginauthComponent } from './components/loginauth/loginauth.component';
import { LoginauthService } from './services/loginauth/loginauth.service';
import { ReimbManagerComponent } from './components/reimb-manager/reimb-manager.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ReimbursementsComponent,
    LoginauthComponent,
    ReimbManagerComponent,
    SearchEmployeePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule//,
    // FormBuilder
    // FormGroup
  ],
  providers: [
    ReimbursementService,
    LoginauthService,
    FormBuilder
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
