package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.MotivoDaDispensa;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Dispensa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String dataExameDemissional;
	private MotivoDaDispensa motivoDaDispensa;
	private String consideracoesDaDispensa;
	private String informacoesComplementaresDaDispensa;
	private String justificativaDaDispensa;
	private Boolean oJovemEstaCienteDaDispensa;
	private Boolean haveraSubstituicao;
	@ManyToOne
	private Jovem jovem;
	private String diaDaDispensa;
	private String mesDaDispensa;
	private String anoDaDispensa;
	
	
	public String getConsideracoesDaDispensa() {
		return consideracoesDaDispensa;
	}
	public void setConsideracoesDaDispensa(String consideracoesDaDispensa) {
		this.consideracoesDaDispensa = consideracoesDaDispensa;
	}
	public String getDataExameDemissional() {
		return dataExameDemissional;
	}
	public void setDataExameDemissional(String dataExameDemissional) {
		this.dataExameDemissional = dataExameDemissional;
	}
	public Boolean getHaveraSubstituicao() {
		return haveraSubstituicao;
	}
	public void setHaveraSubstituicao(Boolean haveraSubstituicao) {
		this.haveraSubstituicao = haveraSubstituicao;
	}
	public String getInformacoesComplementaresDaDispensa() {
		return informacoesComplementaresDaDispensa;
	}
	public void setInformacoesComplementaresDaDispensa(String informacoesComplementaresDaDispensa) {
		this.informacoesComplementaresDaDispensa = informacoesComplementaresDaDispensa;
	}
	public String getJustificativaDaDispensa() {
		return justificativaDaDispensa;
	}
	public void setJustificativaDaDispensa(String justificativaDaDispensa) {
		this.justificativaDaDispensa = justificativaDaDispensa;
	}
	public MotivoDaDispensa getMotivoDaDispensa() {
		return motivoDaDispensa;
	}
	public void setMotivoDaDispensa(MotivoDaDispensa motivoDaDispensa) {
		this.motivoDaDispensa = motivoDaDispensa;
	}
	public Boolean getoJovemEstaCienteDaDispensa() {
		return oJovemEstaCienteDaDispensa;
	}
	public void setoJovemEstaCienteDaDispensa(Boolean oJovemEstaCienteDaDispensa) {
		this.oJovemEstaCienteDaDispensa = oJovemEstaCienteDaDispensa;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	public String getDiaDaDispensa() {
		return diaDaDispensa;
	}
	public void setDiaDaDispensa(String diaDaDispensa) {
		this.diaDaDispensa = diaDaDispensa;
	}
	public String getMesDaDispensa() {
		return mesDaDispensa;
	}
	public void setMesDaDispensa(String mesDaDispensa) {
		this.mesDaDispensa = mesDaDispensa;
	}
	public String getAnoDaDispensa() {
		return anoDaDispensa;
	}
	public void setAnoDaDispensa(String anoDaDispensa) {
		this.anoDaDispensa = anoDaDispensa;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}