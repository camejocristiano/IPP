import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../http.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css'],
})
export class UsuariosComponent implements OnInit {
  
  private usuarios: Array<{}>;
  constructor(public http: HttpService) {
    // Função para iniciar a lista de usuários
    this.http.get('configuracoes/usuarios').subscribe(res => this.usuarios = res);
  }
  ngOnInit() {
    // Função para iniciar o JQuery DataTable
    $(document).ready(function(){
      $('ul.tabs').tabs();
    });
  }}