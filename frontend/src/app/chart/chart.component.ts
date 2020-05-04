import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'ua-chart',
  templateUrl: './chart.component.html'
})
export class ChartComponent implements OnInit {

  @Input() tipo: String

  constructor() {}

  ngOnInit() {
  }
}
