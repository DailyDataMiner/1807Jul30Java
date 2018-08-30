import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';



import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import { AuthService } from './services/auth.service';
import { GetusersComponent } from './component/getusers/getusers.component';
import { GetreimbursementsbyuserComponent } from './component/getreimbursementsbyuser/getreimbursementsbyuser.component';
import { GetreimbursementsComponent } from './component/getreimbursements/getreimbursements.component';
import { CreatenewuserComponent } from './component/createnewuser/createnewuser.component';
import { CreatenewrequestComponent } from './component/createnewrequest/createnewrequest.component';
import { UserinfoComponent } from './component/userinfo/userinfo.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    GetusersComponent,
    GetreimbursementsbyuserComponent,
    GetreimbursementsComponent,
    CreatenewuserComponent,
    CreatenewrequestComponent,
    UserinfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule, // Gives us ngModel
    AppRoutingModule
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
