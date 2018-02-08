package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.StatusDaContratacao;
import br.net.ipp.enums.TipoDeContratacao;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;

@Entity
public class Contratacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "dataDeInicioDaContratacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDeInicioDaContratacao;
	@ManyToOne
	private Empresa empresaContratante;
	@ManyToOne
	private Gestor gestorContratacao;
	@Column(name = "exameAdmissional")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date exameAdmissional;
	@Column(name = "terminoDoContrato")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date terminoDoContrato;
	@ManyToOne
	private Jovem jovem;
	private String contratacaoObservacoes;
	@ManyToOne
	private CBO dadosDoCursoCBO;
	@ManyToOne
	private Curso curso;
	@Column(name = "dataDeInicioDoCurso")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date dataDeInicioDoCurso;
	private String diaDoCurso;
	private boolean domingo;
	@Column(name = "feriasDataDeFim")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date feriasDataDeFim;
	@Column(name = "feriasDataDeInicio")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date feriasDataDeInicio;
	@Column(name = "feriasDataDeVencimento")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date feriasDataDeVencimento;
	private String feriasDiasAGozar;
	private String horarioDeTrabalho;
	private String localDeTrgabalho;
	private boolean segunda;
	private boolean terca;
	private boolean quarta;
	private boolean quinta;
	private boolean sexta;
	private boolean sabado;
	private TipoDeContratacao tipoDeContratacao;
	private String totalDeHorasSemana;
	private StatusDaContratacao statusDaContratacao;

	public Gestor getGestorContratacao() {
		return gestorContratacao;
	}
	public void setGestorContratacao(Gestor gestorContratacao) {
		this.gestorContratacao = gestorContratacao;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public String getContratacaoObservacoes() {
		return contratacaoObservacoes;
	}
	public void setContratacaoObservacoes(String contratacaoObservacoes) {
		this.contratacaoObservacoes = contratacaoObservacoes;
	}
	public Empresa getEmpresaContratante() {
		return empresaContratante;
	}
	public void setEmpresaContratante(Empresa empresaContratante) {
		this.empresaContratante = empresaContratante;
	}
	public Date getExameAdmissional() {
		return exameAdmissional;
	}
	public void setExameAdmissional(Date exameAdmissional) {
		this.exameAdmissional = exameAdmissional;
	}
	public Date getTerminoDoContrato() {
		return terminoDoContrato;
	}
	public void setTerminoDoContrato(Date terminoDoContrato) {
		this.terminoDoContrato = terminoDoContrato;
	}
	public CBO getDadosDoCursoCBO() {
		return dadosDoCursoCBO;
	}
	public void setDadosDoCursoCBO(CBO dadosDoCursoCBO) {
		this.dadosDoCursoCBO = dadosDoCursoCBO;
	}
	public Date getDataDeInicioDoCurso() {
		return dataDeInicioDoCurso;
	}
	public void setDataDeInicioDoCurso(Date dataDeInicioDoCurso) {
		this.dataDeInicioDoCurso = dataDeInicioDoCurso;
	}
	public String getDiaDoCurso() {
		return diaDoCurso;
	}
	public void setDiaDoCurso(String diaDoCurso) {
		this.diaDoCurso = diaDoCurso;
	}
	public boolean getDomingo() {
		return domingo;
	}
	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}
	public Date getFeriasDataDeFim() {
		return feriasDataDeFim;
	}
	public void setFeriasDataDeFim(Date feriasDataDeFim) {
		this.feriasDataDeFim = feriasDataDeFim;
	}
	public Date getFeriasDataDeInicio() {
		return feriasDataDeInicio;
	}
	public void setFeriasDataDeInicio(Date feriasDataDeInicio) {
		this.feriasDataDeInicio = feriasDataDeInicio;
	}
	public Date getFeriasDataDeVencimento() {
		return feriasDataDeVencimento;
	}
	public void setFeriasDataDeVencimento(Date feriasDataDeVencimento) {
		this.feriasDataDeVencimento = feriasDataDeVencimento;
	}
	public String getFeriasDiasAGozar() {
		return feriasDiasAGozar;
	}
	public void setFeriasDiasAGozar(String feriasDiasAGozar) {
		this.feriasDiasAGozar = feriasDiasAGozar;
	}
	public String getHorarioDeTrabalho() {
		return horarioDeTrabalho;
	}
	public void setHorarioDeTrabalho(String horarioDeTrabalho) {
		this.horarioDeTrabalho = horarioDeTrabalho;
	}
	public String getLocalDeTrgabalho() {
		return localDeTrgabalho;
	}
	public void setLocalDeTrgabalho(String localDeTrgabalho) {
		this.localDeTrgabalho = localDeTrgabalho;
	}
	public boolean getQuarta() {
		return quarta;
	}
	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}
	public boolean getQuinta() {
		return quinta;
	}
	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}
	public boolean getSabado() {
		return sabado;
	}
	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}
	public boolean getSegunda() {
		return segunda;
	}
	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}
	public boolean getSexta() {
		return sexta;
	}
	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}
	public boolean getTerca() {
		return terca;
	}
	public void setTerca(boolean terca) {
		this.terca = terca;
	}
	public TipoDeContratacao getTipoDeContratacao() {
		return tipoDeContratacao;
	}
	public void setTipoDeContratacao(TipoDeContratacao tipoDeContratacao) {
		this.tipoDeContratacao = tipoDeContratacao;
	}
	public String getTotalDeHorasSemana() {
		return totalDeHorasSemana;
	}
	public void setTotalDeHorasSemana(String totalDeHorasSemana) {
		this.totalDeHorasSemana = totalDeHorasSemana;
	}
	public Date getDataDeInicioDaContratacao() {
		return dataDeInicioDaContratacao;
	}
	public void setDataDeInicioDaContratacao(Date dataDeInicioDaContratacao) {
		this.dataDeInicioDaContratacao = dataDeInicioDaContratacao;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public StatusDaContratacao getStatusDaContratacao() {
		return statusDaContratacao;
	}
	public void setStatusDaContratacao(StatusDaContratacao statusDaContratacao) {
		this.statusDaContratacao = statusDaContratacao;
	}

}