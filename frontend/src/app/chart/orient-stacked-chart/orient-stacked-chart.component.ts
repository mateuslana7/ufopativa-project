import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { OrientacaoConc } from '../../relevant-data/relevant-data.model'

import { UnidadesService } from '../../unidades/unidades.service';

import * as CanvasJS from '../../../assets/canvasjs/canvasjs.min'
import { DepartamentosService } from '../../unidades/departamentos/departamentos.service';
import { RelevantDataService } from 'src/app/relevant-data/relevant-data.service';



@Component({
  selector: 'ua-orient-stacked-chart',
  templateUrl: './orient-stacked-chart.component.html',
  styleUrls: ['./orient-stacked-chart.component.css']
})
export class OrientStackedChartComponent implements OnInit {

  @Input() tipo: String
  orientacoes: OrientacaoConc[]
  graficoRenderizou: Boolean

  constructor(private relevantDataService: RelevantDataService, private deptoService: DepartamentosService, private unidService: UnidadesService, private route: ActivatedRoute) {
    this.graficoRenderizou = false
  }

  ngOnInit() {
    if(this.tipo === "total"){
      this.relevantDataService.orientacoesConc()
        .subscribe((orientacoes) => {
          this.orientacoes = orientacoes
          this.gerarGraficoOrientacoes()
          this.graficoRenderizou = true;
        });
    }
    else if(this.tipo === "unid"){
      this.unidService.orientacoesConcByIdUnidade(this.route.snapshot.params['id'])
        .subscribe((orientacoes) => {
          this.orientacoes = orientacoes
          this.gerarGraficoOrientacoes()
          this.graficoRenderizou = true;
        });
    }
    else if(this.tipo === "depto"){
      this.deptoService.orientacoesConcByIdDepto(this.route.snapshot.params['id'])
        .subscribe((orientacoes) => {
          this.orientacoes = orientacoes
          this.gerarGraficoOrientacoes()
          this.graficoRenderizou = true;
        });
    }
  }

  gerarGraficoOrientacoes(){

    var dptsMest = [];
    var dptsDout = [];
    var dptsPosDout = [];
    var dptsOutras = [];

    this.orientacoes.map((orientacoesAno) =>{

    let mest = {x: new Date(), y: 0}
    let dout = {x: new Date(), y: 0}
    let posDout = {x: new Date(), y: 0}
    let outras = {x: new Date(), y: 0}

    mest.y = orientacoesAno.totalMest;
    mest.x = new Date(orientacoesAno.ano, 0);
    dout.y = orientacoesAno.totalDout;
    dout.x = new Date(orientacoesAno.ano, 0);
    posDout.y = orientacoesAno.totalPosDout;
    posDout.x = new Date(orientacoesAno.ano, 0);
    outras.y = orientacoesAno.totalOutra;
    outras.x = new Date(orientacoesAno.ano, 0);

    dptsMest.push(mest);
    dptsDout.push(dout);
    dptsPosDout.push(posDout);
    dptsOutras.push(outras);
    })

    var chart = new CanvasJS.Chart("chartContainerOrient", {
    animationEnabled: true,
    exportEnabled: true,
    backgroundColor: "transparent",
    title: false,
    // axisX: {
    //     interval: 1,
    //     intervalType: "year"
    // },
    axisY:{
        gridColor: "#B6B1A8",
        tickColor: "#B6B1A8"
    },
    toolTip: {
        shared: true,
        content: toolTipContent
    },
    data: [{
        type: "stackedColumn",
        showInLegend: true,
        name: "Pós Doutorado",
        dataPoints: dptsPosDout
        },
        {        
        type: "stackedColumn",
        showInLegend: true,
        name: "Doutorado",
        dataPoints: dptsDout
        },
        {        
        type: "stackedColumn",
        showInLegend: true,
        name: "Mestrado",
        dataPoints: dptsMest
        },
        {        
        type: "stackedColumn",
        showInLegend: true,
        name: "Outras",
        dataPoints: dptsOutras
    }]
    });
    chart.render();
    // this.graficoOrientRenderizou = true;
    function toolTipContent(e) {
        var str = "";
        var total = 0;
        var str2, str3;
        for (var i = 0; i < e.entries.length; i++){
            if(e.entries[i].dataPoint.y > 0){
            var  str1 = "<span style= \"color:"+e.entries[i].dataSeries.color + "\"> "+e.entries[i].dataSeries.name+"</span>: <strong>"+e.entries[i].dataPoint.y+"</strong><br/>";
            total = e.entries[i].dataPoint.y + total;
            str = str.concat(str1);
            }
        }
        str2 = "<span style = \"color:DodgerBlue;\"><strong>"+(e.entries[0].dataPoint.x).getFullYear()+"</strong></span><br/>";
        str3 = "<span style = \"color:Blue\">Total:</span><strong>"+total+"</strong><br/>";
        return (str2.concat(str)).concat(str3);
    }
  }

}
