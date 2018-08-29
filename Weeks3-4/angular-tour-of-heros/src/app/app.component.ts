import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';
  test = 'this is a test';
  showLogo: boolean = true;

constructor() {

}

  public toggleDisplay() {
  this.showLogo = !this.showLogo;
  }
}


