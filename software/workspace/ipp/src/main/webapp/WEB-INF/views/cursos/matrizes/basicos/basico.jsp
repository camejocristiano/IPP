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
			<c:url value="/sw/curso/${curso.id}" var="swCursoId"></c:url>
			<a href="${swCursoId}">
				<h4 class="header right black-text">${conteudoTeoricoBasico.titulo != null ? conteudoTeoricoBasico.titulo : "Conteúdo Teórico Básico"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/basicos/${conteudoTeoricoBasico.titulo != null ? conteudoTeoricoBasico.id : null}" var="conteudoTeoricoBasicoId"></c:url>
		<form:form role="form" commandName="conteudoTeoricoBasico" servletRelativeAction="${conteudoTeoricoBasicoId}" method="POST">
			<div class="input-field s12 col l12">
			</div>
				<div class="input-field s12 col l8">
					<form:input path="titulo" value="${requestScope.conteudoTeoricoBasico.titulo}"/>
					<form:label path="titulo">Título</form:label>
				</div>
				<div class="input-field s12 col l4">
					<form:input path="horaAula" value="${requestScope.conteudoTeoricoBasico.horaAula}" />
					<form:label path="horaAula">Horas / Aula</form:label>
				</div>
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>

		</form:form>
		<br />
		<br />
	</div>

<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>