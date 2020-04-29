import { Component, OnInit, Input } from '@angular/core';
import { Producao } from './producao.model';

@Component({
  selector: 'ua-producao',
  templateUrl: './producao.component.html',
  styleUrls: ['./producao.component.css']
})
export class ProducaoComponent implements OnInit {

  @Input() producoesPorTipo: Producao
  @Input() tipo: String
  @Input() index: String
  @Input() classe: String
  icon: String 

  constructor() {
    this.icon = "+"
  }

  ngOnInit() {
  }

  changeIcon(){
    if(this.icon === "+")
      this.icon = "-";
    else
      this.icon = "+";
  }

  key: string = 'ano';
  reverse: boolean = true;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

}
