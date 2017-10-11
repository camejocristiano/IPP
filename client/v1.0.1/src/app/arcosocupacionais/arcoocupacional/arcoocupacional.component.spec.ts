import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArcoocupacionalComponent } from './arcoocupacional.component';

describe('ArcoocupacionalComponent', () => {
  let component: ArcoocupacionalComponent;
  let fixture: ComponentFixture<ArcoocupacionalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArcoocupacionalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArcoocupacionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
