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
		<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
			 <h4 class="header right orange-text">PIT e PIP</h4>
		</div>
	</div>

	<div class="row">
		<form:form role="form" commandName="pitepip" servletRelativeAction="/pITsEPIPs/${pitepip.id}" method="POST">
			<div class="input-field s12 col l12">
				<div class="row">
					<div class="input-field s12 col l6">
						<form:hidden path="matricula" value="${pitepip.matricula.id}" disabled='true' />
						<form:label path="matricula">Matricula: ${pitepip.matricula.id}</form:label>
					</div>
					<div class="input-field s12 col l6">
						<label>Jovem: ${pitepip.matricula.jovem.nome}</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field s12 col l6">
						<label>Data: ${pitepip.dia}/${pitepip.mes}/${pitepip.ano}</label>
                  	</div>
                  	<div class="input-field s12 col l6">
						<label>Turma: ${pitepip.matricula.turma.numeroTurma}</label>
                  	</div>
                </div>
				<div class="row">
                  	<div class="input-field s12 col l6">
						<label>Orientador: ${pitepip.matricula.turma.orientadorTurma.nome}</label>
                  	</div>
                  	<div class="input-field s12 col l6">
                    <form:select path="frequencia">
                    	<form:option value="${pitepip.frequencia}" label="${pitepip.frequencia == null ? 'Frequência' : pitepip.frequencia}" />
						<c:forEach var="frequencia" items="${requestScope.frequencias}">
							<form:option value="${frequencia}">${frequencia}</form:option>							
						</c:forEach>
					</form:select>	
                  	</div>
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

<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>

<c:import url="../../../partials/final.jsp"></c:import>