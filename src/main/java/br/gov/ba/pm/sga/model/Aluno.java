package br.gov.ba.pm.sga.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

@Entity
@Table(name="taluno")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codAluno;


	@Column(name = "Matricula")
	private String matricula;
	@Column(name = "Aluno")
	private String alunoNome;
	
	@Column(name = "Nomeguerra")
	private String nomeGuerra;
	@Column(name = "Sexo")
	private String sexo;

	@Column(name = "Datanasc")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Column(name = "Naturalidade")
	private String naturalidade;
	@Column(name = "Endereco")
	private String endereco;
	@Column(name = "CEP")
	private String cep;
	@Column(name = "Bairro")
	private String bairro;
	@Column(name = "Cidade")
	private String cidade;
	@Column(name = "Estado")
	private String estado;
	@Column(name = "Telefone")
	private String telefone;
	@Column(name = "RG")
	private String rg;
	@Column(name = "TituloEleitor")
	private String tituloEleitor;
	@Column(name = "Secao")
	private String secao;
	@Column(name = "Zona")
	private String zona;
	@Column(name = "email")
	private String email;
	@Column(name = "CPF")
	private String cpf;
	@Column(name = "Celular")
	private String celular;
	@Column(name = "Pai")
	private String pai;
	@Column(name = "Mae")
	private String mae;
	@Column(name = "Estadocivil")
	private String estadoCivil;
	@Column(name = "Nomeconjuge")
	private String nomeConjuge;
	@Column(name = "Calca")
	private String calca;
	@Column(name = "Camisa")
	private String camisa;
	@Column(name = "Tunica")
	private Integer tunica;
	@Column(name = "Quepe")
	private String quepe;
	@Column(name = "Boina")
	private String boina;
	@Column(name = "Sapato")
	private String sapato;
	@Column(name = "Coturno")
	private String coturno;
	@Column(name = "Peso")
	private String peso;
	@Column(name = "altura")
	private Integer altura;
	@Column(name = "CNH")
	private String cnh;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Validade")
	@Temporal(TemporalType.TIMESTAMP)
	private Date validade;
	
	@Column(name = "Categoria")
	private String categoria;
	@Column(name = "Origem")
	private String origem;
	@Column(name = "Unidade")
	private String unidade;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Datapraca")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPraca;
	
	@Column(name = "TipoSanguineo")
	private String tipoSanguineo;
	@Column(name = "Alergia")
	private String alergia;
	@Column(name = "QualAlergia")
	private String qualAlergia;
	@Column(name = "Dadosemergenciais")
	private String dadosEmergenciais;
	@Column(name = "Doadorsangue")
	private String doadorSangue;
	@Column(name = "contatoemergencia")
	private String contatoEmergencia;
	@Column(name = "Digitador")
	private String digitador;
	@Column(name = "PMOrigem")
	private String pMOrigem;
	@Column(name = "Nacionalidade")
	private String nacionalidade;
	@Column(name = "Observacao1")
	private String observacao1;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Datacadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Column(name = "Svmilitar")
	private String svMilitar;
	@Column(name = "Ativo")
	private String ativo;
	@Column(name = "Possuicnh")
	private Boolean possuiCnh;
	@Column(name = "Subjudice")
	private String subJudice;
	@Column(name = "Obshistorico1")
	private String obsHistorico1;
	@Column(name = "Comportamento")
	private String comportamento;
	@Column(name = "Graduacaoanterior")
	private String graduacaoAnterior;
	@Column(name = "PostoAtual")
	private String postoAtual;
	@Column(name = "Doencas")
	private String doencas;
	@Column(name = "Curso")
	private String curso;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "aluno")
    private List<Nota> notas;


	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCodAluno() {
		return codAluno;
	}


	public void setCodAluno(Integer codAluno) {
		this.codAluno = codAluno;
	}

	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public String getNomeGuerra() {
		return nomeGuerra;
	}


	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNaturalidade() {
		return naturalidade;
	}


	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
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


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getTituloEleitor() {
		return tituloEleitor;
	}


	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}


	public String getSecao() {
		return secao;
	}


	public void setSecao(String secao) {
		this.secao = secao;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getPai() {
		return pai;
	}


	public void setPai(String pai) {
		this.pai = pai;
	}


	public String getMae() {
		return mae;
	}


	public void setMae(String mae) {
		this.mae = mae;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getNomeConjuge() {
		return nomeConjuge;
	}


	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}


	public String getCalca() {
		return calca;
	}


	public void setCalca(String calca) {
		this.calca = calca;
	}


	public String getCamisa() {
		return camisa;
	}


	public void setCamisa(String camisa) {
		this.camisa = camisa;
	}


	public Integer getTunica() {
		return tunica;
	}


	public void setTunica(Integer tunica) {
		this.tunica = tunica;
	}


	public String getQuepe() {
		return quepe;
	}


	public void setQuepe(String quepe) {
		this.quepe = quepe;
	}


	public String getBoina() {
		return boina;
	}


	public void setBoina(String boina) {
		this.boina = boina;
	}


	public String getSapato() {
		return sapato;
	}


	public void setSapato(String sapato) {
		this.sapato = sapato;
	}


	public String getCoturno() {
		return coturno;
	}


	public void setCoturno(String coturno) {
		this.coturno = coturno;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public Integer getAltura() {
		return altura;
	}


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public String getCnh() {
		return cnh;
	}


	public void setCnh(String cnh) {
		this.cnh = cnh;
	}


	public Date getValidade() {
		return validade;
	}


	public void setValidade(Date validade) {
		this.validade = validade;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getOrigem() {
		return origem;
	}


	public void setOrigem(String origem) {
		this.origem = origem;
	}


	public String getUnidade() {
		return unidade;
	}


	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}


	public Date getDataPraca() {
		return dataPraca;
	}


	public void setDataPraca(Date dataPraca) {
		this.dataPraca = dataPraca;
	}


	public String getTipoSanguineo() {
		return tipoSanguineo;
	}


	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}


	public String getAlergia() {
		return alergia;
	}


	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}


	public String getQualAlergia() {
		return qualAlergia;
	}


	public void setQualAlergia(String qualAlergia) {
		this.qualAlergia = qualAlergia;
	}


	public String getDadosEmergenciais() {
		return dadosEmergenciais;
	}


	public void setDadosEmergenciais(String dadosEmergenciais) {
		this.dadosEmergenciais = dadosEmergenciais;
	}


	public String getDoadorSangue() {
		return doadorSangue;
	}


	public void setDoadorSangue(String doadorSangue) {
		this.doadorSangue = doadorSangue;
	}


	public String getContatoEmergencia() {
		return contatoEmergencia;
	}


	public void setContatoEmergencia(String contatoEmergencia) {
		this.contatoEmergencia = contatoEmergencia;
	}


	public String getDigitador() {
		return digitador;
	}


	public void setDigitador(String digitador) {
		this.digitador = digitador;
	}


	public String getpMOrigem() {
		return pMOrigem;
	}


	public void setpMOrigem(String pMOrigem) {
		this.pMOrigem = pMOrigem;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public String getObservacao1() {
		return observacao1;
	}


	public void setObservacao1(String observacao1) {
		this.observacao1 = observacao1;
	}


	public Date getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getSvMilitar() {
		return svMilitar;
	}


	public void setSvMilitar(String svMilitar) {
		this.svMilitar = svMilitar;
	}


	public String getAtivo() {
		return ativo;
	}


	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}


	public Boolean getPossuiCnh() {
		return possuiCnh;
	}


	public void setPossuiCnh(Boolean possuiCnh) {
		this.possuiCnh = possuiCnh;
	}


	public String getSubJudice() {
		return subJudice;
	}


	public void setSubJudice(String subJudice) {
		this.subJudice = subJudice;
	}


	public String getObsHistorico1() {
		return obsHistorico1;
	}


	public void setObsHistorico1(String obsHistorico1) {
		this.obsHistorico1 = obsHistorico1;
	}


	public String getComportamento() {
		return comportamento;
	}


	public void setComportamento(String comportamento) {
		this.comportamento = comportamento;
	}


	public String getGraduacaoAnterior() {
		return graduacaoAnterior;
	}


	public void setGraduacaoAnterior(String graduacaoAnterior) {
		this.graduacaoAnterior = graduacaoAnterior;
	}


	public String getPostoAtual() {
		return postoAtual;
	}


	public void setPostoAtual(String postoAtual) {
		this.postoAtual = postoAtual;
	}


	public String getDoencas() {
		return doencas;
	}


	public void setDoencas(String doencas) {
		this.doencas = doencas;
	}


	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public String getAlunoNome() {
		return alunoNome;
	}

	public void setAlunoNome(String alunoNome) {
		this.alunoNome = alunoNome;
	}
}
