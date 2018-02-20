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
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Matrícula"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	<c:url value="/sw/matricula/${matricula.jovem != null ? matricula.id : null}" var="swMatriculaId"></c:url>
	<form:form role="form" commandName="matricula" servletRelativeAction="${swMatriculaId}" method="POST">
<br />
			<div class="row">
				<div class="input-field s12 col l4">
	                <form:select path="turma" required="required" >
	              		<form:option  value="${matricula.turma.id != null ? matricula.turma.id : turma.id}" label="${matricula.turma == null ? 'Turma' : matricula.turma.numeroTurma}" />
						<c:forEach var="turma" items="${requestScope.turmas}">
							<option value="${turma.id}">${turma.numeroTurma}</option>							
						</c:forEach>
					</form:select>
					<label for="turma">Turma</label>				
            	</div>
            	<div class="input-field s12 col l4">
	                <form:select path="jovem" required="required" >
	              		<form:option  value="${jovem.id}" label="${matricula.jovem == null ? 'Jovem' : matricula.jovem.nome}" />
						<c:forEach var="jovem" items="${requestScope.jovens}">
							<option value="${jovem.id}">${jovem.nome}</option>							
						</c:forEach>
					</form:select>
					<label for="jovem">Jovem</label>
            	</div>
            	<div class="input-field s12 col l4">
            		<form:select path="statusDaMatricula" required="required" >
		               	<form:option value="${matricula.statusDaMatricula}" label="${matricula.statusDaMatricula == null ? 'Status Da Matrícula' : matricula.statusDaMatricula}" />
						<c:forEach var="statusDaMatricula" items="${requestScope.statusDeMatricula}">
							<option>${statusDaMatricula}</option>							
						</c:forEach>
					</form:select>
            	</div>
			</div>

			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
<br />
		</form:form>
<br />
   		<br />
	</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/final.jsp"></c:import>