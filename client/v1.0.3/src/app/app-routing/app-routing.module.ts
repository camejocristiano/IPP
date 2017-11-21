import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { EventsComponent } from './../events/events.component';
import { EventSingleComponent } from './../events/event-single/event-single.component';
import { SignupComponent } from './../signup/signup.component';


const appRoutes: Routes = [
  {path: 'event/:slug', component: EventSingleComponent},
  {path: 'signup', component: SignupComponent},
  {path: '', component: EventsComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
