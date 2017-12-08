import { Router } from '@angular/router';
import { Injectable, EventEmitter } from '@angular/core';
import { Usuario } from '../configuracoes/usuarios/usuario/Usuario';


@Injectable()
export class AuthService {

  private usuarioAutenticado = false;

  constructor(private router: Router) { }

  mostrarMenuEmitter = new EventEmitter<boolean>();

  autenticar(usuario: Usuario){
    if(usuario.username === "ipp" && usuario.password === "ipp"){
      this.usuarioAutenticado = true;
      this.mostrarMenuEmitter.emit(true);
      this.router.navigate(['/']);
    } else {
      this.usuarioAutenticado = false;
      this.mostrarMenuEmitter.emit(false);
    }
  }
}
