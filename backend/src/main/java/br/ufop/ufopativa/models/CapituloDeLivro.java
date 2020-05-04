package br.ufop.ufopativa.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class CapituloDeLivro extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String doi;
	private String local;
	private Integer numeroPaginas;
//	private String serie;
	
	@Column(columnDefinition="TEXT")
	private String tituloLivro;
	
	private String isbnLivro;
	private Integer paginaInicial;
	private Integer paginaFinal;

	public CapituloDeLivro() {
		
	}
	
	public CapituloDeLivro(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String doi,
			String local, Integer numeroPaginas, String tituloLivro, String isbnLivro, Integer paginaInicial, Integer paginaFinal) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.doi = doi;
		this.local = local;
		this.numeroPaginas = numeroPaginas;
		this.tituloLivro = tituloLivro;
		this.isbnLivro = isbnLivro;
		this.paginaInicial = paginaInicial;
		this.paginaFinal = paginaFinal;
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

	public String getTituloLivro() {
		return tituloLivro;
	}

	public void setTituloLivro(String tituloLivro) {
		this.tituloLivro = tituloLivro;
	}

	public String getIsbnLivro() {
		return isbnLivro;
	}

	public void setIsbnLivro(String isbnLivro) {
		this.isbnLivro = isbnLivro;
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
	
}
