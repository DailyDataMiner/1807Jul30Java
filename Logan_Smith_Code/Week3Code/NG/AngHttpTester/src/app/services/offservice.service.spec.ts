import { TestBed, inject } from '@angular/core/testing';

import { OffserviceService } from './offservice.service';

describe('OffserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OffserviceService]
    });
  });

  it('should be created', inject([OffserviceService], (service: OffserviceService) => {
    expect(service).toBeTruthy();
  }));
});
