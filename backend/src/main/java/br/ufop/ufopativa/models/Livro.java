package br.ufop.ufopativa.models;

import javax.persistence.Entity;

@Entity
public class Livro extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String doi;
	private String local;
	private Integer numeroPaginas;
//	private String serie;
	
	private String editora;
	private Integer edicaoRevisao;
	private String isbn;

	public Livro() {
		
	}
	
	public Livro(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String doi, String local, 
			Integer numeroPaginas, String editora, Integer edicaoRevisao, String isbn) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.doi = doi;
		this.local = local;
		this.numeroPaginas = numeroPaginas;
		this.editora = editora;
		this.edicaoRevisao = edicaoRevisao;
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

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Integer getEdicaoRevisao() {
		return edicaoRevisao;
	}

	public void setEdicaoRevisao(Integer edicaoRevisao) {
		this.edicaoRevisao = edicaoRevisao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
