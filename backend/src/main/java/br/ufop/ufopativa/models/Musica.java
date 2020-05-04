package br.ufop.ufopativa.models;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Musica extends Producao {
	private static final long serialVersionUID = 1L;
	
	private String nomePremiacao;
	private String instituicaoPromotoraPremiacao;
	private String instituicaoPromotoraEvento;
	private String localEvento;
	private String temporada;
	
	private String tipoEvento;
	private String localEstreia;
	private Date dataEstreia;
	private String nomeObraReferencia;
	private String anoObraReferencia;
	private String autorObraReferencia;
	
	public Musica() {
		
	}
	
	public Musica(Integer id, String tituloPortugues, String tituloIngles, Integer ano, String pais, String nomePremiacao,
			String instituicaoPromotoraPremiacao, String instituicaoPromotoraEvento, String localEvento, String temporada, 
			String tipoEvento, String localEstreia, Date dataEstreia, String nomeObraReferencia, String anoObraReferencia,
			String autorObraReferencia) {
		super(id, tituloPortugues, tituloIngles, ano, pais);
		this.nomePremiacao = nomePremiacao;
		this.instituicaoPromotoraPremiacao = instituicaoPromotoraPremiacao;
		this.instituicaoPromotoraEvento = instituicaoPromotoraEvento;
		this.localEvento = localEvento;
		this.temporada = temporada;
		this.tipoEvento = tipoEvento;
		this.localEstreia = localEstreia;
		this.dataEstreia = dataEstreia;
		this.nomeObraReferencia = nomeObraReferencia;
		this.anoObraReferencia = anoObraReferencia;
		this.autorObraReferencia = autorObraReferencia;
		
	}

	public String getNomePremiacao() {
		return nomePremiacao;
	}
	public void setNomePremiacao(String nomePremiacao) {
		this.nomePremiacao = nomePremiacao;
	}
	public String getInstituicaoPromotoraPremiacao() {
		return instituicaoPromotoraPremiacao;
	}
	public void setInstituicaoPromotoraPremiacao(String instituicaoPromotoraPremiacao) {
		this.instituicaoPromotoraPremiacao = instituicaoPromotoraPremiacao;
	}
	public String getInstituicaoPromotoraEvento() {
		return instituicaoPromotoraEvento;
	}
	public void setInstituicaoPromotoraEvento(String instituicaoPromotoraEvento) {
		this.instituicaoPromotoraEvento = instituicaoPromotoraEvento;
	}
	public String getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public String getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public String getLocalEstreia() {
		return localEstreia;
	}
	public void setLocalEstreia(String localEstreia) {
		this.localEstreia = localEstreia;
	}
	public Date getDataEstreia() {
		return dataEstreia;
	}
	public void setDataEstreia(Date dataEstreia) {
		this.dataEstreia = dataEstreia;
	}
	public String getNomeObraReferencia() {
		return nomeObraReferencia;
	}
	public void setNomeObraReferencia(String nomeObraReferencia) {
		this.nomeObraReferencia = nomeObraReferencia;
	}
	public String getAnoObraReferencia() {
		return anoObraReferencia;
	}
	public void setAnoObraReferencia(String anoObraReferencia) {
		this.anoObraReferencia = anoObraReferencia;
	}
	public String getAutorObraReferencia() {
		return autorObraReferencia;
	}
	public void setAutorObraReferencia(String autorObraReferencia) {
		this.autorObraReferencia = autorObraReferencia;
	}
}
