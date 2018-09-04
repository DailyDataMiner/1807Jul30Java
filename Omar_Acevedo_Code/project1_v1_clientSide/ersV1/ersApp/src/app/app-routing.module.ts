import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';
import { LoginauthComponent } from './components/loginauth/loginauth.component';
import { ReimbManagerComponent } from './components/reimb-manager/reimb-manager.component';
import { ListUserComponent } from './components/list-user/list-user.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import { SignUpComponent } from './components/user/sign-up/sign-up.component';
import { UserComponent } from './components/user/user.component';
import { SignInComponent } from './components/user/sign-in/sign-in.component';

const routes: Routes = [
  // { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  // { path: 'login', component: LoginauthComponent },
  // { path: 'signup', component: SignUpComponent },
  { path: 'home', component: HomeComponent },
  {
    path: 'signup', component: UserComponent,
    children: [{ path: '', component: SignUpComponent }]
  },
  {
    path: 'signin', component: UserComponent,
    children: [{ path: '', component: SignInComponent }]
  },
  { path: 'reimbursements', component: ReimbursementsComponent },
  { path: 'reimbursementManager', component: ReimbManagerComponent },
  { path: 'user', component: UserComponent },
  { path: 'listusers', component: ListUserComponent },
  { path: 'adduser', component: AddUserComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // forChild changed to forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }
