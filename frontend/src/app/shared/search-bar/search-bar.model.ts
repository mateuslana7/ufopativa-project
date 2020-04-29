export interface Resultado {
    servidores: Modelo[]
    unidades: Modelo[]
    departamentos: Modelo[]
}

export interface Modelo {
    id: number
    nome: String
}