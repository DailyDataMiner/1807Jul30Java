import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../../models/user.model';
import { HttpService } from '../../services/http/http.service';
import { DataService } from '../../services/data/data.service';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth/auth.service';
import { UserData } from '../../models/user-data.model';
import { NgbModal, NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  user: User;
  pendingCount: number;
  edit: boolean;
  editData: UserData;

  newPassword: string;
  newPasswordCheck: string;
  changePasswordData: UserData; // for making the put call

  @ViewChild('content')
  content: NgbActiveModal;
  changePasswordModal: NgbModalRef;

  constructor(
    private authService: AuthService,
    private httpService: HttpService,
    private router: Router,
    private modalService: NgbModal
  ) { }

  ngOnInit() {
    this.edit = false;

    this.authService.getCurrentUser().subscribe(user => {
      this.user = user;
      this.pendingCount = 0;
      this.editData = new UserData();
      this.editData.firstName = this.user.firstName;
      this.editData.lastName = this.user.lastName;
      this.editData.email = this.user.email;
      this.changePasswordData = new UserData();

      this.httpService.getReimbursementsByAuthor(user.username).subscribe(reimbursements => {
        if (reimbursements) {
          this.pendingCount = reimbursements.filter(ri => ri.status === 'PENDING').length;
        }
      });
    });
  }

  viewReimbursements(): void {
    this.router.navigate(['/home/reimbursements']);
  }

  toggleEdit(): void {
    this.edit = !this.edit;
  }

  updateUserInfo(): void {
    this.authService.getCurrentUser().subscribe(user => {
      this.httpService.editUser(this.editData).subscribe(u => {
        console.log('successfully updated');
        console.log(u);
        this.user = u;
        this.editData = new UserData();
        this.editData.firstName = this.user.firstName;
        this.editData.lastName = this.user.lastName;
        this.editData.email = this.user.email;
        this.toggleEdit();
      });
    });
  }

  openChangePasswordModal(): void {
    this.changePasswordModal = this.modalService.open(this.content, { centered: true });
  }

  closeChangePasswordModal(): void {
    if (this.newPassword === this.newPasswordCheck) {
      this.changePasswordData.password = this.newPassword;
      this.authService.getCurrentUser().subscribe(user => {
        this.httpService.editUser(this.changePasswordData).subscribe(u => {
          this.user = u;
          this.changePasswordData = new UserData();
          this.changePasswordModal.close();
        });
      });
    }
  }
}
