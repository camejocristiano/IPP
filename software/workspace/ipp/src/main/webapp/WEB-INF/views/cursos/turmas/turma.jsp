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
			<c:url value="/sw/homeCurso/${curso.id}" var="swHomeCursoCursoId"></c:url>
			<a href="${swHomeCursoCursoId}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Turma"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	<c:url value="/sw/turma/${turma.id}" var="swTurmaId"></c:url>
		<form:form role="form" commandName="turma" servletRelativeAction="${swTurmaId}" method="POST">
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='numeroTurma' type='text' required="required" />
					<form:errors path='numeroTurma'/> 
					<label for="numeroTurma">Número Turma</label>
				</div>
				<div class="input-field s12 col l3">
                    <form:select path="diaDaSemana">
	                	<form:option value="${turma.diaDaSemana}" label="${turma.diaDaSemana == null ? 'Dia da Semana' : turma.diaDaSemana}" />
						<c:forEach var="diaDaSemana" items="${requestScope.diaDaSemana}">
							<option>${diaDaSemana}</option>							
						</c:forEach>
					</form:select>
                </div>
                <div class="input-field s12 col l3">
                	<form:input path='curso' type='hidden' />
					<form:errors path='curso'/> 
					<label for="curso">${requestScope.curso.nomeDoCurso}</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s3">
					<form:input path='horaInicioTurma' type='text' class="validate timepicker" required="required" />
					<form:errors path='horaInicioTurma'/> 
					<label for="horaInicioTurma">Hora de Início</label>
				</div>
				<div class="input-field col s3">
					<form:input path='horaFimTurma' type='text' class="validate timepicker" required="required" />
					<form:errors path='horaFimTurma'/> 
					<label for="horaFimTurma">Hora de Fim</label>
				</div>
				<div class="input-field col s3">
					<form:input id="dataInicioTurma" path="dataInicioTurma" type="text" class="validate datepicker" placeholder="Data de Início" /> 
				</div>
				<div class="input-field col s3">
					<form:input id="dataFimTurma" path="dataFimTurma" type="text" class="validate datepicker" placeholder="Data de Fim" /> 
				</div>
			</div>
			<div class="row">
				<div class="input-field col s9">
					<form:select path="orientadorTurma">
                		<form:option  value="${turma.orientadorTurma == null ? usuario.id : turma.orientadorTurma.id}" label="${turma.orientadorTurma == null ? 'Orientador da Turma' : turma.orientadorTurma.nome}" />
						<c:forEach var="usuario" items="${requestScope.usuarios}">
							<option value="${usuario.id}">${usuario.nome}</option>							
						</c:forEach>
					</form:select>
				</div>
				<div class="input-field s12 col l3">
                    <form:select path="tipoTurma">
	                	<form:option value="${turma.tipoTurma}" label="${turma.tipoTurma == null ? 'Tipo da Turma' : turma.tipoTurma}" />
						<c:forEach var="tipoTurma" items="${requestScope.tiposTurma}">
							<option>${tipoTurma}</option>							
						</c:forEach>
					</form:select>
                </div>
			</div>
			
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.turmaCadastrar == true && requestScope.turma.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.turmaEditar == true && requestScope.turma.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
<br />
<br />
	</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>