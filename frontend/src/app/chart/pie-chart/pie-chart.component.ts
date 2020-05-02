import { Component, OnInit } from '@angular/core';
import { Unidade } from '../../relevant-data/relevant-data.model'
import { RelevantDataService } from '../../relevant-data/relevant-data.service'
import * as CanvasJS from '../../../assets/canvasjs/canvasjs.min'

@Component({
  selector: 'ua-pie-chart',
  templateUrl: './pie-chart.component.html',
  styleUrls: ['./pie-chart.component.css']
})
export class PieChartComponent implements OnInit {

  unidades: Unidade[]

  constructor(private relevantDataService: RelevantDataService) {}

  ngOnInit() {
    this.relevantDataService.unidades()
  		.subscribe((unidades) => {
        this.unidades = unidades
        this.gerarGraficoServidores()
      })
  }

  gerarGraficoServidores(){
    var dptsServ = [];

    this.unidades.map((unid) => {
      let data = {y: 0, label: new String}
      data.y = unid.totalServidores;
      data.label = unid.nome;
      dptsServ.push(data);
    })

    var chart = new CanvasJS.Chart("chartContainerServPorUnid", {
      backgroundColor: "transparent",
      exportEnabled: true,
      animationEnabled: true,
      title: false,
      data: [{
        type: "pie",
        startAngle: 25,
        indexLabelFontSize: 16,
        indexLabel: "{label}",
        dataPoints: dptsServ
      }]
    });
    chart.render();
  }

}
