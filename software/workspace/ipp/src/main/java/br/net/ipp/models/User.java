package br.net.ipp.models;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotEmpty;

import br.net.ipp.enums.Status;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Unidade;

@MappedSuperclass
public abstract class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true)
	private String username;
	private boolean admin;
    private String password;
    private Status status;
    @ManyToOne
	private GrupoDePermissoes grupoDePermissoes;
    @ManyToOne
	private Unidade unidade;
    
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
