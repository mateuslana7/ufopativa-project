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
	departamento: Depto
	unidade: Unid
}

export interface Unid {
	id: number
	nome: String
	sigla: String
}

export interface Depto {
	id: number
	nome: String
}