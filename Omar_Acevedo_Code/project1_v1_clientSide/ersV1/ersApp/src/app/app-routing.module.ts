import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { LoginauthComponent } from './components/loginauth/loginauth.component';
import { ReimbManagerComponent } from './components/reimb-manager/reimb-manager.component';

const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginauthComponent },
  { path: 'home', component: HomeComponent },
  { path: 'reimbursements', component: ReimbursementsComponent },
  { path: 'reimbursementManager', component: ReimbManagerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // forChild changed to forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }
