package br.ufop.ufopativa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PalavraChave {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer id;
	
	public String palavra;
	public Integer numeroUtilizacoes;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_pessoa")
	public Pessoa pessoa;
	
	public PalavraChave() {
		
	}
	
	public PalavraChave(Integer id, String palavra, Integer numeroUtilizacoes) {
		super();
		this.id = id;
		this.palavra = palavra;
		this.numeroUtilizacoes = numeroUtilizacoes;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getPalavra() {
		return palavra;
	}
	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	
	public Integer getNumeroUtilizacoes() {
		return numeroUtilizacoes;
	}
	public void setNumeroUtilizacoes(Integer numeroUtilizacoes) {
		this.numeroUtilizacoes = numeroUtilizacoes;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
