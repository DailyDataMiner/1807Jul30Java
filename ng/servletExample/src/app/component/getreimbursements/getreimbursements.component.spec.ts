import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetreimbursementsComponent } from './getreimbursements.component';

describe('GetreimbursementsComponent', () => {
  let component: GetreimbursementsComponent;
  let fixture: ComponentFixture<GetreimbursementsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetreimbursementsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetreimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
