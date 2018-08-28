import { Component, OnInit } from '@angular/core';
import { OffserviceService } from '../../services/offservice.service'

@Component({
  selector: 'app-sendoff',
  templateUrl: './sendoff.component.html',
  styleUrls: ['./sendoff.component.css']
})
export class SendoffComponent implements OnInit {

  constructor(private myService: OffserviceService) { }


  callSomeGetMethod() {
    this.myService.someGetMethod().subscribe(
        data => {
            /* This function handles a successful HTTP call */
        },
        err => {
            /* This function handles an error */
        }
    );
}

callSomePostMethod() {
  this.myService.somePostMethod().subscribe(
      data => {
          /* This function handles a successful HTTP call */
      },
      err => {
          /* This function handles an error */
      }
  );
}

  ngOnInit() {
  }

}
