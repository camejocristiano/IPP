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

			<div class="row">
				<div class="input-field s12 col l4">
				TURMA:
	                ${requestScope.matricula.turma.numeroTurma}				
            	</div>
            	<div class="input-field s12 col l4">
	            JOVEM:
	                ${requestScope.matricula.jovem.nome}
            	</div>
            	<div class="input-field s12 col l4">
	            STATUS:    
	                ${requestScope.matricula.statusDaMatricula}            		
            	</div>
			</div>

		<br />
   		<br />
   		<br />
   		<br />
   		<br />
   		<br />
   		<br />
   		<br />
   		<br />
   		<br />
	</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>