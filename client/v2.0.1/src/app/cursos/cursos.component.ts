import { Component, OnInit } from '@angular/core';
import { CursosService } from "./shared/cursos.service";
import { Curso } from "./shared/curso";

@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.css']
})
export class CursosComponent implements OnInit {

  private cursos: Curso[] = [];

  constructor(private cursosService: CursosService) { }

  ngOnInit() {
    this.cursosService.getCursos()
      .subscribe(data => this.cursos = data);
      $(document).ready(function(){
        $('ul.tabs').tabs();
      }); 
  }

  deleteCurso(curso){
    if (confirm("Are you sure you want to delete " + curso.name + "?")) {
      var index = this.cursos.indexOf(curso);
      this.cursos.splice(index, 1);

      this.cursosService.deleteCurso(curso.id)
        .subscribe(null,
          err => {
            alert("Could not delete curso.");
            // Revert the view back to its original state
            this.cursos.splice(index, 0, curso);
          });
    }
  }

}
