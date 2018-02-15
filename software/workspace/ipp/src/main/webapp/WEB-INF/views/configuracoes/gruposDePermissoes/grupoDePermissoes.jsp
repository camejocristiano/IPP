<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>


<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
				<h4 class="header right black-text">Grupo de Permissões</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
		<c:url value="/sw/grupoDePermissoes/${grupoDePermissoes.grupo != null ? grupoDePermissoes.id : null}" var="swGrupoDePermissoesId"></c:url>
		<form:form role="form" commandName="grupoDePermissoes" servletRelativeAction="${swGrupoDePermissoesId}" method="POST">
			<div class="row">
				<div class="input-field col s4">
					<form:input path='grupo' type='text' required="required" />
					<form:errors path='grupo' />
					<label for="grupo">Nome do Grupo</label>
				</div>
				<div class="input-field col s4">
					<form:select path="status">
						<option>${grupoDePermissoes.status}</option>
						<c:forEach var="status" items="${requestScope.status}">
							<option>${status}</option>							
						</c:forEach>
					</form:select>
					<label for="status">Status do Grupo</label>
				</div>
				<div class="input-field col s4">
					<form:select path="unidade">
						<option value="${grupoDePermissoes.unidade.id}">${grupoDePermissoes.unidade.nomeFantazia}</option>
						<c:forEach var="unidade" items="${requestScope.unidades}">
							<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
						</c:forEach>
					</form:select>
					<label for="unidade">Unidade do Grupo</label>
				</div>
			</div>
			<div class="row">
				<div class="col s12">
					<p id="descrcao">
						Descrição 
						<label style="margin-left: 2em; float: right" for="filled-in-box">Listar</label>
						<label style="margin-left: 2em; float: right" for="filled-in-box">Editar</label>
						<label style="margin-left: 2em; float: right" for="filled-in-box">Visualizar</label> 
						<label style="margin-left: 2em; float: right" for="filled-in-box">Cadastrar</label>
					</p>
					<hr>
				</div>
			</div>


			<div class="row">

				<div class="col s12">
					<h5>Configurações</h5>
					<br />
					<p>
						Usuários 
						<input type="checkbox" name="usuarioListar" class="filled-in" id="usuarioListar" <c:if test="${grupoDePermissoes.usuarioListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="usuarioListar"></label>
						<input type="checkbox" name="usuarioEditar" class="filled-in" id="usuarioEditar" <c:if test="${grupoDePermissoes.usuarioEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="usuarioEditar"></label>
						<input type="checkbox" name="usuarioVisualizar" class="filled-in" id="usuarioVisualizar" <c:if test="${grupoDePermissoes.usuarioVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="usuarioVisualizar"></label>
						<input type="checkbox" name="usuarioCadastrar" class="filled-in" id="usuarioCadastrar" <c:if test="${grupoDePermissoes.usuarioCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="usuarioCadastrar"></label>						
					</p>
					<hr>
					<p>
						Grupos de Permissões 
						<input type="checkbox" name="grupoDePermissoesListar" class="filled-in" id="grupoDePermissoesListar" <c:if test="${grupoDePermissoes.grupoDePermissoesListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="grupoDePermissoesListar"></label>
						<input type="checkbox" name="grupoDePermissoesEditar" class="filled-in" id="grupoDePermissoesEditar" <c:if test="${grupoDePermissoes.grupoDePermissoesEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="grupoDePermissoesEditar"></label>
						<input type="checkbox" name="grupoDePermissoesVisualizar" class="filled-in" id="grupoDePermissoesVisualizar" <c:if test="${grupoDePermissoes.grupoDePermissoesVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="grupoDePermissoesVisualizar"></label>
						<input type="checkbox" name="grupoDePermissoesCadastrar" class="filled-in" id="grupoDePermissoesCadastrar" <c:if test="${grupoDePermissoes.grupoDePermissoesCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="grupoDePermissoesCadastrar"></label>	
					</p>
					<hr>
					<p>
						Unidades 
						<input type="checkbox" name="unidadeListar" class="filled-in" id="unidadeListar" <c:if test="${grupoDePermissoes.unidadeListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="unidadeListar"></label>
						<input type="checkbox" name="unidadeEditar" class="filled-in" id="unidadeEditar" <c:if test="${grupoDePermissoes.unidadeEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="unidadeEditar"></label>
						<input type="checkbox" name="unidadeVisualizar" class="filled-in" id="unidadeVisualizar" <c:if test="${grupoDePermissoes.unidadeVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="unidadeVisualizar"></label>
						<input type="checkbox" name="unidadeCadastrar" class="filled-in" id="unidadeCadastrar" <c:if test="${grupoDePermissoes.unidadeCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="unidadeCadastrar"></label>
					</p>
					<hr>
					<p>
						Canais 
						<input type="checkbox" name="canalListar" class="filled-in" id="canalListar" <c:if test="${grupoDePermissoes.canalListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="canalListar"></label>
						<input type="checkbox" name="canalEditar" class="filled-in" id="canalEditar" <c:if test="${grupoDePermissoes.canalEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="canalEditar"></label>
						<input type="checkbox" name="canalVisualizar" class="filled-in" id="canalVisualizar" <c:if test="${grupoDePermissoes.canalVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="canalVisualizar"></label>
						<input type="checkbox" name="canalCadastrar" class="filled-in" id="canalCadastrar" <c:if test="${grupoDePermissoes.canalCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="canalCadastrar"></label>
					</p>
					<hr>
					<p>
						Gerenciador de Arquivos 
						<input type="checkbox" name="arquivoListar" class="filled-in" id="arquivoListar" <c:if test="${grupoDePermissoes.arquivoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="arquivoListar"></label>
						<input type="checkbox" name="arquivoEditar" class="filled-in" id="arquivoEditar" <c:if test="${grupoDePermissoes.arquivoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="arquivoEditar"></label>
						<input type="checkbox" name="arquivoVisualizar" class="filled-in" id="arquivoVisualizar" <c:if test="${grupoDePermissoes.arquivoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="arquivoVisualizar"></label>
						<input type="checkbox" name="arquivoCadastrar" class="filled-in" id="arquivoCadastrar" <c:if test="${grupoDePermissoes.arquivoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="arquivoCadastrar"></label>
					</p>
					<hr>
					<p>
						Agendamentos 
						<input type="checkbox" name="agendamentoListar" class="filled-in" id="agendamentoListar" <c:if test="${grupoDePermissoes.agendamentoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="agendamentoListar"></label>
						<input type="checkbox" name="agendamentoEditar" class="filled-in" id="agendamentoEditar" <c:if test="${grupoDePermissoes.agendamentoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="agendamentoEditar"></label>
						<input type="checkbox" name="agendamentoVisualizar" class="filled-in" id="agendamentoVisualizar" <c:if test="${grupoDePermissoes.agendamentoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="agendamentoVisualizar"></label>
						<input type="checkbox" name="agendamentoCadastrar" class="filled-in" id="agendamentoCadastrar" <c:if test="${grupoDePermissoes.agendamentoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="agendamentoCadastrar"></label>
					</p>
					<hr>
				</div>
			</div>


			<div class="row">

				<div class="col s12">
					<h5>Cursos</h5>
					<p>
					Curso
						<input type="checkbox" name="cursoListar" class="filled-in" id="cursoListar" <c:if test="${grupoDePermissoes.cursoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="cursoListar"></label>
						<input type="checkbox" name="cursoEditar" class="filled-in" id="cursoEditar" <c:if test="${grupoDePermissoes.cursoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="cursoEditar"></label>
						<input type="checkbox" name="cursoVisualizar" class="filled-in" id="cursoVisualizar" <c:if test="${grupoDePermissoes.cursoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="cursoVisualizar"></label>
						<input type="checkbox" name="cursoCadastrar" class="filled-in" id="cursoCadastrar" <c:if test="${grupoDePermissoes.cursoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="cursoCadastrar"></label>
					</p>
					<hr>
					<p>
					Matrícula
						<input type="checkbox" name="matriculaListar" class="filled-in" id="matriculaListar" <c:if test="${grupoDePermissoes.matriculaListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="matriculaListar"></label>
						<input type="checkbox" name="matriculaEditar" class="filled-in" id="matriculaEditar" <c:if test="${grupoDePermissoes.matriculaEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="matriculaEditar"></label>
						<input type="checkbox" name="matriculaVisualizar" class="filled-in" id="matriculaVisualizar" <c:if test="${grupoDePermissoes.matriculaVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="matriculaVisualizar"></label>
						<input type="checkbox" name="matriculaCadastrar" class="filled-in" id="matriculaCadastrar" <c:if test="${grupoDePermissoes.matriculaCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="matriculaCadastrar"></label>
					</p>
					<hr>
					<p>
					Turma
						<input type="checkbox" name="turmaListar" class="filled-in" id="turmaListar" <c:if test="${grupoDePermissoes.turmaListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="turmaListar"></label>
						<input type="checkbox" name="turmaEditar" class="filled-in" id="turmaEditar" <c:if test="${grupoDePermissoes.turmaEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="turmaEditar"></label>
						<input type="checkbox" name="turmaVisualizar" class="filled-in" id="turmaVisualizar" <c:if test="${grupoDePermissoes.turmaVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="turmaVisualizar"></label>
						<input type="checkbox" name="turmaCadastrar" class="filled-in" id="turmaCadastrar" <c:if test="${grupoDePermissoes.turmaCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="turmaCadastrar"></label>
					</p>
					<hr>

				</div>
			</div>


			<div class="row">

				<div class="col s12">
					<h5>Aprendizes</h5>
					<p>
					Jovens
						<input type="checkbox" name="jovemListar" class="filled-in" id="jovemListar" <c:if test="${grupoDePermissoes.jovemListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="jovemListar"></label>
						<input type="checkbox" name="jovemEditar" class="filled-in" id="jovemEditar" <c:if test="${grupoDePermissoes.jovemEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="jovemEditar"></label>
						<input type="checkbox" name="jovemVisualizar" class="filled-in" id="jovemVisualizar" <c:if test="${grupoDePermissoes.jovemVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="jovemVisualizar"></label>
						<input type="checkbox" name="jovemCadastrar" class="filled-in" id="jovemCadastrar" <c:if test="${grupoDePermissoes.jovemCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="jovemCadastrar"></label>
					</p>
					<hr>
					<p>
					Escolaridade 	
						<input type="checkbox" name="escolaridadeListar" class="filled-in" id="escolaridadeListar" <c:if test="${grupoDePermissoes.escolaridadeListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="escolaridadeListar"></label>
						<input type="checkbox" name="escolaridadeEditar" class="filled-in" id="escolaridadeEditar" <c:if test="${grupoDePermissoes.escolaridadeEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="escolaridadeEditar"></label>
						<input type="checkbox" name="escolaridadeVisualizar" class="filled-in" id="escolaridadeVisualizar" <c:if test="${grupoDePermissoes.escolaridadeVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="escolaridadeVisualizar"></label>
						<input type="checkbox" name="escolaridadeCadastrar" class="filled-in" id="escolaridadeCadastrar" <c:if test="${grupoDePermissoes.escolaridadeCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="escolaridadeCadastrar"></label>
					</p>
					<hr>
					<p>
					Situação Laboral 	
						<input type="checkbox" name="situacaoLaboralListar" class="filled-in" id="situacaoLaboralListar" <c:if test="${grupoDePermissoes.situacaoLaboralListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoLaboralListar"></label>
						<input type="checkbox" name="situacaoLaboralEditar" class="filled-in" id="situacaoLaboralEditar" <c:if test="${grupoDePermissoes.situacaoLaboralEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoLaboralEditar"></label>
						<input type="checkbox" name="situacaoLaboralVisualizar" class="filled-in" id="situacaoLaboralVisualizar" <c:if test="${grupoDePermissoes.situacaoLaboralVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoLaboralVisualizar"></label>
						<input type="checkbox" name="situacaoLaboralCadastrar" class="filled-in" id="situacaoLaboralCadastrar" <c:if test="${grupoDePermissoes.situacaoLaboralCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoLaboralCadastrar"></label>
					</p>
					<hr>
					<p>
					Características Domiciliares 	
						<input type="checkbox" name="caracteristicasDomiciliaresListar" class="filled-in" id="caracteristicasDomiciliaresListar" <c:if test="${grupoDePermissoes.caracteristicasDomiciliaresListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="caracteristicasDomiciliaresListar"></label>
						<input type="checkbox" name="caracteristicasDomiciliaresEditar" class="filled-in" id="caracteristicasDomiciliaresEditar" <c:if test="${grupoDePermissoes.caracteristicasDomiciliaresEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="caracteristicasDomiciliaresEditar"></label>
						<input type="checkbox" name="caracteristicasDomiciliaresVisualizar" class="filled-in" id="caracteristicasDomiciliaresVisualizar" <c:if test="${grupoDePermissoes.caracteristicasDomiciliaresVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="caracteristicasDomiciliaresVisualizar"></label>
						<input type="checkbox" name="caracteristicasDomiciliaresCadastrar" class="filled-in" id="caracteristicasDomiciliaresCadastrar" <c:if test="${grupoDePermissoes.caracteristicasDomiciliaresCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="caracteristicasDomiciliaresCadastrar"></label>
					</p>
					<hr>
					<p>
					Habilidades 	
						<input type="checkbox" name="habilidadesListar" class="filled-in" id="habilidadesListar" <c:if test="${grupoDePermissoes.habilidadesListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="habilidadesListar"></label>
						<input type="checkbox" name="habilidadesEditar" class="filled-in" id="habilidadesEditar" <c:if test="${grupoDePermissoes.habilidadesEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="habilidadesEditar"></label>
						<input type="checkbox" name="habilidadesVisualizar" class="filled-in" id="habilidadesVisualizar" <c:if test="${grupoDePermissoes.habilidadesVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="habilidadesVisualizar"></label>
						<input type="checkbox" name="habilidadesCadastrar" class="filled-in" id="habilidadesCadastrar" <c:if test="${grupoDePermissoes.habilidadesCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="habilidadesCadastrar"></label>
					</p>
					<hr>
					<p>
					Situação de Saúde 	
						<input type="checkbox" name="situacaoDeSaudeListar" class="filled-in" id="situacaoDeSaudeListar" <c:if test="${grupoDePermissoes.situacaoDeSaudeListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoDeSaudeListar"></label>
						<input type="checkbox" name="situacaoDeSaudeEditar" class="filled-in" id="situacaoDeSaudeEditar" <c:if test="${grupoDePermissoes.situacaoDeSaudeEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoDeSaudeEditar"></label>
						<input type="checkbox" name="situacaoDeSaudeVisualizar" class="filled-in" id="situacaoDeSaudeVisualizar" <c:if test="${grupoDePermissoes.situacaoDeSaudeVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoDeSaudeVisualizar"></label>
						<input type="checkbox" name="situacaoDeSaudeCadastrar" class="filled-in" id="situacaoDeSaudeCadastrar" <c:if test="${grupoDePermissoes.situacaoDeSaudeCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="situacaoDeSaudeCadastrar"></label>
					</p>
					<hr>
					<p>
					Ficha Social 	
						<input type="checkbox" name="fichaSocialListar" class="filled-in" id="fichaSocialListar" <c:if test="${grupoDePermissoes.fichaSocialListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaSocialListar"></label>
						<input type="checkbox" name="fichaSocialEditar" class="filled-in" id="fichaSocialEditar" <c:if test="${grupoDePermissoes.fichaSocialEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaSocialEditar"></label>
						<input type="checkbox" name="fichaSocialVisualizar" class="filled-in" id="fichaSocialVisualizar" <c:if test="${grupoDePermissoes.fichaSocialVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaSocialVisualizar"></label>
						<input type="checkbox" name="fichaSocialCadastrar" class="filled-in" id="fichaSocialCadastrar" <c:if test="${grupoDePermissoes.fichaSocialCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaSocialCadastrar"></label>
					</p>
					<hr>
					<p>
					Ficha Profissional 	
						<input type="checkbox" name="fichaProfissionalListar" class="filled-in" id="fichaProfissionalListar" <c:if test="${grupoDePermissoes.fichaProfissionalListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaProfissionalListar"></label>
						<input type="checkbox" name="fichaProfissionalEditar" class="filled-in" id="fichaProfissionalEditar" <c:if test="${grupoDePermissoes.fichaProfissionalEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaProfissionalEditar"></label>
						<input type="checkbox" name="fichaProfissionalVisualizar" class="filled-in" id="fichaProfissionalVisualizar" <c:if test="${grupoDePermissoes.fichaProfissionalVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaProfissionalVisualizar"></label>
						<input type="checkbox" name="fichaProfissionalCadastrar" class="filled-in" id="fichaProfissionalCadastrar" <c:if test="${grupoDePermissoes.fichaProfissionalCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="fichaProfissionalCadastrar"></label>
					</p>
					<%-- <hr>
					<p>
					Histórico 	
						<input type="checkbox" name="historicoListar" class="filled-in" id="historicoListar" <c:if test="${grupoDePermissoes.historicoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoListar"></label>
						<input type="checkbox" name="historicoEditar" class="filled-in" id="historicoEditar" <c:if test="${grupoDePermissoes.historicoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoEditar"></label>
						<input type="checkbox" name="historicoVisualizar" class="filled-in" id="historicoVisualizar" <c:if test="${grupoDePermissoes.historicoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoVisualizar"></label>
						<input type="checkbox" name="historicoCadastrar" class="filled-in" id="historicoCadastrar" <c:if test="${grupoDePermissoes.historicoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoCadastrar"></label>
					</p> --%>
					<hr>
					<p>
					Dados Financeiros 	
						<input type="checkbox" name="dadosFinanceirosListar" class="filled-in" id="dadosFinanceirosListar" <c:if test="${grupoDePermissoes.dadosFinanceirosListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="dadosFinanceirosListar"></label>
						<input type="checkbox" name="dadosFinanceirosEditar" class="filled-in" id="dadosFinanceirosEditar" <c:if test="${grupoDePermissoes.dadosFinanceirosEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="dadosFinanceirosEditar"></label>
						<input type="checkbox" name="dadosFinanceirosVisualizar" class="filled-in" id="dadosFinanceirosVisualizar" <c:if test="${grupoDePermissoes.dadosFinanceirosVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="dadosFinanceirosVisualizar"></label>
						<input type="checkbox" name="dadosFinanceirosCadastrar" class="filled-in" id="dadosFinanceirosCadastrar" <c:if test="${grupoDePermissoes.dadosFinanceirosCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="dadosFinanceirosCadastrar"></label>
					</p>
					<hr>
				</div>
			</div>

			<div class="row">

				<div class="col s12">
					<h5>Frequências</h5>
					<p>
					Frequências 	
						<input type="checkbox" name="frequenciaListar" class="filled-in" id="frequenciaListar" <c:if test="${grupoDePermissoes.frequenciaListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="frequenciaListar"></label>
						<input type="checkbox" name="frequenciaEditar" class="filled-in" id="frequenciaEditar" <c:if test="${grupoDePermissoes.frequenciaEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="frequenciaEditar"></label>
						<input type="checkbox" name="frequenciaVisualizar" class="filled-in" id="frequenciaVisualizar" <c:if test="${grupoDePermissoes.frequenciaVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="frequenciaVisualizar"></label>
						<input type="checkbox" name="frequenciaCadastrar" class="filled-in" id="frequenciaCadastrar" <c:if test="${grupoDePermissoes.frequenciaCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="frequenciaCadastrar"></label>
					</p>
					<hr>

				</div>
			</div>


			<div class="row">
				<div class="col s12">
					<h5>Empresas</h5>
					<p>
					Empresas
						<input type="checkbox" name="empresaListar" class="filled-in" id="empresaListar" <c:if test="${grupoDePermissoes.empresaListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="empresaListar"></label>
						<input type="checkbox" name="empresaEditar" class="filled-in" id="empresaEditar" <c:if test="${grupoDePermissoes.empresaEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="empresaEditar"></label>
						<input type="checkbox" name="empresaVisualizar" class="filled-in" id="empresaVisualizar" <c:if test="${grupoDePermissoes.empresaVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="empresaVisualizar"></label>
						<input type="checkbox" name="empresaCadastrar" class="filled-in" id="empresaCadastrar" <c:if test="${grupoDePermissoes.empresaCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="empresaCadastrar"></label>
					</p>
					<hr>
					<p>
					Gestores	
						<input type="checkbox" name="gestorListar" class="filled-in" id="gestorListar" <c:if test="${grupoDePermissoes.gestorListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="gestorListar"></label>
						<input type="checkbox" name="gestorEditar" class="filled-in" id="gestorEditar" <c:if test="${grupoDePermissoes.gestorEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="gestorEditar"></label>
						<input type="checkbox" name="gestorVisualizar" class="filled-in" id="gestorVisualizar" <c:if test="${grupoDePermissoes.gestorVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="gestorVisualizar"></label>
						<input type="checkbox" name="gestorCadastrar" class="filled-in" id="gestorCadastrar" <c:if test="${grupoDePermissoes.gestorCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="gestorCadastrar"></label>
					</p>
					<hr>
					<p>
					Setores
						<input type="checkbox" name="setorListar" class="filled-in" id="setorListar" <c:if test="${grupoDePermissoes.setorListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="setorListar"></label>
						<input type="checkbox" name="setorEditar" class="filled-in" id="setorEditar" <c:if test="${grupoDePermissoes.setorEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="setorEditar"></label>
						<input type="checkbox" name="setorVisualizar" class="filled-in" id="setorVisualizar" <c:if test="${grupoDePermissoes.setorVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="setorVisualizar"></label>
						<input type="checkbox" name="setorCadastrar" class="filled-in" id="setorCadastrar" <c:if test="${grupoDePermissoes.setorCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="setorCadastrar"></label>
					</p>
					<hr>
					<p>
					Históricos
						<input type="checkbox" name="historicoListar" class="filled-in" id="historicoListar" <c:if test="${grupoDePermissoes.historicoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoListar"></label>
						<input type="checkbox" name="historicoEditar" class="filled-in" id="historicoEditar" <c:if test="${grupoDePermissoes.historicoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoEditar"></label>
						<input type="checkbox" name="historicoVisualizar" class="filled-in" id="historicoVisualizar" <c:if test="${grupoDePermissoes.historicoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoVisualizar"></label>
						<input type="checkbox" name="historicoCadastrar" class="filled-in" id="historicoCadastrar" <c:if test="${grupoDePermissoes.historicoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="historicoCadastrar"></label>
					</p>
					<hr>

			</div>
		</div>

			<div class="row">
				<div class="col s12">
					<h5>Financeiros</h5>
					<p>
					Parâmetros
						<input type="checkbox" name="parametrosListar" class="filled-in" id="parametrosListar" <c:if test="${grupoDePermissoes.parametrosListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="parametrosListar"></label>
						<input type="checkbox" name="parametrosEditar" class="filled-in" id="parametrosEditar" <c:if test="${grupoDePermissoes.parametrosEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="parametrosEditar"></label>
						<input type="checkbox" name="parametrosVisualizar" class="filled-in" id="parametrosVisualizar" <c:if test="${grupoDePermissoes.parametrosVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="parametrosVisualizar"></label>
						<input type="checkbox" name="parametrosCadastrar" class="filled-in" id="parametrosCadastrar" <c:if test="${grupoDePermissoes.parametrosCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="parametrosCadastrar"></label>
					</p>
					<hr>
					<p>
					Demonstrativos	
						<input type="checkbox" name="demonstrativoListar" class="filled-in" id="demonstrativoListar" <c:if test="${grupoDePermissoes.demonstrativoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="demonstrativoListar"></label>
						<input type="checkbox" name="demonstrativoEditar" class="filled-in" id="demonstrativoEditar" <c:if test="${grupoDePermissoes.demonstrativoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="demonstrativoEditar"></label>
						<input type="checkbox" name="demonstrativoVisualizar" class="filled-in" id="demonstrativoVisualizar" <c:if test="${grupoDePermissoes.demonstrativoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="demonstrativoVisualizar"></label>
						<input type="checkbox" name="demonstrativoCadastrar" class="filled-in" id="demonstrativoCadastrar" <c:if test="${grupoDePermissoes.demonstrativoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="demonstrativoCadastrar"></label>
					</p>
					<hr>
					<p>
					VT
						<input type="checkbox" name="vtListar" class="filled-in" id="vtListar" <c:if test="${grupoDePermissoes.vtListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vtListar"></label>
						<input type="checkbox" name="vtEditar" class="filled-in" id="vtEditar" <c:if test="${grupoDePermissoes.vtEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vtEditar"></label>
						<input type="checkbox" name="vtVisualizar" class="filled-in" id="vtVisualizar" <c:if test="${grupoDePermissoes.vtVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vtVisualizar"></label>
						<input type="checkbox" name="vtCadastrar" class="filled-in" id="vtCadastrar" <c:if test="${grupoDePermissoes.vtCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vtCadastrar"></label>
					</p>
					<hr>
					<p>
					VR
						<input type="checkbox" name="vrListar" class="filled-in" id="vrListar" <c:if test="${grupoDePermissoes.vrListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vrListar"></label>
						<input type="checkbox" name="vrEditar" class="filled-in" id="vrEditar" <c:if test="${grupoDePermissoes.vrEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vrEditar"></label>
						<input type="checkbox" name="vrVisualizar" class="filled-in" id="vrVisualizar" <c:if test="${grupoDePermissoes.vrVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vrVisualizar"></label>
						<input type="checkbox" name="vrCadastrar" class="filled-in" id="vrCadastrar" <c:if test="${grupoDePermissoes.vrCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="vrCadastrar"></label>
					</p>
					<hr>
					<p>
					salario13
						<input type="checkbox" name="salario13Listar" class="filled-in" id="salario13Listar" <c:if test="${grupoDePermissoes.salario13Listar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="salario13Listar"></label>
						<input type="checkbox" name="salario13Editar" class="filled-in" id="salario13Editar" <c:if test="${grupoDePermissoes.salario13Editar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="salario13Editar"></label>
						<input type="checkbox" name="salario13Visualizar" class="filled-in" id="salario13Visualizar" <c:if test="${grupoDePermissoes.salario13Visualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="salario13Visualizar"></label>
						<input type="checkbox" name="salario13Cadastrar" class="filled-in" id="salario13Cadastrar" <c:if test="${grupoDePermissoes.salario13Cadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="salario13Cadastrar"></label>
					</p>
					<hr />
					<p>
					Contas à Pagar
						<input type="checkbox" name="contaAPagarListar" class="filled-in" id="contaAPagarListar" <c:if test="${grupoDePermissoes.contaAPagarListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAPagarListar"></label>
						<input type="checkbox" name="contaAPagarEditar" class="filled-in" id="contaAPagarEditar" <c:if test="${grupoDePermissoes.contaAPagarEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAPagarEditar"></label>
						<input type="checkbox" name="contaAPagarVisualizar" class="filled-in" id="contaAPagarVisualizar" <c:if test="${grupoDePermissoes.contaAPagarVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAPagarVisualizar"></label>
						<input type="checkbox" name="contaAPagarCadastrar" class="filled-in" id="contaAPagarCadastrar" <c:if test="${grupoDePermissoes.contaAPagarCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAPagarCadastrar"></label>
					</p>
					<hr />
					<p>
					contaAReceber
						<input type="checkbox" name="contaAReceberListar" class="filled-in" id="contaAReceberListar" <c:if test="${grupoDePermissoes.contaAReceberListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAReceberListar"></label>
						<input type="checkbox" name="contaAReceberEditar" class="filled-in" id="contaAReceberEditar" <c:if test="${grupoDePermissoes.contaAReceberEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAReceberEditar"></label>
						<input type="checkbox" name="contaAReceberVisualizar" class="filled-in" id="contaAReceberVisualizar" <c:if test="${grupoDePermissoes.contaAReceberVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAReceberVisualizar"></label>
						<input type="checkbox" name="contaAReceberCadastrar" class="filled-in" id="contaAReceberCadastrar" <c:if test="${grupoDePermissoes.contaAReceberCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="contaAReceberCadastrar"></label>
					</p>
					<hr />
					<p>
					Bancos
						<input type="checkbox" name="bancoListar" class="filled-in" id="bancoListar" <c:if test="${grupoDePermissoes.bancoListar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="bancoListar"></label>
						<input type="checkbox" name="bancoEditar" class="filled-in" id="bancoEditar" <c:if test="${grupoDePermissoes.bancoEditar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="bancoEditar"></label>
						<input type="checkbox" name="bancoVisualizar" class="filled-in" id="bancoVisualizar" <c:if test="${grupoDePermissoes.bancoVisualizar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="bancoVisualizar"></label>
						<input type="checkbox" name="bancoCadastrar" class="filled-in" id="bancoCadastrar" <c:if test="${grupoDePermissoes.bancoCadastrar == true}">checked</c:if> />
						<label style="margin-left: 2em; float: right" for="bancoCadastrar"></label>
					</p>
					<hr />

			</div>
		</div>

		<c:if test="${usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true
				   || usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true}">
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</c:if>
		</form:form>
		<br />
		<br />
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>