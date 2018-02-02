package br.net.ipp.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	@NotEmpty
	@Column(unique = true)
	private String username;
    @NotEmpty
    private String password;
	@NotEmpty
	private String email;
	@NotNull
	private boolean admin;
	@ManyToOne
	private GrupoDePermissoes grupoDePermissoes;

/*	public User(
			Long id, 
			String username, 
			String password, 
			String email, 
			boolean admin
			) {
        this.id = id;
        this.username = username;
		this.password = password;
		this.email = email;
		this.admin = admin;
    }
	
	public User(
			String username, 
			String password, 
			String email, 
			boolean admin
			) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.admin = admin;
	}
	

	public User() {

	}*/


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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public GrupoDePermissoes getGrupoDePermissoes() {
		return grupoDePermissoes;
	}
	public void setGrupoDePermissoes(GrupoDePermissoes grupoDePermissoes) {
		this.grupoDePermissoes = grupoDePermissoes;
	}
	
}
