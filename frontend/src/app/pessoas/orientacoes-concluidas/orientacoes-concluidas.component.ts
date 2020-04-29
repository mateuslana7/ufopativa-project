import { Component, OnInit, Input } from '@angular/core';
import {OrientacaoConcluida} from './orientacoes-concluidas.model'

@Component({
  selector: 'ua-orientacoes-concluidas',
  templateUrl: './orientacoes-concluidas.component.html'
})
export class OrientacoesConcluidasComponent implements OnInit {

  @Input() orientacoes : OrientacaoConcluida;

  constructor() { }

  ngOnInit() {
  }

}
