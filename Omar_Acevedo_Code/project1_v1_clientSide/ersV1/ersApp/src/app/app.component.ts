import { Component } from '@angular/core';
import { LoginauthComponent } from './components/loginauth/loginauth.component';
import { LoginauthService } from './services/loginauth/loginauth.service';
import { Router } from '../../node_modules/@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  title = 'ersApp';
  public isLoggedIn = true;

  // _loginauthComponent: LoginauthComponent;
  _loginauthService: LoginauthService;

  // constructor(private loginauthComponent: LoginauthComponent) { }
  constructor(private loginauthService: LoginauthService, private router: Router) {}

  ngOnInit() {
    // this.router.navigate(['/login', {}]);
  }

  canLogin() {
    return true;
    // return this._loginauthComponent.doLogin();
    
    // this._loginauthService.login().subscribe(

    // );

  }

}
