package br.net.ipp.models.aprendizes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.models.AbstractEntity;

@Entity
public class SituacaoLaboral extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private boolean jaTrabalhou;
	private boolean remunerado;
	private boolean cTPSRegistrada;
	private boolean trabalhouVoluntario;
	@ManyToOne
	private Jovem jovem;
	
	
	public boolean iscTPSRegistrada() {
		return cTPSRegistrada;
	}
	public void setcTPSRegistrada(boolean cTPSRegistrada) {
		this.cTPSRegistrada = cTPSRegistrada;
	}
	public boolean isJaTrabalhou() {
		return jaTrabalhou;
	}
	public void setJaTrabalhou(boolean jaTrabalhou) {
		this.jaTrabalhou = jaTrabalhou;
	}
	public boolean isRemunerado() {
		return remunerado;
	}
	public void setRemunerado(boolean remunerado) {
		this.remunerado = remunerado;
	}
	public boolean isTrabalhouVoluntario() {
		return trabalhouVoluntario;
	}
	public void setTrabalhouVoluntario(boolean trabalhouVoluntario) {
		this.trabalhouVoluntario = trabalhouVoluntario;
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
