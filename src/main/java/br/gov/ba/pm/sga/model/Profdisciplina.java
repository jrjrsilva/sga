/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ba.pm.sga.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tprofdisciplina")
public class Profdisciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
  
    @JoinColumn(name = "CodDisciplina", referencedColumnName = "CodDisciplina")
    @ManyToOne
    private Disciplina disciplina;
    
    
    @JoinColumn(name = "CodSerie", referencedColumnName = "CodSerie")
    @ManyToOne
    private Serie serie;
    
    
    @JoinColumn(name = "CodTurma", referencedColumnName = "CodTurma")
    @ManyToOne
    private Turma turma;
    
    @Column(name = "Ano")
    private Integer ano;
    
    @JoinColumn(name = "CodProfessor", referencedColumnName = "CodProfessor")
    @ManyToOne
    private Professor professor;

    public Profdisciplina() {
    }

    public Profdisciplina(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

   
    public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profdisciplina)) {
            return false;
        }
        Profdisciplina other = (Profdisciplina) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    
    
}
