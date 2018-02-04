import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { Jovem } from '../shared/jovem';
import { AprendizesService } from '../shared/aprendizes.service';
import { BasicValidators } from '../../shared/basic-validators';

@Component({
  selector: 'app-jovem-form',
  templateUrl: './jovem-form.component.html',
  styleUrls: ['./jovem-form.component.css']
})
export class JovemFormComponent implements OnInit {

  form: FormGroup;
  title: string;
  jovem: Jovem = new Jovem();

  constructor(
    formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private aprendizesService: AprendizesService
  ) {
    this.form = formBuilder.group({
      name: ['', [
        Validators.required,
        Validators.minLength(3)
      ]],
      email: ['', [
        Validators.required,
      ]]
    });
  }

  ngOnInit() {

    var id = this.route.params.subscribe(params => {
      var id = params['id'];

      this.title = id ? 'Edit Jovem' : 'New Jovem';

      if (!id)
        return;

      this.aprendizesService.getJovem(id)
        .subscribe(
          jovem => this.jovem = jovem,
          response => {
            if (response.status == 404) {
              this.router.navigate(['NotFound']);
            }
          });
    });
  }

  save() {
    var result,
        jovemValue = this.form.value;

    if (jovemValue.id){
      result = this.aprendizesService.updateJovem(jovemValue);
    } else {
      result = this.aprendizesService.addJovem(jovemValue);
    }

    result.subscribe(data => this.router.navigate(['aprendizes']));
  }
}
