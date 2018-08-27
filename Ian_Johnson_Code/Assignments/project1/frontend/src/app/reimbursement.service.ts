import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Reimbursement } from './reimbursement';
import { environment } from '../environments/environment';
import { catchError } from 'rxjs/operators';
import { ReimbursementStatus } from './reimbursement-status.enum';

@Injectable({
  providedIn: 'root',
})
export class ReimbursementService {
  constructor(private http: HttpClient) {}

  getByAuthor(
    authorId: number,
    status?: ReimbursementStatus
  ): Observable<Reimbursement[]> {
    const params = { author: authorId.toString() };
    if (status) {
      params['status'] = status;
    }
    return this.http
      .get<Reimbursement[]>(environment.apiUrl + '/reimbursements', {
        params,
        withCredentials: true,
      })
      .pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error(`An internal error occurred: ${error.error.message}`);
    } else if (error.status === 403) {
      return throwError('Unauthorized (perhaps not logged in).');
    } else {
      console.error('Server returned an unexpected error:', error.error);
    }
    return throwError('An unexpected error occurred.');
  }
}
