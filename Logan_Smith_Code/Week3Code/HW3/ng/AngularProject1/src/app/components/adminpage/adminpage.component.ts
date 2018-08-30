import { Component, OnInit } from '@angular/core';
import { DataService } from '../../services/data.service';
import { Router } from '@angular/router';
import { AdminreimbService } from '../../services/adminreimb.service';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {

  constructor(private adService: AdminreimbService, private data: DataService, private router: Router) { }

  ngOnInit() {
    if (this.data.user == null) {
      this.router.navigate(['/']);
    }
    else {
    this.getReimbs();
    }
  }

  getReimbs() {
    this.adService.getReimbs().subscribe(
      t => {
        if(t != null) {
          this.data.reimbs = [];
          console.log(t);
          for (let a = 0; a < t.length; a++) {
            let servletid = parseInt(t[a].reimbID);
            let servletamount = parseFloat(t[a].reimbAmount);
            let servletsubmitted = t[a].reimbSubmitted && new Date(t[a].reimbSubmitted);
            let servletresolved = t[a].reimbResolved && new Date(t[a].reimbResolved);
            let servletreimbdesc = t[a].reimbDesc;
            let servletreimbreciept = t[a].reimbReciept;
            let servletreimbauthor = t[a].reimbAuthor && t[a].reimbAuthor.username;
            let servletreimbresolver = t[a].reimbResolver && t[a].reimbResolver.username;
            let servletstatus = t[a].reimbStatus.reimbStatusName;
            let servlettype = t[a].reimbType.reimbTypeName;
            this.data.insertReimb([servletid, servletamount, servletsubmitted, servletresolved, servletreimbdesc, servletreimbreciept, 
              servletreimbauthor, servletreimbresolver, servletstatus, servlettype]);
          }
          console.log(t[0]);
          console.log(t.length);
        }
        else {
          console.error("Error: Unable to load users.");
        }
      }
    )
  }
  editUser() {
    this.router.navigate(['/edituser']);
  }
  setCurrentReimb(i: number) {
    this.data.setCurrentReimb(i);
  }
  approveReimb() {
    this.adService.approveReimb().subscribe(
      t => {
        console.log(t);
        this.getReimbs();
      }
    )
  }
  denyReimb() {
    this.adService.denyReimb().subscribe(
      t => {
        console.log(t);
        this.getReimbs();
      }
    )
  }
  viewUsers() {
    this.router.navigate(['/viewUsers']);
  }

}
