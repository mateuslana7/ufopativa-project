import { Component, OnInit, Input } from '@angular/core';
import { FormacaoAcademica } from './formacoes-academicas.model'

@Component({
  selector: 'ua-formacoes-academicas',
  templateUrl: './formacoes-academicas.component.html'
})
export class FormacoesAcademicasComponent implements OnInit {

  @Input() formacoes: FormacaoAcademica[]

  constructor() { }

  ngOnInit() {
  }

}
