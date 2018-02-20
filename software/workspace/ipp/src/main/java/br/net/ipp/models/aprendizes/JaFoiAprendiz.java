package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class JaFoiAprendiz extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String dataInicio;
	private String dataDeFim;
	private boolean varJaFoiAprendiz;
	@ManyToOne
	private Jovem jovem;
	private String dias;
	
	
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataDeFim() {
		return dataDeFim;
	}
	public void setDataDeFim(String dataDeFim) {
		this.dataDeFim = dataDeFim;
	}
	public boolean isVarJaFoiAprendiz() {
		return varJaFoiAprendiz;
	}
	public void setVarJaFoiAprendiz(boolean varJaFoiAprendiz) {
		this.varJaFoiAprendiz = varJaFoiAprendiz;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
