import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CboFormComponent } from './cbo-form.component';

describe('CboFormComponent', () => {
  let component: CboFormComponent;
  let fixture: ComponentFixture<CboFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CboFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CboFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
