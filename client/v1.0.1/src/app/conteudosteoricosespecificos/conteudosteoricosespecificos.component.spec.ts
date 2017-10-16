import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteudosteoricosespecificosComponent } from './conteudosteoricosespecificos.component';

describe('ConteudosteoricosespecificosComponent', () => {
  let component: ConteudosteoricosespecificosComponent;
  let fixture: ComponentFixture<ConteudosteoricosespecificosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConteudosteoricosespecificosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConteudosteoricosespecificosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
