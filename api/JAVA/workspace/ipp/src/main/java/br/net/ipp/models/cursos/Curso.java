package br.net.ipp.models.cursos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import br.net.ipp.enums.Status;
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
	private CBO cBO;
	@OneToMany
	private List<ConteudoTeoricoBasico> conteudosTeoricosBasicos;
	@OneToMany
	private List<ConteudoTeoricoEspecifico> conteudosTeoricosEspecificos;
	private Date dataDoCadastro;
	private Boolean livre;
	private String nomeDoCurso;
	private String numeroDoCurso;
	private Boolean pAP;
	private String publicoAlvo;
	private String resumo;
	private Status statusDoCurso;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "curso_unidade", joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "unidade_id", referencedColumnName = "id"))
	private List<Unidade> unidades;
	@OneToMany
	private List<Validacao> validacoes;
	
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
	public CBO getcBO() {
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
	}
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}
	public Boolean getLivre() {
		return livre;
	}
	public void setLivre(Boolean livre) {
		this.livre = livre;
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
	public Boolean getpAP() {
		return pAP;
	}
	public void setpAP(Boolean pAP) {
		this.pAP = pAP;
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
	public Status getStatusDoCurso() {
		return statusDoCurso;
	}
	public void setStatusDoCurso(Status statusDoCurso) {
		this.statusDoCurso = statusDoCurso;
	}
	public List<Unidade> getUnidades() {
		return unidades;
	}
	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}
	public List<Validacao> getValidacoes() {
		return validacoes;
	}
	public void setValidacoes(List<Validacao> validacoes) {
		this.validacoes = validacoes;
	}

}