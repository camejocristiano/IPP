import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class EventsService {

  private url: string = "https://silexapi.000webhostapp.com/public/index.php";

  constructor(private http: Http) { }

  getEvents(){
    return this.http.get(this.url + '/events')
      .map(res => res.json());
  }

  getEvent(id){
    return this.http.get(this.url + '/events/' + id)
      .map(res => res.json());
  }

  addEvent(event){
    let headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    let opt = new RequestOptions({headers: headers});
    return this.http.post(this.url, JSON.stringify(event), opt)
      .map(res => res.json());
  }

  updateEvent(event){
    let headers = new Headers();
    headers.append('Content-Type', 'application/x-www-form-urlencoded');
    let opt = new RequestOptions({headers: headers});
    return this.http.put(this.getEventUrl(event.id), JSON.stringify(event), opt)
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
