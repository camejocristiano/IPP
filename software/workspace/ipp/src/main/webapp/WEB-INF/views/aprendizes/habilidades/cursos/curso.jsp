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
			<c:url value="/sw/jovem/${jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
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
	<c:url value="/sw/outroCurso/${outroCurso.jovem != null ? outroCurso.id : null}" var="swOutrosCursosJovem"></c:url>
	<form:form role="form" commandName="outroCurso" servletRelativeAction="${swOutrosCursosJovem}" method="POST">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='nomeDoCurso' type='text'/>
					<form:errors path='nomeDoCurso'/> 
					<label for="nomeDoCurso">Nome do curso:</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l8">
					<form:input path='instituicao' type='text'/>
					<form:errors path='instituicao'/> 
					<label for="instituicao">Instituição:</label>
				</div><!-- // col -->
				<div class="input-field s12 col l4">
					<form:input id="dataDeConclusao" path="dataDeConclusao" type="text" class="validate datepicker" placeholder="Data da Conclusão" /> 
					<form:label path="dataDeConclusao">Data de Conclusão</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<form:hidden path="jovem" value="${jovem.id}" />

			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.outroCursoCadastrar == true && requestScope.outroCurso.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.outroCursoEditar == true && requestScope.outroCurso.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
<br />
<br />
</div><!-- // container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>