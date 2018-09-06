import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule} from '@angular/router';

import {HomeComponent} from '../home/home.component';
import {LoginComponent} from '../login/login.component';
import { ReimbursementComponent } from '../reimbursement/reimbursement.component';

const appRoutes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'reimbursement', component: ReimbursementComponent},
  {path: '**', component: HomeComponent}


]


@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes),


  ],
  declarations: []
})
export class RoutingModule { }
