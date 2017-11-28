package br.net.ipp.jpa.model.empresas;

import javax.persistence.Entity;

import br.net.ipp.jpa.model.AbstractEntity;

/**
 * @author Cristiano
 * @version 1.0
 * @created 27-nov-2017 20:44:26
 */
@Entity
public class Setor extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private Gestor gestor;
	private String setor;

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
