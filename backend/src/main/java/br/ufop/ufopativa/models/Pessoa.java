package br.ufop.ufopativa.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataAtualizacao;
	private String idLattes;
	private String cpf;
	private String nomeCompleto;
	private String raca;
	private String sexo;
	private String nacionalidade;
	private String linkPerfil;
	private String linkLattes;
	private String linkFoto;
	private String possuiLattes;
	
	//ATRIBUTOS MULTIVALORADOS
//	@ElementCollection
//    @CollectionTable(
//        name = "nome_citacao",
//        joinColumns = @JoinColumn(name = "id")
//    )
//    private List<String> nomesCitacoes = new ArrayList<String>();
	
	@Column(columnDefinition="TEXT")
	private String nomesCitacoes;
	
//	@ElementCollection
//    @CollectionTable(
//        name = "palavra_chave",
//        joinColumns = @JoinColumn(name = "id")
//    )
//    private List<String> palavrasChaves = new ArrayList<String>();
	
	@OneToMany(mappedBy="pessoa")
	@JsonManagedReference
	private List<PalavraChave> palavrasChaves = new ArrayList<PalavraChave>();
	
//	private List<NomesCitacao> nomesCitacoes = new ArrayList<NomesCitacao>();
	
	//ASSOCIAÇÕES N->M
	@JsonManagedReference
	@ManyToMany(mappedBy="pessoas")
	private List<Producao> producoes = new ArrayList<Producao>();
	
	@JsonManagedReference
	@ManyToMany(mappedBy="pessoas")
	private List<ProjetoDePesquisa> projetosDePesquisa = new ArrayList<ProjetoDePesquisa>();
	
	//ASSOCIAÇÕES 1->N
	@OneToMany(mappedBy="pessoa")
	@JsonManagedReference
	private List<Area> areas = new ArrayList<Area>();//VER DPS N->M
	
	@OneToMany(mappedBy="pessoa")
	@JsonManagedReference
	private List<FormacaoAcademica> formacoesAcademicas = new ArrayList<FormacaoAcademica>();
	
	@OneToMany(mappedBy="pessoa")
	@JsonBackReference
	private List<Vinculo> vinculos = new ArrayList<Vinculo>();
	
	@OneToMany(mappedBy="pessoa")
	@JsonBackReference
	private List<AtuacaoProfissional> atuacoesProfissionais = new ArrayList<AtuacaoProfissional>();
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, Date dataAtualizacao, String idLattes, String cpf, String nomeCompleto, String raca,
			String sexo, String nacionalidade, String linkPerfil, String linkLattes, String linkFoto, String possuiLattes) {
		super();
		this.id = id;
		this.dataAtualizacao = dataAtualizacao;
		this.idLattes = idLattes;
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.raca = raca;
		this.sexo = sexo;
		this.nacionalidade = nacionalidade;
		this.linkPerfil = linkPerfil;
		this.linkLattes = linkLattes;
		this.linkFoto = linkFoto;
		this.possuiLattes = possuiLattes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getIdLattes() {
		return idLattes;
	}

	public void setIdLattes(String idLattes) {
		this.idLattes = idLattes;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getLinkPerfil() {
		return linkPerfil;
	}

	public void setLinkPerfil(String linkPerfil) {
		this.linkPerfil = linkPerfil;
	}

	public String getLinkLattes() {
		return linkLattes;
	}

	public void setLinkLattes(String linkLattes) {
		this.linkLattes = linkLattes;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<FormacaoAcademica> getFormacoesAcademicas() {
		return formacoesAcademicas;
	}

	public void setFormacoesAcademicas(List<FormacaoAcademica> formacoesAcademicas) {
		this.formacoesAcademicas = formacoesAcademicas;
	}

	public List<ProjetoDePesquisa> getProjetosDePesquisa() {
		return projetosDePesquisa;
	}

	public void setProjetosDePesquisa(List<ProjetoDePesquisa> projetosDePesquisa) {
		this.projetosDePesquisa = projetosDePesquisa;
	}

	public List<Vinculo> getVinculos() {
		return vinculos;
	}

	public void setVinculos(List<Vinculo> vinculos) {
		this.vinculos = vinculos;
	}
	
	public List<Producao> getProducoes() {
		return producoes;
	}

	public void setProducoes(List<Producao> producoes) {
		this.producoes = producoes;
	}

//	public List<String> getNomesCitacoes() {
//		return nomesCitacoes;
//	}
//
//	public void setNomesCitacoes(List<String> nomesCitacoes) {
//		this.nomesCitacoes = nomesCitacoes;
//	}
	
	public String getNomesCitacoes() {
		return nomesCitacoes;
	}

	public void setNomesCitacoes(String nomesCitacoes) {
		this.nomesCitacoes = nomesCitacoes;
	}

	public List<PalavraChave> getPalavrasChaves() {
		return palavrasChaves;
	}

	public void setPalavrasChaves(List<PalavraChave> palavrasChaves) {
		this.palavrasChaves = palavrasChaves;
	}
	
//	public List<String> getPalavrasChaves() {
//		return palavrasChaves;
//	}
//
//	public void setPalavrasChaves(List<String> palavrasChaves) {
//		this.palavrasChaves = palavrasChaves;
//	}

	public List<AtuacaoProfissional> getAtuacoesProfissionais() {
		return atuacoesProfissionais;
	}

	public void setAtuacoesProfissionais(List<AtuacaoProfissional> atuacoesProfissionais) {
		this.atuacoesProfissionais = atuacoesProfissionais;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getPossuiLattes() {
		return possuiLattes;
	}

	public void setPossuiLattes(String possuiLattes) {
		this.possuiLattes = possuiLattes;
	}
}
