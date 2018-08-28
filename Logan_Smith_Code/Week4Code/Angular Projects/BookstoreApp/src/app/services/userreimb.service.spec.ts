import { TestBed, inject } from '@angular/core/testing';

import { UserreimbService } from './userreimb.service';

describe('UserreimbService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserreimbService]
    });
  });

  it('should be created', inject([UserreimbService], (service: UserreimbService) => {
    expect(service).toBeTruthy();
  }));
});
