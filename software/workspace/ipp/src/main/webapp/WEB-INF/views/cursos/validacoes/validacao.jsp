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
			<c:url value="/sw/homeCurso/${curso.id}" var="swHomeCursoCursoId"></c:url>
			<a href="${swHomeCursoCursoId}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Validação"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
		<c:url value="/sw/validacao/${validacao.id != null ? validacao.id : null}" var="swValidacaoId"></c:url>
		<form:form role="form" commandName="validacao" servletRelativeAction="${swValidacaoId}" method="POST">
			<div class="input-field s12 col l12">
				<div class="row">
					<div class="input-field s12 col l4">
						<form:input id="dataDeEnvio" path="dataDeEnvio" type="text" class="validate datepicker" placeholder="Data de Envio" /> 
						<label for="dataDeEnvio">Data de Envio</label>
					</div><!-- // col -->
					<div class="input-field s12 col l4">
						<form:input id="dataDaSolicitacao" path="dataDaSolicitacao" type="text" class="validate datepicker" placeholder="Data da Solicitação" /> 
						<label for="dataDaSolicitacao">Data da Solicitação</label>
					</div><!-- // col -->
					<div class="input-field s12 col l4">
						<form:input id="dataDaValidacao" path="dataDaValidacao" type="text" class="validate datepicker" placeholder="Data da Validação" /> 
						<label for="dataDaValidacao">Data da Validação</label>
					</div><!-- // col -->
				</div><!-- // row -->
				<div class="row">
					<div class="input-field s12 col l6">
						<form:select path="tipoDeValidacao">
		                	<form:option value="${validacao.tipoDeValidacao}" label="${validacao.tipoDeValidacao == null ? 'Tipo De Validação' : validacao.tipoDeValidacao}" />
							<c:forEach var="tipoDeValidacao" items="${requestScope.tiposDeValidacao}">
								<option>${tipoDeValidacao}</option>							
							</c:forEach>
						</form:select>
					</div><!-- // col -->
					<div class="input-field s12 col l6">
						<form:select path="statusValidacao">
		                	<form:option value="${validacao.statusValidacao}" label="${validacao.statusValidacao == null ? 'Status Da Validação' : validacao.statusValidacao}" />
							<c:forEach var="statusValidacao" items="${requestScope.statusValidacao}">
								<option>${statusValidacao}</option>							
							</c:forEach>
						</form:select>
					</div><!-- // col -->
				</div><!-- // row -->
			</div><!-- // col -->
			<input type="hidden" name="curso" value="${requestScope.curso.id}" />

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.validacaoCadastrar == true && requestScope.validacao.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.validacaoEditar == true && requestScope.validacao.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
		<br />
		<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>