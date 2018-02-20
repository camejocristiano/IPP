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
<c:url value="/sw/aprendizes/${aprendiz.jovem != null ? aprendiz.id : null}" var="swAprendizesAprendizJovemId"></c:url>
		<form:form role="form" commandName="aprendiz" servletRelativeAction="${swAprendizesAprendizJovemId}" method="POST">
		<div class="s12 col l12">	
			<div class="row">
				<div class="s12 col l12">
					<input type="checkbox" name="varJaFoiAprendiz" class="filled-in" id="varJaFoiAprendiz" <c:if test="${aprendiz.varJaFoiAprendiz == true}">checked</c:if> />
					<label for="varJaFoiAprendiz">Já foi aprendiz?</label>										
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l5">
					<form:input id="dataInicio" path="dataInicio" type="text" class="validate datepicker" placeholder="Data de Início" /> 
					<form:errors path="dataInicio"></form:errors>
					<form:label path="dataInicio">Data de Início</form:label>		
				</div><!-- // col -->
				<div class="input-field s12 col l5">
					<form:input id="dataDeFim" path="dataDeFim" type="text" class="validate datepicker" placeholder="Data de Fim" /> 					
					<form:errors path="dataDeFim"></form:errors>
					<form:label path="dataDeFim">Data de Fim</form:label>		
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<form:input id="dias" type="text" path="dias" /> 					
					<form:errors path="dias"></form:errors>
					<label for="dias">Dias</label>		
				</div><!-- // col -->
			</div><!-- // row -->
		</div><!-- // col -->
			<form:hidden path="jovem" value="${jovem.id}" />
			
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.jaFoiAprendizCadastrar == true && requestScope.aprendiz.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.jaFoiAprendizEditar == true && requestScope.aprendiz.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

		</form:form>
	

<br />
<br />
<br />
<br />
<br />
<br />
	</div>

<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>