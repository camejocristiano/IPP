import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpService } from './../../http.service';

@Component({
  selector: 'app-event-single',
  templateUrl: './event-single.component.html',
  styleUrls: ['./event-single.component.css']
})
export class EventSingleComponent implements OnInit {
  private event: {};

  constructor(
    private route: ActivatedRoute,
    private httpService: HttpService
  ) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
        this.httpService.getBy('events', params['slug'])
            .subscribe(data => this.event = data);
    });
  }

}
