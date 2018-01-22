package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.enums.HabilidadeManual;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Habilidades extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String caracteristicasMarcantes;
	private boolean access;
	private boolean excel;
	private HabilidadeManual habilidadeManual;
	private boolean outlook;
	private boolean outrosInformatica;
	private String outrosInformaticaDescricao;
	private boolean powerPoint;
	private boolean sabeLerEEscrever;
	private boolean word;
	private boolean ingles;
	private boolean espanhol;
	private boolean outrosIdiomas;
	private String outrosIdiomasDescricao;
	@OneToOne
	private Jovem jovem;
	
	
	public String getCaracteristicasMarcantes() {
		return caracteristicasMarcantes;
	}
	public void setCaracteristicasMarcantes(String caracteristicasMarcantes) {
		this.caracteristicasMarcantes = caracteristicasMarcantes;
	}
	public boolean isAccess() {
		return access;
	}
	public void setAccess(boolean access) {
		this.access = access;
	}
	public boolean isExcel() {
		return excel;
	}
	public void setExcel(boolean excel) {
		this.excel = excel;
	}
	public HabilidadeManual getHabilidadeManual() {
		return habilidadeManual;
	}
	public void setHabilidadeManual(HabilidadeManual habilidadeManual) {
		this.habilidadeManual = habilidadeManual;
	}
	public boolean isOutlook() {
		return outlook;
	}
	public void setOutlook(boolean outlook) {
		this.outlook = outlook;
	}
	public boolean isOutrosInformatica() {
		return outrosInformatica;
	}
	public void setOutrosInformatica(boolean outrosInformatica) {
		this.outrosInformatica = outrosInformatica;
	}
	public String getOutrosInformaticaDescricao() {
		return outrosInformaticaDescricao;
	}
	public void setOutrosInformaticaDescricao(String outrosInformaticaDescricao) {
		this.outrosInformaticaDescricao = outrosInformaticaDescricao;
	}
	public boolean isPowerPoint() {
		return powerPoint;
	}
	public void setPowerPoint(boolean powerPoint) {
		this.powerPoint = powerPoint;
	}
	public boolean isSabeLerEEscrever() {
		return sabeLerEEscrever;
	}
	public void setSabeLerEEscrever(boolean sabeLerEEscrever) {
		this.sabeLerEEscrever = sabeLerEEscrever;
	}
	public boolean isWord() {
		return word;
	}
	public void setWord(boolean word) {
		this.word = word;
	}
	public boolean isIngles() {
		return ingles;
	}
	public void setIngles(boolean ingles) {
		this.ingles = ingles;
	}
	public boolean isEspanhol() {
		return espanhol;
	}
	public void setEspanhol(boolean espanhol) {
		this.espanhol = espanhol;
	}
	public boolean isOutrosIdiomas() {
		return outrosIdiomas;
	}
	public void setOutrosIdiomas(boolean outrosIdiomas) {
		this.outrosIdiomas = outrosIdiomas;
	}
	public String getOutrosIdiomasDescricao() {
		return outrosIdiomasDescricao;
	}
	public void setOutrosIdiomasDescricao(String outrosIdiomasDescricao) {
		this.outrosIdiomasDescricao = outrosIdiomasDescricao;
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