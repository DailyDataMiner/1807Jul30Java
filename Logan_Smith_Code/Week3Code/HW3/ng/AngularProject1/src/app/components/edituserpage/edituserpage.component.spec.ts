import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EdituserpageComponent } from './edituserpage.component';

describe('EdituserpageComponent', () => {
  let component: EdituserpageComponent;
  let fixture: ComponentFixture<EdituserpageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EdituserpageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EdituserpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
