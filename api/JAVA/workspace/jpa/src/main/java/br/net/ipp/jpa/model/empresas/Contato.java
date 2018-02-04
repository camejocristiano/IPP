package br.net.ipp.jpa.model.empresas;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import br.net.ipp.jpa.model.User;

@Entity
public class Contato extends User {

	private static final long serialVersionUID = 1L;
	@NotEmpty
	private String nome;

}