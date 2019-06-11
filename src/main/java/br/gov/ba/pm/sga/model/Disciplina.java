package br.gov.ba.pm.sga.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tdisciplina")
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CodDisciplina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codDisciplina;
    
    @Column(name = "Disciplina")
    private String disciplinaNome;
    
    @Column(name = "Abreviatura")
    private String abreviatura;
    
    @Column(name = "Reprova")
    private String reprova;
    
    @Column(name = "Diversificada")
    private String diversificada;
    
    @Column(name = "Ordem")
    private Integer ordem;
    
    @Column(name = "Peso")
    private String peso;
    
    @JsonIgnore
    @OneToMany(mappedBy = "disciplina")
    private List<Grade> grades;
    
	public Disciplina() {
		super();
	}
	
	public Disciplina(Integer disciplina) {
		this.codDisciplina = disciplina;
	}

	public Integer getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(Integer codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public String getDisciplinaNome() {
		return disciplinaNome;
	}
	public void setDisciplinaNome(String disciplina) {
		this.disciplinaNome = disciplina;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public String getReprova() {
		return reprova;
	}
	public void setReprova(String reprova) {
		this.reprova = reprova;
	}
	public String getDiversificada() {
		return diversificada;
	}
	public void setDiversificada(String diversificada) {
		this.diversificada = diversificada;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}
	
}
