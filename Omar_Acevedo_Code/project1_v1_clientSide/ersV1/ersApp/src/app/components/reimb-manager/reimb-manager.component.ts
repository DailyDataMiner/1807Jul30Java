import { Component, OnInit } from '@angular/core';
import { ReimbursementService } from '../../services/reimbursement.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reimb-manager',
  templateUrl: './reimb-manager.component.html',
  styleUrls: ['./reimb-manager.component.css']
})
export class ReimbManagerComponent implements OnInit {

  public loggedUserId: number;
  public loggedUserName: string;
  private sub: any;

  constructor(private rService: ReimbursementService, private route: ActivatedRoute) { }

  ngOnInit() {

    this.sub = this.route.params.subscribe(
      params => {
                  this.loggedUserId = +params['loggedUserId']; // (+) converts string 'loggedUserId' to a number
                  this.loggedUserName = params['loggedUserName'];
                  // In a real app: dispatch action to load the details here.
      });
   
    console.log("loggedUserId -> " + this.loggedUserId);
    console.log("loggedUserName -> " + this.loggedUserName);

  }

}
