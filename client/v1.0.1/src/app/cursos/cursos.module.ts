import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CursosComponent } from './cursos.component';
import { CursoFormComponent } from './curso-form/curso-form.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [CursosComponent, CursoFormComponent]
})
export class CursosModule { }
