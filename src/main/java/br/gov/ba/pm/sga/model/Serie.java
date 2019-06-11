package br.gov.ba.pm.sga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tserie")
public class Serie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    
    @Column(name = "CodSerie")
    private String codSerie;
    
    @Column(name = "Serie")
    private String serie;
    @Column(name = "Ano")
    private Integer ano;
    @Column(name = "Apelido")
    private String apelido;

    public Serie() {
    }

	public Serie(Integer codSerie2) {
		this.codigo = codSerie2;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodSerie() {
		return codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

}
