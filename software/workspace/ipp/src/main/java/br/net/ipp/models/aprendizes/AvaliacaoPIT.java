package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class AvaliacaoPIT extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private String avaliacoesPIT_dataAutoAvaliacao;
	private String avaliacoesPIT_dataAvaliacaoInformatica;
	private String avaliacoesPIT_dataAvaliacaoMatematica;
	private String avaliacoesPIT_dataAvaliacaoOrientador;
	private String avaliacoesPIT_dataAvaliacaoPortugues;
	private String avaliacoesPIT_dataAvaliacaoVivencia;
	private double avaliacoesPIT_notaAutoavaliacao;
	private double avaliacoesPIT_notaAvaliacaoInformatica;
	private double avaliacoesPIT_notaAvaliacaoMatematica;
	private double avaliacoesPIT_notaAvaliacaoOrientador;
	private double avaliacoesPIT_notaAvaliacaoPortugues;
	private double avaliacoesPIT_notaAvaliacaoVivencia;
	@ManyToOne
	private Historico historico;
	
	
	public String getAvaliacoesPIT_dataAutoAvaliacao() {
		return avaliacoesPIT_dataAutoAvaliacao;
	}
	public void setAvaliacoesPIT_dataAutoAvaliacao(String avaliacoesPIT_dataAutoAvaliacao) {
		this.avaliacoesPIT_dataAutoAvaliacao = avaliacoesPIT_dataAutoAvaliacao;
	}
	public String getAvaliacoesPIT_dataAvaliacaoInformatica() {
		return avaliacoesPIT_dataAvaliacaoInformatica;
	}
	public void setAvaliacoesPIT_dataAvaliacaoInformatica(String avaliacoesPIT_dataAvaliacaoInformatica) {
		this.avaliacoesPIT_dataAvaliacaoInformatica = avaliacoesPIT_dataAvaliacaoInformatica;
	}
	public String getAvaliacoesPIT_dataAvaliacaoMatematica() {
		return avaliacoesPIT_dataAvaliacaoMatematica;
	}
	public void setAvaliacoesPIT_dataAvaliacaoMatematica(String avaliacoesPIT_dataAvaliacaoMatematica) {
		this.avaliacoesPIT_dataAvaliacaoMatematica = avaliacoesPIT_dataAvaliacaoMatematica;
	}
	public String getAvaliacoesPIT_dataAvaliacaoOrientador() {
		return avaliacoesPIT_dataAvaliacaoOrientador;
	}
	public void setAvaliacoesPIT_dataAvaliacaoOrientador(String avaliacoesPIT_dataAvaliacaoOrientador) {
		this.avaliacoesPIT_dataAvaliacaoOrientador = avaliacoesPIT_dataAvaliacaoOrientador;
	}
	public String getAvaliacoesPIT_dataAvaliacaoPortugues() {
		return avaliacoesPIT_dataAvaliacaoPortugues;
	}
	public void setAvaliacoesPIT_dataAvaliacaoPortugues(String avaliacoesPIT_dataAvaliacaoPortugues) {
		this.avaliacoesPIT_dataAvaliacaoPortugues = avaliacoesPIT_dataAvaliacaoPortugues;
	}
	public String getAvaliacoesPIT_dataAvaliacaoVivencia() {
		return avaliacoesPIT_dataAvaliacaoVivencia;
	}
	public void setAvaliacoesPIT_dataAvaliacaoVivencia(String avaliacoesPIT_dataAvaliacaoVivencia) {
		this.avaliacoesPIT_dataAvaliacaoVivencia = avaliacoesPIT_dataAvaliacaoVivencia;
	}
	public double getAvaliacoesPIT_notaAutoavaliacao() {
		return avaliacoesPIT_notaAutoavaliacao;
	}
	public void setAvaliacoesPIT_notaAutoavaliacao(double avaliacoesPIT_notaAutoavaliacao) {
		this.avaliacoesPIT_notaAutoavaliacao = avaliacoesPIT_notaAutoavaliacao;
	}
	public double getAvaliacoesPIT_notaAvaliacaoInformatica() {
		return avaliacoesPIT_notaAvaliacaoInformatica;
	}
	public void setAvaliacoesPIT_notaAvaliacaoInformatica(double avaliacoesPIT_notaAvaliacaoInformatica) {
		this.avaliacoesPIT_notaAvaliacaoInformatica = avaliacoesPIT_notaAvaliacaoInformatica;
	}
	public double getAvaliacoesPIT_notaAvaliacaoMatematica() {
		return avaliacoesPIT_notaAvaliacaoMatematica;
	}
	public void setAvaliacoesPIT_notaAvaliacaoMatematica(double avaliacoesPIT_notaAvaliacaoMatematica) {
		this.avaliacoesPIT_notaAvaliacaoMatematica = avaliacoesPIT_notaAvaliacaoMatematica;
	}
	public double getAvaliacoesPIT_notaAvaliacaoOrientador() {
		return avaliacoesPIT_notaAvaliacaoOrientador;
	}
	public void setAvaliacoesPIT_notaAvaliacaoOrientador(double avaliacoesPIT_notaAvaliacaoOrientador) {
		this.avaliacoesPIT_notaAvaliacaoOrientador = avaliacoesPIT_notaAvaliacaoOrientador;
	}
	public double getAvaliacoesPIT_notaAvaliacaoPortugues() {
		return avaliacoesPIT_notaAvaliacaoPortugues;
	}
	public void setAvaliacoesPIT_notaAvaliacaoPortugues(double avaliacoesPIT_notaAvaliacaoPortugues) {
		this.avaliacoesPIT_notaAvaliacaoPortugues = avaliacoesPIT_notaAvaliacaoPortugues;
	}
	public double getAvaliacoesPIT_notaAvaliacaoVivencia() {
		return avaliacoesPIT_notaAvaliacaoVivencia;
	}
	public void setAvaliacoesPIT_notaAvaliacaoVivencia(double avaliacoesPIT_notaAvaliacaoVivencia) {
		this.avaliacoesPIT_notaAvaliacaoVivencia = avaliacoesPIT_notaAvaliacaoVivencia;
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
