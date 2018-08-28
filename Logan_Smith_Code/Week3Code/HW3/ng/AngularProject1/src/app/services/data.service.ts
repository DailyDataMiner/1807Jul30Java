import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { Reimb } from '../models/reimb.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  user: User;
  reimbs:Reimb[]=[];
  constructor(private http: HttpClient) { }
  
  setUser(toInput: [number, string, string, string, string, string]) {
    this.user = new User(toInput);
  }
  getUser():User {
    return this.user;
  }
  insertReimb(toInput: [number, number, Date, Date, string, string, string, string, string, string]) {
    this.reimbs.push(new Reimb(toInput));
  }

  userUpdateUser(username: string, firstname: string, lastname: string, email: string) {
    this.user.username = username;
    this.user.firstname = firstname;
    this.user.lastname = lastname;
    this.user.email = email;
    return this.http.post<any>('http://localhost:8084/LSProject1/userupdateuser.ng', 
    {userID: this.user.id, username: this.user.username, firstname: this.user.firstname, lastname: this.user.lastname, email: this.user.email});
  }
}
