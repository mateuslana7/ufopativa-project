import {Routes} from '@angular/router'

import { HomeComponent } from './home/home.component'
import { RelevantDataComponent } from './relevant-data/relevant-data.component'
import {PessoaComponent} from './pessoas/pessoa/pessoa.component'
import {UnidadeComponent} from './unidades/unidade/unidade.component'
import {DepartamentoComponent} from './unidades/departamentos/departamento/departamento.component'
import {UnidadesComponent} from './unidades/unidades.component'
import {DepartamentosComponent} from './unidades/departamentos/departamentos.component'
import {PessoasComponent} from './pessoas/pessoas.component'

import {LoadingComponent} from './shared/loading/loading.component'

export const ROUTES: Routes = [
	{path: '', component: HomeComponent},
	{path: 'sobre', loadChildren: './static-information/static-information.module#StaticInformationModule'},
	// {path: 'dados-relevantes', loadChildren: './relevant-data/relevant-data.module#RelevantDataComponent'},
	{path: 'dados-relevantes', component: RelevantDataComponent},
	{path: 'fale-conosco', loadChildren: './static-information/static-information.module#StaticInformationModule'},
	{path: 'unidade-academica', component: UnidadeComponent},//TIRAR DEPOIS
	{path: 'departamento-academico', component: DepartamentoComponent},
	{path: 'unidades', component: UnidadesComponent},
	{path: 'unidades/:id', component: UnidadeComponent},
	{path: 'departamentos', component: DepartamentosComponent},
	{path: 'departamentos/:id', component: DepartamentoComponent},
	{path: 'pessoas', component: PessoasComponent},
	{path: 'pessoas/:id', component: PessoaComponent},
	{path: 'loading', component: LoadingComponent}
]