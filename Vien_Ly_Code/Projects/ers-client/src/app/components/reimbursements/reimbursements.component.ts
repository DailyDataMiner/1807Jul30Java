import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../../services/data/data.service';
import { AuthService } from '../../services/auth/auth.service';
import { HttpService } from '../../services/http/http.service';
import { Reimbursement } from '../../models/reimbursement.model';
import { ReimbursementDetailsComponent } from '../reimbursement-details/reimbursement-details.component';
import { AddReimbursementComponent } from '../add-reimbursement/add-reimbursement.component';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { NgbActiveModal, NgbModalRef, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-reimbursements',
  templateUrl: './reimbursements.component.html',
  styleUrls: ['./reimbursements.component.css']
})
export class ReimbursementsComponent implements OnInit {

  reimbursements: Reimbursement[];
  selectedOption: string;

  @ViewChild(ReimbursementDetailsComponent)
  detailsModal: ReimbursementDetailsComponent;

  @ViewChild(AddReimbursementComponent)
  addReimbursementModal: AddReimbursementComponent;

  constructor(
    private authService: AuthService,
    private dataService: DataService,
    private httpService: HttpService,
  ) {
    this.selectedOption = 'ALL';
  }

  ngOnInit() {
    this.loadMyReimbursements().subscribe(reimbursements => {
      this.reimbursements = this.dataService.reimbursements = reimbursements;
    });
  }

  loadMyReimbursements(): Observable<Reimbursement[]> {
    return this.authService.getCurrentUser().pipe(
      switchMap(user => this.httpService.getReimbursementsByAuthor(user.username)));
  }

  openDetailsModal(ri: Reimbursement) {
    this.detailsModal.open(ri);
  }

  openAddReimbursementModal() {
    this.addReimbursementModal.open();
  }

  addReimbursement(ri: Reimbursement) {
    this.httpService.postReimbursement(ri).subscribe(data => {
      console.log('successfully posted ' + ri);
      this.loadMyReimbursements().subscribe(reimbursements => {
        this.reimbursements = this.dataService.reimbursements = reimbursements;
      });
    });
  }

  chooseStatusOption(option: string) {
    this.selectedOption = option;
    this.loadMyReimbursements().subscribe(reimbursements => {
      this.reimbursements = this.dataService.reimbursements = reimbursements;
      if (option === 'ALL') {
        return;
      }
      this.reimbursements = this.reimbursements.filter(ri => ri.status === option);
    });
  }

}
