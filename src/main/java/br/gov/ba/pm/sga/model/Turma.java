package br.gov.ba.pm.sga.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tturma")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "CodTurma")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codTurma;
	
	
	@JoinColumn(name = "CodSerie", referencedColumnName = "CodSerie")
	@ManyToOne
	private Serie serie;

	
	@Column(name = "TurmaD")
	private String turmaD;
	@Column(name = "Descricao")
	private String descricao;
	@Column(name = "Turma")
	private String turma;
	@Column(name = "Ano")
	private Integer ano;
	@Column(name = "Pel")
	private String pel;
	
	@OneToMany(mappedBy="turma")
	private List<MatriculaNova> matriculas;
	
	public Turma() {
	}

	public Integer getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(Integer codTurma) {
		this.codTurma = codTurma;
	}	

	public String getTurmaD() {
		return turmaD;
	}

	public void setTurmaD(String turmaD) {
		this.turmaD = turmaD;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	/*public List<MatriculaNova> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<MatriculaNova> matriculas) {
		this.matriculas = matriculas;
	}*/

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPel() {
		return pel;
	}

	public void setPel(String pel) {
		this.pel = pel;
	}

	

	
}
