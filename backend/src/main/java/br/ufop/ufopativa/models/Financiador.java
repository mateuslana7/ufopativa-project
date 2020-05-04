package br.ufop.ufopativa.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Financiador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String codigo;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(
		name="financiador_projeto_de_pesquisa"
		, joinColumns={
			@JoinColumn(name="id_financiador")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_projeto_de_pesquisa")
			}
		)
	List<ProjetoDePesquisa> projetosDePesquisa = new ArrayList<>();
	
	public Financiador() {
		
	}

	public Financiador(Integer id, String nome, String codigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<ProjetoDePesquisa> getProjetosDePesquisa() {
		return projetosDePesquisa;
	}

	public void setProjetosDePesquisa(List<ProjetoDePesquisa> projetosDePesquisa) {
		this.projetosDePesquisa = projetosDePesquisa;
	}
	
}
