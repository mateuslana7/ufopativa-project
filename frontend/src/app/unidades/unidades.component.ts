import { Component, OnInit } from '@angular/core';

import {Unidade} from './unidade/unidade.model'
import {UnidadesService} from './unidades.service'

@Component({
  selector: 'ua-unidades',
  templateUrl: './unidades.component.html',
  styleUrls: ['./unidades.component.css']
})
export class UnidadesComponent implements OnInit {

  unidades: Unidade[]

  constructor(private unidadesService: UnidadesService) { }

  ngOnInit() {
  	this.getUnidades()
  }

  getUnidades(){
  	this.unidadesService.unidades()
  		.subscribe(unidades => this.unidades = unidades)
  }
}
