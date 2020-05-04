package br.ufop.ufopativa.models;

import javax.persistence.Entity;

@Entity
public class TrabalhoTecnico extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String instituicaoFinanciadora;
	private String finalidade;
	
	private String disponibilidade;
	private String duracao;
	private Integer numeroPaginas;
	private String cidade;
	
	public TrabalhoTecnico() {
		
	}
	
	

	public TrabalhoTecnico(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String instituicaoFinanciadora, 
			String finalidade, String disponibilidade, String duracao, Integer numeroPaginas, String cidade) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.instituicaoFinanciadora = instituicaoFinanciadora;
		this.finalidade = finalidade;
		this.disponibilidade = disponibilidade;
		this.duracao = duracao;
		this.numeroPaginas = numeroPaginas;
		this.cidade = cidade;
	}



	public String getInstituicaoFinanciadora() {
		return instituicaoFinanciadora;
	}

	public void setInstituicaoFinanciadora(String instituicaoFinanciadora) {
		this.instituicaoFinanciadora = instituicaoFinanciadora;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
}
