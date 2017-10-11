import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArcosocupacionaisComponent } from './arcosocupacionais.component';

describe('ArcosocupacionaisComponent', () => {
  let component: ArcosocupacionaisComponent;
  let fixture: ComponentFixture<ArcosocupacionaisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArcosocupacionaisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArcosocupacionaisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
