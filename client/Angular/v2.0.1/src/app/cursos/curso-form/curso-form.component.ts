import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Curso } from '../shared/curso';
import { CursosService } from '../shared/cursos.service';
import { BasicValidators } from '../../shared/basic-validators';

@Component({
  selector: 'app-curso-form',
  templateUrl: './curso-form.component.html',
  styleUrls: ['./curso-form.component.css']
})
export class CursoFormComponent implements OnInit {

  form: FormGroup;
  title: string;
  curso: Curso = new Curso();

  constructor(
    formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private cursosService: CursosService
  ) {
    this.form = formBuilder.group({
      name: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],
      turno: ['', [
        Validators.required,
      ]]
    });
  }

  ngOnInit() {

    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.title = id ? 'Edit Curso' : 'New Curso';

      if (!id)
        return;

      this.cursosService.getCurso(id)
        .subscribe(
          curso => this.curso = curso,
          response => {
            if (response.status == 404) {
              this.router.navigate(['NotFound']);
            }
          });
    });
  }

  save() {
    var result,
        cursoValue = this.form.value;

    if (cursoValue.id){
      result = this.cursosService.updateCurso(cursoValue);
    } else {
      result = this.cursosService.addCurso(cursoValue);
    }

    result.subscribe(data => this.router.navigate(['cursos']));
  }
}
