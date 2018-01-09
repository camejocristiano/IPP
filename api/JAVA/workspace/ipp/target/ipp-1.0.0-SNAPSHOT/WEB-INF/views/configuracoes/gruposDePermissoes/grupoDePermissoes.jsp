<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

	<br>
<h3 class="${requestScope.corMsg} col s12">${requestScope.msg}</h3>

	<div class="row">
		<form:form role="form" commandName="grupoDePermissoes" servletRelativeAction="/gruposDePermissoes/${grupoDePermissoes.id}" method="POST">
			<div class="row">
				<form:input path='grupo' type='text' />
				<form:errors path='grupo' />
			</div>
			<div class="row">
				<div class="input-field col s12">
					<form:select path="status">
						<option>${grupoDePermissoes.status}</option>
						<c:forEach var="status" items="${requestScope.status}">
							<option>${status}</option>							
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
					<form:select path="unidade">
						<option value="${grupoDePermissoes.unidade.id}">${grupoDePermissoes.unidade.nomeFantazia}</option>
						<c:forEach var="unidade" items="${requestScope.unidades}">
							<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
						</c:forEach>
					</form:select>
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
					<h4>Configurações</h4>
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
					<h6>Cursos</h6>
					<p>
						Cursos <input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Mtrículas <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Turmas <input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>

				</div>
			</div>


			<div class="row">

				<div class="col s12">
					<h6>Aprendizes</h6>
					<p>
						Jovens <input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Cursos IPP <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Escolaridade <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Situação Laboral <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Características Domiciliares <input type="checkbox"
							class="filled-in" id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Habilidades <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Situação de Saúde <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Ficha Social <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Ficha Profissional <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Históricos <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Dados Financeiros <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
				</div>
			</div>

			<div class="row">

				<div class="col s12">
					<h6>Frequências</h6>
					<p>
						PIT e PIP <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						PAP <input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						PIO <input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Aulas Extras <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>

				</div>
			</div>


			<div class="row">

				<div class="col s12">
					<h6>Empresas</h6>
					<p>
						Empresas <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Gestores <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Setores <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>
					<p>
						Históricos <input type="checkbox" class="filled-in"
							id="filled-in-box" checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
						<input type="checkbox" class="filled-in" id="filled-in-box"
							checked="checked" /><label
							style="margin-left: 2em; float: right" for="filled-in-box"></label>
					</p>
					<hr>

				</div>
			</div>

			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>

		</form:form>
	</div>

</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>

<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>

<c:import url="../../../partials/final.jsp"></c:import>