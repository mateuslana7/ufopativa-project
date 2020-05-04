package br.ufop.ufopativa.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the projeto_de_pesquisa database table.
 * 
 */
@Entity
@Table(name="projeto_de_pesquisa")
@NamedQuery(name="ProjetoDePesquisa.findAll", query="SELECT p FROM ProjetoDePesquisa p")
public class ProjetoDePesquisa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ano_conclusao")
	private Integer anoConclusao;

	@Column(name="ano_inicio")
	private Integer anoInicio;

//	@Column(name="codigo_financiador")
//	private int codigoFinanciador;

	@Column(columnDefinition="TEXT")
	private String descricao;

//	@Column(name="nome_financiador")
//	private String nomeFinanciador;

	private String situacao;

	private String nome;

	//bi-directional many-to-many association to Pessoa
	@JsonBackReference
	@ManyToMany
	@JoinTable(
		name="pessoa_projeto_de_pesquisa"
		, joinColumns={
			@JoinColumn(name="id_projeto_de_pesquisa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_pessoa")
			}
		)
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	@JsonManagedReference
	@ManyToMany(mappedBy="projetosDePesquisa")
	private List<Financiador> financiadores = new ArrayList<>();

	public ProjetoDePesquisa() {
	}
	
	public ProjetoDePesquisa(String nome, Integer anoConclusao, Integer anoInicio, String descricao, String situacao) {
		super();
		this.nome = nome;
		this.anoConclusao = anoConclusao;
		this.anoInicio = anoInicio;
		this.descricao = descricao;
		this.situacao = situacao;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoConclusao() {
		return this.anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public Integer getAnoInicio() {
		return this.anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

//	public int getCodigoFinanciador() {
//		return this.codigoFinanciador;
//	}
//
//	public void setCodigoFinanciador(int codigoFinanciador) {
//		this.codigoFinanciador = codigoFinanciador;
//	}
//	
//	public String getNomeFinanciador() {
//		return this.nomeFinanciador;
//	}
//
//	public void setNomeFinanciador(String nomeFinanciador) {
//		this.nomeFinanciador = nomeFinanciador;
//	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setTitulo(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Financiador> getFinanciadores() {
		return financiadores;
	}

	public void setFinanciadores(List<Financiador> financiadores) {
		this.financiadores = financiadores;
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
		ProjetoDePesquisa other = (ProjetoDePesquisa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
