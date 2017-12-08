import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contatos',
  templateUrl: './contatos.component.html',
  styleUrls: ['./contatos.component.css']
})
export class ContatosComponent implements OnInit {

   ngOnInit() {
      $(document).ready(function(){
        $('ul.tabs').tabs();
      });
  }
}
