import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConteudosteoricosespecificosRoutingModule } from './conteudosteoricosespecificos-routing.module';
import { ConteudosteoricosespecificosComponent } from './conteudosteoricosespecificos.component';
import { ConteudosteoricosespecificosFormComponent } from './conteudosteoricosespecificos-form/conteudosteoricosespecificos-form.component';

@NgModule({
  imports: [
    CommonModule,
    ConteudosteoricosespecificosRoutingModule
  ],
  declarations: [ConteudosteoricosespecificosComponent, ConteudosteoricosespecificosFormComponent]
})
export class ConteudosteoricosespecificosModule { }
