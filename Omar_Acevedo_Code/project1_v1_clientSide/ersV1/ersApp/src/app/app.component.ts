import { Component } from '@angular/core';
import { LoginauthComponent } from './components/loginauth/loginauth.component';
import { LoginauthService } from './services/loginauth/loginauth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ersApp';

  // _loginauthComponent: LoginauthComponent;
  _loginauthService: LoginauthService;

  // constructor(private loginauthComponent: LoginauthComponent) { }
  constructor(private loginauthService: LoginauthService) {}

  ngOnInit() {
  }

  canLogin() {
    return true;
    // return this._loginauthComponent.doLogin();
    
    // this._loginauthService.login().subscribe(

    // );

  }

}
