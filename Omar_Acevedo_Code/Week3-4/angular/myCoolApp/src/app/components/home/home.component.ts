import { Component, OnInit } from '@angular/core';
import { SampleModel } from '../../models/samplemodel';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nameValue: string;

  constructor() { 
  }

  ngOnInit() {
  }

}