package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Habilidades extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String caracteristicasMarcantes;
/*	private Boolean access;
	private Boolean excel;
	private HabilidadeManual habilidadeManual;
	private Boolean outlook;
	private Boolean outros;
	private Boolean powerPoint;
	private Boolean sabeLerEEscrever;
	private Boolean word;*/

	public String getCaracteristicasMarcantes() {
		return caracteristicasMarcantes;
	}
	public void setCaracteristicasMarcantes(String caracteristicasMarcantes) {
		this.caracteristicasMarcantes = caracteristicasMarcantes;
	}
	
	/*public Boolean getAccess() {
		return access;
	}
	public void setAccess(Boolean access) {
		this.access = access;
	}
	public Boolean getExcel() {
		return excel;
	}
	public void setExcel(Boolean excel) {
		this.excel = excel;
	}
	public HabilidadeManual getHabilidadeManual() {
		return habilidadeManual;
	}
	public void setHabilidadeManual(HabilidadeManual habilidadeManual) {
		this.habilidadeManual = habilidadeManual;
	}
	public Boolean getOutlook() {
		return outlook;
	}
	public void setOutlook(Boolean outlook) {
		this.outlook = outlook;
	}
	public Boolean getOutros() {
		return outros;
	}
	public void setOutros(Boolean outros) {
		this.outros = outros;
	}
	public Boolean getPowerPoint() {
		return powerPoint;
	}
	public void setPowerPoint(Boolean powerPoint) {
		this.powerPoint = powerPoint;
	}
	public Boolean getSabeLerEEscrever() {
		return sabeLerEEscrever;
	}
	public void setSabeLerEEscrever(Boolean sabeLerEEscrever) {
		this.sabeLerEEscrever = sabeLerEEscrever;
	}
	public Boolean getWord() {
		return word;
	}
	public void setWord(Boolean word) {
		this.word = word;
	}*/
	
}