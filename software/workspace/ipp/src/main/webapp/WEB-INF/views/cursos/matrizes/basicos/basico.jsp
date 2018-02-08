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
		<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Conteúdo Teórico Básico</h4>
		</div>
	</div>
	
	<div class="row">
		<form:form role="form" commandName="conteudoTeoricoBasico" servletRelativeAction="/basicos/${conteudoTeoricoBasico.id}" method="POST">
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
	</div>

</div>

<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>

<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>

<c:import url="../../../../partials/final.jsp"></c:import>