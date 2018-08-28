import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

@Injectable()
export class OffserviceService {

  constructor(private http: HttpClient) { }

  someGetMethod(): Observable<string> {
    return this.http.get<string>('requestUrl');
}
somePostMethod(): Observable<string> {
  return this.http.post<string>('requestUrl', {});
}

}
