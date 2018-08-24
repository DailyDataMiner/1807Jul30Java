import { Component, OnInit } from '@angular/core';
import { Todo } from '../../models/todo.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  buttonClass = 'btn btn-warning';
  text = '';
  counter = 0;
  color = '';
  pipeText = 'sample text';
  currentTime: Date;
  listStyle = "";

  newItem = 'New Item...';
  toDoList: Todo[];
  constructor() { 
    setInterval(
      ()=> {
        this.currentTime = new Date;
      }, 1000);
  }

  ngOnInit() {
    this.toDoList = [new Todo("Test", false)];
  }

  testBinding() {
    ++this.counter;
    this.text = `this is event binding and property binding! woo!
    --- You've clicked ${this.counter} times.`;
    const classes = ['primary', 'secondary', 'success', 'danger', 'warning', 'info', 'light', 'dark'];
    this.buttonClass = `btn btn-${classes[this.counter%8]}`;
  }

  add() {
    this.toDoList.push();
  }

  strike(item) {
    
  }
}
