import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class EventsService {

  private url: string = "http://localhost/projetos/clientes/ipp/github/ipp/api/v2.0.1/public/index.php";

  constructor(private http: Http) { }

  getEvents(){
    return this.http.get(this.url + '/events')
      .map(res => res.json());
  }

  getEvent(id){
    return this.http.get(this.url + '/find/' + id)
      .map(res => res.json());
  }

  addEvent(event){
    return this.http.post(this.url, JSON.stringify(event))
      .map(res => res.json());
  }

  updateEvent(event){
    return this.http.put(this.getEventUrl(event.id), JSON.stringify(event))
      .map(res => res.json());
  }

  deleteEvent(id){
    return this.http.delete(this.getEventUrl(id))
      .map(res => res.json());
  }

  private getEventUrl(id){
    return this.url + "/" + id;
  }
}
