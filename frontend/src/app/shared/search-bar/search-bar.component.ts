import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms'
import { debounceTime, switchMap } from 'rxjs/operators'

import { Resultado } from './search-bar.model'
import { SearchBarService } from './search-bar.service'

@Component({
  selector: 'ua-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})

export class SearchBarComponent implements OnInit {

  campoDePesquisa: FormControl = new FormControl()
  resultado: Resultado;

  constructor(private searchBarService: SearchBarService) {}

  ngOnInit() {
    this.campoDePesquisa.valueChanges.pipe(
      debounceTime(200),
      switchMap(campoDePesquisa => this.searchBarService.pesquisa(campoDePesquisa))
    ).subscribe(resultado => this.resultado = resultado)
  }

  //APLICANDO ESTILO DINAMICAMENTE -- MELHORAR DEPOIS
  verificaResultado(){
    if(this.resultado.servidores.length > 0 && this.resultado.departamentos.length > 0 && this.resultado.unidades.length > 0)
      return "4";
    else if((this.resultado.servidores.length > 0 && this.resultado.departamentos.length > 0) 
            || (this.resultado.servidores.length > 0 && this.resultado.unidades.length > 0) 
            || (this.resultado.unidades.length > 0 && this.resultado.departamentos.length > 0))
            return "6";
    else
      return "12";

  }

  // limparPesquisa(){
  //   this.campoDePesquisa.setValue('');
  // }
}
