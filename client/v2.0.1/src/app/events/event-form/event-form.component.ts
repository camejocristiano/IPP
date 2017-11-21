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
  
  }
}
