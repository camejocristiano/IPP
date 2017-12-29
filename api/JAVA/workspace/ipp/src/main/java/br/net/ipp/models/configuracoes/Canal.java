package br.net.ipp.models.configuracoes;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;
import br.net.ipp.models.aprendizes.Jovem;

@Entity
public class Canal extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String canal;
	@ManyToOne
	public Jovem jovem;
	
	
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public Jovem getJovem() {
		return jovem;
	}
	public void setJovem(Jovem jovem) {
		this.jovem = jovem;
	}
	
	
}
