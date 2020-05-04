package br.ufop.ufopativa.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Producao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition="TEXT")
	private String tituloPortugues;
	@Column(columnDefinition="TEXT")
	private String tituloIngles;
	
	private Integer ano;
	private String pais;
	
	//bi-directional many-to-many association to Pessoa
	@JsonBackReference
	@ManyToMany
	@JoinTable(
		name="pessoa_producao"
		, joinColumns={
			@JoinColumn(name="id_producao")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_pessoa")
			}
		)
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@OneToMany(mappedBy="producao")
	@JsonManagedReference
	private List<AutorExterno> autoresExternos = new ArrayList<AutorExterno>();
	
	@OneToMany(mappedBy="producao")
	@JsonManagedReference
	private List<Autor> autores = new ArrayList<>();
	
	
	public Producao() {
		
	}
	
	public Producao(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais) {
		super();
		this.id = id;
		this.tituloPortugues = tituloPortugues;
		this.tituloIngles = tituloIngles;
		this.ano = ano;
		this.pais = pais;
	}
	
	public Producao(String titulo, int ano) {
		this.tituloPortugues = titulo;
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTituloPortugues() {
		return tituloPortugues;
	}
	public void setTituloPortugues(String tituloPortugues) {
		this.tituloPortugues = tituloPortugues;
	}
	
	public String getTituloIngles() {
		return tituloIngles;
	}
	public void setTituloIngles(String tituloIngles) {
		this.tituloIngles = tituloIngles;
	}
	
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public List<AutorExterno> getAutoresExternos() {
		return autoresExternos;
	}

	public void setAutoresExternos(List<AutorExterno> autoresExternos) {
		this.autoresExternos = autoresExternos;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producao other = (Producao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
