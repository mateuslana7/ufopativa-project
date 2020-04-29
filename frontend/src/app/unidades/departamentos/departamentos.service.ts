import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'

import { Observable } from 'rxjs'
import { catchError } from 'rxjs/operators'

import {Departamento, Servidor} from './departamento/departamento.model'

import {UA_API} from '../../app.api'
import { OrientacaoConc, ProducaoBib } from 'src/app/relevant-data/relevant-data.model'
import {ErrorHandler} from '../../app.error-handler'

@Injectable()
export class DepartamentosService {
	constructor(private http: HttpClient){}

	departamentos(): Observable<Departamento[]>{
		return this.http.get<Departamento[]>(`${UA_API}/departamentos`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	departamentoById(id: number): Observable<Departamento>{
		return this.http.get<Departamento>(`${UA_API}/departamentos/${id}`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	servidoresByIdDepartamento(id: number): Observable<Servidor[]>{
		return this.http.get<Servidor[]>(`${UA_API}/departamentos/${id}/servidores`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	orientacoesConcByIdDepto(id: number): Observable<OrientacaoConc[]>{
		return this.http.get<OrientacaoConc[]>(`${UA_API}/departamentos/${id}/orientacoes-conc`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	producoesBibByIdDepto(id: number): Observable<ProducaoBib[]>{
		return this.http.get<ProducaoBib[]>(`${UA_API}/departamentos/${id}/producoes-bib`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}
}