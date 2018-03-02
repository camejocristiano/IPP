package br.net.ipp.models.financeiros;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class VR extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String diasAPagar;
	private String valor;
	private String total;
	private String mes;
	private String nomeDoJovem;
	private String codigoDoJovem;
	private String nomeFantaziaEmpresa;
	private String diaSemana;
	private String dataInicioContrato;
	private String dataFimContrato;
	
	
	public String getDiasAPagar() {
		return diasAPagar;
	}
	public void setDiasAPagar(String diasAPagar) {
		this.diasAPagar = diasAPagar;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getNomeDoJovem() {
		return nomeDoJovem;
	}
	public void setNomeDoJovem(String nomeDoJovem) {
		this.nomeDoJovem = nomeDoJovem;
	}
	public String getCodigoDoJovem() {
		return codigoDoJovem;
	}
	public void setCodigoDoJovem(String codigoDoJovem) {
		this.codigoDoJovem = codigoDoJovem;
	}
	public String getNomeFantaziaEmpresa() {
		return nomeFantaziaEmpresa;
	}
	public void setNomeFantaziaEmpresa(String nomeFantaziaEmpresa) {
		this.nomeFantaziaEmpresa = nomeFantaziaEmpresa;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public String getDataInicioContrato() {
		return dataInicioContrato;
	}
	public void setDataInicioContrato(String dataInicioContrato) {
		this.dataInicioContrato = dataInicioContrato;
	}
	public String getDataFimContrato() {
		return dataFimContrato;
	}
	public void setDataFimContrato(String dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
