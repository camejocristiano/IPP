import { ArcoocupacionalComponent } from './arcoocupacional/arcoocupacional.component';
import { ArcosocupacionaisComponent } from './arcosocupacionais.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'arcosocupacionais', component: ArcosocupacionaisComponent, pathMatch: 'full' },
  { path: 'arcosocupacionais/create', component: ArcoocupacionalComponent},
  { path: 'arcosocupacionais/:id', component: ArcoocupacionalComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArcosocupacionaisRoutingModule { }
