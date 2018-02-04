package br.net.ipp.models.aprendizes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import br.net.ipp.enums.MotivoDaDispensa;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Dispensa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Jovem jovem;
	@Column(name = "dataDaDispensa")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date dataDaDispensa;
	@Column(name = "exameDemissional")  
	@DateTimeFormat(pattern = "dd/mm/yyyy") 
	private Date exameDemissional;
	private MotivoDaDispensa motivoDaDispensa;
	private String consideracoesDaDispensa;
	private String informacoesComplementaresDaDispensa;
	private String justificativaDaDispensa;
	private Boolean oJovemEstaCienteDaDispensa;
	private Boolean haveraSubstituicao;
	
	public String getConsideracoesDaDispensa() {
		return consideracoesDaDispensa;
	}
	public void setConsideracoesDaDispensa(String consideracoesDaDispensa) {
		this.consideracoesDaDispensa = consideracoesDaDispensa;
	}
	public Date getDataDaDispensa() {
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
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	
}