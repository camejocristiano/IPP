import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Event } from '../shared/event';
import { EventsService } from '../shared/events.service';
import { BasicValidators } from '../../shared/basic-validators';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.css']
})
export class EventFormComponent implements OnInit {

  form: FormGroup;
  title: string;
  event: Event = new Event();

  constructor(
    formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private eventsService: EventsService
  ) {
    this.form = formBuilder.group({
      title: ['', [
        
      ]]     
    });
  }
  
  ngOnInit() {
    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.title = id ? 'Edit Event' : 'New Event';

      if (!id)
        return;

      this.eventsService.getEvent(id)
        .subscribe(
          event => this.event = event,
          response => {
            if (response.status == 404) {
              this.router.navigate(['NotFound']);
            }
          });
    });
  }

  save() {
    var result,
        eventValue = this.form.value;

    if (eventValue.id){
      result = this.eventsService.updateEvent(eventValue);
    } else {
      result = this.eventsService.addEvent(eventValue);
    }

    result.subscribe(data => this.router.navigate(['events']));
  }
}
