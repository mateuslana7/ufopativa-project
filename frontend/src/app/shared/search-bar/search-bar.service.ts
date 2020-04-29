import {Injectable} from '@angular/core'
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs'
import { catchError } from 'rxjs/operators'

import { Resultado } from './search-bar.model'

import {UA_API} from '../../app.api'

import {ErrorHandler} from '../../app.error-handler'

@Injectable()
export class SearchBarService {

    constructor(private http: HttpClient){}
    
    pesquisa(textoPesq: string): Observable<Resultado> {
        return this.http.get<Resultado>(`${UA_API}/pesquisa?nome=${textoPesq}`).pipe(
			catchError(ErrorHandler.handleError)
		);
    }
}