import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';
import { DataTablesModule } from 'angular-datatables';

import { usuariosRouting } from "./usuarios/usuarios.routing";
import { UsuariosModule } from "./usuarios/usuarios.module";

import { ConfiguracoesComponent } from './configuracoes.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    HttpModule,
    DataTablesModule,
    usuariosRouting,
    UsuariosModule
  ],
  declarations: [
    ConfiguracoesComponent
    ],
  exports: [
    ConfiguracoesComponent
    ],
  providers: [
  ]
})
export class ConfiguracoesModule { }
