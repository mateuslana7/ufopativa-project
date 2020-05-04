import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router'

import { PessoasService } from '../pessoas.service'
import { Pessoa } from './pessoa.model'
import { PalavraChave } from '../palavras-chaves/palavra-chave/palavra-chave.model'
import { Area } from '../areas/area/area.model'
import { Producoes } from '../../producoes/producoes.model'
import { OrientacaoConcluida } from '../orientacoes-concluidas/orientacoes-concluidas.model'
import { FormacaoAcademica } from '../formacoes-academicas/formacoes-academicas.model'
import { ProjetoDePesquisa } from '../projetos-de-pesquisa/projetos-de-pesquisa.model'
import { OrientacaoConc, ProducaoBib } from 'src/app/relevant-data/relevant-data.model';

import * as CanvasJS from '../../../assets/canvasjs/canvasjs.min';
// import * as CanvasJS from 'canvasjs/dist/canvasjs.min';

@Component({
  selector: 'ua-pessoa',
  templateUrl: './pessoa.component.html',
  styleUrls: ['./pessoa.component.css']
})
export class PessoaComponent implements OnInit {
  
  pessoa: Pessoa
  palavrasChaves: PalavraChave[]
  areas: Area[]
  producoes: Producoes
  orientacoes: OrientacaoConcluida
  orientacoesConc: OrientacaoConc[]
  formacoesAcad: FormacaoAcademica[]
  projetosPesq: ProjetoDePesquisa[]
  producoesBib: ProducaoBib[]
  comandoDoBotao: String

  // reqErro: Boolean
  // errorMsg: String

  constructor(private pessoaService: PessoasService, private route: ActivatedRoute) {
    this.comandoDoBotao = "Visualizar"
  }


  ngOnInit() {
  	this.pessoaService.pessoaById(this.route.snapshot.params['id']).subscribe(pessoa => {
      this.pessoa = pessoa;
    }, err =>{
      // this.reqErro = true
      // this.errorMsg = "Página não encontrada!";
    })
    this.loadPalavrasChaves();
    this.loadAreas();
    this.loadProducoes();
    this.loadOrientacoes();
    this.loadProducoesBib();
    this.loadFormacoesAcademicas();
    this.loadProjetosDePesquisa();
  }

  loadPalavrasChaves(){
    this.pessoaService.palavrasChavesByIdPessoa(this.route.snapshot.params['id']).subscribe(palavrasChaves => {
      //carregou as palavras chaves
      this.palavrasChaves = palavrasChaves
    }, err => {
      //erro na requisicao.
    })
  }

  loadAreas(){
    this.pessoaService.areasByIdPessoa(this.route.snapshot.params['id']).subscribe(areas => {
      //carregou as areas 
      this.areas = areas
    }, err => {
      //erro na requisicao.
    })
  }

  loadFormacoesAcademicas(){
    this.pessoaService.formacoesByIdPessoa(this.route.snapshot.params['id']).subscribe(formacoesAcad => {
      //carregou as formacoes academicas
      this.formacoesAcad = formacoesAcad
    }, err => {
      //erro na requisicao.
    })
  }

  loadProjetosDePesquisa(){
    this.pessoaService.projetosByIdPessoa(this.route.snapshot.params['id']).subscribe(projetosPesq => {
      //carregou os projetos de pesquisa
      this.projetosPesq = projetosPesq
    }, err => {
      //erro na requisicao.
    })
  }

  loadProducoes(){
    this.pessoaService.producoesByIdPessoa(this.route.snapshot.params['id']).subscribe(producoes => {
      //carregou a producao bibligrafica
      this.producoes = producoes
    }, err => {
      //erro na requisicao.
    })
  }

  loadOrientacoes(){
    this.pessoaService.orientacoesByIdPessoa(this.route.snapshot.params['id']).subscribe(orientacoesConc => {
      this.orientacoesConc = orientacoesConc
      this.setQuantOrientacoes();
      // this.gerarGraficoOrientacoes();
    }, err => {
      //erro na requisicao.
    })
  }

  loadProducoesBib(){
    this.pessoaService.producoesBibByIdPessoa(this.route.snapshot.params['id']).subscribe(producoesBib => {
      this.producoesBib = producoesBib
    }, err => {
      //erro na requisicao.
    })
  }

  setQuantOrientacoes(){
    var obj = {mest: 0, dout: 0, posDout: 0, outra: 0}
    var mest=0
    var dout=0
    var posDout=0
    var outra=0

    this.orientacoesConc.map((orientacao) => {
      mest += orientacao.totalMest
      dout += orientacao.totalDout
      posDout += orientacao.totalPosDout
      outra += orientacao.totalOutra
    })
    
    obj.mest = mest;
    obj.dout = dout;
    obj.posDout = posDout;
    obj.outra = outra;

    this.orientacoes = obj;
    
  }

  gerarGraficoOrientacoes(){

    if(this.comandoDoBotao === "Visualizar")
      this.comandoDoBotao = "Ocultar"
    else
      this.comandoDoBotao = "Visualizar"

    var dptsMest = [];
    var dptsDout = [];
    var dptsPosDout = [];
    var dptsOutras = [];

    this.orientacoesConc && this.orientacoesConc.map((orientacoesAno) =>{

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

    var chart = new CanvasJS.Chart("chartContainer", {
    animationEnabled: true,
    exportEnabled: true,
    backgroundColor: "transparent",
    title: false,
    axisX: {
        interval: 1,
        intervalType: "year"
    },
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
    setTimeout(() => { chart.render(); }, 300)
    // chart.render();
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

  gerarGraficoProdBib(){
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
    setTimeout(() => { chart.render(); }, 300)
    // chart.render();
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
