package br.net.ipp.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class GrupoDePermissoes extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true)
	private String grupo;
	@NotNull
	private boolean usuarioCadastrar;
	@NotNull
	private boolean usuarioEditar;
	@NotNull
	private boolean usuarioListar;
	@NotNull
	private boolean usuarioVisualizar;

	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public boolean isUsuarioCadastrar() {
		return usuarioCadastrar;
	}
	public void setUsuarioCadastrar(boolean usuarioCadastrar) {
		this.usuarioCadastrar = usuarioCadastrar;
	}
	public boolean isUsuarioEditar() {
		return usuarioEditar;
	}
	public void setUsuarioEditar(boolean usuarioEditar) {
		this.usuarioEditar = usuarioEditar;
	}
	public boolean isUsuarioListar() {
		return usuarioListar;
	}
	public void setUsuarioListar(boolean usuarioListar) {
		this.usuarioListar = usuarioListar;
	}
	public boolean isUsuarioVisualizar() {
		return usuarioVisualizar;
	}
	public void setUsuarioVisualizar(boolean usuarioVisualizar) {
		this.usuarioVisualizar = usuarioVisualizar;
	}

}
