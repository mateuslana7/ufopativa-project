import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'

import {Observable} from 'rxjs'
import { catchError } from 'rxjs/operators'
import {UA_API} from '../app.api'

import { Numeros, Unidade, ProducaoBib, OrientacaoConc } from './relevant-data.model'
import {ErrorHandler} from '../app.error-handler'

@Injectable()
export class RelevantDataService {
	constructor(private http: HttpClient){}

	numeros(): Observable<Numeros>{
		return this.http.get<Numeros>(`${UA_API}/dados-relevantes`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	unidades(): Observable<Unidade[]>{
		return this.http.get<Unidade[]>(`${UA_API}/dados-relevantes/unidades`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	producoesBib(): Observable<ProducaoBib[]>{
		return this.http.get<ProducaoBib[]>(`${UA_API}/dados-relevantes/producoes-bib`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}

	orientacoesConc(): Observable<OrientacaoConc[]>{
		return this.http.get<OrientacaoConc[]>(`${UA_API}/dados-relevantes/orientacoes-conc`).pipe(
			catchError(ErrorHandler.handleError)
		);
	}
}