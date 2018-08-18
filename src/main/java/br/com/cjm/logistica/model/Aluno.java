package br.com.cjm.logistica.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="aluno")
public class Aluno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	private String cpf;
	
	private String nome;
	
	private String gruposanguineo;
	
	private String fatorrh;
	
	private String matricula;
	
	@Column(name="cod_cargo")
	private String codgrauhierarquico;
	
	@Column(name="cargo")
	private String grauhierarquico;
	
	@Column(name="cod_unidade")
	private String codopm;
	
	private LocalDateTime cadastro;
	
	
	@Column(name="data_nascimento")
	private String dtnasc;
	
	@Column(name="data_admissao")
	private String dtadmissao;
	

	@Column(name="unidade")
	private String opm;
	
	private String sexo;
	
	@Column(length=150)
	private String endereco;
	
	@Column(length=2)
	private String ddd;
	
	@Column(length=9)
	private String telefone;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date admissao;
	
	@Transient
	private Integer tempoServico;
	
	@ManyToMany(mappedBy="alunos")
	private List<GrupoServico> gruposServico;
			
	public Integer getTempoServico() {
		LocalDate dataAtual = LocalDate.now();
		String d = this.getNascimento().toString(); 
        LocalDate data = LocalDate.parse(d);
		Period tempo = Period.between(data ,dataAtual);
		
		return tempo.getYears(); 
	}
		
	public List<GrupoServico> getGruposServico() {
		return gruposServico;
	}

	public void setGruposServico(List<GrupoServico> gruposServico) {
		this.gruposServico = gruposServico;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if (endereco != null )
			endereco = endereco.toUpperCase();
		this.endereco = endereco;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




	@Column(name="nomeguerra")
	private String nomeGuerra;
	
	private Integer numero;
	
	private String turma;
	
	private String curso;
	
	private String email;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return cpf;
	}
	public void setCodigo(String codigo) {
		this.cpf = codigo;
	}
	public String getNome() {
		return nome;
	}
	
	
	public void setTempoServico(Integer tempoServico) {
		this.tempoServico = tempoServico;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGruposanguineo() {
		return gruposanguineo;
	}
	public void setGruposanguineo(String gruposanguineo) {
		this.gruposanguineo = gruposanguineo;
	}
	public String getFatorrh() {
		return fatorrh;
	}
	public void setFatorrh(String fatorrh) {
		this.fatorrh = fatorrh;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCodgrauhierarquico() {
		return codgrauhierarquico;
	}
	public void setCodgrauhierarquico(String codgrauhierarquico) {
		this.codgrauhierarquico = codgrauhierarquico;
	}
	public String getGrauhierarquico() {
		return grauhierarquico;
	}
	public void setGrauhierarquico(String grauhierarquico) {
		this.grauhierarquico = grauhierarquico;
	}
	public String getCodopm() {
		return codopm;
	}
	public void setCodopm(String codopm) {
		this.codopm = codopm;
	}
	public String getOpm() {
		return opm;
	}
	public void setOpm(String opm) {
		this.opm = opm;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Date getAdmissao() {
		return admissao;
	}
	public void setAdmissao(Date admissao) {
		this.admissao = admissao;
	}
	public String getNomeGuerra() {
		return nomeGuerra;
	}
	public void setNomeGuerra(String nomeGuerra) {
		if (nomeGuerra != null )
			nomeGuerra = nomeGuerra.toUpperCase();
		this.nomeGuerra = nomeGuerra;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	
	public LocalDateTime getCadastro() {
		return cadastro;
	}
	public void setCadastro(LocalDateTime cadastro) {
		this.cadastro = cadastro;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(String dtnasc) {
		this.dtnasc = dtnasc;
	}
	public String getDtadmissao() {
		return dtadmissao;
	}
	public void setDtadmissao(String dtadmissao) {
		this.dtadmissao = dtadmissao;
	}
	
	
		
}

