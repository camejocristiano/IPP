package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Historico extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String observacoes;
	@OneToOne
	private Jovem jovem;
	
	
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
	
}