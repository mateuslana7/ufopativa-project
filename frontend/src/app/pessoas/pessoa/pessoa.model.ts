import {Area} from '../areas/area/area.model'

export interface Pessoa {
	id: number
	dataAtualizacao: Date
	idLattes: String
	nomeCompleto: String
	linkPerfil: String
	linkLattes: String
	possuiLattes: String
	nomesCitacoes: String[]
	tipo: String
	deptoUnid: DeptoUnid
}

export interface Unid {
	id: number
	nome: String
	sigla: String
}

export interface DeptoUnid {
	id: number
	nome: String
	unidade: Unid
}