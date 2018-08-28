import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ReimbursementComponent } from './components/reimbursement/reimbursement.component';
import { NewEmployeeComponent } from './components/new-employee/new-employee.component';
import { LandingComponent } from './components/landing/landing.component';

export const routes: Routes = [
    { path: '', redirectTo: '/home', pathMatch: 'full' },
    // { path: 'home', component: HomeComponent },
    { path: 'home', component: HomeComponent },
    { path: 'reimbursement', component: ReimbursementComponent },
    { path: 'login', component: LoginComponent },
    // {path: '', component: LoginComponent},
      {path: 'logged',component: LandingComponent}, 
      {path: 'register',component: NewEmployeeComponent}
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})

export class AppRoutingModule {}