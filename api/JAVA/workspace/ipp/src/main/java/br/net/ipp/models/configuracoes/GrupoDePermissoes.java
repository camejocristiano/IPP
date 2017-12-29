package br.net.ipp.models.configuracoes;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.net.ipp.enums.Status;
import br.net.ipp.models.AbstractEntity;

@Entity
public class GrupoDePermissoes extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	private String grupo;
	private Status status;
	@ManyToOne
	private Unidade unidade;

	private boolean grupoDePermissoesCadastrar;
	private boolean grupoDePermissoesEditar;
	private boolean grupoDePermissoesListar;
	private boolean grupoDePermissoesVisualizar;

	private boolean usuarioCadastrar;
	private boolean usuarioEditar;
	private boolean usuarioListar;
	private boolean usuarioVisualizar;
	
	private boolean canalCadastrar;
	private boolean canalEditar;
	private boolean canalListar;
	private boolean canalVisualizar;
	
	private boolean unidadeCadastrar;
	private boolean unidadeEditar;
	private boolean unidadeListar;
	private boolean unidadeVisualizar;
	
	private boolean arquivoCadastrar;
	private boolean arquivoEditar;
	private boolean arquivoListar;
	private boolean arquivoVisualizar;

	private boolean agendamentoCadastrar;
	private boolean agendamentoEditar;
	private boolean agendamentoListar;
	private boolean agendamentoVisualizar;

	
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public boolean isGrupoDePermissoesCadastrar() {
		return grupoDePermissoesCadastrar;
	}
	public void setGrupoDePermissoesCadastrar(boolean grupoDePermissoesCadastrar) {
		this.grupoDePermissoesCadastrar = grupoDePermissoesCadastrar;
	}
	public boolean isGrupoDePermissoesEditar() {
		return grupoDePermissoesEditar;
	}
	public void setGrupoDePermissoesEditar(boolean grupoDePermissoesEditar) {
		this.grupoDePermissoesEditar = grupoDePermissoesEditar;
	}
	public boolean isGrupoDePermissoesListar() {
		return grupoDePermissoesListar;
	}
	public void setGrupoDePermissoesListar(boolean grupoDePermissoesListar) {
		this.grupoDePermissoesListar = grupoDePermissoesListar;
	}
	public boolean isGrupoDePermissoesVisualizar() {
		return grupoDePermissoesVisualizar;
	}
	public void setGrupoDePermissoesVisualizar(boolean grupoDePermissoesVisualizar) {
		this.grupoDePermissoesVisualizar = grupoDePermissoesVisualizar;
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
	public boolean isCanalCadastrar() {
		return canalCadastrar;
	}
	public void setCanalCadastrar(boolean canalCadastrar) {
		this.canalCadastrar = canalCadastrar;
	}
	public boolean isCanalEditar() {
		return canalEditar;
	}
	public void setCanalEditar(boolean canalEditar) {
		this.canalEditar = canalEditar;
	}
	public boolean isCanalListar() {
		return canalListar;
	}
	public void setCanalListar(boolean canalListar) {
		this.canalListar = canalListar;
	}
	public boolean isCanalVisualizar() {
		return canalVisualizar;
	}
	public void setCanalVisualizar(boolean canalVisualizar) {
		this.canalVisualizar = canalVisualizar;
	}
	public boolean isUnidadeCadastrar() {
		return unidadeCadastrar;
	}
	public void setUnidadeCadastrar(boolean unidadeCadastrar) {
		this.unidadeCadastrar = unidadeCadastrar;
	}
	public boolean isUnidadeEditar() {
		return unidadeEditar;
	}
	public void setUnidadeEditar(boolean unidadeEditar) {
		this.unidadeEditar = unidadeEditar;
	}
	public boolean isUnidadeListar() {
		return unidadeListar;
	}
	public void setUnidadeListar(boolean unidadeListar) {
		this.unidadeListar = unidadeListar;
	}
	public boolean isUnidadeVisualizar() {
		return unidadeVisualizar;
	}
	public void setUnidadeVisualizar(boolean unidadeVisualizar) {
		this.unidadeVisualizar = unidadeVisualizar;
	}
	public boolean isArquivoCadastrar() {
		return arquivoCadastrar;
	}
	public void setArquivoCadastrar(boolean arquivoCadastrar) {
		this.arquivoCadastrar = arquivoCadastrar;
	}
	public boolean isArquivoEditar() {
		return arquivoEditar;
	}
	public void setArquivoEditar(boolean arquivoEditar) {
		this.arquivoEditar = arquivoEditar;
	}
	public boolean isArquivoListar() {
		return arquivoListar;
	}
	public void setArquivoListar(boolean arquivoListar) {
		this.arquivoListar = arquivoListar;
	}
	public boolean isArquivoVisualizar() {
		return arquivoVisualizar;
	}
	public void setArquivoVisualizar(boolean arquivoVisualizar) {
		this.arquivoVisualizar = arquivoVisualizar;
	}
	public boolean isAgendamentoCadastrar() {
		return agendamentoCadastrar;
	}
	public void setAgendamentoCadastrar(boolean agendamentoCadastrar) {
		this.agendamentoCadastrar = agendamentoCadastrar;
	}
	public boolean isAgendamentoEditar() {
		return agendamentoEditar;
	}
	public void setAgendamentoEditar(boolean agendamentoEditar) {
		this.agendamentoEditar = agendamentoEditar;
	}
	public boolean isAgendamentoListar() {
		return agendamentoListar;
	}
	public void setAgendamentoListar(boolean agendamentoListar) {
		this.agendamentoListar = agendamentoListar;
	}
	public boolean isAgendamentoVisualizar() {
		return agendamentoVisualizar;
	}
	public void setAgendamentoVisualizar(boolean agendamentoVisualizar) {
		this.agendamentoVisualizar = agendamentoVisualizar;
	}

}
