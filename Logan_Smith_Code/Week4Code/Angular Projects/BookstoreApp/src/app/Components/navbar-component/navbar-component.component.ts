import { Component, OnInit } from '@angular/core';
//import { AppRoutingModule } from '../../app-routing.module'
//import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-navbar-component',
  templateUrl: './navbar-component.component.html',
  styleUrls: ['./navbar-component.component.css']
})
export class NavbarComponentComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  /*toRoute(event: any) {
    console.log(event.target.id);
    switch(event.target.id) {
      case "booksNav":
      this.router.navigate([]);
    }
  }*/

}
