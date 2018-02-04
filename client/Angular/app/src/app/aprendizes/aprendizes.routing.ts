import { Routes, RouterModule } from '@angular/router';

import { AprendizesComponent } from './aprendizes.component';
import {JovemFormComponent} from "./jovem-form/jovem-form.component";

const aprendizesRoutes: Routes = [
  { path: 'aprendizes', component: AprendizesComponent, pathMatch: 'full' },
  { path: 'aprendizes/new', component: JovemFormComponent},
  { path: 'aprendizes/:id', component: JovemFormComponent}
];

export const aprendizesRouting = RouterModule.forChild(aprendizesRoutes);
