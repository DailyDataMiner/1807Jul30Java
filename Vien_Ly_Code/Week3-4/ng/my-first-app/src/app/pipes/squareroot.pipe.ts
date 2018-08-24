import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot'
})
export class SquarerootPipe implements PipeTransform {

  transform(value: number): number {
    return Math.sqrt(value);
  }

}
