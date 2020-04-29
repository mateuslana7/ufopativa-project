import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router'
import * as CanvasJS from '../../../../assets/canvasjs/canvasjs.min'

import {DepartamentosService} from '../departamentos.service'
import {Departamento, Servidor} from './departamento.model'
import { ProducaoBib, OrientacaoConc } from 'src/app/relevant-data/relevant-data.model';

@Component({
  selector: 'ua-departamento',
  templateUrl: './departamento.component.html',
  styleUrls: ['./departamento.component.css']
})
export class DepartamentoComponent implements OnInit {
  
  departamento: Departamento;
  servidores: Servidor[]
  producoesBib: ProducaoBib[]
  orientacoesConc: OrientacaoConc[]
  graficoProdBibRenderizou: Boolean
  graficoOrientConcRenderizou: Boolean

  constructor(private deptoService: DepartamentosService, private route: ActivatedRoute) {
    this.graficoProdBibRenderizou = false
    this.graficoOrientConcRenderizou = false
  }

  ngOnInit() {
  	this.deptoService.departamentoById(this.route.snapshot.params['id'])
  		.subscribe((departamento) => {
        this.departamento = departamento
        this.calculaPercentServComLattes()
      }) 
    
    this.loadServidores();
    this.getProducoesBib();
    this.getOrientacoesConc();
  }

  calculaPercentServComLattes(){
    return ((this.departamento.totalServComLattes/this.servidores.length)*100).toFixed(2);
  }

  loadServidores(){
    this.deptoService.servidoresByIdDepartamento(this.route.snapshot.params['id']).subscribe(servidores => {
      //carregou os servidores
      this.servidores = servidores
    }, err => {
      //erro na requisicao.
    })
  }

  getOrientacoesConc(){
  	this.deptoService.orientacoesConcByIdDepto(this.route.snapshot.params['id'])
      .subscribe(orientacoesConc => {
        this.orientacoesConc = orientacoesConc
        this.mostraGraficoOrientacoes()
    }, err => {
      //erro na requisicao.
    })
  }

  getProducoesBib(){
    this.deptoService.producoesBibByIdDepto(this.route.snapshot.params['id'])
      .subscribe(producoesBib => {
        this.producoesBib = producoesBib
        this.mostraGraficoProdBib()
    }, err => {
      //erro na requisicao.
    })
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


}
