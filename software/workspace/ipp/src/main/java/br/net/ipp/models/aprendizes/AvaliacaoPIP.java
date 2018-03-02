package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class AvaliacaoPIP extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String avaliacoesPIP_dataAutoAvaliacao;
	private String avaliacoesPIP_dataAvaliacaoInformatica;
	private String avaliacoesPIP_dataAvaliacaoMatematica;
	private String avaliacoesPIP_dataAvaliacaoOrientador;
	private String avaliacoesPIP_dataAvaliacaoPortugues;
	private String avaliacoesPIP_dataAvaliacaoVivencia;
	private double avaliacoesPIP_notaAutoavaliacao;
	private double avaliacoesPIP_notaAvaliacaoInformatica;
	private double avaliacoesPIP_notaAvaliacaoMatematica;
	private double avaliacoesPIP_notaAvaliacaoOrientador;
	private double avaliacoesPIP_notaAvaliacaoPortugues;
	private double avaliacoesPIP_notaAvaliacaoVivencia;
	@ManyToOne
	private Historico historico;
	
	
	public String getAvaliacoesPIP_dataAutoAvaliacao() {
		return avaliacoesPIP_dataAutoAvaliacao;
	}
	public void setAvaliacoesPIP_dataAutoAvaliacao(String avaliacoesPIP_dataAutoAvaliacao) {
		this.avaliacoesPIP_dataAutoAvaliacao = avaliacoesPIP_dataAutoAvaliacao;
	}
	public String getAvaliacoesPIP_dataAvaliacaoInformatica() {
		return avaliacoesPIP_dataAvaliacaoInformatica;
	}
	public void setAvaliacoesPIP_dataAvaliacaoInformatica(String avaliacoesPIP_dataAvaliacaoInformatica) {
		this.avaliacoesPIP_dataAvaliacaoInformatica = avaliacoesPIP_dataAvaliacaoInformatica;
	}
	public String getAvaliacoesPIP_dataAvaliacaoMatematica() {
		return avaliacoesPIP_dataAvaliacaoMatematica;
	}
	public void setAvaliacoesPIP_dataAvaliacaoMatematica(String avaliacoesPIP_dataAvaliacaoMatematica) {
		this.avaliacoesPIP_dataAvaliacaoMatematica = avaliacoesPIP_dataAvaliacaoMatematica;
	}
	public String getAvaliacoesPIP_dataAvaliacaoOrientador() {
		return avaliacoesPIP_dataAvaliacaoOrientador;
	}
	public void setAvaliacoesPIP_dataAvaliacaoOrientador(String avaliacoesPIP_dataAvaliacaoOrientador) {
		this.avaliacoesPIP_dataAvaliacaoOrientador = avaliacoesPIP_dataAvaliacaoOrientador;
	}
	public String getAvaliacoesPIP_dataAvaliacaoPortugues() {
		return avaliacoesPIP_dataAvaliacaoPortugues;
	}
	public void setAvaliacoesPIP_dataAvaliacaoPortugues(String avaliacoesPIP_dataAvaliacaoPortugues) {
		this.avaliacoesPIP_dataAvaliacaoPortugues = avaliacoesPIP_dataAvaliacaoPortugues;
	}
	public String getAvaliacoesPIP_dataAvaliacaoVivencia() {
		return avaliacoesPIP_dataAvaliacaoVivencia;
	}
	public void setAvaliacoesPIP_dataAvaliacaoVivencia(String avaliacoesPIP_dataAvaliacaoVivencia) {
		this.avaliacoesPIP_dataAvaliacaoVivencia = avaliacoesPIP_dataAvaliacaoVivencia;
	}
	public double getAvaliacoesPIP_notaAutoavaliacao() {
		return avaliacoesPIP_notaAutoavaliacao;
	}
	public void setAvaliacoesPIP_notaAutoavaliacao(double avaliacoesPIP_notaAutoavaliacao) {
		this.avaliacoesPIP_notaAutoavaliacao = avaliacoesPIP_notaAutoavaliacao;
	}
	public double getAvaliacoesPIP_notaAvaliacaoInformatica() {
		return avaliacoesPIP_notaAvaliacaoInformatica;
	}
	public void setAvaliacoesPIP_notaAvaliacaoInformatica(double avaliacoesPIP_notaAvaliacaoInformatica) {
		this.avaliacoesPIP_notaAvaliacaoInformatica = avaliacoesPIP_notaAvaliacaoInformatica;
	}
	public double getAvaliacoesPIP_notaAvaliacaoMatematica() {
		return avaliacoesPIP_notaAvaliacaoMatematica;
	}
	public void setAvaliacoesPIP_notaAvaliacaoMatematica(double avaliacoesPIP_notaAvaliacaoMatematica) {
		this.avaliacoesPIP_notaAvaliacaoMatematica = avaliacoesPIP_notaAvaliacaoMatematica;
	}
	public double getAvaliacoesPIP_notaAvaliacaoOrientador() {
		return avaliacoesPIP_notaAvaliacaoOrientador;
	}
	public void setAvaliacoesPIP_notaAvaliacaoOrientador(double avaliacoesPIP_notaAvaliacaoOrientador) {
		this.avaliacoesPIP_notaAvaliacaoOrientador = avaliacoesPIP_notaAvaliacaoOrientador;
	}
	public double getAvaliacoesPIP_notaAvaliacaoPortugues() {
		return avaliacoesPIP_notaAvaliacaoPortugues;
	}
	public void setAvaliacoesPIP_notaAvaliacaoPortugues(double avaliacoesPIP_notaAvaliacaoPortugues) {
		this.avaliacoesPIP_notaAvaliacaoPortugues = avaliacoesPIP_notaAvaliacaoPortugues;
	}
	public double getAvaliacoesPIP_notaAvaliacaoVivencia() {
		return avaliacoesPIP_notaAvaliacaoVivencia;
	}
	public void setAvaliacoesPIP_notaAvaliacaoVivencia(double avaliacoesPIP_notaAvaliacaoVivencia) {
		this.avaliacoesPIP_notaAvaliacaoVivencia = avaliacoesPIP_notaAvaliacaoVivencia;
	}
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
