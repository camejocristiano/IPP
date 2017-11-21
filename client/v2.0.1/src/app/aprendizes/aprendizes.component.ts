import { Component, OnInit } from '@angular/core';
import { AprendizesService } from "./shared/aprendizes.service";
import { Jovem } from "./shared/jovem";

@Component({
  selector: 'app-aprendizes',
  templateUrl: './aprendizes.component.html',
  styleUrls: ['./aprendizes.component.css']
})
export class AprendizesComponent implements OnInit {

  private aprendizes: Jovem[] = [];

  constructor(private aprendizesService: AprendizesService) { }

  ngOnInit() {
    this.aprendizesService.getAprendizes()
      .subscribe(data => this.aprendizes = data);
      $(document).ready(function(){
        $('ul.tabs').tabs();
      }); 
  }

  deleteJovem(jovem){
    if (confirm("Are you sure you want to delete " + jovem.name + "?")) {
      var index = this.aprendizes.indexOf(jovem);
      this.aprendizes.splice(index, 1);

      this.aprendizesService.deleteJovem(jovem.id)
        .subscribe(null,
          err => {
            alert("Could not delete curso.");
            // Revert the view back to its original state
            this.aprendizes.splice(index, 0, jovem);
          });
    }
  }

}
