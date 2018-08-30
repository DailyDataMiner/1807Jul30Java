import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbManagerComponent } from './reimb-manager.component';

describe('ReimbManagerComponent', () => {
  let component: ReimbManagerComponent;
  let fixture: ComponentFixture<ReimbManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReimbManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
