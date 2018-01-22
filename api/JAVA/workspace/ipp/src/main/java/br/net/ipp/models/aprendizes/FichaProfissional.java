package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.net.ipp.enums.SituacaoAtual;
import br.net.ipp.enums.Status;
import br.net.ipp.models.AbstractEntity;

@Entity
public class FichaProfissional extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String observacoesSituacaoProfissional;
	private SituacaoAtual situacaoAtual;
	private Status status;
	@OneToOne
	private Jovem jovem;
	
	
	public String getObservacoesSituacaoProfissional() {
		return observacoesSituacaoProfissional;
	}
	public void setObservacoesSituacaoProfissional(String observacoesSituacaoProfissional) {
		this.observacoesSituacaoProfissional = observacoesSituacaoProfissional;
	}
	public SituacaoAtual getSituacaoAtual() {
		return situacaoAtual;
	}
	public void setSituacaoAtual(SituacaoAtual situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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