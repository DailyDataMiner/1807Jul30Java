import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetreimbursementsbyuserComponent } from './getreimbursementsbyuser.component';

describe('GetreimbursementsbyuserComponent', () => {
  let component: GetreimbursementsbyuserComponent;
  let fixture: ComponentFixture<GetreimbursementsbyuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetreimbursementsbyuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetreimbursementsbyuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
