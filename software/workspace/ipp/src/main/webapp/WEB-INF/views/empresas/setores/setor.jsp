<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<c:url value="/sw/empresa/${empresa.id}" var="swEmpresaId"></c:url>
			<a href="${swEmpresaId}">
				<h4 class="header right black-text">${setor.nome != null ? setor.nome : empresa.nomeFantazia}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/setor/${setor.nome != null ? setor.id : null}" var="swSetorId"></c:url>
		<form:form role="form" commandName="setor" servletRelativeAction="${swSetorId}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='nome' type='text' required="true" />
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
				</div>
				<div class="input-field s12 col l6">
				<form:select path="gestor">
		        <form:option  value="${setor.gestor}" label="${setor.gestor != null ? setor.gestor.nome : 'Gestor'}" />
					<c:forEach var="gestor" items="${requestScope.gestores}">
						<option value="${gestor.id}">${gestor.nome}</option>							
					</c:forEach>
				</form:select>
				</div>
			</div>
		<br />
<br />
			<form:input path='empresa' type='hidden' value="${empresa.id}" />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.setorCadastrar == true && requestScope.setor.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.setorEditar == true && requestScope.setor.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
		
		</form:form>
<br />
<br />
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>