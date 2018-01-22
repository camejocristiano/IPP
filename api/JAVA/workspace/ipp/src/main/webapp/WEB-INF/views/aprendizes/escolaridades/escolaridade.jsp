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
		<h2>Escolaridades</h2>
		<form:form role="form" commandName="escolaridade" servletRelativeAction="/escolaridades/${escolaridade.id}" method="POST"
			class="col s12">
			<div class="row">
				<div class="input-field s12 col l9">
					<form:input path='curso' type='text'/>
					<form:errors path='curso'/> 
					<label for="curso">Curso</label>
				</div>
				<div class="input-field s12 col l3">
					<form:input path='jovem' type='text' value="${jovem.id}" />
					<form:errors path='jovem'/> 
					<label for="jovem">Jovem</label>
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