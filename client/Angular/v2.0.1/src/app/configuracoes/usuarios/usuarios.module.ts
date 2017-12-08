import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';
import { DataTablesModule } from 'angular-datatables';

import { UsuariosComponent } from './usuarios.component';
import { UsuarioFormComponent } from './usuario/usuario-form.component';

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
    UsuariosComponent,
    UsuarioFormComponent
  ],
  exports: [
    UsuariosComponent,
    UsuarioFormComponent
  ],
  providers: [

  ]
})
export class UsuariosModule { }
