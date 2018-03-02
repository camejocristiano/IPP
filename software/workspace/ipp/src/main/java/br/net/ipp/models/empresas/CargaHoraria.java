package br.net.ipp.models.empresas;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class CargaHoraria extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String cargaHorariaSemanal;
	private String porcentagemSobreSMF;
	private String valor;
	@ManyToOne
	private Empresa empresa;

	public String getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}
	public void setCargaHorariaSemanal(String cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}
	public String getPorcentagemSobreSMF() {
		return porcentagemSobreSMF;
	}
	public void setPorcentagemSobreSMF(String porcentagemSobreSMF) {
		this.porcentagemSobreSMF = porcentagemSobreSMF;
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
