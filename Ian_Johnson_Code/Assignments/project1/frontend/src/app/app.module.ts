import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AppRoutingModule } from './app-routing/app-routing.module';
import { MainComponent } from './main/main.component';
import { ReimbursementsComponent } from './main/reimbursements/reimbursements.component';
import { ReimbursementViewComponent } from './main/reimbursements/reimbursement-view/reimbursement-view.component';
import { AccountComponent } from './main/account/account.component';
import { NavbarComponent } from './main/navbar/navbar.component';
import { TableComponent } from './util/table/table.component';
import { AddReimbursementModalComponent } from './main/reimbursements/add-reimbursement-modal/add-reimbursement-modal.component';
import { AdminReimbursementsComponent } from './main/admin-reimbursements/admin-reimbursements.component';
import { AdminUsersComponent } from './main/admin-users/admin-users.component';
import { AdminReimbursementViewComponent } from './main/admin-reimbursements/admin-reimbursement-view/admin-reimbursement-view.component';
import { ReimbursementDetailsModalComponent } from './main/reimbursements/reimbursement-details-modal/reimbursement-details-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainComponent,
    NavbarComponent,
    ReimbursementsComponent,
    ReimbursementViewComponent,
    AccountComponent,
    PageNotFoundComponent,
    TableComponent,
    AddReimbursementModalComponent,
    AdminReimbursementsComponent,
    AdminUsersComponent,
    AdminReimbursementViewComponent,
    ReimbursementDetailsModalComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
