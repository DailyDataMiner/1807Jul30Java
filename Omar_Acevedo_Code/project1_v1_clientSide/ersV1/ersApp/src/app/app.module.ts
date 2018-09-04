import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormControl, FormBuilder, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
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
import { UserService } from './services/user.service';
import { ListUserComponent } from './components/list-user/list-user.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { SearchStatusPipe } from './pipes/search-status.pipe';
import { UserComponent } from './components/user/user.component';
import { SignUpComponent } from './components/user/sign-up/sign-up.component';
import { SignInComponent } from './components/user/sign-in/sign-in.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ReimbursementsComponent,
    LoginauthComponent,
    ReimbManagerComponent,
    SearchEmployeePipe,
    ListUserComponent,
    AddUserComponent,
    SearchStatusPipe,
    SignUpComponent,
    UserComponent,
    SignInComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
    // FormBuilder
    // FormGroup
  ],
  providers: [
    ReimbursementService,
    LoginauthService,
    FormBuilder,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
