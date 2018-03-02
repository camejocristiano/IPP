package br.net.ipp.models.empresas;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Taxa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String taxaExtra18PorcentoDoSMF;
	private String porcentagemSobreTaxaExtraBaseSMF;
	private String valor;
	@ManyToOne
	private Empresa empresa;

	public String getTaxaExtra18PorcentoDoSMF() {
		return taxaExtra18PorcentoDoSMF;
	}
	public void setTaxaExtra18PorcentoDoSMF(String taxaExtra18PorcentoDoSMF) {
		this.taxaExtra18PorcentoDoSMF = taxaExtra18PorcentoDoSMF;
	}
	public String getPorcentagemSobreTaxaExtraBaseSMF() {
		return porcentagemSobreTaxaExtraBaseSMF;
	}
	public void setPorcentagemSobreTaxaExtraBaseSMF(String porcentagemSobreTaxaExtraBaseSMF) {
		this.porcentagemSobreTaxaExtraBaseSMF = porcentagemSobreTaxaExtraBaseSMF;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
