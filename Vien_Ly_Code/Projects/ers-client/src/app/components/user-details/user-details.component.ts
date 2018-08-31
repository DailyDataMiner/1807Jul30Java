import { Component, OnInit, ViewChild, Output, EventEmitter} from '@angular/core';
import { User } from '../../models/user.model';
import { NgbActiveModal, NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpService } from '../../services/http/http.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  user: User;

  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  @Output()
  close = new EventEmitter();


  constructor(private modalService: NgbModal, private httpService: HttpService) { }

  ngOnInit() {
  }

  open(user: User): void {
    this.httpService.getUser(user.id).subscribe(u => {
      this.user = u;
      this.modal = this.modalService.open(this.content, { centered: true });
    });
  }

  deleteUser(): void {
    this.httpService.deleteUser(this.user.id).subscribe(u => {
      console.log(u.username + ' deleted');
      this.modal.close();
      this.close.emit();
    });
  }
}
