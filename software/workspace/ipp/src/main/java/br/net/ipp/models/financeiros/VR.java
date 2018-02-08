package br.net.ipp.models.financeiros;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Contratacao;

@Entity
public class VR extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Contratacao contratacao; // (dataDeAdmissao)
	@ManyToOne
	private Parametro parametro; //(taxaAdministracaoVR)
	private double diasAPagar; // soma dos dias presentes no mês
	private BigDecimal valor; // multiplicação dos dias a pagar pelo valor do VR jovem subtraindo - se a taxa administrativa

	
	public Contratacao getContratacao() {
		return contratacao;
	}
	public void setContratacao(Contratacao contratacao) {
		this.contratacao = contratacao;
	}
	public Parametro getParametro() {
		return parametro;
	}
	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}
	public double getDiasAPagar() {
		return diasAPagar;
	}
	public void setDiasAPagar(double diasAPagar) {
		this.diasAPagar = diasAPagar;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
