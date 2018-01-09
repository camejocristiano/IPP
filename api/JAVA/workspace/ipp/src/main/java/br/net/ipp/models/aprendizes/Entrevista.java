package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Entrevista extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String motivo;
	/*private Boolean aprovadoNaEntrevista;
	private Date dataDaEntrevista;
	private Empresa empresaParaEntrevista;
	private Boolean retomando;*/

	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
/*	public Boolean getAprovadoNaEntrevista() {
		return aprovadoNaEntrevista;
	}
	public void setAprovadoNaEntrevista(Boolean aprovadoNaEntrevista) {
		this.aprovadoNaEntrevista = aprovadoNaEntrevista;
	}
	public Date getDataDaEntrevista() {
		return dataDaEntrevista;
	}
	public void setDataDaEntrevista(Date dataDaEntrevista) {
		this.dataDaEntrevista = dataDaEntrevista;
	}
	public Empresa getEmpresaParaEntrevista() {
		return empresaParaEntrevista;
	}
	public void setEmpresaParaEntrevista(Empresa empresaParaEntrevista) {
		this.empresaParaEntrevista = empresaParaEntrevista;
	}
	public Boolean getRetomando() {
		return retomando;
	}
	public void setRetomando(Boolean retomando) {
		this.retomando = retomando;
	}*/
	
}