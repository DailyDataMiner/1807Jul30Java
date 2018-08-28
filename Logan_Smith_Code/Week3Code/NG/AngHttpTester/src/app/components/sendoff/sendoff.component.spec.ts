import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SendoffComponent } from './sendoff.component';

describe('SendoffComponent', () => {
  let component: SendoffComponent;
  let fixture: ComponentFixture<SendoffComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SendoffComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SendoffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
