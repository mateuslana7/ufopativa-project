export interface Unidade {
	id: number
	nome: string
	sigla: string
	totalServidores: number
	totalServComLattes: number
}

export interface Departamento{
	id: number
	nome: String
	sigla: String
	taotalServidores: number
}

export interface ServidorSemDepto {
	id: number
	nomeCompleto: string
}