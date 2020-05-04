package br.ufop.ufopativa.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class AutorExterno implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String nomeCitacao;
	private Integer ordemAutoria;
	
	//bi-directional many-to-one association to Producao
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_producao")
	private Producao producao;
	
	public AutorExterno() {
		
	}
	
	public AutorExterno(Integer id, String nome, String nomeCitacao, Integer ordemAutoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeCitacao = nomeCitacao;
		this.ordemAutoria = ordemAutoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Producao getProducao() {
		return producao;
	}

	public void setProducao(Producao producao) {
		this.producao = producao;
	}
}
