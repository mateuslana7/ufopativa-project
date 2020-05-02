import { Component, OnInit } from '@angular/core';
import { RelevantDataService } from './relevant-data.service';

import { Numeros, Unidade } from './relevant-data.model'

@Component({
  selector: 'ua-relevant-data',
  templateUrl: './relevant-data.component.html',
  styleUrls: ['./relevant-data.component.css']
})
export class RelevantDataComponent implements OnInit {

  numeros: Numeros
  unidades: Unidade[]
  totalServidoresEmUnidades: number

  constructor(private relevantDataService: RelevantDataService) {}

  ngOnInit() {
    this.getNumeros();
    this.getUnidades();
  }

  getNumeros(){
  	this.relevantDataService.numeros()
  		.subscribe((numeros) => {
        this.numeros = numeros
        this.calculaPercentServComLattes()
      })
  }

  getUnidades(){
    this.relevantDataService.unidades()
  		.subscribe((unidades) => {
        this.unidades = unidades
      })
  }

  setTotalServidoresEmUnidades(){
    var total = 0;
    this.unidades.map((unid) => {
      total += unid.totalServidores;
    })
    this.totalServidoresEmUnidades = total;
  }

  calculaPercentServ(value){
      return ((value/this.numeros.totalServidores)*100).toFixed(2);
  }

  calculaPercentServComLattes(){
    return ((this.numeros.totalServComLattes/this.numeros.totalServidores)*100).toFixed(2);
  }

  key: string = 'totalServidores';
  reverse: boolean = true;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

}
