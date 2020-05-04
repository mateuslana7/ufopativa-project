package br.ufop.ufopativa.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Software extends Producao {
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition="TEXT")
	private String instituicaoFinanciadora;
	
	private String finalidade;
	
	private String plataforma;
	private String ambiente;
	private String disponibilidade;
	
	public Software() {
		
	}
	
	public Software(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, 
			String instituicaoFinanciadora, String finalidade, String plataforma, String ambiente, String disponibilidade) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.instituicaoFinanciadora = instituicaoFinanciadora;
		this.finalidade = finalidade;
		this.plataforma = plataforma;
		this.ambiente = ambiente;
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
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
}
