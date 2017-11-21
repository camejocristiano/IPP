import { Routes, RouterModule } from '@angular/router';

import { CursosComponent } from './cursos.component';
import { CursoFormComponent } from "./curso-form/curso-form.component";

const cursosRoutes: Routes = [
  { path: 'cursos', component: CursosComponent, pathMatch: 'full' },
  { path: 'cursos/new', component: CursoFormComponent},
  { path: 'cursos/:id', component: CursoFormComponent}
];

export const cursosRouting = RouterModule.forChild(cursosRoutes);