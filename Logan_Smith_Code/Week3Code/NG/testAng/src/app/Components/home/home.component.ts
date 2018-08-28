import { Component, OnInit } from '@angular/core';
//import { Todo} from '../../Models/ToDo.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nothing = "Don't click it...";
  buttonClass = "btn btn-primary";
  counter = 0;
  color = "";
  pipeText = "Sample Text";
  currentTime: Date;
  toAdd = "";
  listStyle = "";

  listToDo = [];

  constructor() {
    setInterval(
      () => {
      this.currentTime = new Date;
      }, 1000);
   }

  ngOnInit() {
    //this.listToDo = [new Todo("Test", false)];
  }

mytestevent() {
  const classes = ["primary", "secondary", "success", "danger", "warning", "light", "dark"];
  ++this.counter;
  if (this.counter == 1) {
    this.buttonClass = "btn btn-" + classes[4];
    console.log(this.buttonClass);
    this.nothing = "I'm warning you...";
  }
  else if (this.counter >= 2) {
    this.buttonClass = "btn btn-" + classes[3];
    this.nothing = 'I WILL SEND THE WORLD AWAY!';
  }

}
addOne() {
  this.listToDo.push(this.toAdd);
  this.toAdd = "";
}
strike(toChange) {
  
}

}
