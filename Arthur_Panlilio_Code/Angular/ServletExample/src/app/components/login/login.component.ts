import { Component, OnInit } from '@angular/core';
import { ServService } from '../../service/serv.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;
  servletData: any;

  constructor(private ser: ServService) { }

  ngOnInit() {
  }


  login(){
    console.log(`value of username: ${this.username}`);
    console.log(`value of password: ${this.password}`);

    this.ser.login(this.username, this.password).subscribe(
      function(data){
        this.servletData = data;
      }
    );
  }

}
