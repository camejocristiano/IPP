package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Contratacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Jovem jovem;
	private String contratacaoObservacoes;
	/*private CBO dadosDoCursoCBO;
	private Date dataDeInicioDoCurso;
	private String diaDoCurso;
	private Boolean domingo;
	private Empresa empresa;
	private Date exameAdmissional;
	private Date feriasDataDeFim;
	private Date feriasDataDeInicio;
	private Date feriasDataDeVencimento;
	private String feriasDiasAGozar;
	private Gestor gestor;
	private String horarioDeTrabalho;
	private String localDeTrgabalho;
	private Boolean quarta;
	private Boolean quinta;
	private Boolean sabado;
	private Boolean segunda;
	private Boolean sexta;
	private Boolean terca;
	private Date terminoDoContrato;
	private TipoDeContratacao tipoDeContratacao;
	private String totalDeHorasSemanai;*/

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
	/*public CBO getDadosDoCursoCBO() {
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
	public Boolean getDomingo() {
		return domingo;
	}
	public void setDomingo(Boolean domingo) {
		this.domingo = domingo;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Date getExameAdmissional() {
		return exameAdmissional;
	}
	public void setExameAdmissional(Date exameAdmissional) {
		this.exameAdmissional = exameAdmissional;
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
	public Gestor getGestor() {
		return gestor;
	}
	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
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
	public Boolean getQuarta() {
		return quarta;
	}
	public void setQuarta(Boolean quarta) {
		this.quarta = quarta;
	}
	public Boolean getQuinta() {
		return quinta;
	}
	public void setQuinta(Boolean quinta) {
		this.quinta = quinta;
	}
	public Boolean getSabado() {
		return sabado;
	}
	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}
	public Boolean getSegunda() {
		return segunda;
	}
	public void setSegunda(Boolean segunda) {
		this.segunda = segunda;
	}
	public Boolean getSexta() {
		return sexta;
	}
	public void setSexta(Boolean sexta) {
		this.sexta = sexta;
	}
	public Boolean getTerca() {
		return terca;
	}
	public void setTerca(Boolean terca) {
		this.terca = terca;
	}
	public Date getTerminoDoContrato() {
		return terminoDoContrato;
	}
	public void setTerminoDoContrato(Date terminoDoContrato) {
		this.terminoDoContrato = terminoDoContrato;
	}
	public TipoDeContratacao getTipoDeContratacao() {
		return tipoDeContratacao;
	}
	public void setTipoDeContratacao(TipoDeContratacao tipoDeContratacao) {
		this.tipoDeContratacao = tipoDeContratacao;
	}
	public String getTotalDeHorasSemanai() {
		return totalDeHorasSemanai;
	}
	public void setTotalDeHorasSemanai(String totalDeHorasSemanai) {
		this.totalDeHorasSemanai = totalDeHorasSemanai;
	}*/

}