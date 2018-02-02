package br.net.ipp.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
public abstract class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true)
	private String username;
    private String password;
	private boolean admin;
	
	private boolean unidadeCadastrar;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isUnidadeCadastrar() {
		return unidadeCadastrar;
	}
	public void setUnidadeCadastrar(boolean unidadeCadastrar) {
		this.unidadeCadastrar = unidadeCadastrar;
	}

}
