package br.net.ipp.models.financeiros;

import java.math.BigDecimal;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Parametro extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal contribuicaoSindical;
	private BigDecimal salarioMinimoFederalSMF;
	private BigDecimal seguroDeVidaPCMSO;
	private BigDecimal taxaAdministrativaDeVR;
	private BigDecimal taxaBancaria;
	private BigDecimal taxaBancariaDeVR;
	private BigDecimal taxaBancariaDeVT;
	private BigDecimal taxaDeEmissaoDeCartaoDeVR;
	private BigDecimal valorDoConvenioDeSaudeMaiorDeIdade;
	private BigDecimal valorDoConvenioDeSaudeMenorDeIdade;
	private double taxaAdministrativaDaSPTrans;
	private double taxaAdministrativaBom;
	private Integer dia;
	private Integer mes;
	private Integer ano;

	
	public BigDecimal getContribuicaoSindical() {
		return contribuicaoSindical;
	}
	public void setContribuicaoSindical(BigDecimal contribuicaoSindical) {
		this.contribuicaoSindical = contribuicaoSindical;
	}
	public BigDecimal getSalarioMinimoFederalSMF() {
		return salarioMinimoFederalSMF;
	}
	public void setSalarioMinimoFederalSMF(BigDecimal salarioMinimoFederalSMF) {
		this.salarioMinimoFederalSMF = salarioMinimoFederalSMF;
	}
	public BigDecimal getSeguroDeVidaPCMSO() {
		return seguroDeVidaPCMSO;
	}
	public void setSeguroDeVidaPCMSO(BigDecimal seguroDeVidaPCMSO) {
		this.seguroDeVidaPCMSO = seguroDeVidaPCMSO;
	}
	public BigDecimal getTaxaAdministrativaDeVR() {
		return taxaAdministrativaDeVR;
	}
	public void setTaxaAdministrativaDeVR(BigDecimal taxaAdministrativaDeVR) {
		this.taxaAdministrativaDeVR = taxaAdministrativaDeVR;
	}
	public BigDecimal getTaxaBancaria() {
		return taxaBancaria;
	}
	public void setTaxaBancaria(BigDecimal taxaBancaria) {
		this.taxaBancaria = taxaBancaria;
	}
	public BigDecimal getTaxaBancariaDeVR() {
		return taxaBancariaDeVR;
	}
	public void setTaxaBancariaDeVR(BigDecimal taxaBancariaDeVR) {
		this.taxaBancariaDeVR = taxaBancariaDeVR;
	}
	public BigDecimal getTaxaBancariaDeVT() {
		return taxaBancariaDeVT;
	}
	public void setTaxaBancariaDeVT(BigDecimal taxaBancariaDeVT) {
		this.taxaBancariaDeVT = taxaBancariaDeVT;
	}
	public BigDecimal getTaxaDeEmissaoDeCartaoDeVR() {
		return taxaDeEmissaoDeCartaoDeVR;
	}
	public void setTaxaDeEmissaoDeCartaoDeVR(BigDecimal taxaDeEmissaoDeCartaoDeVR) {
		this.taxaDeEmissaoDeCartaoDeVR = taxaDeEmissaoDeCartaoDeVR;
	}
	public BigDecimal getValorDoConvenioDeSaudeMaiorDeIdade() {
		return valorDoConvenioDeSaudeMaiorDeIdade;
	}
	public void setValorDoConvenioDeSaudeMaiorDeIdade(BigDecimal valorDoConvenioDeSaudeMaiorDeIdade) {
		this.valorDoConvenioDeSaudeMaiorDeIdade = valorDoConvenioDeSaudeMaiorDeIdade;
	}
	public BigDecimal getValorDoConvenioDeSaudeMenorDeIdade() {
		return valorDoConvenioDeSaudeMenorDeIdade;
	}
	public void setValorDoConvenioDeSaudeMenorDeIdade(BigDecimal valorDoConvenioDeSaudeMenorDeIdade) {
		this.valorDoConvenioDeSaudeMenorDeIdade = valorDoConvenioDeSaudeMenorDeIdade;
	}
	public double getTaxaAdministrativaDaSPTrans() {
		return taxaAdministrativaDaSPTrans;
	}
	public void setTaxaAdministrativaDaSPTrans(double taxaAdministrativaDaSPTrans) {
		this.taxaAdministrativaDaSPTrans = taxaAdministrativaDaSPTrans;
	}
	public double getTaxaAdministrativaBom() {
		return taxaAdministrativaBom;
	}
	public void setTaxaAdministrativaBom(double taxaAdministrativaBom) {
		this.taxaAdministrativaBom = taxaAdministrativaBom;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
