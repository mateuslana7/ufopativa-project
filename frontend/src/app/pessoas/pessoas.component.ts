import { Component, OnInit } from '@angular/core';

import {Pessoa} from './pessoa/pessoa.model'
import {PessoasService} from './pessoas.service'

@Component({
  selector: 'ua-pessoas',
  templateUrl: './pessoas.component.html'
})
export class PessoasComponent implements OnInit {

  pessoas: Pessoa[]

  constructor(private pessoasService: PessoasService) { }

  ngOnInit() {
  	// this.getPessoas()
  }

  // getPessoas(){
  // 	this.pessoasService.pessoas()
  // 		.subscribe(pessoas => this.pessoas = pessoas)
  // }

}
