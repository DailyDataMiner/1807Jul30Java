import { Component, OnInit } from '@angular/core';
import { ConnectionService } from '../../services/connection.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  
  connService: ConnectionService;

  constructor() {
  }

  ngOnInit() {
  }

  doSomething() {
    console.log('doing something');
  }

  useService() {
    // this.connService.giveNameToModel();
    this.connService.getSomeData();
  }

}
