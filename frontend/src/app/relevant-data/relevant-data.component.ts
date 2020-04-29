import { Component, OnInit } from '@angular/core';
import { RelevantDataService } from './relevant-data.service';
import * as CanvasJS from '../../assets/canvasjs/canvasjs.min';

import { Numeros, Unidade, ProducaoBib, OrientacaoConc } from './relevant-data.model'

@Component({
  selector: 'ua-relevant-data',
  templateUrl: './relevant-data.component.html',
  styleUrls: ['./relevant-data.component.css']
})
export class RelevantDataComponent implements OnInit {

  numeros: Numeros
  unidades: Unidade[]
  producoesBib: ProducaoBib[]
  orientacoesConc: OrientacaoConc[]
  totalServidoresEmUnidades: number
  graficoProdBibRenderizou: Boolean
  graficoOrientConcRenderizou: Boolean

  constructor(private relevantDataService: RelevantDataService) {
    this.graficoProdBibRenderizou = false
    this.graficoOrientConcRenderizou = false
  }

  ngOnInit() {
    this.getNumeros();
    this.getUnidades();
    this.getProducoesBib();
    this.getOrientacoesConc();
  }

  getNumeros(){
  	this.relevantDataService.numeros()
  		.subscribe((numeros) => {
        this.numeros = numeros
        this.calculaPercentServComLattes()
      })
  }

  getUnidades(){
  	this.relevantDataService.unidades()
  		.subscribe((unidades) => {
        this.unidades = unidades
        this.setTotalServidoresEmUnidades()
        this.mostraGraficoServidores()
      })
  }

  setTotalServidoresEmUnidades(){
    var total = 0;
    this.unidades.map((unid) => {
      total += unid.totalServidores;
    })
    this.totalServidoresEmUnidades = total;
  }

  calculaPercentServ(value){
      return ((value/this.numeros.totalServidores)*100).toFixed(2);
  }

  calculaPercentServComLattes(){
    return ((this.numeros.totalServComLattes/this.numeros.totalServidores)*100).toFixed(2);
  }

  getProducoesBib(){
  	this.relevantDataService.producoesBib()
      .subscribe((producoesBib) => {
        this.producoesBib = producoesBib
        this.mostraGraficoProdBib()
        this.mostraGraficoProdBibPorTipo()
      });
  }

  getOrientacoesConc(){
  	this.relevantDataService.orientacoesConc()
      .subscribe((orientacoesConc) => {
        this.orientacoesConc = orientacoesConc
        this.mostraGraficoOrientacoes()
      });
  }

  mostraGraficoProdBib(){
    var dptsArt = [];
    var dptsOutras = [];
    var dptsCapLivro = [];
    var dptsLivro = [];
    var dptsTrabEv = [];

    this.producoesBib.map((producoesAno) =>{

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
    this.graficoProdBibRenderizou = true
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

  mostraGraficoOrientacoes(){

    var dptsMest = [];
    var dptsDout = [];
    var dptsPosDout = [];
    var dptsOutras = [];

    this.orientacoesConc.map((orientacoesAno) =>{

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
    this.graficoOrientConcRenderizou = true
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

  mostraGraficoServidores(){
    var dptsServ = [];

    this.unidades.map((unid) => {
      let data = {y: 0, label: new String}
      data.y = unid.totalServidores;
      data.label = unid.nome;
      dptsServ.push(data);
    })

    var chart = new CanvasJS.Chart("chartContainerServ", {
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

  mostraGraficoProdBibPorTipo(){
    var dptsProdBib = [];

    var art = {y: 0, label: new String}
    var capLivro = {y: 0, label: new String}
    var outraProd = {y: 0, label: new String}
    var trabEv = {y: 0, label: new String}
    var livro = {y: 0, label: new String}


    this.producoesBib.map((producoesAno) => {
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

  key: string = 'totalServidores';
  reverse: boolean = true;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }

}
