import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchEmployeeFilter'
})
export class SearchEmployeePipe implements PipeTransform {

  transform(items: any[], searchText: string): any[] {
    console.log(items);
    if (!items) return [];
    if (!searchText) return items;

    searchText = searchText.toLowerCase();
    
    // return items.filter(
    //   item => { return item.toLowerCase().includes(searchText); }
    // );

    return items.filter( it => {
      console.log(it.created_by.toLowerCase().includes(searchText));
      return it.created_by.toLowerCase().includes(searchText);
      // return it.toLowerCase().includes(searchText);
    });

  }

}
// https://codeburst.io/create-a-search-pipe-to-dynamically-filter-results-with-angular-4-21fd3a5bec5c