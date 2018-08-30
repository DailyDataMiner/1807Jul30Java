import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatenewrequestComponent } from './createnewrequest.component';

describe('CreatenewrequestComponent', () => {
  let component: CreatenewrequestComponent;
  let fixture: ComponentFixture<CreatenewrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreatenewrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatenewrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
