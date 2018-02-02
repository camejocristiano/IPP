package br.net.ipp.models.empresas;

import javax.persistence.Entity;

import br.net.ipp.models.User;

@Entity
public class Gestor extends User {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String ramal;
	private String telefone;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}