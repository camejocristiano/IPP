package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Dispensa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String consideracoesDaDispensa;
	/*private Date dataDaDispensa;
	private Date exameDemissional;
	private Boolean haveraSubstituicao;
	private String informacoesComplementaresDaDispensa;
	private String justificativaDaDispensa;
	private MotivoDaDispensa motivoDaDispensa;
	private Boolean oJovemEstaCienteDaDispensa;
	public FichaProfissional m_FichaProfissional;*/
	
	public String getConsideracoesDaDispensa() {
		return consideracoesDaDispensa;
	}
	public void setConsideracoesDaDispensa(String consideracoesDaDispensa) {
		this.consideracoesDaDispensa = consideracoesDaDispensa;
	}
	/*public Date getDataDaDispensa() {
		return dataDaDispensa;
	}
	public void setDataDaDispensa(Date dataDaDispensa) {
		this.dataDaDispensa = dataDaDispensa;
	}
	public Date getExameDemissional() {
		return exameDemissional;
	}
	public void setExameDemissional(Date exameDemissional) {
		this.exameDemissional = exameDemissional;
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
	public FichaProfissional getM_FichaProfissional() {
		return m_FichaProfissional;
	}
	public void setM_FichaProfissional(FichaProfissional m_FichaProfissional) {
		this.m_FichaProfissional = m_FichaProfissional;
	}*/
	
}