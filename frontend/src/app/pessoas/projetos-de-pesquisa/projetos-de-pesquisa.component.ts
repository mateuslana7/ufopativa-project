import { Component, OnInit, Input } from '@angular/core';
import { ProjetoDePesquisa } from './projetos-de-pesquisa.model'

@Component({
  selector: 'ua-projetos-de-pesquisa',
  templateUrl: './projetos-de-pesquisa.component.html',
  styleUrls: ['./projetos-de-pesquisa.component.css']
})
export class ProjetosDePesquisaComponent implements OnInit {

  @Input() projetos: ProjetoDePesquisa[]

  constructor() { }

  ngOnInit() {
  }

}
