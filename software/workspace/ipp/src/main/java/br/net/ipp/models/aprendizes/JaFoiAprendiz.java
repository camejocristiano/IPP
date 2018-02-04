package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.models.AbstractEntity;

@Entity
public class JaFoiAprendiz extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "dataInicio")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataInicio;
	@Column(name = "dataDeFim")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDeFim;
	private boolean varJaFoiAprendiz;
	@ManyToOne
	private Jovem jovem;
	
	
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataDeFim() {
		return dataDeFim;
	}
	public void setDataDeFim(Date dataDeFim) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
