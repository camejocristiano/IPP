import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agendamentos',
  templateUrl: './agendamentos.component.html',
  styleUrls: ['./agendamentos.component.css']
})
export class AgendamentosComponent implements OnInit {

   ngOnInit() {
      $(document).ready(function(){
        $('ul.tabs').tabs();
      });
  }
}
