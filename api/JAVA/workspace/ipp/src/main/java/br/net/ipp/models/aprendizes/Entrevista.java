package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.empresas.Empresa;

@Entity
public class Entrevista extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String motivo;
	private boolean aprovadoNaEntrevista;
	private boolean retomando;
	@Column(name = "dataDaEntrevista")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDaEntrevista;
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
	public boolean getRetomando() {
		return retomando;
	}
	public void setRetomando(boolean retomando) {
		this.retomando = retomando;
	}
	
}