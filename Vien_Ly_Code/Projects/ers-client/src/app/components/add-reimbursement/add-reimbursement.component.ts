import { Component, OnInit, ViewChild, Output, EventEmitter } from '@angular/core';
import { NgbActiveModal, NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Reimbursement } from '../../models/reimbursement.model';
import { HttpService } from '../../services/http/http.service';
import { ReimbursementType } from '../../models/reimbursement-type.enum';
@Component({
  selector: 'app-add-reimbursement',
  templateUrl: './add-reimbursement.component.html',
  styleUrls: ['./add-reimbursement.component.css']
})
export class AddReimbursementComponent implements OnInit {

  reimbursement: Reimbursement;

  @ViewChild('content')
  content: NgbActiveModal;
  modal: NgbModalRef;

  @Output()
  close = new EventEmitter<Reimbursement>();

  type = 'lodging';
  amount = 0;
  description = '';

  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  open(): void {
    this.modal = this.modalService.open(this.content, {centered: true});
  }

  closeModal(): void {
    const type = this.parse(this.type);
    const reimbursement: Reimbursement = {
      type: type,
      amount: this.amount,
      description: this.description,

      // set by servlet
      id: 0,
      submittedTime: null,
      authorId: 0,
      status: null,
    };

    // Reset to default values.
    this.type = 'lodging';
    this.amount = 0;
    this.description = '';

    this.modal.close();
    this.close.emit(reimbursement);
  }

  parse(input: string): ReimbursementType | null {
    switch (input.toUpperCase()) {
      case 'LODGING':
        return ReimbursementType.Lodging;
      case 'TRAVEL':
        return ReimbursementType.Travel;
      case 'FOOD':
        return ReimbursementType.Food;
      case 'OTHER':
        return ReimbursementType.Other;
      default:
        return null;
    }
  }

}
