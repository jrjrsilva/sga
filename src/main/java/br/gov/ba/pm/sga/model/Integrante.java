package br.gov.ba.pm.sga.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="integrante")
public class Integrante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Escala getEscala() {
		return escala;
	}

	public void setEscala(Escala escala) {
		this.escala = escala;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public Integrante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	@ManyToOne
	@JoinColumn(name="escala_id")
	private Escala escala;
	
	@ManyToOne
	@JoinColumn(name="funcao_id")
	private Funcao funcao;
	
	@ManyToOne
	@JoinColumn(name="posto_id")
	private Posto posto;
}
