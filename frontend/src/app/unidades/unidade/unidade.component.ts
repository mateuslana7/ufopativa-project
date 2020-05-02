import { Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router'

import {UnidadesService} from '../unidades.service'
import {Unidade, Departamento, ServidorSemDepto} from './unidade.model'

@Component({
  selector: 'ua-unidade',
  templateUrl: './unidade.component.html',
  styleUrls: ['./unidade.component.css']
})
export class UnidadeComponent implements OnInit {

  unidade: Unidade
  departamentos: Departamento[]
  servidoresSemDepto: ServidorSemDepto[]

  constructor(private unidadeService: UnidadesService, private route: ActivatedRoute) {}

  ngOnInit() {
  	this.unidadeService.unidadeById(this.route.snapshot.params['id'])
      .subscribe((unidade) => { 
        this.unidade = unidade
        this.calculaPercentServComLattes()
      })

    this.loadDepartamentos();
    this.loadServidoresSemDepto();
  }

  calculaPercentServComLattes(){
    return ((this.unidade.totalServComLattes/this.unidade.totalServidores)*100).toFixed(2);
  }

  loadDepartamentos(){
    this.unidadeService.departamentosByIdUnidade(this.route.snapshot.params['id']).subscribe(departamentos => {
      //carregou os departamentos
      this.departamentos = departamentos
    }, err => {
      //erro na requisicao.
    })
  }

  loadServidoresSemDepto(){
    this.unidadeService.servsSemDeptoByIdUnidade(this.route.snapshot.params['id']).subscribe(servidoresSemDepto => {
      //carregou os departamentos
      this.servidoresSemDepto = servidoresSemDepto
    }, err => {
      //erro na requisicao.
    })
  }
}