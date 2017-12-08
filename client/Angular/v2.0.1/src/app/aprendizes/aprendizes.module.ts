import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule }  from '@angular/router';
import { HttpModule }  from '@angular/http';
import { DataTablesModule } from 'angular-datatables';

import { AprendizesComponent } from './aprendizes.component';
import { AprendizesService } from './shared/aprendizes.service';
import { JovemFormComponent } from './jovem-form/jovem-form.component';

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
    AprendizesComponent,
    JovemFormComponent
  ],
  exports: [
    AprendizesComponent
  ],
  providers: [
    AprendizesService
  ]
})
export class AprendizesModule { }
