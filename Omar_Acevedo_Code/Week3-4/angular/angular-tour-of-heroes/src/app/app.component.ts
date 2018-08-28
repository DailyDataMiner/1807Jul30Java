import { Component } from '@angular/core';

// Annotation
// Decorator function that specifies the Angular 
// metadata for the component
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'My Title';
}
