import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { BasicValidators } from '../../../../../shared/basic-validators';

declare var $:any;

@Component({
  selector: 'app-representante-form',
  templateUrl: './representante-form.component.html',
  styleUrls: ['./representante-form.component.css']
})
export class RepresentanteFormComponent implements OnInit {
  ngOnInit(){
    $(document).ready(function() {
      $('select').material_select();
    });
    $('.datepicker').pickadate({
      selectMonths: true, // Creates a dropdown to control month
      selectYears: 15, // Creates a dropdown of 15 years to control year,
      today: 'Hoje',
      clear: 'Limpar',
      close: 'Ok',
      closeOnSelect: false // Close upon selecting a date,
    });
  }
}