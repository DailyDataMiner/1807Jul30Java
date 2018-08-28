import { Injectable } from '@angular/core';
import { SampleModel } from '../models/samplemodel';
import { HomeComponent } from '../components/home/home.component';

@Injectable({
  providedIn: 'root'
})
export class ConnectionService {

  // sampleModel: SampleModel;
  dataFromConnService: string;

  constructor() { }

  getSomeData() {
    // this.sampleModel.name = 'name given from service';
    // this.dataFromConnService = 'data coming from http response';
  }

}
