import { BrowserModule } from '@angular/platform-browser';
import { NgModule, LOCALE_ID } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms'
import { RouterModule, PreloadAllModules } from '@angular/router'
import { HttpClientModule } from '@angular/common/http'
import { OrderModule } from 'ngx-order-pipe'; 
import { StaticInformationModule } from './static-information/static-information.module'
// import { RelevantDataModule } from './relevant-data/relevant-data.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component'
import { RelevantDataComponent } from './relevant-data/relevant-data.component'
import { HeaderComponent } from './header/header.component';

import {ROUTES} from './app.routes';

// Components
import { PessoasComponent } from './pessoas/pessoas.component';
import { PessoaComponent } from './pessoas/pessoa/pessoa.component';
import { UnidadesComponent } from './unidades/unidades.component';
import { UnidadeComponent } from './unidades/unidade/unidade.component';
import { DepartamentosComponent } from './unidades/departamentos/departamentos.component';
import { DepartamentoComponent } from './unidades/departamentos/departamento/departamento.component';
import { AreasComponent } from './pessoas/areas/areas.component';
import { FormacoesAcademicasComponent } from './pessoas/formacoes-academicas/formacoes-academicas.component';
import { ProjetosDePesquisaComponent } from './pessoas/projetos-de-pesquisa/projetos-de-pesquisa.component';
import { AreaComponent } from './pessoas/areas/area/area.component';
import { ProducoesComponent } from './producoes/producoes.component';
import { ProducaoComponent } from './producoes/producao/producao.component';
import { OrientacoesConcluidasComponent } from './pessoas/orientacoes-concluidas/orientacoes-concluidas.component';
import { PalavrasChavesComponent } from './pessoas/palavras-chaves/palavras-chaves.component';
import { ChartComponent } from './chart/chart.component';

//Services
import {CoreModule} from './core/core.module';
import { LoadingComponent } from './shared/loading/loading.component';
import { SearchBarComponent } from './shared/search-bar/search-bar.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { ResultComponent } from './shared/search-bar/result/result.component';
import { PieChartComponent } from './chart/pie-chart/pie-chart.component';
import { ProdStackedChartComponent } from './chart/prod-stacked-chart/prod-stacked-chart.component';
import { OrientStackedChartComponent } from './chart/orient-stacked-chart/orient-stacked-chart.component';
import { ProdPieChartComponent } from './chart/prod-pie-chart/prod-pie-chart.component';








@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    RelevantDataComponent,
    PessoasComponent,
    PessoaComponent,
    UnidadesComponent,
    UnidadeComponent,
    DepartamentosComponent,
    DepartamentoComponent,
    AreasComponent,
    FormacoesAcademicasComponent,
    ProjetosDePesquisaComponent,
    AreaComponent,
    ProducoesComponent,
    ProducaoComponent,
    OrientacoesConcluidasComponent,
    ChartComponent,
    PalavrasChavesComponent,
    LoadingComponent,
    SearchBarComponent,
    ResultComponent,
    PieChartComponent,
    ProdStackedChartComponent,
    OrientStackedChartComponent,
    ProdPieChartComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    OrderModule,
    StaticInformationModule,
    // RelevantDataModule,
    CoreModule,
    RouterModule.forRoot(ROUTES, {preloadingStrategy: PreloadAllModules}),
    NoopAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
