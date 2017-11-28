package br.net.ipp.jpa.model.aprendizes;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import br.net.ipp.jpa.model.User;

@Entity
public class Jovem extends User {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String nome;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}