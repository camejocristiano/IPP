import { Routes, RouterModule } from '@angular/router';

import { ConfiguracoesComponent } from './configuracoes.component';

import { UsuarioFormComponent } from './usuarios/usuario/usuario-form.component';
import { GrupoPermissoesFormComponent } from './grupos-permissoes/grupo-permissoes/grupo-permissoes-form.component';
import { UnidadeFormComponent } from './unidades/unidade/unidade-form.component';

const configuracoesRoutes: Routes = [
  { path: 'configuracoes', component: ConfiguracoesComponent, pathMatch: 'full' },
  
  { path: 'usuarios/new', component: UsuarioFormComponent },
  { path: 'usuarios/{id}', component: UsuarioFormComponent },

  { path: 'permissoes/new', component: GrupoPermissoesFormComponent },
  { path: 'permissoes/1', component: GrupoPermissoesFormComponent },
  
  { path: 'unidades/new', component: UnidadeFormComponent },
  { path: 'unidades/1', component: UnidadeFormComponent }
];

export const configuracoesRouting = RouterModule.forChild(configuracoesRoutes);