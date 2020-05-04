package br.ufop.ufopativa.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TrabalhoEmEvento extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String doi;
	private String local;
	private Integer numeroPaginas;
//	private String serie;
	
//	private String volume;
//	private String fasciculo;
	
	@Column(columnDefinition="TEXT")
	private String nomeEventoPortugues;
	
	@Column(columnDefinition="TEXT")
	private String nomeEventoIngles;
	
	private String cidadeEvento;
	@Column(columnDefinition="TEXT")
	private String tituloAnaisProceedings;
	
	private Integer paginaInicial;
	private Integer paginaFinal;
	private String editora;
	private String isbn;
	
	public TrabalhoEmEvento() {
		
	}

	public TrabalhoEmEvento(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String doi, 
			String local, Integer numeroPaginas, String nomeEventoPortugues, String nomeEventoIngles, String cidadeEvento, 
			String tituloAnaisProceedings, Integer paginaInicial, Integer paginaFinal, String editora, String isbn) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.doi = doi;
		this.local = local;
		this.numeroPaginas = numeroPaginas;
		this.nomeEventoPortugues = nomeEventoPortugues;
		this.nomeEventoIngles = nomeEventoIngles;
		this.cidadeEvento = cidadeEvento;
		this.tituloAnaisProceedings = tituloAnaisProceedings;
		this.paginaInicial = paginaInicial;
		this.paginaFinal = paginaFinal;
		this.editora = editora;
		this.isbn = isbn;
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

	public String getNomeEventoPortugues() {
		return nomeEventoPortugues;
	}

	public void setNomeEventoPortugues(String nomeEventoPortugues) {
		this.nomeEventoPortugues = nomeEventoPortugues;
	}

	public String getNomeEventoIngles() {
		return nomeEventoIngles;
	}

	public void setNomeEventoIngles(String nomeEventoIngles) {
		this.nomeEventoIngles = nomeEventoIngles;
	}

	public String getCidadeEvento() {
		return cidadeEvento;
	}

	public void setCidadeEvento(String cidadeEvento) {
		this.cidadeEvento = cidadeEvento;
	}

	public String getTituloAnaisProceedings() {
		return tituloAnaisProceedings;
	}

	public void setTituloAnaisProceedings(String tituloAnaisProceedings) {
		this.tituloAnaisProceedings = tituloAnaisProceedings;
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

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
}
