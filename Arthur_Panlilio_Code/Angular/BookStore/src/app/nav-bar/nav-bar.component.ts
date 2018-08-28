import { Component, OnInit } from '@angular/core';
import { NavBarService } from '../services/nav-bar.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private navBarService: NavBarService) { }

  ngOnInit() {
  }

  onGoToAccount(){
    this.navBarService.onGoToAccount().subscribe(
    );
  }

}
