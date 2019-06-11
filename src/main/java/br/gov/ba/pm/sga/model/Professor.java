/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ba.pm.sga.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tprofessor")
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "CodProfessor")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer codProfessor;
    
    @Column(name = "Professor")
    private String professorNome;
    @Column(name = "Apelido")
    private String apelido;   
    @Column(name = "DataNasc")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNasc;
    
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "RG")
    private String rg;
    @Column(name = "Expedidor")
    private String expedidor;
    @Column(name = "Situacao")
    private String situacao;
    @Column(name = "Observacoes")
    private String observacoes;
   
    @Column(name = "Endereco")
    private String endereco;
    @Column(name = "Bairro")
    private String bairro;
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "Estado")
    private String estado;
    @Column(name = "CEP")
    private String cep;
    
    @Column(name = "Telefone")
    private String telefone;
    @Column(name = "Sexo")
    private Character sexo;
    @Column(name = "Cadastro")
    private String cadastro;
    @Column(name = "Celular")
    private String celular;
    @Column(name = "TelContato")
    private String telContato;
    @Column(name = "Formacao")
    private String formacao;
    @Column(name = "Especificacao")
    private String especificacao;
    
    @Column(name = "Posto_grad")
    private String postograd;
    
    @Column(name = "email")
    private String email;
    @Column(name = "Mae")
    private String mae;
    @Column(name = "Pai")
    private String pai;
    @Column(name = "Naturalidade")
    private String naturalidade;
    
    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Profdisciplina> profdisciplinas;

    public Professor() {
    }
    
    public Professor(Integer codProfessor, String professorNome, String apelido, Date dataNasc, String cpf, String rg,
			String expedidor) {
		super();
		this.codProfessor = codProfessor;
		this.professorNome = professorNome;
		this.apelido = apelido;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.rg = rg;
		this.expedidor = expedidor;
	}

    public Professor(Integer codProfessor) {
        this.codProfessor = codProfessor;
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

	public List<Profdisciplina> getProfdisciplinas() {
		return profdisciplinas;
	}

	public void setProfdisciplinas(List<Profdisciplina> profdisciplinas) {
		this.profdisciplinas = profdisciplinas;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

    public String getPostograd() {
        return postograd;
    }

    public void setPostograd(String postograd) {
        this.postograd = postograd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMae() {
        return mae;
    }

    public void setMae(String mae) {
        this.mae = mae;
    }

    public String getPai() {
        return pai;
    }

    public void setPai(String pai) {
        this.pai = pai;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProfessor != null ? codProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.codProfessor == null && other.codProfessor != null) || (this.codProfessor != null && !this.codProfessor.equals(other.codProfessor))) {
            return false;
        }
        return true;
    }

   
}
