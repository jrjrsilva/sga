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

@Entity
@Table(name = "tnota")
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodNota")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codNota;
    
    @Column(name = "Ano")
    private Integer ano;
    
    public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@Column(name = "Bimestre")
    private String bimestre;
    
	 @JoinColumn(name = "CodSerie", referencedColumnName = "CodSerie")
	 @ManyToOne
	 private Serie serie;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
   
    public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	/* 1º Semestre */
    @Column(name = "VC1_1Sem")
    private Float vC11Sem;
    
    @Column(name = "VC2_1Sem")
    private Float vC21Sem;
    
    @Column(name = "VF_1Sem")
    private Float vF1Sem;
    
    @Column(name = "MedPar_1Sem")
    private Float medPar1Sem;
    
    @Column(name = "MedFin_1Sem")
    private Float medFin1Sem;
    
    @Column(name = "Cons_1Sem")
    private Float cons1Sem;
    
    @Column(name = "Rec_1Sem")
    private Float rec1Sem;
    
    @Column(name = "Res_1Sem")
    private String res1Sem;
    
    @Column(name = "Ch_1Sem")
    private Integer ch1Sem;
    
    /*2º semestre*/
    @Column(name = "VC1_2Sem")
    private Float vC12Sem;
    
    @Column(name = "VC2_2Sem")
    private Float vC22Sem;
    
    @Column(name = "VF_2Sem")
    private Float vF2Sem;
    
    @Column(name = "MedPar_2Sem")
    private Float medPar2Sem;
    
    @Column(name = "MedFin_2Sem")
    private Float medFin2Sem;
    
    @Column(name = "Cons_2Sem")
    private Float cons2Sem;
    
    @Column(name = "Rec_2Sem")
    private Float rec2Sem;
    
    @Column(name = "Res_2Sem")
    private String res2Sem;
    
    @Column(name = "CH_2Sem")
    private Integer cH2Sem;
    
    /* Final Ano */
    @Column(name = "MedFinal")
    private Float medFinal;
    @Column(name = "HorasAnual")
    private Integer horasAnual;
    @Column(name = "Reprova")
    private String reprova;
    @Column(name = "CodSenhaDigitador")
    private Integer codSenhaDigitador;
    @Column(name = "ImpHistorico")
    private String impHistorico;
    @Column(name = "ImpBoletim")
    private String impBoletim;
    @Column(name = "AtivoNota")
    private String ativoNota;
    @Column(name = "ResSituacao")
    private String resSituacao;
    @Column(name = "ChTot")
    private Integer chTot;
    @Column(name = "ResGeral")
    private String resGeral;
    @Column(name = "Semestre")
    private String semestre;
    @Column(name = "Peso")
    private String peso;
    
    
    @JoinColumn(name = "CodTurma", referencedColumnName = "CodTurma")
    @ManyToOne
    private Turma turma;
    
    @JoinColumn(name = "CodAluno", referencedColumnName = "CodAluno")
    @ManyToOne
    private Aluno aluno;
    
    @JoinColumn(name = "CodDisciplina", referencedColumnName = "CodDisciplina")
    @ManyToOne
    private Disciplina disciplina;

    public Nota() {
    }

	public Integer getCodNota() {
		return codNota;
	}

	public void setCodNota(Integer codNota) {
		this.codNota = codNota;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getBimestre() {
		return bimestre;
	}

	public void setBimestre(String bimestre) {
		this.bimestre = bimestre;
	}

	public Nota(Integer ano, Turma turma, Aluno aluno, Disciplina disciplina,Serie serie) {
		super();
		this.ano = ano;
		this.turma = turma;
		this.aluno = aluno;
		this.disciplina = disciplina;
		this.serie = serie;
	}

	public Float getvC11Sem() {
		return vC11Sem;
	}

	public void setvC11Sem(Float vC11Sem) {
		this.vC11Sem = vC11Sem;
	}

	public Float getvC21Sem() {
		return vC21Sem;
	}

	public void setvC21Sem(Float vC21Sem) {
		this.vC21Sem = vC21Sem;
	}

	public Float getvF1Sem() {
		return vF1Sem;
	}

	public void setvF1Sem(Float vF1Sem) {
		this.vF1Sem = vF1Sem;
	}

	public Float getMedPar1Sem() {
		return medPar1Sem;
	}
	
	public void setMedPar1Sem(Float medPar1Sem) {
		this.medPar1Sem = medPar1Sem;
	}

	public Float getMedFin1Sem() {
		return medFin1Sem;
	}

	public void setMedFin1Sem(Float medFin1Sem) {
		this.medFin1Sem = medFin1Sem;
	}

	public Float getCons1Sem() {
		return cons1Sem;
	}

	public void setCons1Sem(Float cons1Sem) {
		this.cons1Sem = cons1Sem;
	}

	public Float getRec1Sem() {
		return rec1Sem;
	}

	public void setRec1Sem(Float rec1Sem) {
		this.rec1Sem = rec1Sem;
	}

	public String getRes1Sem() {
		return res1Sem;
	}

	public void setRes1Sem(String res1Sem) {
		this.res1Sem = res1Sem;
	}

	public Integer getCh1Sem() {
		return ch1Sem;
	}

	public void setCh1Sem(Integer ch1Sem) {
		this.ch1Sem = ch1Sem;
	}

	public Float getvC12Sem() {
		return vC12Sem;
	}

	public void setvC12Sem(Float vC12Sem) {
		this.vC12Sem = vC12Sem;
	}

	public Float getvC22Sem() {
		return vC22Sem;
	}

	public void setvC22Sem(Float vC22Sem) {
		this.vC22Sem = vC22Sem;
	}

	public Float getvF2Sem() {
		return vF2Sem;
	}

	public void setvF2Sem(Float vF2Sem) {
		this.vF2Sem = vF2Sem;
	}

	public Float getMedPar2Sem() {
		return medPar2Sem;
	}

	public void setMedPar2Sem(Float medPar2Sem) {
		this.medPar2Sem = medPar2Sem;
	}

	public Float getMedFin2Sem() {
		return medFin2Sem;
	}

	public void setMedFin2Sem(Float medFin2Sem) {
		this.medFin2Sem = medFin2Sem;
	}

	public Float getCons2Sem() {
		return cons2Sem;
	}

	public void setCons2Sem(Float cons2Sem) {
		this.cons2Sem = cons2Sem;
	}

	public Float getRec2Sem() {
		return rec2Sem;
	}

	public void setRec2Sem(Float rec2Sem) {
		this.rec2Sem = rec2Sem;
	}

	public String getRes2Sem() {
		return res2Sem;
	}

	public void setRes2Sem(String res2Sem) {
		this.res2Sem = res2Sem;
	}

	public Integer getcH2Sem() {
		return cH2Sem;
	}

	public void setcH2Sem(Integer cH2Sem) {
		this.cH2Sem = cH2Sem;
	}

	public Float getMedFinal() {
		return medFinal;
	}

	public void setMedFinal(Float medFinal) {
		this.medFinal = medFinal;
	}

	public Integer getHorasAnual() {
		return horasAnual;
	}

	public void setHorasAnual(Integer horasAnual) {
		this.horasAnual = horasAnual;
	}

	public String getReprova() {
		return reprova;
	}

	public void setReprova(String reprova) {
		this.reprova = reprova;
	}

	public Integer getCodSenhaDigitador() {
		return codSenhaDigitador;
	}

	public void setCodSenhaDigitador(Integer codSenhaDigitador) {
		this.codSenhaDigitador = codSenhaDigitador;
	}

	public String getImpHistorico() {
		return impHistorico;
	}

	public void setImpHistorico(String impHistorico) {
		this.impHistorico = impHistorico;
	}

	public String getImpBoletim() {
		return impBoletim;
	}

	public void setImpBoletim(String impBoletim) {
		this.impBoletim = impBoletim;
	}

	public String getAtivoNota() {
		return ativoNota;
	}

	public void setAtivoNota(String ativoNota) {
		this.ativoNota = ativoNota;
	}

	public String getResSituacao() {
		return resSituacao;
	}

	public void setResSituacao(String resSituacao) {
		this.resSituacao = resSituacao;
	}

	public Integer getChTot() {
		return chTot;
	}

	public void setChTot(Integer chTot) {
		this.chTot = chTot;
	}

	public String getResGeral() {
		return resGeral;
	}

	public void setResGeral(String resGeral) {
		this.resGeral = resGeral;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
