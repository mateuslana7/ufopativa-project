import { Component, OnInit, Input } from '@angular/core';
import { Producoes } from './producoes.model';

@Component({
  selector: 'ua-producoes',
  templateUrl: './producoes.component.html'
})
export class ProducoesComponent implements OnInit {

  @Input() producoes: Producoes;
  // tiposProducoes: string[]

  icon: String

  constructor() {
    this.icon = "+"
  }

  ngOnInit() {
  }

  temProducoesBib(){
    return (this.producoes.Artigo || this.producoes.TrabalhoEmEvento || this.producoes.Livro || this.producoes.CapituloDeLivro || this.producoes.OutraProducaoBibliografica);
  }

  temProducoesTec(){
    return (this.producoes.Software || this.producoes.ProdutoTecnologico || this.producoes.Patente || this.producoes.TrabalhoTecnico || this.producoes.OutraProducaoTecnica);
  }

  temProducoesArtCult(){
    return (this.producoes.ArteCenica || this.producoes.ArteVisual || this.producoes.Musica || this.producoes.OutraProducaoArtisticaCultural);
  }  

}
