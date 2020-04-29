import {Producao} from './producao/producao.model'

export interface Producoes {
	//Producao Bibliografica
	TrabalhoEmEvento: Producao[]
	Livro : Producao[]
	CapituloDeLivro: Producao[]
	Artigo: Producao[]
	OutraProducaoBibliografica: Producao[]

	//Producao Tecnica
	Software: Producao[]
	ProdutoTecnologico : Producao[]
	Patente: Producao[]
	TrabalhoTecnico: Producao[]
	OutraProducaoTecnica: Producao[]

	//Producao Artistica Cultural
	ArteCenica: Producao[]
	ArteVisual : Producao[]
	Musica: Producao[]
	OutraProducaoArtisticaCultural: Producao[]
}