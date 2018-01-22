package br.net.ipp.models.cursos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.Status;
import br.net.ipp.enums.StatusPAP;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.configuracoes.Unidade;

@Entity
public class Curso  extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private ArcoOcupacional arcoOcupacional;
	private String articulacaoComOutrasAreas;
	private String atividadePraticas;
	private String cargaHorariaTotal;
	private String cargaHorarioSemanal;
	@ManyToOne
	private CBO cBO;
	/*@OneToMany
	private List<ConteudoTeoricoBasico> conteudosTeoricosBasicos;
	@OneToMany
	private List<ConteudoTeoricoEspecifico> conteudosTeoricosEspecificos;
	*/private Date dataDoCadastro;
	private boolean livre;
	private boolean pap;
	private StatusPAP statusPAP;
	private String nomeDoCurso;
	private String numeroDoCurso;
	
	private String publicoAlvo;
	private String resumo;
	private Status status;
	
	@ManyToOne
	private Unidade unidade;
	/*
	@OneToMany
	private List<Validacao> validacoes;
	*/
	
	
	public ArcoOcupacional getArcoOcupacional() {
		return arcoOcupacional;
	}
	public void setArcoOcupacional(ArcoOcupacional arcoOcupacional) {
		this.arcoOcupacional = arcoOcupacional;
	}
	public String getArticulacaoComOutrasAreas() {
		return articulacaoComOutrasAreas;
	}
	public void setArticulacaoComOutrasAreas(String articulacaoComOutrasAreas) {
		this.articulacaoComOutrasAreas = articulacaoComOutrasAreas;
	}
	public String getAtividadePraticas() {
		return atividadePraticas;
	}
	public void setAtividadePraticas(String atividadePraticas) {
		this.atividadePraticas = atividadePraticas;
	}
	public String getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	public void setCargaHorariaTotal(String cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	public String getCargaHorarioSemanal() {
		return cargaHorarioSemanal;
	}
	public void setCargaHorarioSemanal(String cargaHorarioSemanal) {
		this.cargaHorarioSemanal = cargaHorarioSemanal;
	}
	/*	public CBO getcBO() {
		return cBO;
	}
	public void setcBO(CBO cBO) {
		this.cBO = cBO;
	}
	public List<ConteudoTeoricoBasico> getConteudosTeoricosBasicos() {
		return conteudosTeoricosBasicos;
	}
	public void setConteudosTeoricosBasicos(List<ConteudoTeoricoBasico> conteudosTeoricosBasicos) {
		this.conteudosTeoricosBasicos = conteudosTeoricosBasicos;
	}
	public List<ConteudoTeoricoEspecifico> getConteudosTeoricosEspecificos() {
		return conteudosTeoricosEspecificos;
	}
	public void setConteudosTeoricosEspecificos(List<ConteudoTeoricoEspecifico> conteudosTeoricosEspecificos) {
		this.conteudosTeoricosEspecificos = conteudosTeoricosEspecificos;
	}*/
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}
	public String getNomeDoCurso() {
		return nomeDoCurso;
	}
	public void setNomeDoCurso(String nomeDoCurso) {
		this.nomeDoCurso = nomeDoCurso;
	}
	public String getNumeroDoCurso() {
		return numeroDoCurso;
	}
	public void setNumeroDoCurso(String numeroDoCurso) {
		this.numeroDoCurso = numeroDoCurso;
	}
	public String getPublicoAlvo() {
		return publicoAlvo;
	}
	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	/*	public List<Validacao> getValidacoes() {
		return validacoes;
	}
	public void setValidacoes(List<Validacao> validacoes) {
		this.validacoes = validacoes;
	}*/

	public boolean isLivre() {
		return livre;
	}
	public void setLivre(boolean livre) {
		this.livre = livre;
	}
	public boolean isPap() {
		return pap;
	}
	public void setPap(boolean pap) {
		this.pap = pap;
	}
	public StatusPAP getStatusPAP() {
		return statusPAP;
	}
	public void setStatusPAP(StatusPAP statusPAP) {
		this.statusPAP = statusPAP;
	}
	public CBO getcBO() {
		return cBO;
	}
	public void setcBO(CBO cBO) {
		this.cBO = cBO;
	}

}