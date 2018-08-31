import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../models/user.model';
import { Reimbursement } from '../../models/reimbursement.model';
import { HttpService } from '../http/http.service';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  user: User; // only set by auth service
  users: User[];
  reimbursements: Reimbursement[];

  constructor(private httpService: HttpService) {
  }

}
