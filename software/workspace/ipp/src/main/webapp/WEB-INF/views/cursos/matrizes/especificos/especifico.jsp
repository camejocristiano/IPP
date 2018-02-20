<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../../partials/header.jsp"></c:import>
<c:import url="../../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<c:url value="/sw/curso/${curso.id}" var="swCursoId"></c:url>
			<a href="${swCursoId}">
				<h4 class="header right black-text">${conteudoTeoricoEspecifico.titulo != null ? conteudoTeoricoEspecifico.titulo : "Conteúdo Teórico Específico"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/especifico/${conteudoTeoricoEspecifico.titulo != null ? conteudoTeoricoEspecifico.id : null}" var="swEspecificoId"></c:url>
		<form:form role="form" commandName="conteudoTeoricoEspecifico" servletRelativeAction="${swEspecificoId}" method="POST">
			<div class="row">
				<div class="input-field s12 col l8">
					<form:input path="titulo" value="${requestScope.conteudoTeoricoEspecifico.titulo}" required="required" />
					<form:label path="titulo">Título</form:label>
				</div>
				<div class="input-field s12 col l4">
					<form:input path="horaAula" value="${requestScope.conteudoTeoricoEspecifico.horaAula}" required="required" />
					<form:label path="horaAula">Horas / Aula</form:label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
				<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.especificoCadastrar == true && requestScope.conteudoTeoricoEspecifico.id == null}">
					<button class="btn waves-effect waves-light right" type="submit">
						Salvar<i class="material-icons right">send</i>
					</button>
				</c:if>
				<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.especificoEditar == true && requestScope.conteudoTeoricoEspecifico.id != null}">
					<button class="btn waves-effect waves-light right" type="submit">
						Salvar<i class="material-icons right">send</i>
					</button>
				</c:if>
				</div>
			</div>

		</form:form>
	</div>
	<br />
	<br />
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>