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
				<h4 class="header right black-text">${gestor.nome != null ? gestor.nome : empresa.nomeFantazia}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

		<c:url value="/sw/cbos/${cbo.titulo != null ? cbo.id : null}" var="swCboId"></c:url>
		<form:form role="form" commandName="cbo" servletRelativeAction="${swCboId}" method="POST">
			<div class="input-field s12 col l12">
			</div>
				<div class="input-field s12 col l8">
					<form:input path="titulo" value="${requestScope.cbo.titulo}"/>
					<form:label path="titulo">Título</form:label>
				</div>
				<div class="input-field s12 col l4">
					<form:input path="numero" value="${requestScope.cbo.numero}" />
					<form:label path="numero">Número</form:label>
				</div>
				<input type="hidden" name="curso" value="${requestScope.curso.id}" />
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>

		</form:form>
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>