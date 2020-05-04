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

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String especialidade;

	@Column(name="grande_area")
	private String grandeArea;

	@Column(name="nome_area")
	private String nomeArea;

	@Column(name="sub_area")
	private String subArea;

	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Area() {
	}
	
	public Area(String grandeArea, String nomeArea, String subArea, String especialidade) {
		super();
		//this.id = id;
		this.grandeArea = grandeArea;
		this.nomeArea = nomeArea;
		this.subArea = subArea;
		this.especialidade = especialidade;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getGrandeArea() {
		return this.grandeArea;
	}

	public void setGrandeArea(String grandeArea) {
		this.grandeArea = grandeArea;
	}

	public String getNomeArea() {
		return this.nomeArea;
	}

	public void setNomeArea(String nomeArea) {
		this.nomeArea = nomeArea;
	}

	public String getSubArea() {
		return this.subArea;
	}

	public void setSubArea(String subArea) {
		this.subArea = subArea;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
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
		Area other = (Area) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
