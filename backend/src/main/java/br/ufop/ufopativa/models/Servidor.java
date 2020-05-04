package br.ufop.ufopativa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Servidor extends Pessoa {
	private static final long serialVersionUID = 1L;
	 
	private String tipo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_unidade")
	private Unidade unidade;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;
	
//	@OneToMany(mappedBy="servidor")
//	@JsonManagedReference
//	private List<ProgramaPosGraduacao> ppgs = new ArrayList<>();
	
	@Column(name="programas_pos_graduacao")
	private String ppgs;
	
	@OneToMany(mappedBy="servidor")
	@JsonManagedReference
	private List<OrientacaoConcluida> orientacoesConcluidas = new ArrayList<>();
	
	public Servidor() {
		
	}

	public Servidor(Integer id, Date dataAtualizacao, String id_lattes, String cpf, String nomeCompleto, String raca,
			String sexo, String nacionalidade, String linkPerfil, String linkLattes, String linkFoto, String possuiLattes, String tipo, Unidade unidade, Departamento departamento, String ppgs) {
		super(id, dataAtualizacao, id_lattes, cpf, nomeCompleto, raca, sexo, nacionalidade, linkPerfil, linkLattes, linkFoto, possuiLattes);
		this.tipo = tipo;
		this.unidade = unidade;
		this.departamento = departamento;
		this.ppgs = ppgs;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getPpgs() {
		return ppgs;
	}

	public void setPpgs(String ppgs) {
		this.ppgs = ppgs;
	}

	public List<OrientacaoConcluida> getOrientacoesConcluidas() {
		return orientacoesConcluidas;
	}

	public void setOrientacoesConcluidas(List<OrientacaoConcluida> orientacoesConcluidas) {
		this.orientacoesConcluidas = orientacoesConcluidas;
	}
	
}
