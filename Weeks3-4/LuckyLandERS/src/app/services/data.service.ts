import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {LoginComponent} from '../login/login.component';
import { Login} from '../login';
import {User} from '../model/user';
import { Observable } from 'rxjs';



interface myData {
  obj: Object;
}

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { 

    
   }

   public getUsers(username:string , password: string){
     return this.http.get("http://localhost:8081/ERS-Application/login",{params: {username, password}});
   }

    postLogin() {
      
      //return this.http.post<User[]>("http://localhost:8081/ERS-Application/login")
      
      
    }
  }

