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

		<br />
		<br />
		<c:url value="/sw/situacaoLaboral/${situacaoLaboral.jovem != null ? situacaoLaboral.id : null}" var="swSituacaoLaboralId"></c:url>
		<form:form role="form" commandName="situacaoLaboral" servletRelativeAction="${swSituacaoLaboralId}" method="POST">
			<div class="row">
				<div class="s12 col l3">
					<input type="checkbox" name="jaTrabalhou" class="filled-in" id="jaTrabalhou" <c:if test="${situacaoLaboral.jaTrabalhou == true}">checked</c:if> />
					<label for="jaTrabalhou">Já trabalhou?</label>
				</div><!-- // col -->
				<div class="s12 col l3">
					<input type="checkbox" name="remunerado" class="filled-in" id="remunerado" <c:if test="${situacaoLaboral.remunerado == true}">checked</c:if> />
					<label for="remunerado">Remunerado?</label>
				</div><!-- // col -->
				<div class="s12 col l3">
					<input type="checkbox" name="cTPSRegistrada" class="filled-in" id="cTPSRegistrada" <c:if test="${situacaoLaboral.cTPSRegistrada == true}">checked</c:if> />
					<label for="cTPSRegistrada">CTPS registrada?</label>
				</div><!-- // col -->
				<div class="s12 col l3">
					<input type="checkbox" name="trabalhouVoluntario" class="filled-in" id="trabalhouVoluntario" <c:if test="${situacaoLaboral.trabalhouVoluntario == true}">checked</c:if> />
					<label for="trabalhouVoluntario">Trabalhou voluntário?</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<br />
			<br />
			<br />
			<br />
			<form:hidden path="jovem" value="${jovem.id}" />
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>