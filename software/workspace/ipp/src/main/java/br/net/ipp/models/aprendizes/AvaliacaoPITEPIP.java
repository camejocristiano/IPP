package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.TipoAvaliacaoEnum;
import br.net.ipp.models.AbstractEntity;

@Entity
public class AvaliacaoPITEPIP extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "avaliacoesPITEPIP_dataAutoAvaliacao")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPITEPIP_dataAutoAvaliacao;
	@Column(name = "avaliacoesPITEPIP_dataAvaliacaoInformatica")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPITEPIP_dataAvaliacaoInformatica;
	@Column(name = "avaliacoesPITEPIP_dataAvaliacaoMatematica")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPITEPIP_dataAvaliacaoMatematica;
	@Column(name = "avaliacoesPITEPIP_dataAvaliacaoOrientador")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPITEPIP_dataAvaliacaoOrientador;
	@Column(name = "avaliacoesPITEPIP_dataAvaliacaoPortugues")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPITEPIP_dataAvaliacaoPortugues;
	@Column(name = "avaliacoesPITEPIP_dataAvaliacaoVivencia")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date avaliacoesPITEPIP_dataAvaliacaoVivencia;
	private double avaliacoesPITEPIP_notaAutoavaliacao;
	private double avaliacoesPITEPIP_notaAvaliacaoInformatica;
	private double avaliacoesPITEPIP_notaAvaliacaoMatematica;
	private double avaliacoesPITEPIP_notaAvaliacaoOrientador;
	private double avaliacoesPITEPIP_notaAvaliacaoPortugues;
	private double avaliacoesPITEPIP_notaAvaliacaoVivencia;
	private TipoAvaliacaoEnum tipoAvaliacao;
	@ManyToOne
	private Jovem jovem;
	
	
	public Date getAvaliacoesPITEPIP_dataAutoAvaliacao() {
		return avaliacoesPITEPIP_dataAutoAvaliacao;
	}
	public void setAvaliacoesPITEPIP_dataAutoAvaliacao(Date avaliacoesPITEPIP_dataAutoAvaliacao) {
		this.avaliacoesPITEPIP_dataAutoAvaliacao = avaliacoesPITEPIP_dataAutoAvaliacao;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoInformatica() {
		return avaliacoesPITEPIP_dataAvaliacaoInformatica;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoInformatica(Date avaliacoesPITEPIP_dataAvaliacaoInformatica) {
		this.avaliacoesPITEPIP_dataAvaliacaoInformatica = avaliacoesPITEPIP_dataAvaliacaoInformatica;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoMatematica() {
		return avaliacoesPITEPIP_dataAvaliacaoMatematica;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoMatematica(Date avaliacoesPITEPIP_dataAvaliacaoMatematica) {
		this.avaliacoesPITEPIP_dataAvaliacaoMatematica = avaliacoesPITEPIP_dataAvaliacaoMatematica;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoOrientador() {
		return avaliacoesPITEPIP_dataAvaliacaoOrientador;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoOrientador(Date avaliacoesPITEPIP_dataAvaliacaoOrientador) {
		this.avaliacoesPITEPIP_dataAvaliacaoOrientador = avaliacoesPITEPIP_dataAvaliacaoOrientador;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoPortugues() {
		return avaliacoesPITEPIP_dataAvaliacaoPortugues;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoPortugues(Date avaliacoesPITEPIP_dataAvaliacaoPortugues) {
		this.avaliacoesPITEPIP_dataAvaliacaoPortugues = avaliacoesPITEPIP_dataAvaliacaoPortugues;
	}
	public Date getAvaliacoesPITEPIP_dataAvaliacaoVivencia() {
		return avaliacoesPITEPIP_dataAvaliacaoVivencia;
	}
	public void setAvaliacoesPITEPIP_dataAvaliacaoVivencia(Date avaliacoesPITEPIP_dataAvaliacaoVivencia) {
		this.avaliacoesPITEPIP_dataAvaliacaoVivencia = avaliacoesPITEPIP_dataAvaliacaoVivencia;
	}
	public double getAvaliacoesPITEPIP_notaAutoavaliacao() {
		return avaliacoesPITEPIP_notaAutoavaliacao;
	}
	public void setAvaliacoesPITEPIP_notaAutoavaliacao(double avaliacoesPITEPIP_notaAutoavaliacao) {
		this.avaliacoesPITEPIP_notaAutoavaliacao = avaliacoesPITEPIP_notaAutoavaliacao;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoInformatica() {
		return avaliacoesPITEPIP_notaAvaliacaoInformatica;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoInformatica(double avaliacoesPITEPIP_notaAvaliacaoInformatica) {
		this.avaliacoesPITEPIP_notaAvaliacaoInformatica = avaliacoesPITEPIP_notaAvaliacaoInformatica;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoMatematica() {
		return avaliacoesPITEPIP_notaAvaliacaoMatematica;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoMatematica(double avaliacoesPITEPIP_notaAvaliacaoMatematica) {
		this.avaliacoesPITEPIP_notaAvaliacaoMatematica = avaliacoesPITEPIP_notaAvaliacaoMatematica;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoOrientador() {
		return avaliacoesPITEPIP_notaAvaliacaoOrientador;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoOrientador(double avaliacoesPITEPIP_notaAvaliacaoOrientador) {
		this.avaliacoesPITEPIP_notaAvaliacaoOrientador = avaliacoesPITEPIP_notaAvaliacaoOrientador;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoPortugues() {
		return avaliacoesPITEPIP_notaAvaliacaoPortugues;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoPortugues(double avaliacoesPITEPIP_notaAvaliacaoPortugues) {
		this.avaliacoesPITEPIP_notaAvaliacaoPortugues = avaliacoesPITEPIP_notaAvaliacaoPortugues;
	}
	public double getAvaliacoesPITEPIP_notaAvaliacaoVivencia() {
		return avaliacoesPITEPIP_notaAvaliacaoVivencia;
	}
	public void setAvaliacoesPITEPIP_notaAvaliacaoVivencia(double avaliacoesPITEPIP_notaAvaliacaoVivencia) {
		this.avaliacoesPITEPIP_notaAvaliacaoVivencia = avaliacoesPITEPIP_notaAvaliacaoVivencia;
	}
	public TipoAvaliacaoEnum getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	public void setTipoAvaliacao(TipoAvaliacaoEnum tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
