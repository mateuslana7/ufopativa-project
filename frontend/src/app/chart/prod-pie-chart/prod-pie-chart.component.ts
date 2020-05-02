import { Component, OnInit } from '@angular/core';
import * as CanvasJS from '../../../assets/canvasjs/canvasjs.min'
import { RelevantDataService } from 'src/app/relevant-data/relevant-data.service';
import { ProducaoBib } from '../../relevant-data/relevant-data.model';

@Component({
  selector: 'ua-prod-pie-chart',
  templateUrl: './prod-pie-chart.component.html',
  styleUrls: ['./prod-pie-chart.component.css']
})
export class ProdPieChartComponent implements OnInit {

  producoes: ProducaoBib[]
  graficoRenderizou: Boolean

  constructor(private relevantDataService: RelevantDataService) { 
    this.graficoRenderizou = false
  }

  ngOnInit() {
    this.relevantDataService.producoesBib()
        .subscribe((producoes) => {
          this.producoes = producoes
          this.gerarGraficoProdBibPorTipo()
          this.graficoRenderizou = true;
        });
  }

  gerarGraficoProdBibPorTipo(){
    var dptsProdBib = [];

    var art = {y: 0, label: new String}
    var capLivro = {y: 0, label: new String}
    var outraProd = {y: 0, label: new String}
    var trabEv = {y: 0, label: new String}
    var livro = {y: 0, label: new String}


    this.producoes.map((producoesAno) => {
      art.y += producoesAno.totalArtigos;
      capLivro.y += producoesAno.totalCapsLivro;
      outraProd.y += producoesAno.totalOutras;
      trabEv.y += producoesAno.totalTrabsEv;
      livro.y += producoesAno.totalLivros;
    })

    art.label = "Artigos";
    capLivro.label = "Capítulos de Livros";
    outraProd.label = "Outras Produções Bibliográficas";
    trabEv.label = "Trabalhos em Eventos";
    livro.label = "Livros";

    dptsProdBib.push(art);
    dptsProdBib.push(capLivro);
    dptsProdBib.push(outraProd);
    dptsProdBib.push(trabEv);
    dptsProdBib.push(livro);

    var chart = new CanvasJS.Chart("chartContainerProdBibPorTipo", {
      backgroundColor: "transparent",
      exportEnabled: true,
      animationEnabled: true,
      title: false,
      data: [{
        type: "pie",
        startAngle: 25,
        indexLabelFontSize: 16,
        indexLabel: "{label}",
        dataPoints: dptsProdBib
      }]
    });
    chart.render();
  }

}
