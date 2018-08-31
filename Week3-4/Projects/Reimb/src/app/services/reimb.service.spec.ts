import { TestBed, inject } from '@angular/core/testing';

import { ReimbService } from './reimb.service';

describe('ReimbService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReimbService]
    });
  });

  it('should be created', inject([ReimbService], (service: ReimbService) => {
    expect(service).toBeTruthy();
  }));
});
