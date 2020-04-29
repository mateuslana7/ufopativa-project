import {Unidade} from '../../unidade/unidade.model'

export interface Departamento {
	id: number
	nome: string
	sigla: string
	unidade: Unidade
	totalServComLattes: number
}

export interface Servidor {
	id: number
	nomeCompleto: String
}