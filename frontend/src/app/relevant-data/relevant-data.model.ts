export interface Numeros {
    totalServidores: number
    totalUnidades: number
    totalDepartamentos: number
    totalServComLattes: number
}

export interface Unidade {
    id: number
    nome: String
    totalServidores: number
}

export interface ProducaoBib {
    ano: number
    totalArtigos: number
    totalTrabsEv: number
    totalLivros: number
    totalCapsLivro: number
    totalOutras: number
}

export interface OrientacaoConc {
    ano: number
    totalMest: number
    totalDout: number
    totalPosDout: number
    totalOutra: number
}