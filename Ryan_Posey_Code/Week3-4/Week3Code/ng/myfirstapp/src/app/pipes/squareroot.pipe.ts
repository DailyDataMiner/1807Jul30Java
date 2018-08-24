import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqt' // ie {{10 | sqt}}
})
export class SquarerootPipe implements PipeTransform {

  // must override transform method to create new pipe
  transform(value: number): number {
    return Math.sqrt(value);
  }

}
