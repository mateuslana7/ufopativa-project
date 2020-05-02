import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'

import {DepartamentosService} from '../departamentos.service'
import {Departamento, Servidor} from './departamento.model'

@Component({
  selector: 'ua-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css']
})
export class DepartamentoComponent implements OnInit {
  
  departamento: Departamento;
  servidores: Servidor[]

  constructor(private deptoService: DepartamentosService, private route: ActivatedRoute) { }

  ngOnInit() {
  	this.deptoService.departamentoById(this.route.snapshot.params['id'])
  		.subscribe((departamento) => {
        this.departamento = departamento
        this.calculaPercentServComLattes()
      }) 
    
    this.loadServidores();
  }

  calculaPercentServComLattes(){
    return ((this.departamento.totalServComLattes/this.servidores.length)*100).toFixed(2);
  }

  loadServidores(){
    this.deptoService.servidoresByIdDepartamento(this.route.snapshot.params['id']).subscribe(servidores => {
      //carregou os servidores
      this.servidores = servidores
    }, err => {
      //erro na requisicao.
    })
  }

}
