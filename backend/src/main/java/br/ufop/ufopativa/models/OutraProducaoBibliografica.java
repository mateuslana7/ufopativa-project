package br.ufop.ufopativa.models;

import javax.persistence.Entity;

@Entity
public class OutraProducaoBibliografica extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String doi;
	private String local;
	private Integer numeroPaginas;
//	private String serie;
	
	public OutraProducaoBibliografica() {
		
	}
	
	public OutraProducaoBibliografica(Integer id, String tituloPortugues, String tituloIngles, Integer ano,
			String pais, String doi, String local, Integer numeroPaginas) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.doi = doi;
		this.local = local;
		this.numeroPaginas = numeroPaginas;
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

}
