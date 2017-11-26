import { Component, OnInit } from '@angular/core';
import { Usuario } from '../configuracoes/usuarios/usuario/usuario';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  private usuario: Usuario = new Usuario();

  constructor(private authService: AuthService) {

  }

  ngOnInit(){
    
  }

  autenticar(){
    this.authService.autenticar(this.usuario);
  }

}
