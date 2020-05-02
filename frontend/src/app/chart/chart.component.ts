import { Component, OnInit, Input } from '@angular/core';
import { OrientacaoConc, ProducaoBib } from '../relevant-data/relevant-data.model'
import * as CanvasJS from '../../assets/canvasjs/canvasjs.min';

@Component({
  selector: 'ua-chart',
  templateUrl: './chart.component.html'
})
export class ChartComponent implements OnInit {

  @Input() titulo: String
  @Input() nome: String
  @Input() orientacoes: OrientacaoConc[]
  @Input() producoes: ProducaoBib[]

  constructor() {}

  ngOnInit() {
    // this.mostraGraficoOrientacoes("Orient", this.orientacoes);
    // this.mostraGraficoProdBib("ProdBib", this.producoes);
  }

  ngOnChanges(){
    // this.mostraGraficoOrientacoes("Orient", this.orientacoes);
    // this.mostraGraficoProdBib("ProdBib", this.producoes);
  }
}
