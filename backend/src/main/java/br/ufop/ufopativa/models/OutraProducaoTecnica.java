package br.ufop.ufopativa.models;

import javax.persistence.Entity;

@Entity
public class OutraProducaoTecnica extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String instituicaoFinanciadora;
	private String finalidade;
	
	public OutraProducaoTecnica() {
		
	}
	
	public OutraProducaoTecnica(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, 
			String instituicaoFinanciadora, String finalidade) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.instituicaoFinanciadora = instituicaoFinanciadora;
		this.finalidade = finalidade;
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
	
	

}
