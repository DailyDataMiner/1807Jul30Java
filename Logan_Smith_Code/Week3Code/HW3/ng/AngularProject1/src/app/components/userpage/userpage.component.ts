import { Component, OnInit } from '@angular/core';
import { UserreimbService } from '../../services/userreimb.service';
import { DataService } from '../../services/data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-userpage',
  templateUrl: './userpage.component.html',
  styleUrls: ['./userpage.component.css']
})
export class UserpageComponent implements OnInit {

  constructor(private urService: UserreimbService, private data: DataService, private router: Router) { }

  ngOnInit() {
    if (this.data.user == null) {
      this.router.navigate(['/']);
    }
    else {
    this.getReimbs();
    }
  }
  toAddToggle:boolean = false;

  iamount:number;
  itype:string;
  idesc:string;

  getReimbs() {
    this.urService.getReimbsbyUserID(this.data.user.id).subscribe(
      t => {
        if(t != null) {
          this.data.reimbs = [];
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
          console.error("Error: Unable to load books.");
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
  toggleAdd() {
    this.toAddToggle=!this.toAddToggle;
  }
  addReimb() {

    this.urService.postReimb(this.iamount, this.itype, this.idesc).subscribe(
      d => {
        console.log(d);
        if (d != null) {
        this.iamount = 0;
        this.itype = "";
        this.idesc = "";
        this.toggleAdd();
        this.getReimbs();
        }
      }
    );
  }

  logout() {
    this.data.clear();
    this.router.navigate(['/loginPage']);
  }

}
