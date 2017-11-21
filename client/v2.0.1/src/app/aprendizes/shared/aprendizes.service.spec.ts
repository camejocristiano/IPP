/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AprendizesService } from './aprendizes.service';

describe('Service: Cursos', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AprendizesService]
    });
  });

  it('should ...', inject([AprendizesService], (service: AprendizesService) => {
    expect(service).toBeTruthy();
  }));
});
