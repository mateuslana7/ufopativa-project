import { Component, OnInit, Input } from '@angular/core';
import {Area} from './area/area.model'

@Component({
  selector: 'ua-areas',
  templateUrl: './areas.component.html',
  styleUrls: ['./areas.component.css']
})
export class AreasComponent implements OnInit {

  @Input() areas: Area[]
  icons: String[]

  constructor() {
    // for(let i=0; i<this.areas.length; i++){
    //   this.icons.push("+");
    // }
    // console.log(this.icons)
  }

  ngOnInit() {
    for(let i=0; i<this.areas.length; i++){
      this.icons.push("+");
    }
    // console.log(this.icons)
  }

  textoDoBotao(area){
    if(area.especialidade.length > 0)
      return area.especialidade
    // if(area.subArea){
    //   console.log("EEEEEEEEEEEEEENNNNNNNNNNNNNNNNNNTTTTTTTTTTTTTTTTRRRRRRRRRRRRRRRRROOOOOOOOOOOOOOUUUUUUUUUUUUU")
    //   return area.subArea
    // }
    return " "
  }

  //CRIAR FILTROS PARA CORRIGIR PALAVRAS
  grandeAreaFilter(area){
    return area.replace(/_/g, " ");
  }

  changeIcon(index){
    if(this.icons[index] === "+")
      this.icons[index] = "-";
    else
      this.icons[index] = "+";
  }

}
