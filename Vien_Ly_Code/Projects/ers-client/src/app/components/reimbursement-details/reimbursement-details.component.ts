import { Component, OnInit, ViewChild, Output, EventEmitter, Input } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement.model';
import { NgbModal, NgbActiveModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ReimbursementDetails } from '../../models/reimbursement-details.model';
import { HttpService } from '../../services/http/http.service';
import { User } from '../../models/user.model';
import { AuthService } from '../../services/auth/auth.service';
import { ReimbursementResolveData } from '../../models/reimbursement-resolve-data.model';
import { ReimbursementStatus } from '../../models/reimbursement-status.enum';

@Component({
  selector: 'app-reimbursement-details',
  templateUrl: './reimbursement-details.component.html',
  styleUrls: ['./reimbursement-details.component.css']
})
export class ReimbursementDetailsComponent implements OnInit {

  user: User;

  resolveData: ReimbursementResolveData;

  reimbursementDetails: ReimbursementDetails;

  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  @Input()
  isAdminPanel = false;

  @Output()
  close = new EventEmitter<ReimbursementResolveData>();

  constructor(private authService: AuthService, private modalService: NgbModal, private httpService: HttpService) { }

  ngOnInit() {
    this.resolveData = new ReimbursementResolveData();
    this.authService.getCurrentUser().subscribe(user => {
      this.user = user;
    });
  }

  open(ri: Reimbursement): void {
    this.httpService.getReimbursementDetails(ri.id).subscribe(details => {
      this.reimbursementDetails = details;
      this.resolveData.id = this.reimbursementDetails.id;
      this.modal = this.modalService.open(this.content, { centered: true });
    });
  }

  closeModal(isApproved: string): void {
    this.modal.close();
    this.resolveData.status = this.parse(isApproved);
    this.close.emit(this.resolveData);
    this.resolveData = new ReimbursementResolveData();
  }

  parse(input: string): ReimbursementStatus | null {
    switch (input.toUpperCase()) {
      case 'APPROVED':
        return ReimbursementStatus.Approved;
      case 'DENIED':
        return ReimbursementStatus.Denied;
      default:
        return null;
    }
  }
}
