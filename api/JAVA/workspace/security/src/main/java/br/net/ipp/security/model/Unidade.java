package br.net.ipp.security.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unidade")
public class Unidade extends User {
	
	private static final long serialVersionUID = 1L;
	private String nome;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
