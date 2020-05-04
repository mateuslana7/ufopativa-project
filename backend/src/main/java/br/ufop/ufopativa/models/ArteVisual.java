package br.ufop.ufopativa.models;

import javax.persistence.Entity;

@Entity
public class ArteVisual extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String nomePremiacao;
	private String instituicaoPromotoraPremiacao;
	private String instituicaoPromotoraEvento;
	private String localEvento;
	private String temporada;
	
	private String atividadeAutores;
	private String cidadeEvento;

	public ArteVisual() {
		
	}
	
	public ArteVisual(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String nomePremiacao,
			String instituicaoPromotoraPremiacao, String instituicaoPromotoraEvento, String localEvento, String temporada,
			String atividadeAutores, String cidadeEvento) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.nomePremiacao = nomePremiacao;
		this.instituicaoPromotoraPremiacao = instituicaoPromotoraPremiacao;
		this.instituicaoPromotoraEvento = instituicaoPromotoraEvento;
		this.localEvento = localEvento;
		this.temporada = temporada;
		this.atividadeAutores = atividadeAutores;
		this.cidadeEvento = cidadeEvento;
	}

	public String getNomePremiacao() {
		return nomePremiacao;
	}

	public void setNomePremiacao(String nomePremiacao) {
		this.nomePremiacao = nomePremiacao;
	}

	public String getInstituicaoPromotoraPremiacao() {
		return instituicaoPromotoraPremiacao;
	}

	public void setInstituicaoPromotoraPremiacao(String instituicaoPromotoraPremiacao) {
		this.instituicaoPromotoraPremiacao = instituicaoPromotoraPremiacao;
	}

	public String getInstituicaoPromotoraEvento() {
		return instituicaoPromotoraEvento;
	}

	public void setInstituicaoPromotoraEvento(String instituicaoPromotoraEvento) {
		this.instituicaoPromotoraEvento = instituicaoPromotoraEvento;
	}

	public String getLocalEvento() {
		return localEvento;
	}

	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	
	public String getAtividadeAutores() {
		return atividadeAutores;
	}

	public void setAtividadeAutores(String atividadeAutores) {
		this.atividadeAutores = atividadeAutores;
	}

	public String getCidadeEvento() {
		return cidadeEvento;
	}

	public void setCidadeEvento(String cidadeEvento) {
		this.cidadeEvento = cidadeEvento;
	}
}
