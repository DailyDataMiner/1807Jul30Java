import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from '../components/login/login.component';
import { HomeComponent } from '../components/home/home.component';
import { UserComponent } from '../components/user/user.component';
import { ReimbursementsComponent } from '../components/reimbursements/reimbursements.component';
import { AdminComponent } from '../components/admin/admin.component';
import { AccessGuard } from '../services/access-guard.service';
import { AdminUsersComponent } from '../components/admin-users/admin-users.component';
import { AdminReimbursementsComponent } from '../components/admin-reimbursements/admin-reimbursements.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  {
    path: 'home',
    component: HomeComponent,
    data: { requiresLogin: true },
    canActivate: [AccessGuard],
    children: [
      {
        path: 'user', component: UserComponent
      },
      {
        path: 'reimbursements', component: ReimbursementsComponent
      },
      {
        path: 'admin',
        component: AdminComponent,
        data: { requiresLogin: true , requiresAdmin: true},
        canActivate: [AccessGuard],
        children: [
          { path: 'users', component: AdminUsersComponent },
          { path: 'reimbursements', component: AdminReimbursementsComponent },
          { path: '', pathMatch: 'full', redirectTo: '/home/admin/reimbursements' }
        ]
      },
      { path: '', pathMatch: 'full', redirectTo: '/home/reimbursements' }
    ]
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule { }
