import { Component, OnInit } from '@angular/core';
import {Login } from '../login';
import { DataService} from '../services/data.service';
import { User} from '../model/user';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;
  private username: string;
  private password: string;
  
  constructor(private data: DataService) { }

  login = new Login("","")

  submitted = false;

  onSubmit(){
    this.submitted = true;
    
     
    
    
  }

  onLogin(){
    this.data.getUsers(this.username, this.password).subscribe();
  }

  ngOnInit() {
  }

}
