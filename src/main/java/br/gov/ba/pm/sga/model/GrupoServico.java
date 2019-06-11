package br.gov.ba.pm.sga.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="gruposervico")
public class GrupoServico implements Serializable{

	public GrupoServico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String nome;

	private String letra;
	
	private Integer grupo;
	
	@ManyToMany
	@JoinTable(name="gruposervico_aluno",
			joinColumns=@JoinColumn(name="gruposervico_id"),
			inverseJoinColumns=@JoinColumn(name="aluno_id"))
	private List<Aluno> alunos;

		
	public Integer getGrupo() {
		return grupo;
	}

	public void setGrupo(Integer grupo) {
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = (nome != null ? nome.toUpperCase() : "" );
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	
}

