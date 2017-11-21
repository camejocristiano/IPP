import { Routes, RouterModule } from '@angular/router';

import { ConfiguracoesComponent } from './configuracoes.component';

const configuracoesRoutes: Routes = [
  { path: 'configuracoes', component: ConfiguracoesComponent, pathMatch: 'full' }
];

export const configuracoesRouting = RouterModule.forChild(configuracoesRoutes);