import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  private fn: string;
  private rid: number;
  private ida: number;

  ngOnInit() {
    this.route.params.subscribe(
      params => {
        this.fn = params['fn'];
        this.rid = params['rid'];
        this.ida = params['ida'];
        console.log(this.ida);
  })}

  passOnR() {
    this.router.navigate(['/reimbursements', {
      fn: this.fn,
      rid: this.rid,
      ida:  this.ida
   
    
    }])
  }

  passOnA() {
    this.router.navigate(['/add_reimb', {
      fn: this.fn,
      rid: this.rid,
      ida:  this.ida
    
    }])
  }
}

