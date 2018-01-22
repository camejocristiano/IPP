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
		<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Histórico</h4>
		</div>
	</div>
	
	<div class="row">
		<form:form role="form" commandName="laboral" servletRelativeAction="/historicos/${historico.id}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='observacoes' type='text'/>
					<form:errors path='observacoes'/> 
					<label for="observacoes">Observações</label>
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

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>