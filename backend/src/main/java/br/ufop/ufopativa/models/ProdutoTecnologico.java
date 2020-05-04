package br.ufop.ufopativa.models;

import javax.persistence.Entity;

@Entity
public class ProdutoTecnologico extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String instituicaoFinanciadora;
	private String finalidade;
	
	private String disponibilidade;
	
	public ProdutoTecnologico() {
		
	}

	public ProdutoTecnologico(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, 
			String instituicaoFinanciadora, String finalidade, String disponibilidade) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.instituicaoFinanciadora = instituicaoFinanciadora;
		this.finalidade = finalidade;
		this.disponibilidade = disponibilidade;
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

}
