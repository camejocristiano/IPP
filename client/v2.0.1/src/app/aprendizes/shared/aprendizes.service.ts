import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class AprendizesService {

  private url: string = "http://localhost/api/v201/public/index.php";

  constructor(private http: Http) { }

  getAprendizes(){
    return this.http.get(this.url + '/aprendizes/list')
      .map(res => res.json());
  }

  getJovem(id){
    return this.http.get(this.url + '/find/' + id)
      .map(res => res.json());
  }

  addJovem(jovem){
    return this.http.post(this.url, JSON.stringify(jovem))
      .map(res => res.json());
  }

  updateJovem(jovem){
    return this.http.put(this.getJovemUrl(jovem.id), JSON.stringify(jovem))
      .map(res => res.json());
  }

  deleteJovem(id){
    return this.http.delete(this.getJovemUrl(id))
      .map(res => res.json());
  }

  private getJovemUrl(id){
    return this.url + "/" + id;
  }
}
