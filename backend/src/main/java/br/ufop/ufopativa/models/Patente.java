package br.ufop.ufopativa.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Patente extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String instituicaoFinanciadora;
	private String finalidade;
	
	@Column(columnDefinition="TEXT")
	private String categoria;
	
	public Patente() {
		
	}

	public Patente(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, 
			String instituicaoFinanciadora, String finalidade, String categoria) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.instituicaoFinanciadora = instituicaoFinanciadora;
		this.finalidade = finalidade;
		this.categoria = categoria;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
