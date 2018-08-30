import { LoginComponent } from './component/login/login.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserinfoComponent } from './component/userinfo/userinfo.component';
import { CreatenewuserComponent } from './component/createnewuser/createnewuser.component';
import { CreatenewrequestComponent } from './component/createnewrequest/createnewrequest.component';
import { GetreimbursementsComponent } from './component/getreimbursements/getreimbursements.component';
import { GetreimbursementsbyuserComponent } from './component/getreimbursementsbyuser/getreimbursementsbyuser.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'userinfo', component: UserinfoComponent },
    { path: 'createnewuser', component: CreatenewuserComponent },
    { path: 'createnewrequest', component: CreatenewrequestComponent},
    { path: 'getreimbursements', component: GetreimbursementsComponent },
    { path: 'getreimbursementsbyuser', component: GetreimbursementsbyuserComponent }
];

@NgModule({
    imports: [ RouterModule.forRoot(routes)],
    exports: [ RouterModule ]
})
export class AppRoutingModule {}
