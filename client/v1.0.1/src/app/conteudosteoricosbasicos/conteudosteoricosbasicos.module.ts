import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConteudosteoricosbasicosRoutingModule } from './conteudosteoricosbasicos-routing.module';
import { ConteudoteoricobasicoComponent } from './conteudoteoricobasico/conteudoteoricobasico.component';
import { ConteudosteoricosbasicosComponent } from './conteudosteoricosbasicos.component';

@NgModule({
  imports: [
    CommonModule,
    ConteudosteoricosbasicosRoutingModule
  ],
  declarations: [ConteudoteoricobasicoComponent, ConteudosteoricosbasicosComponent]
})
export class ConteudosteoricosbasicosModule { }
