import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './router/app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { AuthService } from './services/auth/auth.service';
import { DataService } from './services/data/data.service';
import { HomeComponent } from './components/home/home.component';
import { UserComponent } from './components/user/user.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { AdminComponent } from './components/admin/admin.component';
import { AccessGuard } from './services/access-guard.service';
import { ReimbursementDetailsComponent } from './components/reimbursement-details/reimbursement-details.component';
import { AddReimbursementComponent } from './components/add-reimbursement/add-reimbursement.component';
import { AdminUsersComponent } from './components/admin-users/admin-users.component';
import { AdminReimbursementsComponent } from './components/admin-reimbursements/admin-reimbursements.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';
import { AddUserComponent } from './components/add-user/add-user.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavbarComponent,
    HomeComponent,
    UserComponent,
    ReimbursementsComponent,
    AdminComponent,
    ReimbursementDetailsComponent,
    AddReimbursementComponent,
    AdminUsersComponent,
    AdminReimbursementsComponent,
    UserDetailsComponent,
    AddUserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [
    AuthService,
    DataService,
    AccessGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
