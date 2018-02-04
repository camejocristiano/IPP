<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- <div class="row">
	<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
		 <h4 class="header right orange-text">Curso:</h4>
	</div>
</div> -->
<div class="row">
	<form:form role="form" commandName="curso" servletRelativeAction="/cursos/${curso.id}" method="POST">
	<div class="s12 col l12">	
		<hr />
		<hr />
		<div class="row">
			<div class="s12 col l12">
				<div class="row">
					<div class="input-field s12 col l6">
						<form:input path='nomeDoCurso' type='text'/>
						<form:errors path='nomeDoCurso'/> 
						<label for="nomeDoCurso">Nome do Curso</label>
					</div>
					<div class="input-field s12 col l2">
						<form:input path='numeroDoCurso' type='text'/>
						<form:errors path='numeroDoCurso'/> 
						<label for="numeroDoCurso">Nº do Curso</label>
					</div>
					<div class="input-field s12 col l2">
	                    <form:select path="status">
		                	<form:option value="${curso.status}" label="${curso.status == null ? 'Status' : curso.status}" />
							<c:forEach var="status" items="${requestScope.status}">
								<option>${status}</option>							
							</c:forEach>
						</form:select>
	                </div>
					<div class="input-field s12 col l2">
	                    <form:select path="unidade" required="required">
	                		<form:option  value="${unidade.id}" label="${curso.unidade == null ? 'Unidade' : curso.unidade.nomeFantazia}" />
							<c:forEach var="unidade" items="${requestScope.unidades}">
								<option value="${unidade.id}">${unidade.nomeFantazia}</option>							
							</c:forEach>
						</form:select>
	                </div>
				</div>
				<div class="row">
					<div class="s12 col l3">
						<input type="checkbox" class="filled-in" name="pap" id="pap" <c:if test="${curso.pap == true}">checked</c:if> />
						<label for="pap">PAP</label>
					</div>
					<div class="input-field s12 col l3">
	                    <form:select path="statusPAP">
		                	<form:option value="${curso.statusPAP}" label="${curso.statusPAP == null ? 'Status' : curso.statusPAP}" />
							<c:forEach var="statusPAP" items="${requestScope.statusPAP}">
								<option>${statusPAP}</option>							
							</c:forEach>
						</form:select>
	                </div>
					<div class="s12 col l3">
						<input type="checkbox" class="filled-in" name="livre" id="livre" <c:if test="${curso.livre == true}">checked</c:if> />
						<label for="livre">Livre</label>
					</div>
					<div class="input-field s12 col l3">
	                    <form:select path="statusLivre">
		                	<form:option value="${curso.status}" label="${curso.status == null ? 'Status' : curso.status}" />
							<c:forEach var="status" items="${requestScope.status}">
								<option>${status}</option>							
							</c:forEach>
						</form:select>
	                </div>
				</div>
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l12">
			</div><!-- // col -->
		</div><!-- // row -->
		<div class="row">
			<div class="input-field s12 col l12">		
			</div><!-- // col -->
		</div><!-- // row -->
	</div><!-- // col -->
	<button class="btn waves-effect waves-light right" type="submit">
		Salvar<i class="material-icons right">send</i>
	</button>
	</form:form>
</div><!-- // row -->
