import { Component, OnInit, ViewChild } from '@angular/core';
import { Reimbursement } from '../../models/reimbursement.model';
import { AuthService } from '../../services/auth/auth.service';
import { HttpService } from '../../services/http/http.service';
import { ReimbursementDetailsComponent } from '../reimbursement-details/reimbursement-details.component';
import { User } from '../../models/user.model';
import { ReimbursementResolveData } from '../../models/reimbursement-resolve-data.model';
import { DataService } from '../../services/data/data.service';

@Component({
  selector: 'app-admin-reimbursements',
  templateUrl: './admin-reimbursements.component.html',
  styleUrls: ['./admin-reimbursements.component.css']
})
export class AdminReimbursementsComponent implements OnInit {

  user: User;
  reimbursements: Reimbursement[];

  selectedOption: string;

  @ViewChild(ReimbursementDetailsComponent)
  detailsModal: ReimbursementDetailsComponent;

  constructor(private dataService: DataService, private authService: AuthService, private httpService: HttpService) { }

  ngOnInit() {
    this.authService.getCurrentUser().subscribe(user => {
      this.user = user;
    });
    this.loadAllReimbursements();
  }

  loadAllReimbursements() {
    this.httpService.getReimbursements().subscribe(reimbursements => {
      this.reimbursements = reimbursements;
    });
  }

  openDetailsModal(ri: Reimbursement) {
    this.detailsModal.open(ri);
  }

  resolve(resolveData: ReimbursementResolveData) {
    this.httpService.resolveReimbursement(resolveData).subscribe(_ => {
      this.loadAllReimbursements();
    });
  }

  chooseStatusOption(option: string) {
    this.selectedOption = option;
    this.httpService.getReimbursements().subscribe(reimbursements => {
      this.reimbursements = reimbursements;
      if (option === 'ALL') {
        return;
      }
      this.reimbursements = this.reimbursements.filter(ri => ri.status === option);
    });
  }
}
