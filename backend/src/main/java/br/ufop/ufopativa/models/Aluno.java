package br.ufop.ufopativa.models;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String nomeCurso;
	private String nivelCurso;
	
	public Aluno() {
		
	}

	public Aluno(Integer id, Date dataAtualizacao, String id_lattes, String cpf, String nomeCompleto, String raca,
			String sexo, String nacionalidade, String linkPerfil, String linkLattes, String linkFoto, String possuiLattes, String nomeCurso, String nivelCurso) {
		super(id, dataAtualizacao, id_lattes, cpf, nomeCompleto, raca, sexo, nacionalidade, linkPerfil, linkLattes, linkFoto, possuiLattes);
		this.nomeCurso = nomeCurso;
		this.nivelCurso = nivelCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(String nivelCurso) {
		this.nivelCurso = nivelCurso;
	}
}
