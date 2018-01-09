package br.net.ipp.models.financeiros;

import javax.persistence.Entity;

import br.net.ipp.models.AbstractEntity;

@Entity
public class ContaAPagar extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	} 

}
