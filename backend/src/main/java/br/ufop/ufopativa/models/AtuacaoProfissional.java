package br.ufop.ufopativa.models;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The persistent class for the atuacao_profissional database table.
 * 
 */
@Entity
@Table(name="atuacao_profissional")
@NamedQuery(name="AtuacaoProfissional.findAll", query="SELECT a FROM AtuacaoProfissional a")
public class AtuacaoProfissional implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="ano_fim")
	private Integer anoFim;

	@Column(name="ano_inicio")
	private Integer anoInicio;

	private String descricao;
	
	private String tipo;
	
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public AtuacaoProfissional() {
	}
	
	public AtuacaoProfissional(Integer anoFim, Integer anoInicio, String descricao, String tipo) {
		super();
		this.anoFim = anoFim;
		this.anoInicio = anoInicio;
		this.descricao = descricao;
		this.tipo = tipo;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoFim() {
		return this.anoFim;
	}

	public void setAnoFim(Integer anoFim) {
		this.anoFim = anoFim;
	}

	public Integer getAnoInicio() {
		return this.anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
		AtuacaoProfissional other = (AtuacaoProfissional) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
