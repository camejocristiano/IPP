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
		<h2>Matricula</h2>
		<form:form role="form" commandName="matricula" servletRelativeAction="/matriculas/${matricula.id}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='nomeTest' type='text'/>
					<form:errors path='nomeTest'/> 
					<label for="nomeTest"> nomeTest Matrícula</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">
				</div>
			</div>
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
	</div>

</div>

<c:import url="../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/final.jsp"></c:import>