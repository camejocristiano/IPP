<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../../partials/header.jsp"></c:import>
<c:import url="../../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<a href="/sw/historicos/home/${jovem.id}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/ocorrencia/${ocorrencia.historico != null ? ocorrencia.id : null}" var="swOcorrenciaId"></c:url>
		<form:form role="form" commandName="ocorrencia" servletRelativeAction="${swOcorrenciaId}" method="POST">
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="data" path="data" type="text" class="validate datepicker" placeholder="Data" /> 
				</div><!-- // col -->
				<div class="input-field col s12 l8">
					<form:hidden path='historico' value="${ocorrencia.historico != null ? ocorrencia.historico.id : historico.id}" />
					<form:errors path='historico'/> 
					 <form:select path="responsavel">
                		<form:option  value="${usuario.id}" label="${ocorrencia.responsavel == null ? 'Responsável' : ocorrencia.responsavel.nome}" />
						<c:forEach var="usuario" items="${requestScope.usuarios}">
							<option value="${usuario.id}">${usuario.nome}</option>							
						</c:forEach>
					</form:select>
					<form:label path="responsavel">Responsável</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:select path="tipo">
                    	<form:option value="${ocorrencia.tipo}" label="${ocorrencia.tipo == null ? 'Tipo' : ocorrencia.tipo}" />
						<c:forEach var="tipo" items="${requestScope.tiposDeOcorrencias}">
							<form:option value="${tipo}">${tipo}</form:option>							
						</c:forEach>
					</form:select>	
					<form:label path="tipo">Tipo</form:label>
				</div><!-- // col -->
				<div class="input-field col s12 l8">
					<form:input path="titulo" type='text' />
					<form:errors path="titulo"></form:errors>
					<form:label path="titulo">Título da Ocorrência</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l12">
					<form:textarea path="descricao" />
					<form:errors path="descricao"></form:errors>
					<form:label path="descricao">Descrição</form:label>
				</div><!-- // col -->
			</div><!-- // row -->

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaCadastrar == true && requestScope.ocorrencia.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaEditar == true && requestScope.ocorrencia.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
		</form:form>
<br />
<br />
</div><!-- // Container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>