package br.net.ipp.models.aprendizes;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.models.AbstractEntity;

@Entity
public class Familiar extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeFamiliar;
	private String grauInstrucaoFamiliar;
	private String idadeFamiliar;
	private String profissaoOcupacaoFamiliar;
	private BigDecimal salarioFamiliar;
	private String vinculoFamiliar;
	private EstadoCivil estadoCivil;
	@OneToOne
	private Jovem jovem;
	

	public Jovem getJovem() {
		return jovem;
	}

	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}

	public String getNomeFamiliar() {
		return nomeFamiliar;
	}
	public void setNomeFamiliar(String nomeFamiliar) {
		this.nomeFamiliar = nomeFamiliar;
	}
	public String getGrauInstrucaoFamiliar() {
		return grauInstrucaoFamiliar;
	}
	public void setGrauInstrucaoFamiliar(String grauInstrucaoFamiliar) {
		this.grauInstrucaoFamiliar = grauInstrucaoFamiliar;
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
	public BigDecimal getSalarioFamiliar() {
		return salarioFamiliar;
	}
	public void setSalarioFamiliar(BigDecimal salarioFamiliar) {
		this.salarioFamiliar = salarioFamiliar;
	}
	public String getVinculoFamiliar() {
		return vinculoFamiliar;
	}
	public void setVinculoFamiliar(String vinculoFamiliar) {
		this.vinculoFamiliar = vinculoFamiliar;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}