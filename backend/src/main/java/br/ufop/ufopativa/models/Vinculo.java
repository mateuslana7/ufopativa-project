package br.ufop.ufopativa.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="vinculo")
//@NamedQuery(name="Vinculo.findAll", query="SELECT a FROM Vinculo a")
public class Vinculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="ano_fim")
	private Integer anoFim;

	@Column(name="ano_inicio")
	private Integer anoInicio;

	@Column(name="enquadramento_funcional")
	private String enquadramentoFuncional;
	
//	//bi-directional many-to-one association to Pessoa
	@ManyToOne
	@JsonManagedReference
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	public Vinculo() {
		
	}
	
	public Vinculo(Integer anoFim, Integer anoInicio, String enquadramentoFuncional) {
		super();
		this.anoFim = anoFim;
		this.anoInicio = anoInicio;
		this.enquadramentoFuncional = enquadramentoFuncional;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAnoFim() {
		return anoFim;
	}

	public void setAnoFim(Integer anoFim) {
		this.anoFim = anoFim;
	}

	public Integer getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

	public String getEnquadramentoFuncional() {
		return enquadramentoFuncional;
	}

	public void setEnquadramentoFuncional(String enquadramentoFuncional) {
		this.enquadramentoFuncional = enquadramentoFuncional;
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
		Vinculo other = (Vinculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
