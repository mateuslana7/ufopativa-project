package br.ufop.ufopativa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the formacao_academica database table.
 * 
 */
@Entity
@Table(name="formacao_academica")
@NamedQuery(name="FormacaoAcademica.findAll", query="SELECT f FROM FormacaoAcademica f")
public class FormacaoAcademica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ano_conclusao")
	private Integer anoConclusao;

	@Column(name="ano_inicio")
	private Integer anoInicio;

	private String curso;

	private String instituicao;

	private String situacao;

	private String tipo;

	@Column(name="titulo_trabalho")
	private String tituloTrabalho;

//	//bi-directional many-to-one association to Pessoa
	@ManyToOne//(cascade = {CascadeType.ALL})
	@JsonBackReference
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public FormacaoAcademica() {
	}
	
	public FormacaoAcademica(Integer anoConclusao, Integer anoInicio, String curso, String instituicao, String situacao, String tipo, String tituloTrabalho) {
		super();
		this.anoConclusao = anoConclusao;
		this.anoInicio = anoInicio;
		this.curso = curso;
		this.instituicao = instituicao;
		this.situacao = situacao;
		this.tipo = tipo;
		this.tituloTrabalho = tituloTrabalho;
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

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return this.instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTituloTrabalho() {
		return this.tituloTrabalho;
	}

	public void setTituloTrabalho(String tituloTrabalho) {
		this.tituloTrabalho = tituloTrabalho;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
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
		FormacaoAcademica other = (FormacaoAcademica) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
