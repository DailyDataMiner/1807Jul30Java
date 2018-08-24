import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  text = '';
  buttonClass = 'btn btn-warning';
  counter = 0;
  color = 'yellow';
  pipeText = 'sample text';
  currentTime: Date;
  todoItem = '';
  todoItems = [];

  constructor() { }

  ngOnInit() {
    setInterval(() => {
      this.currentTime = new Date();
    }, 1000);
  }

  testBinding() {
    this.text = 'button clicked ' + this.counter + ' times';
    this.buttonClass = 'btn btn-' + ['primary', 'warning'][this.counter++ % 2];
  }

  addTodo(text) {
    console.log(text);
    this.todoItems.push(text);
    this.todoItem = '';
  }

  removeItem(item) {
    console.log(typeof(item));
    this.todoItems.splice(this.todoItem.indexOf(item), 1);
  }

}
