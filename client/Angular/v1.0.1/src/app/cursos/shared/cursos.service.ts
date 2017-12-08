import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class CursosService {

  private url: string = "http://ipp.net.br/api/v101/public/index.php";

  constructor(private http: Http) { }

  getCursos(){
    return this.http.get(this.url + '/cursos/list')
      .map(res => res.json());
  }

  getCurso(id){
    return this.http.get(this.url + '/find/' + id)
      .map(res => res.json());
  }

  addCurso(curso){
    return this.http.post(this.url, JSON.stringify(curso))
      .map(res => res.json());
  }

  updateCurso(curso){
    return this.http.put(this.getCursoUrl(curso.id), JSON.stringify(curso))
      .map(res => res.json());
  }

  deleteCurso(id){
    return this.http.delete(this.getCursoUrl(id))
      .map(res => res.json());
  }

  private getCursoUrl(id){
    return this.url + "/" + id;
  }
}
