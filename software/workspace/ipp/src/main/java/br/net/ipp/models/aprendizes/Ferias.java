package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Ferias extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Integer diaDeInicioFerias;
	private Integer mesDeInicioFerias;
	private Integer anoDeInicioFerias;
	
	private Integer diaDeFimFerias;
	private Integer mesDeFimFerias;
	private Integer anoDeFimFerias;
	
	private String feriasDataDeVencimento;
	
	private String feriasDiasAGozar;
	private String observacoes;

	@ManyToOne
	private Jovem jovem;

	
	public Integer getDiaDeInicioFerias() {
		return diaDeInicioFerias;
	}

	public void setDiaDeInicioFerias(Integer diaDeInicioFerias) {
		this.diaDeInicioFerias = diaDeInicioFerias;
	}

	public Integer getMesDeInicioFerias() {
		return mesDeInicioFerias;
	}

	public void setMesDeInicioFerias(Integer mesDeInicioFerias) {
		this.mesDeInicioFerias = mesDeInicioFerias;
	}

	public Integer getAnoDeInicioFerias() {
		return anoDeInicioFerias;
	}

	public void setAnoDeInicioFerias(Integer anoDeInicioFerias) {
		this.anoDeInicioFerias = anoDeInicioFerias;
	}

	public Integer getDiaDeFimFerias() {
		return diaDeFimFerias;
	}

	public void setDiaDeFimFerias(Integer diaDeFimFerias) {
		this.diaDeFimFerias = diaDeFimFerias;
	}

	public Integer getMesDeFimFerias() {
		return mesDeFimFerias;
	}

	public void setMesDeFimFerias(Integer mesDeFimFerias) {
		this.mesDeFimFerias = mesDeFimFerias;
	}

	public Integer getAnoDeFimFerias() {
		return anoDeFimFerias;
	}

	public void setAnoDeFimFerias(Integer anoDeFimFerias) {
		this.anoDeFimFerias = anoDeFimFerias;
	}

	public String getFeriasDataDeVencimento() {
		return feriasDataDeVencimento;
	}

	public void setFeriasDataDeVencimento(String feriasDataDeVencimento) {
		this.feriasDataDeVencimento = feriasDataDeVencimento;
	}

	public String getFeriasDiasAGozar() {
		return feriasDiasAGozar;
	}

	public void setFeriasDiasAGozar(String feriasDiasAGozar) {
		this.feriasDiasAGozar = feriasDiasAGozar;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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