package br.net.ipp.testes.model;

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
	private String nome;
	@NotNull
	private boolean admin;
	@ManyToOne
	GrupoDePermissoes grupoDePermissoes;
	
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
