import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqt'//ie {{10 | sqt}}
})
export class SquarerootpipePipe implements PipeTransform {

  //Must override transform method
  transform(value: number): number {
    return Math.sqrt(value);
  }

}
