import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteudosteoricosbasicosComponent } from './conteudosteoricosbasicos.component';

describe('ConteudosteoricosbasicosComponent', () => {
  let component: ConteudosteoricosbasicosComponent;
  let fixture: ComponentFixture<ConteudosteoricosbasicosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConteudosteoricosbasicosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConteudosteoricosbasicosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
