import { Component, OnInit, ViewChild, Output, EventEmitter } from '@angular/core';
import { User } from '../../models/user.model';
import { NgbActiveModal, NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UserRole } from '../../models/user-role.enum';
import { UserData } from '../../models/user-data.model';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  newUserData: UserData;
  newUserRole: UserRole;

  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  @Output()
  close = new EventEmitter<UserData>();

  constructor(private modalService: NgbModal) {
    this.newUserData = new UserData();
  }

  ngOnInit() {
  }

  open(): void {
    this.modal = this.modalService.open(this.content, { centered: true });
  }

  closeModal(): void {
    const role = this.parse(this.newUserRole);
    this.newUserData.role = role;
    const submitData = this.newUserData;
    this.newUserData = new UserData();
    this.newUserRole = null;
    this.modal.close();
    this.close.emit(submitData);
  }

  parse(input: string): UserRole | null {
    switch (input.toUpperCase()) {
      case 'EMPLOYEE':
        return UserRole.Employee;
      case 'MANAGER':
        return UserRole.Manager;
      default:
        return null;
    }
  }

}
