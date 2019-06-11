/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ba.pm.sga.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.gov.ba.pm.sga.model.enums.EnumPerfil;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@JsonIgnore
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "email", unique=true)
	private String email;
	
	@OneToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	@OneToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@Enumerated(EnumType.STRING)
	private EnumPerfil perfil;
	
	

	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	

	public Usuario() {
	}

	public Usuario(Integer id, String senha, String email) {
		super();
		this.id = id;
		this.senha = senha;
		this.email = email;
		//addPerfil(Perfil.CLIENTE);
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer codigo) {
		this.id = codigo;
	}
	public EnumPerfil getPerfil() {
		return perfil;
	}
	public void setPerfil(EnumPerfil perfil) {
		this.perfil = perfil;
	}
	
}
