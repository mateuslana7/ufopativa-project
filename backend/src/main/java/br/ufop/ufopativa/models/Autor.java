package br.ufop.ufopativa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Autor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeCompleto;
	
	@Column(columnDefinition="TEXT")
	private String nomeCitacao;
	
	private Integer ordemAutoria;
	private String idLattes;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_producao")
	private Producao producao;

	public Autor() {
		
	}
	
	public Autor(Integer id, String nomeCompleto, String nomeCitacao, Integer ordemAutoria, String idLattes) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.nomeCitacao = nomeCitacao;
		this.ordemAutoria = ordemAutoria;
		this.idLattes = idLattes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeCitacao() {
		return nomeCitacao;
	}

	public void setNomeCitacao(String nomeCitacao) {
		this.nomeCitacao = nomeCitacao;
	}

	public Integer getOrdemAutoria() {
		return ordemAutoria;
	}

	public void setOrdemAutoria(Integer ordemAutoria) {
		this.ordemAutoria = ordemAutoria;
	}

	public String getIdLattes() {
		return idLattes;
	}

	public void setIdLattes(String idLattes) {
		this.idLattes = idLattes;
	}

	public Producao getProducao() {
		return producao;
	}

	public void setProducao(Producao producao) {
		this.producao = producao;
	}
}
