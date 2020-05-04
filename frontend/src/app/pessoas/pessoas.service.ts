import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'

import { Observable } from 'rxjs'
import { catchError } from 'rxjs/operators'
// import 'rxjs/add/operator/catch'

import {Pessoa} from './pessoa/pessoa.model'
import {PalavraChave} from './palavras-chaves/palavra-chave/palavra-chave.model'
import {Area} from './areas/area/area.model'
import {FormacaoAcademica} from './formacoes-academicas/formacoes-academicas.model'
import {ProjetoDePesquisa} from './projetos-de-pesquisa/projetos-de-pesquisa.model'
import {Producoes} from '../producoes/producoes.model'
import {OrientacaoConc, ProducaoBib} from '../relevant-data/relevant-data.model'

import {UA_API} from '../app.api'
import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class PessoasService {
	constructor(private http: HttpClient){}

	pessoas(): Observable<Pessoa[]>{
		return this.http.get<Pessoa[]>(`${UA_API}/pessoas`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	pessoaById(id: number): Observable<Pessoa>{
		return this.http.get<Pessoa>(`${UA_API}/pessoas/${id}`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	palavrasChavesByIdPessoa(id: number): Observable<PalavraChave[]>{
		return this.http.get<PalavraChave[]>(`${UA_API}/pessoas/${id}/palavras-chaves`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	areasByIdPessoa(id: number): Observable<Area[]>{
		return this.http.get<Area[]>(`${UA_API}/pessoas/${id}/areas`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	formacoesByIdPessoa(id: number): Observable<FormacaoAcademica[]>{
		return this.http.get<FormacaoAcademica[]>(`${UA_API}/pessoas/${id}/formacoes-acad`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	projetosByIdPessoa(id: number): Observable<ProjetoDePesquisa[]>{
		return this.http.get<ProjetoDePesquisa[]>(`${UA_API}/pessoas/${id}/projetos-pesq`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	producoesByIdPessoa(id: number): Observable<Producoes>{
		return this.http.get<Producoes>(`${UA_API}/pessoas/${id}/producoes`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	producoesBibByIdPessoa(id: number): Observable<ProducaoBib[]>{
		return this.http.get<ProducaoBib[]>(`${UA_API}/pessoas/${id}/producoes-bib`)
	}

	orientacoesByIdPessoa(id: number): Observable<OrientacaoConc[]>{
		return this.http.get<OrientacaoConc[]>(`${UA_API}/pessoas/${id}/orientacoes`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}
}