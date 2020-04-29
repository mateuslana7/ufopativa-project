import { Component, OnInit } from '@angular/core';

import {Departamento} from './departamento/departamento.model'
import {DepartamentosService} from './departamentos.service'

@Component({
  selector: 'ua-departamentos',
  templateUrl: './departamentos.component.html',
  styleUrls: ['./departamentos.component.css']
})
export class DepartamentosComponent implements OnInit {

  departamentos: Departamento[]

  constructor(private departamentosService: DepartamentosService) { }

  ngOnInit() {
	  	this.departamentosService.departamentos()
	  		.subscribe(departamentos => this.departamentos = departamentos)
  }

}
