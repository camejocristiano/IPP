package br.com.contatos.model;

import javax.persistence.Entity;

@Entity
public class Usuario extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    public String Token;

    public String Nome;

    public String Email;

    public String Senha;

    
	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}
	
}
