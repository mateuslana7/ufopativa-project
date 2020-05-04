package br.ufop.ufopativa.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProgramaPosGraduacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="id_servidor")
//	private Servidor servidor;

	public ProgramaPosGraduacao() {
		
	}
	
	public ProgramaPosGraduacao(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public Servidor getServidor() {
//		return servidor;
//	}
//
//	public void setServidor(Servidor servidor) {
//		this.servidor = servidor;
//	}
	
	
}
