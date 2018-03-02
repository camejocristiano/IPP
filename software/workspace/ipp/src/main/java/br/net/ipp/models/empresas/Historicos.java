package br.net.ipp.models.empresas;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Historicos extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String dataDoHistorico;
	private String descricaoDoHistorico;
	@ManyToOne
	private Empresa empresa;
	
	public String getDataDoHistorico() {
		return dataDoHistorico;
	}
	public void setDataDoHistorico(String dataDoHistorico) {
		this.dataDoHistorico = dataDoHistorico;
	}
	public String getDescricaoDoHistorico() {
		return descricaoDoHistorico;
	}
	public void setDescricaoDoHistorico(String descricaoDoHistorico) {
		this.descricaoDoHistorico = descricaoDoHistorico;
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
