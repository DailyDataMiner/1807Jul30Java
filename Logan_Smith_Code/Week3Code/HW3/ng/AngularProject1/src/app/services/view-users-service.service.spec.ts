import { TestBed, inject } from '@angular/core/testing';

import { ViewUsersServiceService } from './view-users-service.service';

describe('ViewUsersServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ViewUsersServiceService]
    });
  });

  it('should be created', inject([ViewUsersServiceService], (service: ViewUsersServiceService) => {
    expect(service).toBeTruthy();
  }));
});
