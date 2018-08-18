package br.com.cjm.logistica.model;

import java.io.Serializable;
import java.util.List;

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