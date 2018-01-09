package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Familiar extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeFamiliar;
	/*private String grauParentescoFamiliar;
	private String idadeFamiliar;
	private String profissaoOcupacaoFamiliar;
	private double salarioFamiliar;
	private String vinculaFamiliar;
	public FichaSocial m_FichaSocial;
	public EstadoCivil m_EstadoCivil;*/

	public String getNomeFamiliar() {
		return nomeFamiliar;
	}
	public void setNomeFamiliar(String nomeFamiliar) {
		this.nomeFamiliar = nomeFamiliar;
	}
	
/*	public String getGrauParentescoFamiliar() {
		return grauParentescoFamiliar;
	}
	public void setGrauParentescoFamiliar(String grauParentescoFamiliar) {
		this.grauParentescoFamiliar = grauParentescoFamiliar;
	}
	public String getIdadeFamiliar() {
		return idadeFamiliar;
	}
	public void setIdadeFamiliar(String idadeFamiliar) {
		this.idadeFamiliar = idadeFamiliar;
	}
	public String getProfissaoOcupacaoFamiliar() {
		return profissaoOcupacaoFamiliar;
	}
	public void setProfissaoOcupacaoFamiliar(String profissaoOcupacaoFamiliar) {
		this.profissaoOcupacaoFamiliar = profissaoOcupacaoFamiliar;
	}
	public double getSalarioFamiliar() {
		return salarioFamiliar;
	}
	public void setSalarioFamiliar(double salarioFamiliar) {
		this.salarioFamiliar = salarioFamiliar;
	}
	public String getVinculaFamiliar() {
		return vinculaFamiliar;
	}
	public void setVinculaFamiliar(String vinculaFamiliar) {
		this.vinculaFamiliar = vinculaFamiliar;
	}
	public FichaSocial getM_FichaSocial() {
		return m_FichaSocial;
	}
	public void setM_FichaSocial(FichaSocial m_FichaSocial) {
		this.m_FichaSocial = m_FichaSocial;
	}
	public EstadoCivil getM_EstadoCivil() {
		return m_EstadoCivil;
	}
	public void setM_EstadoCivil(EstadoCivil m_EstadoCivil) {
		this.m_EstadoCivil = m_EstadoCivil;
	}
*/	
}