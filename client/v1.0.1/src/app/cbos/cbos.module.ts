import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CbosRoutingModule } from './cbos-routing.module';
import { CbosComponent } from './cbos.component';
import { CboFormComponent } from './cbo-form/cbo-form.component';

@NgModule({
  imports: [
    CommonModule,
    CbosRoutingModule
  ],
  declarations: [CbosComponent, CboFormComponent]
})
export class CbosModule { }
