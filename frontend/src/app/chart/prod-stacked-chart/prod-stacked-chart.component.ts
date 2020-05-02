import { Component, OnInit, Input } from '@angular/core';
import { ProducaoBib } from '../../relevant-data/relevant-data.model'

import * as CanvasJS from '../../../assets/canvasjs/canvasjs.min'
import { UnidadesService } from '../../unidades/unidades.service';
import { DepartamentosService } from '../../unidades/departamentos/departamentos.service'
import { ActivatedRoute } from '@angular/router';
import { RelevantDataService } from 'src/app/relevant-data/relevant-data.service';

@Component({
  selector: 'ua-prod-stacked-chart',
  templateUrl: './prod-stacked-chart.component.html',
  styleUrls: ['./prod-stacked-chart.component.css']
})
export class ProdStackedChartComponent implements OnInit {

  @Input() tipo: String
  producoes: ProducaoBib[]
  graficoRenderizou: Boolean

  constructor(private relevantDataService: RelevantDataService, private unidService: UnidadesService, private deptoService: DepartamentosService, private route: ActivatedRoute) {
    this.graficoRenderizou = false
  }

  ngOnInit() {
    if(this.tipo === "total"){
      this.relevantDataService.producoesBib()
        .subscribe((producoes) => {
          this.producoes = producoes
          this.gerarGraficoProdBib()
          this.graficoRenderizou = true;
        });
    }
    else if(this.tipo === "unid"){
      this.unidService.producoesBibByIdUnidade(this.route.snapshot.params['id'])
        .subscribe((producoes) => {
          this.producoes = producoes
          this.gerarGraficoProdBib()
          this.graficoRenderizou = true;
        });
    }
    else if(this.tipo === "depto"){
      this.deptoService.producoesBibByIdDepto(this.route.snapshot.params['id'])
        .subscribe((producoes) => {
          this.producoes = producoes
          this.gerarGraficoProdBib()
          this.graficoRenderizou = true;
        });
    }
  }

  gerarGraficoProdBib(){
    var dptsArt = [];
    var dptsOutras = [];
    var dptsCapLivro = [];
    var dptsLivro = [];
    var dptsTrabEv = [];

    this.producoes.map((producoesAno) =>{

      let art = {x: new Date(), y: 0}
      let outraProd = {x: new Date(), y: 0}
      let trabEv = {x: new Date(), y: 0}
      let capLivro = {x: new Date(), y: 0}
      let livro = {x: new Date(), y: 0}

      art.y = producoesAno.totalArtigos;
      outraProd.y = producoesAno.totalOutras;
      trabEv.y = producoesAno.totalTrabsEv;
      capLivro.y = producoesAno.totalCapsLivro;
      livro.y = producoesAno.totalLivros;

      if(producoesAno.ano !== null)
      {
        art.x = new Date(producoesAno.ano, 0);
        outraProd.x = new Date(producoesAno.ano, 0);
        trabEv.x = new Date(producoesAno.ano, 0);
        capLivro.x = new Date(producoesAno.ano, 0);
        livro.x = new Date(producoesAno.ano, 0);
      }

      dptsArt.push(art);
      dptsOutras.push(outraProd);
      dptsCapLivro.push(capLivro);
      dptsLivro.push(livro);
      dptsTrabEv.push(trabEv);
    })

    var chart = new CanvasJS.Chart("chartContainerProdBib", {
      animationEnabled: true,
      exportEnabled: true,
      backgroundColor: "transparent",
      title: false,
      // axisX: {
      //   interval: 2,
      //   intervalType: "year"
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
          name: "Trabalhos em Eventos",
          dataPoints: dptsTrabEv
        },
        {        
          type: "stackedColumn",
          showInLegend: true,
          name: "Livros",
          dataPoints: dptsLivro
        },
        {        
          type: "stackedColumn",
          showInLegend: true,
          name: "Capítulos de Livros",
          dataPoints: dptsCapLivro
        },
        {        
          type: "stackedColumn",
          showInLegend: true,
          name: "Outras Produções Bibliográficas",
          dataPoints: dptsOutras
        },
        {        
          type: "stackedColumn",
          showInLegend: true,
          name: "Artigos",
          dataPoints: dptsArt
        }
    ]
    });
    chart.render();
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