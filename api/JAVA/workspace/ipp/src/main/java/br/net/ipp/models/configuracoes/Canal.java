package br.net.ipp.models.configuracoes;


import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class Canal extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String nomeCanal;
	
	public String getNomeCanal() {
		return nomeCanal;
	}
	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}
	
}
