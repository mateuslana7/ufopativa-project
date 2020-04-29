import {NgModule, ModuleWithProviders} from '@angular/core'

import {PessoasService} from '../pessoas/pessoas.service'
import {UnidadesService} from '../unidades/unidades.service'
import {DepartamentosService} from '../unidades/departamentos/departamentos.service'
import {RelevantDataService} from '../relevant-data/relevant-data.service'
import { SearchBarService } from '../shared/search-bar/search-bar.service'

@NgModule({
    providers: [PessoasService, UnidadesService, DepartamentosService, RelevantDataService, SearchBarService]
})


export class CoreModule {
    
}