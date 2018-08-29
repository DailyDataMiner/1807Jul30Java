import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  private servletUsername: string;
  private servletFirst: string;
  private servletLast: string;
  private servletEmail: string;

  servletData: any;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }