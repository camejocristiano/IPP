import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ArcosocupacionaisRoutingModule } from './arcosocupacionais-routing.module';
import { ArcosocupacionaisComponent } from './arcosocupacionais.component';
import { ArcoocupacionalComponent } from './arcoocupacional/arcoocupacional.component';

@NgModule({
  imports: [
    CommonModule,
    ArcosocupacionaisRoutingModule
  ],
  declarations: [ArcosocupacionaisComponent, ArcoocupacionalComponent]
})
export class ArcosocupacionaisModule { }
