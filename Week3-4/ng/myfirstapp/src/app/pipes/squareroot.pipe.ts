import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'squareroot'
})
export class SquarerootPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return null;
  }

}
