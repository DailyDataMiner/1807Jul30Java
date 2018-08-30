import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { UserpageComponent } from '../app/components/userpage/userpage.component';
import { LoginComponent } from '../app/components/login-page/login-page.component'
import { NavbarComponent } from '../app/components/navbar/navbar.component'
import { EdituserpageComponent } from './components/edituserpage/edituserpage.component';
import { AdminpageComponent } from './components/adminpage/adminpage.component';
import { ViewUsersPageComponent } from '../app/components/view-users-page/view-users-page.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/loginPage', pathMatch: 'full' },
  { path: 'userPage', component:UserpageComponent},
  { path: 'loginPage', component:LoginComponent},
  { path: 'navbar', component:NavbarComponent},
  { path: 'edituser', component:EdituserpageComponent},
  { path: 'adminPage', component:AdminpageComponent},
  { path: 'viewUsers', component:ViewUsersPageComponent }
 ];

@NgModule({
  imports: [ RouterModule.forRoot(appRoutes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

