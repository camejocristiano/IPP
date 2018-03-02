package br.net.ipp.models.configuracoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import br.net.ipp.enums.Status;
import br.net.ipp.models.AbstractEntity;

@Entity
public class GrupoDePermissoes extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Column(unique = true)
	private String grupo;
	private Status status;
	@ManyToOne
	private Unidade unidade;

	/**
	 * CONFIGURAÇÕES
	 */
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
	
	/**
	 * CURSOS
	 */
	private boolean cursoCadastrar;
	private boolean cursoEditar;
	private boolean cursoListar;
	private boolean cursoVisualizar;
	
	private boolean matriculaCadastrar;
	private boolean matriculaEditar;
	private boolean matriculaListar;
	private boolean matriculaVisualizar;
	
	private boolean turmaCadastrar;
	private boolean turmaEditar;
	private boolean turmaListar;
	private boolean turmaVisualizar;
	
	private boolean cboCadastrar;
	private boolean cboEditar;
	private boolean cboListar;
	private boolean cboVisualizar;
	
	private boolean arcoCadastrar;
	private boolean arcoEditar;
	private boolean arcoListar;
	private boolean arcoVisualizar;
	
	private boolean basicoCadastrar;
	private boolean basicoEditar;
	private boolean basicoListar;
	private boolean basicoVisualizar;
	
	private boolean especificoCadastrar;
	private boolean especificoEditar;
	private boolean especificoListar;
	private boolean especificoVisualizar;

	private boolean validacaoCadastrar;
	private boolean validacaoEditar;
	private boolean validacaoListar;
	private boolean validacaoVisualizar;
	
	/**
	 * JOVEMS
	 */
	private boolean jovemCadastrar;
	private boolean jovemEditar;
	private boolean jovemListar;
	private boolean jovemVisualizar;
	
	private boolean escolaridadeCadastrar;
	private boolean escolaridadeEditar;
	private boolean escolaridadeListar;
	private boolean escolaridadeVisualizar;
	
	private boolean situacaoLaboralCadastrar;
	private boolean situacaoLaboralEditar;
	private boolean situacaoLaboralListar;
	private boolean situacaoLaboralVisualizar;

	private boolean jaFoiAprendizCadastrar;
	private boolean jaFoiAprendizEditar;
	private boolean jaFoiAprendizListar;
	private boolean jaFoiAprendizVisualizar;
	
	private boolean caracteristicasDomiciliaresCadastrar;
	private boolean caracteristicasDomiciliaresEditar;
	private boolean caracteristicasDomiciliaresListar;
	private boolean caracteristicasDomiciliaresVisualizar;
	
	private boolean habilidadesCadastrar;
	private boolean habilidadesEditar;
	private boolean habilidadesListar;
	private boolean habilidadesVisualizar;
	
	private boolean outroCursoCadastrar;
	private boolean outroCursoEditar;
	private boolean outroCursoListar;
	private boolean outroCursoVisualizar;
	
	private boolean situacaoDeSaudeCadastrar;
	private boolean situacaoDeSaudeEditar;
	private boolean situacaoDeSaudeListar;
	private boolean situacaoDeSaudeVisualizar;
	
	private boolean fichaSocialCadastrar;
	private boolean fichaSocialEditar;
	private boolean fichaSocialListar;
	private boolean fichaSocialVisualizar;

	private boolean familiarCadastrar;
	private boolean familiarEditar;
	private boolean familiarListar;
	private boolean familiarVisualizar;
	
	private boolean fichaProfissionalCadastrar;
	private boolean fichaProfissionalEditar;
	private boolean fichaProfissionalListar;
	private boolean fichaProfissionalVisualizar;
	
	private boolean entrevistaCadastrar;
	private boolean entrevistaEditar;
	private boolean entrevistaListar;
	private boolean entrevistaVisualizar;
	
	private boolean contratacaoCadastrar;
	private boolean contratacaoEditar;
	private boolean contratacaoListar;
	private boolean contratacaoVisualizar;
	
	private boolean feriasCadastrar;
	private boolean feriasEditar;
	private boolean feriasListar;
	private boolean feriasVisualizar;
	
	private boolean dispensaCadastrar;
	private boolean dispensaEditar;
	private boolean dispensaListar;
	private boolean dispensaVisualizar;
	
	private boolean historicoCadastrar;
	private boolean historicoEditar;
	private boolean historicoListar;
	private boolean historicoVisualizar;
	
	private boolean pIPCadastrar;
	private boolean pIPEditar;
	private boolean pIPListar;
	private boolean pIPVisualizar;
	
	private boolean pITCadastrar;
	private boolean pITEditar;
	private boolean pITListar;
	private boolean pITVisualizar;
	
	private boolean pIOCadastrar;
	private boolean pIOEditar;
	private boolean pIOListar;
	private boolean pIOVisualizar;
	
	private boolean pAPEmpresaCadastrar;
	private boolean pAPEmpresaEditar;
	private boolean pAPEmpresaListar;
	private boolean pAPEmpresaVisualizar;
	
	private boolean pAPIPPCadastrar;
	private boolean pAPIPPEditar;
	private boolean pAPIPPListar;
	private boolean pAPIPPVisualizar;
	
	private boolean ocorrenciaCadastrar;
	private boolean ocorrenciaEditar;
	private boolean ocorrenciaListar;
	private boolean ocorrenciaVisualizar;
	
	private boolean dadosFinanceirosCadastrar;
	private boolean dadosFinanceirosEditar;
	private boolean dadosFinanceirosListar;
	private boolean dadosFinanceirosVisualizar;
	
	/**
	 * FREQUÊNCIAS
	 */
	private boolean frequenciaCadastrar;
	private boolean frequenciaEditar;
	private boolean frequenciaListar;
	private boolean frequenciaVisualizar;
	
	/**
	 * EMPRESAS
	 */
	private boolean empresaCadastrar;
	private boolean empresaEditar;
	private boolean empresaListar;
	private boolean empresaVisualizar;
	
	private boolean gestorCadastrar;
	private boolean gestorEditar;
	private boolean gestorListar;
	private boolean gestorVisualizar;
	
	private boolean setorCadastrar;
	private boolean setorEditar;
	private boolean setorListar;
	private boolean setorVisualizar;
	
	private boolean representanteLegalCadastrar;
	private boolean representanteLegalEditar;
	private boolean representanteLegalListar;
	private boolean representanteLegalVisualizar;
	
	private boolean contatoCadastrar;
	private boolean contatoEditar;
	private boolean contatoListar;
	private boolean contatoVisualizar;
	
	private boolean cargaHorariaCadastrar;
	private boolean cargaHorariaEditar;
	private boolean cargaHorariaListar;
	private boolean cargaHorariaVisualizar;
	
	private boolean taxaCadastrar;
	private boolean taxaEditar;
	private boolean taxaListar;
	private boolean taxaVisualizar;
	
	private boolean historicosCadastrar;
	private boolean historicosEditar;
	private boolean historicosListar;
	private boolean historicosVisualizar;
	
	/**
	 * FINANCEIROS
	 */
	private boolean parametrosCadastrar;
	private boolean parametrosEditar;
	private boolean parametrosListar;
	private boolean parametrosVisualizar;
	
	private boolean demonstrativoCadastrar;
	private boolean demonstrativoEditar;
	private boolean demonstrativoListar;
	private boolean demonstrativoVisualizar;
	
	private boolean vtCadastrar;
	private boolean vtEditar;
	private boolean vtListar;
	private boolean vtVisualizar;
	
	private boolean vrCadastrar;
	private boolean vrEditar;
	private boolean vrListar;
	private boolean vrVisualizar;
	
	private boolean salario13Cadastrar;
	private boolean salario13Editar;
	private boolean salario13Listar;
	private boolean salario13Visualizar;
	
	private boolean contaAPagarCadastrar;
	private boolean contaAPagarEditar;
	private boolean contaAPagarListar;
	private boolean contaAPagarVisualizar;
	
	private boolean contaAReceberCadastrar;
	private boolean contaAReceberEditar;
	private boolean contaAReceberListar;
	private boolean contaAReceberVisualizar;
	
	private boolean bancoCadastrar;
	private boolean bancoEditar;
	private boolean bancoListar;
	private boolean bancoVisualizar;
	
	
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
	public boolean isCursoCadastrar() {
		return cursoCadastrar;
	}
	public void setCursoCadastrar(boolean cursoCadastrar) {
		this.cursoCadastrar = cursoCadastrar;
	}
	public boolean isCursoEditar() {
		return cursoEditar;
	}
	public void setCursoEditar(boolean cursoEditar) {
		this.cursoEditar = cursoEditar;
	}
	public boolean isCursoListar() {
		return cursoListar;
	}
	public void setCursoListar(boolean cursoListar) {
		this.cursoListar = cursoListar;
	}
	public boolean isCursoVisualizar() {
		return cursoVisualizar;
	}
	public void setCursoVisualizar(boolean cursoVisualizar) {
		this.cursoVisualizar = cursoVisualizar;
	}
	public boolean isMatriculaCadastrar() {
		return matriculaCadastrar;
	}
	public void setMatriculaCadastrar(boolean matriculaCadastrar) {
		this.matriculaCadastrar = matriculaCadastrar;
	}
	public boolean isMatriculaEditar() {
		return matriculaEditar;
	}
	public void setMatriculaEditar(boolean matriculaEditar) {
		this.matriculaEditar = matriculaEditar;
	}
	public boolean isMatriculaListar() {
		return matriculaListar;
	}
	public void setMatriculaListar(boolean matriculaListar) {
		this.matriculaListar = matriculaListar;
	}
	public boolean isMatriculaVisualizar() {
		return matriculaVisualizar;
	}
	public void setMatriculaVisualizar(boolean matriculaVisualizar) {
		this.matriculaVisualizar = matriculaVisualizar;
	}
	public boolean isTurmaCadastrar() {
		return turmaCadastrar;
	}
	public void setTurmaCadastrar(boolean turmaCadastrar) {
		this.turmaCadastrar = turmaCadastrar;
	}
	public boolean isTurmaEditar() {
		return turmaEditar;
	}
	public void setTurmaEditar(boolean turmaEditar) {
		this.turmaEditar = turmaEditar;
	}
	public boolean isTurmaListar() {
		return turmaListar;
	}
	public void setTurmaListar(boolean turmaListar) {
		this.turmaListar = turmaListar;
	}
	public boolean isTurmaVisualizar() {
		return turmaVisualizar;
	}
	public void setTurmaVisualizar(boolean turmaVisualizar) {
		this.turmaVisualizar = turmaVisualizar;
	}
	public boolean isCboCadastrar() {
		return cboCadastrar;
	}
	public void setCboCadastrar(boolean cboCadastrar) {
		this.cboCadastrar = cboCadastrar;
	}
	public boolean isCboEditar() {
		return cboEditar;
	}
	public void setCboEditar(boolean cboEditar) {
		this.cboEditar = cboEditar;
	}
	public boolean isCboListar() {
		return cboListar;
	}
	public void setCboListar(boolean cboListar) {
		this.cboListar = cboListar;
	}
	public boolean isCboVisualizar() {
		return cboVisualizar;
	}
	public void setCboVisualizar(boolean cboVisualizar) {
		this.cboVisualizar = cboVisualizar;
	}
	public boolean isArcoCadastrar() {
		return arcoCadastrar;
	}
	public void setArcoCadastrar(boolean arcoCadastrar) {
		this.arcoCadastrar = arcoCadastrar;
	}
	public boolean isArcoEditar() {
		return arcoEditar;
	}
	public void setArcoEditar(boolean arcoEditar) {
		this.arcoEditar = arcoEditar;
	}
	public boolean isArcoListar() {
		return arcoListar;
	}
	public void setArcoListar(boolean arcoListar) {
		this.arcoListar = arcoListar;
	}
	public boolean isArcoVisualizar() {
		return arcoVisualizar;
	}
	public void setArcoVisualizar(boolean arcoVisualizar) {
		this.arcoVisualizar = arcoVisualizar;
	}
	public boolean isBasicoCadastrar() {
		return basicoCadastrar;
	}
	public void setBasicoCadastrar(boolean basicoCadastrar) {
		this.basicoCadastrar = basicoCadastrar;
	}
	public boolean isBasicoEditar() {
		return basicoEditar;
	}
	public void setBasicoEditar(boolean basicoEditar) {
		this.basicoEditar = basicoEditar;
	}
	public boolean isBasicoListar() {
		return basicoListar;
	}
	public void setBasicoListar(boolean basicoListar) {
		this.basicoListar = basicoListar;
	}
	public boolean isBasicoVisualizar() {
		return basicoVisualizar;
	}
	public void setBasicoVisualizar(boolean basicoVisualizar) {
		this.basicoVisualizar = basicoVisualizar;
	}
	public boolean isEspecificoCadastrar() {
		return especificoCadastrar;
	}
	public void setEspecificoCadastrar(boolean especificoCadastrar) {
		this.especificoCadastrar = especificoCadastrar;
	}
	public boolean isEspecificoEditar() {
		return especificoEditar;
	}
	public void setEspecificoEditar(boolean especificoEditar) {
		this.especificoEditar = especificoEditar;
	}
	public boolean isEspecificoListar() {
		return especificoListar;
	}
	public void setEspecificoListar(boolean especificoListar) {
		this.especificoListar = especificoListar;
	}
	public boolean isEspecificoVisualizar() {
		return especificoVisualizar;
	}
	public void setEspecificoVisualizar(boolean especificoVisualizar) {
		this.especificoVisualizar = especificoVisualizar;
	}
	public boolean isValidacaoCadastrar() {
		return validacaoCadastrar;
	}
	public void setValidacaoCadastrar(boolean validacaoCadastrar) {
		this.validacaoCadastrar = validacaoCadastrar;
	}
	public boolean isValidacaoEditar() {
		return validacaoEditar;
	}
	public void setValidacaoEditar(boolean validacaoEditar) {
		this.validacaoEditar = validacaoEditar;
	}
	public boolean isValidacaoListar() {
		return validacaoListar;
	}
	public void setValidacaoListar(boolean validacaoListar) {
		this.validacaoListar = validacaoListar;
	}
	public boolean isValidacaoVisualizar() {
		return validacaoVisualizar;
	}
	public void setValidacaoVisualizar(boolean validacaoVisualizar) {
		this.validacaoVisualizar = validacaoVisualizar;
	}
	public boolean isJovemCadastrar() {
		return jovemCadastrar;
	}
	public void setJovemCadastrar(boolean jovemCadastrar) {
		this.jovemCadastrar = jovemCadastrar;
	}
	public boolean isJovemEditar() {
		return jovemEditar;
	}
	public void setJovemEditar(boolean jovemEditar) {
		this.jovemEditar = jovemEditar;
	}
	public boolean isJovemListar() {
		return jovemListar;
	}
	public void setJovemListar(boolean jovemListar) {
		this.jovemListar = jovemListar;
	}
	public boolean isJovemVisualizar() {
		return jovemVisualizar;
	}
	public void setJovemVisualizar(boolean jovemVisualizar) {
		this.jovemVisualizar = jovemVisualizar;
	}
	public boolean isEscolaridadeCadastrar() {
		return escolaridadeCadastrar;
	}
	public void setEscolaridadeCadastrar(boolean escolaridadeCadastrar) {
		this.escolaridadeCadastrar = escolaridadeCadastrar;
	}
	public boolean isEscolaridadeEditar() {
		return escolaridadeEditar;
	}
	public void setEscolaridadeEditar(boolean escolaridadeEditar) {
		this.escolaridadeEditar = escolaridadeEditar;
	}
	public boolean isEscolaridadeListar() {
		return escolaridadeListar;
	}
	public void setEscolaridadeListar(boolean escolaridadeListar) {
		this.escolaridadeListar = escolaridadeListar;
	}
	public boolean isEscolaridadeVisualizar() {
		return escolaridadeVisualizar;
	}
	public void setEscolaridadeVisualizar(boolean escolaridadeVisualizar) {
		this.escolaridadeVisualizar = escolaridadeVisualizar;
	}
	public boolean isSituacaoLaboralCadastrar() {
		return situacaoLaboralCadastrar;
	}
	public void setSituacaoLaboralCadastrar(boolean situacaoLaboralCadastrar) {
		this.situacaoLaboralCadastrar = situacaoLaboralCadastrar;
	}
	public boolean isSituacaoLaboralEditar() {
		return situacaoLaboralEditar;
	}
	public void setSituacaoLaboralEditar(boolean situacaoLaboralEditar) {
		this.situacaoLaboralEditar = situacaoLaboralEditar;
	}
	public boolean isSituacaoLaboralListar() {
		return situacaoLaboralListar;
	}
	public void setSituacaoLaboralListar(boolean situacaoLaboralListar) {
		this.situacaoLaboralListar = situacaoLaboralListar;
	}
	public boolean isSituacaoLaboralVisualizar() {
		return situacaoLaboralVisualizar;
	}
	public void setSituacaoLaboralVisualizar(boolean situacaoLaboralVisualizar) {
		this.situacaoLaboralVisualizar = situacaoLaboralVisualizar;
	}
	public boolean isJaFoiAprendizCadastrar() {
		return jaFoiAprendizCadastrar;
	}
	public void setJaFoiAprendizCadastrar(boolean jaFoiAprendizCadastrar) {
		this.jaFoiAprendizCadastrar = jaFoiAprendizCadastrar;
	}
	public boolean isJaFoiAprendizEditar() {
		return jaFoiAprendizEditar;
	}
	public void setJaFoiAprendizEditar(boolean jaFoiAprendizEditar) {
		this.jaFoiAprendizEditar = jaFoiAprendizEditar;
	}
	public boolean isJaFoiAprendizListar() {
		return jaFoiAprendizListar;
	}
	public void setJaFoiAprendizListar(boolean jaFoiAprendizListar) {
		this.jaFoiAprendizListar = jaFoiAprendizListar;
	}
	public boolean isJaFoiAprendizVisualizar() {
		return jaFoiAprendizVisualizar;
	}
	public void setJaFoiAprendizVisualizar(boolean jaFoiAprendizVisualizar) {
		this.jaFoiAprendizVisualizar = jaFoiAprendizVisualizar;
	}
	public boolean isCaracteristicasDomiciliaresCadastrar() {
		return caracteristicasDomiciliaresCadastrar;
	}
	public void setCaracteristicasDomiciliaresCadastrar(boolean caracteristicasDomiciliaresCadastrar) {
		this.caracteristicasDomiciliaresCadastrar = caracteristicasDomiciliaresCadastrar;
	}
	public boolean isCaracteristicasDomiciliaresEditar() {
		return caracteristicasDomiciliaresEditar;
	}
	public void setCaracteristicasDomiciliaresEditar(boolean caracteristicasDomiciliaresEditar) {
		this.caracteristicasDomiciliaresEditar = caracteristicasDomiciliaresEditar;
	}
	public boolean isCaracteristicasDomiciliaresListar() {
		return caracteristicasDomiciliaresListar;
	}
	public void setCaracteristicasDomiciliaresListar(boolean caracteristicasDomiciliaresListar) {
		this.caracteristicasDomiciliaresListar = caracteristicasDomiciliaresListar;
	}
	public boolean isCaracteristicasDomiciliaresVisualizar() {
		return caracteristicasDomiciliaresVisualizar;
	}
	public void setCaracteristicasDomiciliaresVisualizar(boolean caracteristicasDomiciliaresVisualizar) {
		this.caracteristicasDomiciliaresVisualizar = caracteristicasDomiciliaresVisualizar;
	}
	public boolean isHabilidadesCadastrar() {
		return habilidadesCadastrar;
	}
	public void setHabilidadesCadastrar(boolean habilidadesCadastrar) {
		this.habilidadesCadastrar = habilidadesCadastrar;
	}
	public boolean isHabilidadesEditar() {
		return habilidadesEditar;
	}
	public void setHabilidadesEditar(boolean habilidadesEditar) {
		this.habilidadesEditar = habilidadesEditar;
	}
	public boolean isHabilidadesListar() {
		return habilidadesListar;
	}
	public void setHabilidadesListar(boolean habilidadesListar) {
		this.habilidadesListar = habilidadesListar;
	}
	public boolean isHabilidadesVisualizar() {
		return habilidadesVisualizar;
	}
	public void setHabilidadesVisualizar(boolean habilidadesVisualizar) {
		this.habilidadesVisualizar = habilidadesVisualizar;
	}
	public boolean isOutroCursoCadastrar() {
		return outroCursoCadastrar;
	}
	public void setOutroCursoCadastrar(boolean outroCursoCadastrar) {
		this.outroCursoCadastrar = outroCursoCadastrar;
	}
	public boolean isOutroCursoEditar() {
		return outroCursoEditar;
	}
	public void setOutroCursoEditar(boolean outroCursoEditar) {
		this.outroCursoEditar = outroCursoEditar;
	}
	public boolean isOutroCursoListar() {
		return outroCursoListar;
	}
	public void setOutroCursoListar(boolean outroCursoListar) {
		this.outroCursoListar = outroCursoListar;
	}
	public boolean isOutroCursoVisualizar() {
		return outroCursoVisualizar;
	}
	public void setOutroCursoVisualizar(boolean outroCursoVisualizar) {
		this.outroCursoVisualizar = outroCursoVisualizar;
	}
	public boolean isSituacaoDeSaudeCadastrar() {
		return situacaoDeSaudeCadastrar;
	}
	public void setSituacaoDeSaudeCadastrar(boolean situacaoDeSaudeCadastrar) {
		this.situacaoDeSaudeCadastrar = situacaoDeSaudeCadastrar;
	}
	public boolean isSituacaoDeSaudeEditar() {
		return situacaoDeSaudeEditar;
	}
	public void setSituacaoDeSaudeEditar(boolean situacaoDeSaudeEditar) {
		this.situacaoDeSaudeEditar = situacaoDeSaudeEditar;
	}
	public boolean isSituacaoDeSaudeListar() {
		return situacaoDeSaudeListar;
	}
	public void setSituacaoDeSaudeListar(boolean situacaoDeSaudeListar) {
		this.situacaoDeSaudeListar = situacaoDeSaudeListar;
	}
	public boolean isSituacaoDeSaudeVisualizar() {
		return situacaoDeSaudeVisualizar;
	}
	public void setSituacaoDeSaudeVisualizar(boolean situacaoDeSaudeVisualizar) {
		this.situacaoDeSaudeVisualizar = situacaoDeSaudeVisualizar;
	}
	public boolean isFichaSocialCadastrar() {
		return fichaSocialCadastrar;
	}
	public void setFichaSocialCadastrar(boolean fichaSocialCadastrar) {
		this.fichaSocialCadastrar = fichaSocialCadastrar;
	}
	public boolean isFichaSocialEditar() {
		return fichaSocialEditar;
	}
	public void setFichaSocialEditar(boolean fichaSocialEditar) {
		this.fichaSocialEditar = fichaSocialEditar;
	}
	public boolean isFichaSocialListar() {
		return fichaSocialListar;
	}
	public void setFichaSocialListar(boolean fichaSocialListar) {
		this.fichaSocialListar = fichaSocialListar;
	}
	public boolean isFichaSocialVisualizar() {
		return fichaSocialVisualizar;
	}
	public void setFichaSocialVisualizar(boolean fichaSocialVisualizar) {
		this.fichaSocialVisualizar = fichaSocialVisualizar;
	}
	public boolean isFamiliarCadastrar() {
		return familiarCadastrar;
	}
	public void setFamiliarCadastrar(boolean familiarCadastrar) {
		this.familiarCadastrar = familiarCadastrar;
	}
	public boolean isFamiliarEditar() {
		return familiarEditar;
	}
	public void setFamiliarEditar(boolean familiarEditar) {
		this.familiarEditar = familiarEditar;
	}
	public boolean isFamiliarListar() {
		return familiarListar;
	}
	public void setFamiliarListar(boolean familiarListar) {
		this.familiarListar = familiarListar;
	}
	public boolean isFamiliarVisualizar() {
		return familiarVisualizar;
	}
	public void setFamiliarVisualizar(boolean familiarVisualizar) {
		this.familiarVisualizar = familiarVisualizar;
	}
	public boolean isFichaProfissionalCadastrar() {
		return fichaProfissionalCadastrar;
	}
	public void setFichaProfissionalCadastrar(boolean fichaProfissionalCadastrar) {
		this.fichaProfissionalCadastrar = fichaProfissionalCadastrar;
	}
	public boolean isFichaProfissionalEditar() {
		return fichaProfissionalEditar;
	}
	public void setFichaProfissionalEditar(boolean fichaProfissionalEditar) {
		this.fichaProfissionalEditar = fichaProfissionalEditar;
	}
	public boolean isFichaProfissionalListar() {
		return fichaProfissionalListar;
	}
	public void setFichaProfissionalListar(boolean fichaProfissionalListar) {
		this.fichaProfissionalListar = fichaProfissionalListar;
	}
	public boolean isFichaProfissionalVisualizar() {
		return fichaProfissionalVisualizar;
	}
	public void setFichaProfissionalVisualizar(boolean fichaProfissionalVisualizar) {
		this.fichaProfissionalVisualizar = fichaProfissionalVisualizar;
	}
	public boolean isEntrevistaCadastrar() {
		return entrevistaCadastrar;
	}
	public void setEntrevistaCadastrar(boolean entrevistaCadastrar) {
		this.entrevistaCadastrar = entrevistaCadastrar;
	}
	public boolean isEntrevistaEditar() {
		return entrevistaEditar;
	}
	public void setEntrevistaEditar(boolean entrevistaEditar) {
		this.entrevistaEditar = entrevistaEditar;
	}
	public boolean isEntrevistaListar() {
		return entrevistaListar;
	}
	public void setEntrevistaListar(boolean entrevistaListar) {
		this.entrevistaListar = entrevistaListar;
	}
	public boolean isEntrevistaVisualizar() {
		return entrevistaVisualizar;
	}
	public void setEntrevistaVisualizar(boolean entrevistaVisualizar) {
		this.entrevistaVisualizar = entrevistaVisualizar;
	}
	public boolean isContratacaoCadastrar() {
		return contratacaoCadastrar;
	}
	public void setContratacaoCadastrar(boolean contratacaoCadastrar) {
		this.contratacaoCadastrar = contratacaoCadastrar;
	}
	public boolean isContratacaoEditar() {
		return contratacaoEditar;
	}
	public void setContratacaoEditar(boolean contratacaoEditar) {
		this.contratacaoEditar = contratacaoEditar;
	}
	public boolean isContratacaoListar() {
		return contratacaoListar;
	}
	public void setContratacaoListar(boolean contratacaoListar) {
		this.contratacaoListar = contratacaoListar;
	}
	public boolean isContratacaoVisualizar() {
		return contratacaoVisualizar;
	}
	public void setContratacaoVisualizar(boolean contratacaoVisualizar) {
		this.contratacaoVisualizar = contratacaoVisualizar;
	}
	public boolean isFeriasCadastrar() {
		return feriasCadastrar;
	}
	public void setFeriasCadastrar(boolean feriasCadastrar) {
		this.feriasCadastrar = feriasCadastrar;
	}
	public boolean isFeriasEditar() {
		return feriasEditar;
	}
	public void setFeriasEditar(boolean feriasEditar) {
		this.feriasEditar = feriasEditar;
	}
	public boolean isFeriasListar() {
		return feriasListar;
	}
	public void setFeriasListar(boolean feriasListar) {
		this.feriasListar = feriasListar;
	}
	public boolean isFeriasVisualizar() {
		return feriasVisualizar;
	}
	public void setFeriasVisualizar(boolean feriasVisualizar) {
		this.feriasVisualizar = feriasVisualizar;
	}
	public boolean isDispensaCadastrar() {
		return dispensaCadastrar;
	}
	public void setDispensaCadastrar(boolean dispensaCadastrar) {
		this.dispensaCadastrar = dispensaCadastrar;
	}
	public boolean isDispensaEditar() {
		return dispensaEditar;
	}
	public void setDispensaEditar(boolean dispensaEditar) {
		this.dispensaEditar = dispensaEditar;
	}
	public boolean isDispensaListar() {
		return dispensaListar;
	}
	public void setDispensaListar(boolean dispensaListar) {
		this.dispensaListar = dispensaListar;
	}
	public boolean isDispensaVisualizar() {
		return dispensaVisualizar;
	}
	public void setDispensaVisualizar(boolean dispensaVisualizar) {
		this.dispensaVisualizar = dispensaVisualizar;
	}
	public boolean isHistoricoCadastrar() {
		return historicoCadastrar;
	}
	public void setHistoricoCadastrar(boolean historicoCadastrar) {
		this.historicoCadastrar = historicoCadastrar;
	}
	public boolean isHistoricoEditar() {
		return historicoEditar;
	}
	public void setHistoricoEditar(boolean historicoEditar) {
		this.historicoEditar = historicoEditar;
	}
	public boolean isHistoricoListar() {
		return historicoListar;
	}
	public void setHistoricoListar(boolean historicoListar) {
		this.historicoListar = historicoListar;
	}
	public boolean isHistoricoVisualizar() {
		return historicoVisualizar;
	}
	public void setHistoricoVisualizar(boolean historicoVisualizar) {
		this.historicoVisualizar = historicoVisualizar;
	}
	public boolean ispIPCadastrar() {
		return pIPCadastrar;
	}
	public void setpIPCadastrar(boolean pIPCadastrar) {
		this.pIPCadastrar = pIPCadastrar;
	}
	public boolean ispIPEditar() {
		return pIPEditar;
	}
	public void setpIPEditar(boolean pIPEditar) {
		this.pIPEditar = pIPEditar;
	}
	public boolean ispIPListar() {
		return pIPListar;
	}
	public void setpIPListar(boolean pIPListar) {
		this.pIPListar = pIPListar;
	}
	public boolean ispIPVisualizar() {
		return pIPVisualizar;
	}
	public void setpIPVisualizar(boolean pIPVisualizar) {
		this.pIPVisualizar = pIPVisualizar;
	}
	public boolean ispITCadastrar() {
		return pITCadastrar;
	}
	public void setpITCadastrar(boolean pITCadastrar) {
		this.pITCadastrar = pITCadastrar;
	}
	public boolean ispITEditar() {
		return pITEditar;
	}
	public void setpITEditar(boolean pITEditar) {
		this.pITEditar = pITEditar;
	}
	public boolean ispITListar() {
		return pITListar;
	}
	public void setpITListar(boolean pITListar) {
		this.pITListar = pITListar;
	}
	public boolean ispITVisualizar() {
		return pITVisualizar;
	}
	public void setpITVisualizar(boolean pITVisualizar) {
		this.pITVisualizar = pITVisualizar;
	}
	public boolean ispIOCadastrar() {
		return pIOCadastrar;
	}
	public void setpIOCadastrar(boolean pIOCadastrar) {
		this.pIOCadastrar = pIOCadastrar;
	}
	public boolean ispIOEditar() {
		return pIOEditar;
	}
	public void setpIOEditar(boolean pIOEditar) {
		this.pIOEditar = pIOEditar;
	}
	public boolean ispIOListar() {
		return pIOListar;
	}
	public void setpIOListar(boolean pIOListar) {
		this.pIOListar = pIOListar;
	}
	public boolean ispIOVisualizar() {
		return pIOVisualizar;
	}
	public void setpIOVisualizar(boolean pIOVisualizar) {
		this.pIOVisualizar = pIOVisualizar;
	}
	public boolean ispAPEmpresaCadastrar() {
		return pAPEmpresaCadastrar;
	}
	public void setpAPEmpresaCadastrar(boolean pAPEmpresaCadastrar) {
		this.pAPEmpresaCadastrar = pAPEmpresaCadastrar;
	}
	public boolean ispAPEmpresaEditar() {
		return pAPEmpresaEditar;
	}
	public void setpAPEmpresaEditar(boolean pAPEmpresaEditar) {
		this.pAPEmpresaEditar = pAPEmpresaEditar;
	}
	public boolean ispAPEmpresaListar() {
		return pAPEmpresaListar;
	}
	public void setpAPEmpresaListar(boolean pAPEmpresaListar) {
		this.pAPEmpresaListar = pAPEmpresaListar;
	}
	public boolean ispAPEmpresaVisualizar() {
		return pAPEmpresaVisualizar;
	}
	public void setpAPEmpresaVisualizar(boolean pAPEmpresaVisualizar) {
		this.pAPEmpresaVisualizar = pAPEmpresaVisualizar;
	}
	public boolean ispAPIPPCadastrar() {
		return pAPIPPCadastrar;
	}
	public void setpAPIPPCadastrar(boolean pAPIPPCadastrar) {
		this.pAPIPPCadastrar = pAPIPPCadastrar;
	}
	public boolean ispAPIPPEditar() {
		return pAPIPPEditar;
	}
	public void setpAPIPPEditar(boolean pAPIPPEditar) {
		this.pAPIPPEditar = pAPIPPEditar;
	}
	public boolean ispAPIPPListar() {
		return pAPIPPListar;
	}
	public void setpAPIPPListar(boolean pAPIPPListar) {
		this.pAPIPPListar = pAPIPPListar;
	}
	public boolean ispAPIPPVisualizar() {
		return pAPIPPVisualizar;
	}
	public void setpAPIPPVisualizar(boolean pAPIPPVisualizar) {
		this.pAPIPPVisualizar = pAPIPPVisualizar;
	}
	public boolean isOcorrenciaCadastrar() {
		return ocorrenciaCadastrar;
	}
	public void setOcorrenciaCadastrar(boolean ocorrenciaCadastrar) {
		this.ocorrenciaCadastrar = ocorrenciaCadastrar;
	}
	public boolean isOcorrenciaEditar() {
		return ocorrenciaEditar;
	}
	public void setOcorrenciaEditar(boolean ocorrenciaEditar) {
		this.ocorrenciaEditar = ocorrenciaEditar;
	}
	public boolean isOcorrenciaListar() {
		return ocorrenciaListar;
	}
	public void setOcorrenciaListar(boolean ocorrenciaListar) {
		this.ocorrenciaListar = ocorrenciaListar;
	}
	public boolean isOcorrenciaVisualizar() {
		return ocorrenciaVisualizar;
	}
	public void setOcorrenciaVisualizar(boolean ocorrenciaVisualizar) {
		this.ocorrenciaVisualizar = ocorrenciaVisualizar;
	}
	public boolean isDadosFinanceirosCadastrar() {
		return dadosFinanceirosCadastrar;
	}
	public void setDadosFinanceirosCadastrar(boolean dadosFinanceirosCadastrar) {
		this.dadosFinanceirosCadastrar = dadosFinanceirosCadastrar;
	}
	public boolean isDadosFinanceirosEditar() {
		return dadosFinanceirosEditar;
	}
	public void setDadosFinanceirosEditar(boolean dadosFinanceirosEditar) {
		this.dadosFinanceirosEditar = dadosFinanceirosEditar;
	}
	public boolean isDadosFinanceirosListar() {
		return dadosFinanceirosListar;
	}
	public void setDadosFinanceirosListar(boolean dadosFinanceirosListar) {
		this.dadosFinanceirosListar = dadosFinanceirosListar;
	}
	public boolean isDadosFinanceirosVisualizar() {
		return dadosFinanceirosVisualizar;
	}
	public void setDadosFinanceirosVisualizar(boolean dadosFinanceirosVisualizar) {
		this.dadosFinanceirosVisualizar = dadosFinanceirosVisualizar;
	}
	public boolean isFrequenciaCadastrar() {
		return frequenciaCadastrar;
	}
	public void setFrequenciaCadastrar(boolean frequenciaCadastrar) {
		this.frequenciaCadastrar = frequenciaCadastrar;
	}
	public boolean isFrequenciaEditar() {
		return frequenciaEditar;
	}
	public void setFrequenciaEditar(boolean frequenciaEditar) {
		this.frequenciaEditar = frequenciaEditar;
	}
	public boolean isFrequenciaListar() {
		return frequenciaListar;
	}
	public void setFrequenciaListar(boolean frequenciaListar) {
		this.frequenciaListar = frequenciaListar;
	}
	public boolean isFrequenciaVisualizar() {
		return frequenciaVisualizar;
	}
	public void setFrequenciaVisualizar(boolean frequenciaVisualizar) {
		this.frequenciaVisualizar = frequenciaVisualizar;
	}
	public boolean isEmpresaCadastrar() {
		return empresaCadastrar;
	}
	public void setEmpresaCadastrar(boolean empresaCadastrar) {
		this.empresaCadastrar = empresaCadastrar;
	}
	public boolean isEmpresaEditar() {
		return empresaEditar;
	}
	public void setEmpresaEditar(boolean empresaEditar) {
		this.empresaEditar = empresaEditar;
	}
	public boolean isEmpresaListar() {
		return empresaListar;
	}
	public void setEmpresaListar(boolean empresaListar) {
		this.empresaListar = empresaListar;
	}
	public boolean isEmpresaVisualizar() {
		return empresaVisualizar;
	}
	public void setEmpresaVisualizar(boolean empresaVisualizar) {
		this.empresaVisualizar = empresaVisualizar;
	}
	public boolean isGestorCadastrar() {
		return gestorCadastrar;
	}
	public void setGestorCadastrar(boolean gestorCadastrar) {
		this.gestorCadastrar = gestorCadastrar;
	}
	public boolean isGestorEditar() {
		return gestorEditar;
	}
	public void setGestorEditar(boolean gestorEditar) {
		this.gestorEditar = gestorEditar;
	}
	public boolean isGestorListar() {
		return gestorListar;
	}
	public void setGestorListar(boolean gestorListar) {
		this.gestorListar = gestorListar;
	}
	public boolean isGestorVisualizar() {
		return gestorVisualizar;
	}
	public void setGestorVisualizar(boolean gestorVisualizar) {
		this.gestorVisualizar = gestorVisualizar;
	}
	public boolean isSetorCadastrar() {
		return setorCadastrar;
	}
	public void setSetorCadastrar(boolean setorCadastrar) {
		this.setorCadastrar = setorCadastrar;
	}
	public boolean isSetorEditar() {
		return setorEditar;
	}
	public void setSetorEditar(boolean setorEditar) {
		this.setorEditar = setorEditar;
	}
	public boolean isSetorListar() {
		return setorListar;
	}
	public void setSetorListar(boolean setorListar) {
		this.setorListar = setorListar;
	}
	public boolean isSetorVisualizar() {
		return setorVisualizar;
	}
	public void setSetorVisualizar(boolean setorVisualizar) {
		this.setorVisualizar = setorVisualizar;
	}
	public boolean isRepresentanteLegalCadastrar() {
		return representanteLegalCadastrar;
	}
	public void setRepresentanteLegalCadastrar(boolean representanteLegalCadastrar) {
		this.representanteLegalCadastrar = representanteLegalCadastrar;
	}
	public boolean isRepresentanteLegalEditar() {
		return representanteLegalEditar;
	}
	public void setRepresentanteLegalEditar(boolean representanteLegalEditar) {
		this.representanteLegalEditar = representanteLegalEditar;
	}
	public boolean isRepresentanteLegalListar() {
		return representanteLegalListar;
	}
	public void setRepresentanteLegalListar(boolean representanteLegalListar) {
		this.representanteLegalListar = representanteLegalListar;
	}
	public boolean isRepresentanteLegalVisualizar() {
		return representanteLegalVisualizar;
	}
	public void setRepresentanteLegalVisualizar(boolean representanteLegalVisualizar) {
		this.representanteLegalVisualizar = representanteLegalVisualizar;
	}
	public boolean isContatoCadastrar() {
		return contatoCadastrar;
	}
	public void setContatoCadastrar(boolean contatoCadastrar) {
		this.contatoCadastrar = contatoCadastrar;
	}
	public boolean isContatoEditar() {
		return contatoEditar;
	}
	public void setContatoEditar(boolean contatoEditar) {
		this.contatoEditar = contatoEditar;
	}
	public boolean isContatoListar() {
		return contatoListar;
	}
	public void setContatoListar(boolean contatoListar) {
		this.contatoListar = contatoListar;
	}
	public boolean isContatoVisualizar() {
		return contatoVisualizar;
	}
	public void setContatoVisualizar(boolean contatoVisualizar) {
		this.contatoVisualizar = contatoVisualizar;
	}
	public boolean isCargaHorariaCadastrar() {
		return cargaHorariaCadastrar;
	}
	public void setCargaHorariaCadastrar(boolean cargaHorariaCadastrar) {
		this.cargaHorariaCadastrar = cargaHorariaCadastrar;
	}
	public boolean isCargaHorariaEditar() {
		return cargaHorariaEditar;
	}
	public void setCargaHorariaEditar(boolean cargaHorariaEditar) {
		this.cargaHorariaEditar = cargaHorariaEditar;
	}
	public boolean isCargaHorariaListar() {
		return cargaHorariaListar;
	}
	public void setCargaHorariaListar(boolean cargaHorariaListar) {
		this.cargaHorariaListar = cargaHorariaListar;
	}
	public boolean isCargaHorariaVisualizar() {
		return cargaHorariaVisualizar;
	}
	public void setCargaHorariaVisualizar(boolean cargaHorariaVisualizar) {
		this.cargaHorariaVisualizar = cargaHorariaVisualizar;
	}
	public boolean isTaxaCadastrar() {
		return taxaCadastrar;
	}
	public void setTaxaCadastrar(boolean taxaCadastrar) {
		this.taxaCadastrar = taxaCadastrar;
	}
	public boolean isTaxaEditar() {
		return taxaEditar;
	}
	public void setTaxaEditar(boolean taxaEditar) {
		this.taxaEditar = taxaEditar;
	}
	public boolean isTaxaListar() {
		return taxaListar;
	}
	public void setTaxaListar(boolean taxaListar) {
		this.taxaListar = taxaListar;
	}
	public boolean isTaxaVisualizar() {
		return taxaVisualizar;
	}
	public void setTaxaVisualizar(boolean taxaVisualizar) {
		this.taxaVisualizar = taxaVisualizar;
	}
	public boolean isHistoricosCadastrar() {
		return historicosCadastrar;
	}
	public void setHistoricosCadastrar(boolean historicosCadastrar) {
		this.historicosCadastrar = historicosCadastrar;
	}
	public boolean isHistoricosEditar() {
		return historicosEditar;
	}
	public void setHistoricosEditar(boolean historicosEditar) {
		this.historicosEditar = historicosEditar;
	}
	public boolean isHistoricosListar() {
		return historicosListar;
	}
	public void setHistoricosListar(boolean historicosListar) {
		this.historicosListar = historicosListar;
	}
	public boolean isHistoricosVisualizar() {
		return historicosVisualizar;
	}
	public void setHistoricosVisualizar(boolean historicosVisualizar) {
		this.historicosVisualizar = historicosVisualizar;
	}
	public boolean isParametrosCadastrar() {
		return parametrosCadastrar;
	}
	public void setParametrosCadastrar(boolean parametrosCadastrar) {
		this.parametrosCadastrar = parametrosCadastrar;
	}
	public boolean isParametrosEditar() {
		return parametrosEditar;
	}
	public void setParametrosEditar(boolean parametrosEditar) {
		this.parametrosEditar = parametrosEditar;
	}
	public boolean isParametrosListar() {
		return parametrosListar;
	}
	public void setParametrosListar(boolean parametrosListar) {
		this.parametrosListar = parametrosListar;
	}
	public boolean isParametrosVisualizar() {
		return parametrosVisualizar;
	}
	public void setParametrosVisualizar(boolean parametrosVisualizar) {
		this.parametrosVisualizar = parametrosVisualizar;
	}
	public boolean isDemonstrativoCadastrar() {
		return demonstrativoCadastrar;
	}
	public void setDemonstrativoCadastrar(boolean demonstrativoCadastrar) {
		this.demonstrativoCadastrar = demonstrativoCadastrar;
	}
	public boolean isDemonstrativoEditar() {
		return demonstrativoEditar;
	}
	public void setDemonstrativoEditar(boolean demonstrativoEditar) {
		this.demonstrativoEditar = demonstrativoEditar;
	}
	public boolean isDemonstrativoListar() {
		return demonstrativoListar;
	}
	public void setDemonstrativoListar(boolean demonstrativoListar) {
		this.demonstrativoListar = demonstrativoListar;
	}
	public boolean isDemonstrativoVisualizar() {
		return demonstrativoVisualizar;
	}
	public void setDemonstrativoVisualizar(boolean demonstrativoVisualizar) {
		this.demonstrativoVisualizar = demonstrativoVisualizar;
	}
	public boolean isVtCadastrar() {
		return vtCadastrar;
	}
	public void setVtCadastrar(boolean vtCadastrar) {
		this.vtCadastrar = vtCadastrar;
	}
	public boolean isVtEditar() {
		return vtEditar;
	}
	public void setVtEditar(boolean vtEditar) {
		this.vtEditar = vtEditar;
	}
	public boolean isVtListar() {
		return vtListar;
	}
	public void setVtListar(boolean vtListar) {
		this.vtListar = vtListar;
	}
	public boolean isVtVisualizar() {
		return vtVisualizar;
	}
	public void setVtVisualizar(boolean vtVisualizar) {
		this.vtVisualizar = vtVisualizar;
	}
	public boolean isVrCadastrar() {
		return vrCadastrar;
	}
	public void setVrCadastrar(boolean vrCadastrar) {
		this.vrCadastrar = vrCadastrar;
	}
	public boolean isVrEditar() {
		return vrEditar;
	}
	public void setVrEditar(boolean vrEditar) {
		this.vrEditar = vrEditar;
	}
	public boolean isVrListar() {
		return vrListar;
	}
	public void setVrListar(boolean vrListar) {
		this.vrListar = vrListar;
	}
	public boolean isVrVisualizar() {
		return vrVisualizar;
	}
	public void setVrVisualizar(boolean vrVisualizar) {
		this.vrVisualizar = vrVisualizar;
	}
	public boolean isSalario13Cadastrar() {
		return salario13Cadastrar;
	}
	public void setSalario13Cadastrar(boolean salario13Cadastrar) {
		this.salario13Cadastrar = salario13Cadastrar;
	}
	public boolean isSalario13Editar() {
		return salario13Editar;
	}
	public void setSalario13Editar(boolean salario13Editar) {
		this.salario13Editar = salario13Editar;
	}
	public boolean isSalario13Listar() {
		return salario13Listar;
	}
	public void setSalario13Listar(boolean salario13Listar) {
		this.salario13Listar = salario13Listar;
	}
	public boolean isSalario13Visualizar() {
		return salario13Visualizar;
	}
	public void setSalario13Visualizar(boolean salario13Visualizar) {
		this.salario13Visualizar = salario13Visualizar;
	}
	public boolean isContaAPagarCadastrar() {
		return contaAPagarCadastrar;
	}
	public void setContaAPagarCadastrar(boolean contaAPagarCadastrar) {
		this.contaAPagarCadastrar = contaAPagarCadastrar;
	}
	public boolean isContaAPagarEditar() {
		return contaAPagarEditar;
	}
	public void setContaAPagarEditar(boolean contaAPagarEditar) {
		this.contaAPagarEditar = contaAPagarEditar;
	}
	public boolean isContaAPagarListar() {
		return contaAPagarListar;
	}
	public void setContaAPagarListar(boolean contaAPagarListar) {
		this.contaAPagarListar = contaAPagarListar;
	}
	public boolean isContaAPagarVisualizar() {
		return contaAPagarVisualizar;
	}
	public void setContaAPagarVisualizar(boolean contaAPagarVisualizar) {
		this.contaAPagarVisualizar = contaAPagarVisualizar;
	}
	public boolean isContaAReceberCadastrar() {
		return contaAReceberCadastrar;
	}
	public void setContaAReceberCadastrar(boolean contaAReceberCadastrar) {
		this.contaAReceberCadastrar = contaAReceberCadastrar;
	}
	public boolean isContaAReceberEditar() {
		return contaAReceberEditar;
	}
	public void setContaAReceberEditar(boolean contaAReceberEditar) {
		this.contaAReceberEditar = contaAReceberEditar;
	}
	public boolean isContaAReceberListar() {
		return contaAReceberListar;
	}
	public void setContaAReceberListar(boolean contaAReceberListar) {
		this.contaAReceberListar = contaAReceberListar;
	}
	public boolean isContaAReceberVisualizar() {
		return contaAReceberVisualizar;
	}
	public void setContaAReceberVisualizar(boolean contaAReceberVisualizar) {
		this.contaAReceberVisualizar = contaAReceberVisualizar;
	}
	public boolean isBancoCadastrar() {
		return bancoCadastrar;
	}
	public void setBancoCadastrar(boolean bancoCadastrar) {
		this.bancoCadastrar = bancoCadastrar;
	}
	public boolean isBancoEditar() {
		return bancoEditar;
	}
	public void setBancoEditar(boolean bancoEditar) {
		this.bancoEditar = bancoEditar;
	}
	public boolean isBancoListar() {
		return bancoListar;
	}
	public void setBancoListar(boolean bancoListar) {
		this.bancoListar = bancoListar;
	}
	public boolean isBancoVisualizar() {
		return bancoVisualizar;
	}
	public void setBancoVisualizar(boolean bancoVisualizar) {
		this.bancoVisualizar = bancoVisualizar;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
