import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, URLSearchParams } from '@angular/http';

import 'rxjs/add/operator/map';

@Injectable()
export class HttpService {

  private mainUrl: string = 'http://localhost/projetos/clientes/ipp/github/ipp/api/v2.0.0/public/index.php/';


  constructor(public http: Http) { }

  get(endpoint) {
    return this.http.get(`${this.mainUrl}${endpoint}`)
             .map(res => {
                return res.json();
             });
  }

  getBy(endpoint: string, param: any) {
    return this.http.get(`${this.mainUrl}${endpoint}/${param}`)
      .map(res => {
        return res.json();
      });
  }

  post(endpoint: string, data: Object) {
    let headers = new Headers();
        headers.append('Content-Type', 'application/x-www-form-urlencoded');

    let opt = new RequestOptions({ headers: headers});

    let urlData = new URLSearchParams();

    for(let k in data) {
      //urlData.append(k, data[k]);
      console.log(k, data[k]);
    }

    /* return this.http.post(`${this.mainUrl}${endpoint}`, urlData, opt)
      .map(res => {
        return res.json();
    }); */
  }
}