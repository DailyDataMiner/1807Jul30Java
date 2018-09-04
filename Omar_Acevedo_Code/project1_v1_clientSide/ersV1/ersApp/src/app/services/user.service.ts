import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Response } from '@angular/http';
import { Observable } from 'rxjs';
// import 'rxjs/add/operator/map';

import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  readonly baseUrl: string = "http://localhost:8080/project1_v1/users";
  constructor(private http: HttpClient) { }
  
  registerUser(user: User) {
    const body: User = {
      username: user.username,
      password: user.password,
      email:  user.email,
      firstname: user.firstname,
      lastname: user.lastname,
      user_id: user.user_id
    };
    return this.http.post(this.baseUrl, body);
  }

  userAuthentication(username, password) {
    var data = "username=" + username + "&password=" + password + "&grant_type=password";
    var reqHeader = new HttpHeaders({ 'Content-Type': 'application/x-www-urlencoded','No-Auth':'True' });
    return this.http.post(this.baseUrl + '/token', data, { headers: reqHeader });
  }

  getUsers() {
    return this.http.get<User[]>(this.baseUrl);
  }

  // getUserById(id: number) {
  //   return this.http.get<User>(this.baseUrl + '/' + id);
  // }

  createUser(user: User) {
    // {id: null, username: "", email: "", firstName: "", lastName: ""}
    // const body: User = {
    //   username: user.username,
    //   password: user.password,
    //   email:  user.email,
    //   firstname: user.firstname,
    //   lastname: user.lastname,
    //   user_id: user.user_id
    // };
    console.log(user);
    return this.http.post(this.baseUrl, user);
  }

  // updateUser(user: User) {
  //   return this.http.put(this.baseUrl + '/' + user.id, user);
  // }

  // deleteUser(id: number) {
  //   return this.http.delete(this.baseUrl + '/' + id);
  // }

}
