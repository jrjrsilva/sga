package br.gov.ba.pm.sga.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import br.gov.ba.pm.sga.model.Professor;

public class ProfessorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer codProfessor;
    
    @NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5,max=120, message="O tamanho deve estar entre 5 e 120 caracteres!")
    private String professorNome;
    private String apelido;   
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNasc;
    private String cpf;
    private String rg;
    private String expedidor;
    private String situacao;
    
    
	@Length(max=500, message="O tamanho pode ter até 500 caracteres!")
    private String observacoes;
	
	
	
	public ProfessorDTO(Professor obj) {
		super();
		this.codProfessor = obj.getCodProfessor();
		this.professorNome = obj.getProfessorNome();
		this.apelido = obj.getApelido();
		this.dataNasc = obj.getDataNasc();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.expedidor = obj.getExpedidor();

	}
	public ProfessorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCodProfessor() {
		return codProfessor;
	}
	public void setCodProfessor(Integer codProfessor) {
		this.codProfessor = codProfessor;
	}
	public String getProfessorNome() {
		return professorNome;
	}
	public void setProfessorNome(String professorNome) {
		this.professorNome = professorNome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getExpedidor() {
		return expedidor;
	}
	public void setExpedidor(String expedidor) {
		this.expedidor = expedidor;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	
}
