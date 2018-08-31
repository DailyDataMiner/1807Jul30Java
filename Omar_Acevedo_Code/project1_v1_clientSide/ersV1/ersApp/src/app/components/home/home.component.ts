import { Component, OnInit } from '@angular/core';
// import { LoginauthComponent } from '../loginauth/loginauth.component';
import { Router } from '../../../../node_modules/@angular/router';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { AppComponent } from '../../app.component';
import { LoginauthService } from '../../services/loginauth/loginauth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  private loggedUserId: number;
  private loggedUserName: string;
  private username: string;
  // loggedUserId: number;
  private sub: any;
  // private _loginauthComponent: LoginauthComponent;

  // constructor(private loginauthComponent: LoginauthComponent) { }
  constructor(
    // private service: HeroService,
    private route: ActivatedRoute,
    private appComponent: AppComponent,
    private loginAuthSrv: LoginauthService
  ) {}

  ngOnInit() {

    // this.username = this.loginauthComponent.loggedUserName;

    this.sub = this.route.params.subscribe(
      params => {
                  this.loggedUserId = +params['loggedUserId']; // (+) converts string 'loggedUserId' to a number
                  this.loggedUserName = params['loggedUserName'];
                  // In a real app: dispatch action to load the details here.
      });
   
   console.log("loggedUserId -> " + this.loggedUserId);
   console.log("loggedUserName -> " + this.loggedUserName);

    // this.route.paramMap.pipe(
    //   switchMap((params: ParamMap) => {
    //     // (+) before `params.get()` turns the string into a number
    //     this.loggedUserId = +params.get('loggedUserId');

    //     console.log("loggedUserId -> " + this.loggedUserId);
    //     console.log("loggedUserName -> " + this.loggedUserName);

    //     // return this.service.getHeroes();
    //     return new Observable<any>();
    //   })
    // );

  }

}
