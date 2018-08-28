import { Component, OnInit } from '@angular/core';
import { toDo } from '../models/toDoModel';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html', //template: <h1>yahaha</h1>
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  buttonClass='btn btn-warning';
  text = '';
  counter = 0;
  color = 'yellow';
  pipeText = 'sample text';
  newItem = '';
  itemList: Array<String> = [];
  currentTime: Date;


  constructor() {
    setInterval(
      ()=>{
        this.currentTime = new Date;
      }, 1000);
    
  }

  ngOnInit() {
      //this.itemList = [new toDo('test',false)];
  }

  addToList(){
    console.log(this.newItem);
    this.itemList.push(this.newItem);
  }

  testBinding(){
    this.counter++;
    this.text = `This is Event and Property binding! Woo!
    --- You've clicked ${this.counter} times!`;
    const classes = ['primary', 'secondary', 'success',
        'danger','warning', 'info', 'light', 'dark'];
    this.buttonClass = `btn btn-${classes[this.counter % 8]}`
  }

  strike(item){
    this.itemList = this.itemList.filter(i => i !== item);
  }



}
