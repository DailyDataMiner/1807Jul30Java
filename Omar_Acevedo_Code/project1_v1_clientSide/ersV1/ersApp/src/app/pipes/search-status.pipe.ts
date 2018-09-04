import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchStatusFilter'
})
export class SearchStatusPipe implements PipeTransform {

  transform(items: any[], searchText: string): any[] {
    console.log(items);
    if (!items) return [];
    if (!searchText) return items;

    searchText = searchText.toLowerCase();

    return items.filter( it => {
      console.log(it.ticket_status.toLowerCase().includes(searchText));
      return it.ticket_status.toLowerCase().includes(searchText);
    });

  }

}
