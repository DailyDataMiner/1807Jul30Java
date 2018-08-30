import { TestBed, inject } from '@angular/core/testing';

import { AdminreimbService } from './adminreimb.service';

describe('AdminreimbService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdminreimbService]
    });
  });

  it('should be created', inject([AdminreimbService], (service: AdminreimbService) => {
    expect(service).toBeTruthy();
  }));
});
