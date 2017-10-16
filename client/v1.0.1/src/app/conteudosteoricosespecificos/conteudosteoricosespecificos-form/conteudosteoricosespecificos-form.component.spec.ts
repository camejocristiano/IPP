import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteudosteoricosespecificosFormComponent } from './conteudosteoricosespecificos-form.component';

describe('ConteudosteoricosespecificosFormComponent', () => {
  let component: ConteudosteoricosespecificosFormComponent;
  let fixture: ComponentFixture<ConteudosteoricosespecificosFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConteudosteoricosespecificosFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConteudosteoricosespecificosFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
