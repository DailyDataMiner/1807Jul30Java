import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sqrt'
})
export class SquarerootPipe implements PipeTransform {

  //MUST OVERRIDE !!! !!!!!
  transform(value: number, args?: number): number {
    return Math.sqrt(value);
  }

}
