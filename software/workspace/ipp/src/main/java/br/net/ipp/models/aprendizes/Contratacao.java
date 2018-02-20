package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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

	private Integer diaDeInicioDaContratacao;
	private Integer mesDeInicioDaContratacao;
	private Integer anoDeInicioDaContratacao;
	@ManyToOne
	private Empresa empresaContratante;
	@ManyToOne
	private Gestor gestorContratacao;
	private String exameAdmissional;
	private Integer diaTerminoDoContrato;
	private Integer mesTerminoDoContrato;
	private Integer anoTerminoDoContrato;

	@ManyToOne
	private Jovem jovem;
	private String contratacaoObservacoes;
	@ManyToOne
	private CBO dadosDoCursoCBO;
	@ManyToOne
	private Curso curso;
	private String dataDeInicioDoCurso;
	private String diaDoCurso;
	private boolean domingo;
	
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
	private String observacoes;
	
	
	public Integer getDiaDeInicioDaContratacao() {
		return diaDeInicioDaContratacao;
	}
	public void setDiaDeInicioDaContratacao(Integer diaDeInicioDaContratacao) {
		this.diaDeInicioDaContratacao = diaDeInicioDaContratacao;
	}
	public Integer getMesDeInicioDaContratacao() {
		return mesDeInicioDaContratacao;
	}
	public void setMesDeInicioDaContratacao(Integer mesDeInicioDaContratacao) {
		this.mesDeInicioDaContratacao = mesDeInicioDaContratacao;
	}
	public Integer getAnoDeInicioDaContratacao() {
		return anoDeInicioDaContratacao;
	}
	public void setAnoDeInicioDaContratacao(Integer anoDeInicioDaContratacao) {
		this.anoDeInicioDaContratacao = anoDeInicioDaContratacao;
	}
	public Empresa getEmpresaContratante() {
		return empresaContratante;
	}
	public void setEmpresaContratante(Empresa empresaContratante) {
		this.empresaContratante = empresaContratante;
	}
	public Gestor getGestorContratacao() {
		return gestorContratacao;
	}
	public void setGestorContratacao(Gestor gestorContratacao) {
		this.gestorContratacao = gestorContratacao;
	}
	public String getExameAdmissional() {
		return exameAdmissional;
	}
	public void setExameAdmissional(String exameAdmissional) {
		this.exameAdmissional = exameAdmissional;
	}
	public Integer getDiaTerminoDoContrato() {
		return diaTerminoDoContrato;
	}
	public void setDiaTerminoDoContrato(Integer diaTerminoDoContrato) {
		this.diaTerminoDoContrato = diaTerminoDoContrato;
	}
	public Integer getMesTerminoDoContrato() {
		return mesTerminoDoContrato;
	}
	public void setMesTerminoDoContrato(Integer mesTerminoDoContrato) {
		this.mesTerminoDoContrato = mesTerminoDoContrato;
	}
	public Integer getAnoTerminoDoContrato() {
		return anoTerminoDoContrato;
	}
	public void setAnoTerminoDoContrato(Integer anoTerminoDoContrato) {
		this.anoTerminoDoContrato = anoTerminoDoContrato;
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
	public CBO getDadosDoCursoCBO() {
		return dadosDoCursoCBO;
	}
	public void setDadosDoCursoCBO(CBO dadosDoCursoCBO) {
		this.dadosDoCursoCBO = dadosDoCursoCBO;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getDataDeInicioDoCurso() {
		return dataDeInicioDoCurso;
	}
	public void setDataDeInicioDoCurso(String dataDeInicioDoCurso) {
		this.dataDeInicioDoCurso = dataDeInicioDoCurso;
	}
	public String getDiaDoCurso() {
		return diaDoCurso;
	}
	public void setDiaDoCurso(String diaDoCurso) {
		this.diaDoCurso = diaDoCurso;
	}
	public boolean isDomingo() {
		return domingo;
	}
	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
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
	public boolean isSegunda() {
		return segunda;
	}
	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}
	public boolean isTerca() {
		return terca;
	}
	public void setTerca(boolean terca) {
		this.terca = terca;
	}
	public boolean isQuarta() {
		return quarta;
	}
	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}
	public boolean isQuinta() {
		return quinta;
	}
	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}
	public boolean isSexta() {
		return sexta;
	}
	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}
	public boolean isSabado() {
		return sabado;
	}
	public void setSabado(boolean sabado) {
		this.sabado = sabado;
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
	public StatusDaContratacao getStatusDaContratacao() {
		return statusDaContratacao;
	}
	public void setStatusDaContratacao(StatusDaContratacao statusDaContratacao) {
		this.statusDaContratacao = statusDaContratacao;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}