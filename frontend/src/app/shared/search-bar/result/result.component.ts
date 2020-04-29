import { Component, OnInit, Input } from '@angular/core';

import { Modelo } from '../search-bar.model'

@Component({
  selector: 'ua-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  @Input() titulo: String
  @Input() valor: String
  @Input() resultado: Modelo[]

  constructor() { }

  ngOnInit() {
  }

}
