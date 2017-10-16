import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CbosComponent } from './cbos.component';

describe('CbosComponent', () => {
  let component: CbosComponent;
  let fixture: ComponentFixture<CbosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CbosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CbosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
