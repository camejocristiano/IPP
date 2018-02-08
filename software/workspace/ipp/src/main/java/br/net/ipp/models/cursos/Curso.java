package br.net.ipp.models.cursos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.Status;
import br.net.ipp.enums.StatusPAP;
import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.configuracoes.Unidade;

@Entity
public class Curso  extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private ArcoOcupacional arcoOcupacional;
	private String articulacaoComOutrasAreas;
	private String atividadesPraticas;
	private String cargaHorariaTotal;
	private String cargaHorariaSemanal;
	@ManyToOne
	private CBO cBO;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "basiso_curso", 
      joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "basiso_id", 
      referencedColumnName = "id"))
	private List<ConteudoTeoricoBasico> conteudosTeoricosBasicos;
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "especifico_curso", 
      joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "especifico_id", 
      referencedColumnName = "id"))
	private List<ConteudoTeoricoEspecifico> conteudosTeoricosEspecificos;
	@Column(name = "dataDoCadastro")  
	@DateTimeFormat(pattern = "dd/mm/yyyy")  
	private Date dataDoCadastro;
	private boolean livre;
	private boolean pap;
	private StatusPAP statusPAP;
	private Status statusLivre;
	private String nomeDoCurso;
	private String numeroDoCurso;
	private String publicoAlvo;
	private String resumo;
	private Status status;
	@ManyToOne
	private Unidade unidade;
	
	
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
	public String getAtividadesPraticas() {
		return atividadesPraticas;
	}
	public void setAtividadesPraticas(String atividadesPraticas) {
		this.atividadesPraticas = atividadesPraticas;
	}
	public String getCargaHorariaTotal() {
		return cargaHorariaTotal;
	}
	public void setCargaHorariaTotal(String cargaHorariaTotal) {
		this.cargaHorariaTotal = cargaHorariaTotal;
	}
	public String getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}
	public void setCargaHorariaSemanal(String cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
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
	public Status getStatusLivre() {
		return statusLivre;
	}
	public void setStatusLivre(Status statusLivre) {
		this.statusLivre = statusLivre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}