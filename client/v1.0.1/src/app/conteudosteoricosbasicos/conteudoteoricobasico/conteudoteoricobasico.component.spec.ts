import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConteudoteoricobasicoComponent } from './conteudoteoricobasico.component';

describe('ConteudoteoricobasicoComponent', () => {
  let component: ConteudoteoricobasicoComponent;
  let fixture: ComponentFixture<ConteudoteoricobasicoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConteudoteoricobasicoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConteudoteoricobasicoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
