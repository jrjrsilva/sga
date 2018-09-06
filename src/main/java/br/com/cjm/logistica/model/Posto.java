package br.com.cjm.logistica.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posto")
public class Posto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	@ManyToOne
	@JoinColumn(name="tipoposto_id")
	private TipoPosto tipoPosto;
	
	
	@ManyToMany
	@JoinTable(name="tiposervico_postos",
	joinColumns=@JoinColumn(name="postos_id"),
	inverseJoinColumns=@JoinColumn(name="tipo_servico_id"))
	private List<TipoServico> tiposServico;
	
	
	public Posto(Long posto) {
		this.id = posto;
	}

	public Long getId() {
		return id;
	}

	public Posto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
