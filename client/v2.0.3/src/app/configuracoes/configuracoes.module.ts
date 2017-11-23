import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';
import { DataTablesModule } from 'angular-datatables';

import { ConfiguracoesComponent } from './configuracoes.component';

import { UsuariosComponent } from './usuarios/usuarios.component';
import { UsuarioFormComponent } from './usuarios/usuario/usuario-form.component';
import { GruposPermissoesComponent } from './grupos-permissoes/grupos-permissoes.component';
import { GrupoPermissoesFormComponent } from './grupos-permissoes/grupo-permissoes/grupo-permissoes-form.component';
import { UnidadesComponent } from './unidades/unidades.component';
import { UnidadeFormComponent } from './unidades/unidade/unidade-form.component';
import { RepresentantesComponent } from './unidades/unidade/representantes/representantes.component';
import { RepresentanteFormComponent } from './unidades/unidade/representantes/representante/representante-form.component';
import { ContatosComponent } from './unidades/unidade/contatos/contatos.component';
import { ContatoFormComponent } from './unidades/unidade/contatos/contato/contato-form.component';
import { CanaisComponent } from './canais/canais.component';
import { CanalFormComponent } from './canais/canal/canal-form.component';
import { ArquivosComponent } from './arquivos/arquivos.component';
import { ArquivoFormComponent } from './arquivos/arquivo/arquivo-form.component';
import { AgendamentosComponent } from './agendamentos/agendamentos.component';
import { AgendamentoFormComponent } from './agendamentos/agendamento/agendamento-form.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpModule,
    DataTablesModule
  ],
  declarations: [
    ConfiguracoesComponent,
    UsuariosComponent,
    UsuarioFormComponent,
    GruposPermissoesComponent,
    GrupoPermissoesFormComponent,
    UnidadesComponent,
    UnidadeFormComponent,
    RepresentantesComponent,
    RepresentanteFormComponent,
    ContatosComponent,
    ContatoFormComponent,
    CanaisComponent,
    CanalFormComponent,
    ArquivosComponent,
    ArquivoFormComponent,
    AgendamentosComponent,
    AgendamentoFormComponent
    ],
  exports: [
    ConfiguracoesComponent,
    UsuariosComponent,
    UsuarioFormComponent,
    GruposPermissoesComponent,
    GrupoPermissoesFormComponent,
    UnidadesComponent,
    UnidadeFormComponent,
    RepresentantesComponent,
    RepresentanteFormComponent,
    ContatosComponent,
    ContatoFormComponent,
    CanaisComponent,
    CanalFormComponent,
    ArquivosComponent,
    ArquivoFormComponent,
    AgendamentosComponent,
    AgendamentoFormComponent
    ],
  providers: [
  ]
})
export class ConfiguracoesModule { }
