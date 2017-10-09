import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class UsersService {

  //private url: string = "http://ipp.net.br/api/public/index.php/users";
  private url: string = "http://localhost/projetos/clientes/ipp/api/v1.0.0/public/index.php/users";
  //private url: string = "http://localhost:3000/users";

  constructor(private http: Http) { }

  getUsers(){
    return this.http.get(this.url + '/list')
      .map(res => res.json());
  }

  getUser(id){
    return this.http.get(this.url + '/find/' + id)
      .map(res => res.json());
  }

  addUser(user){
    return this.http.post(this.url + '/create/', JSON.stringify(user))
      .map(res => res.json());
  }

  updateUser(user){
    return this.http.put(this.getUserUrl(user.id), JSON.stringify(user))
      .map(res => res.json());
  }

  deleteUser(id){
    return this.http.delete(this.getUserUrl(id))
      .map(res => res.json());
  }

  private getUserUrl(id){
    return this.url + "/" + id;
  }
}
