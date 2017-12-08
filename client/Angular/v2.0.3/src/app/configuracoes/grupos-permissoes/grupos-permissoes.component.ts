import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-grupos-permissoes',
  templateUrl: './grupos-permissoes.component.html',
  styleUrls: ['./grupos-permissoes.component.css']
})
export class GruposPermissoesComponent implements OnInit {

   ngOnInit() {
      $(document).ready(function(){
        $('ul.tabs').tabs();
      }); 
  }
}
