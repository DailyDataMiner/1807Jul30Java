import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ReimbursementsComponent } from './components/reimbursements/reimbursements.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'reimbursements', component: ReimbursementsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // forChild changed to forRoot
  exports: [RouterModule]
})
export class AppRoutingModule { }
