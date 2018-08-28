import { Component, OnInit } from '@angular/core';
// import { Todo } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  buttonClass = 'btn btn-warning';
  text = '';
  counter = 0;
  color = 'yellow';
  pipeText = 'Some sample text';
  currentTime: Date;
  valueFromUser = '';
  valueToDisplay = '';
  itemsArray: string[] = [];
  strikeClass = '';
  unstrikeClass = '';
  
  constructor() {
    setInterval( () => this.currentTime = new Date, 1000 );
  }

  ngOnInit() {
  }

  addItemToList() {
    this.valueToDisplay = this.valueFromUser;
    this.itemsArray.push(this.valueFromUser);
    this.valueFromUser = '';
  }

  strike(item) {
    // this.strikeClass = 'strikeClass';
    if (this.strikeClass == 'strikeClass') {
      this.strikeClass = 'unstrikeClass';
    } else {
      this.strikeClass = 'strikeClass';
    }
    // this.itemsArray = this.itemsArray.filter( i => i !== item);
  }

  testBinding() {

    ++this.counter;

    // alert('hello there!');
    this.text = 'this is event an property binding! woo!';
    this.text += `<br />You've clicked this counter ${this.counter} times`;
    const classes = ['primary', 'secondary', 'success', 'danger',
                     'warning', 'info', 'light', 'dark'];

    this.buttonClass = `btn btn-${classes[this.counter % 8]}`;

    // if (this.buttonClass == 'btn btn-primary') {
    //   this.buttonClass = 'btn btn-warning';
    // }else {
    //   this.buttonClass = 'btn btn-primary';
    // }
  }

}
