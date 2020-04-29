import { Component, OnInit, Input } from '@angular/core';
import {PalavraChave} from './palavras-chaves.model'

@Component({
  selector: 'ua-palavras-chaves',
  templateUrl: './palavras-chaves.component.html',
  styleUrls: ['./palavras-chaves.component.css']
})
export class PalavrasChavesComponent implements OnInit {

  @Input() palavrasChaves: PalavraChave[]

  constructor() { }

  ngOnInit() {
  }

  key: string = 'numeroUtilizacoes';
  reverse: boolean = true;
  sort(key) {
      this.key = key;
      this.reverse = !this.reverse;
  }
}
