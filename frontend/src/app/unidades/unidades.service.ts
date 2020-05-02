import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs'
import {catchError} from 'rxjs/operators'

import {Unidade, Departamento, ServidorSemDepto} from './unidade/unidade.model'
import { ProducaoBib, OrientacaoConc } from '../relevant-data/relevant-data.model'

import {UA_API} from '../app.api'

import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class UnidadesService {
	constructor(private http: HttpClient){}

	unidades(): Observable<Unidade[]>{
		return this.http.get<Unidade[]>(`${UA_API}/unidades`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	unidadeById(id: number): Observable<Unidade>{
		return this.http.get<Unidade>(`${UA_API}/unidades/${id}`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	departamentosByIdUnidade(id: number): Observable<Departamento[]>{
		return this.http.get<Departamento[]>(`${UA_API}/unidades/${id}/departamentos`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	servsSemDeptoByIdUnidade(id: number): Observable<ServidorSemDepto[]>{
		return this.http.get<ServidorSemDepto[]>(`${UA_API}/unidades/${id}/servs-sem-depto`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	orientacoesConcByIdUnidade(id: number): Observable<OrientacaoConc[]>{
		return this.http.get<OrientacaoConc[]>(`${UA_API}/unidades/${id}/orientacoes-conc`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	producoesBibByIdUnidade(id: number): Observable<ProducaoBib[]>{
		return this.http.get<ProducaoBib[]>(`${UA_API}/unidades/${id}/producoes-bib`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}
}