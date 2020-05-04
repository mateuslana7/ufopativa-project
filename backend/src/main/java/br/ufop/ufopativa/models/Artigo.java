package br.ufop.ufopativa.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Artigo extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String doi;
	private String local;
	private Integer numeroPaginas;
//	private String serie;
	
//	private String fasciculo;
//	private Integer volume;
//	private String situacaoDePublicacao;
	private Integer paginaInicial;
	private Integer paginaFinal;
	private String issn;
	
	@Column(columnDefinition="TEXT")
	private String tituloPeriodicoRevista;

	public Artigo() {
		
	}

	public Artigo(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String doi, String local,
			Integer numeroPaginas, Integer paginaInicial, Integer paginaFinal, String issn, String tituloPeriodicoRevista) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.doi = doi;
		this.local = local;
		this.numeroPaginas = numeroPaginas;
		this.paginaInicial = paginaInicial;
		this.paginaFinal = paginaFinal;
		this.issn = issn;
		this.tituloPeriodicoRevista = tituloPeriodicoRevista;
	}



	public String getDoi() {
		return doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getPaginaInicial() {
		return paginaInicial;
	}

	public void setPaginaInicial(Integer paginaInicial) {
		this.paginaInicial = paginaInicial;
	}

	public Integer getPaginaFinal() {
		return paginaFinal;
	}

	public void setPaginaFinal(Integer paginaFinal) {
		this.paginaFinal = paginaFinal;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	public String getTituloPeriodicoRevista() {
		return tituloPeriodicoRevista;
	}

	public void setTituloPeriodicoRevista(String tituloPeriodicoRevista) {
		this.tituloPeriodicoRevista = tituloPeriodicoRevista;
	}
}
