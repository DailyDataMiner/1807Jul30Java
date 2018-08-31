import { Component, OnInit } from '@angular/core';
import { LoginauthService } from '../../services/loginauth/loginauth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  currentClass = "";

  constructor(private loginAuthSrv: LoginauthService) { }

  ngOnInit() {
    this.currentClass = "active";
    
  }

}
