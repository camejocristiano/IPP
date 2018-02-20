package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.empresas.Empresa;

@Entity
public class Entrevista extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String motivo;
	private boolean aprovadoNaEntrevista;
	private boolean retomando;
	private String dataDaEntrevista;
	@ManyToOne
	private Empresa empresaParaEntrevista;
	@ManyToOne
	private Jovem jovem;

	
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
	
	public boolean getAprovadoNaEntrevista() {
		return aprovadoNaEntrevista;
	}
	public void setAprovadoNaEntrevista(boolean aprovadoNaEntrevista) {
		this.aprovadoNaEntrevista = aprovadoNaEntrevista;
	}
	public String getDataDaEntrevista() {
		return dataDaEntrevista;
	}
	public void setDataDaEntrevista(String dataDaEntrevista) {
		this.dataDaEntrevista = dataDaEntrevista;
	}
	public Empresa getEmpresaParaEntrevista() {
		return empresaParaEntrevista;
	}
	public void setEmpresaParaEntrevista(Empresa empresaParaEntrevista) {
		this.empresaParaEntrevista = empresaParaEntrevista;
	}
	public boolean getRetomando() {
		return retomando;
	}
	public void setRetomando(boolean retomando) {
		this.retomando = retomando;
	}
	
}