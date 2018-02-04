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
		<div class="input-field  s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Contratação: <a class="header right" href="/jovens/${fichaProfissional.jovem != null ? fichaProfissional.jovem.id : jovem.id}">${fichaProfissional.jovem != null ? fichaProfissional.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
<div class="row">
	<div class="input-field s12 col l12">
		<form:form role="form" commandName="contratacao" servletRelativeAction="/contratacoes/${contratacao.id}" method="POST">
		<div class="row">
			<div class="input-field s12 col l4">
				<form:input id="dataDeInicioDaContratacao" path="dataDeInicioDaContratacao" type="date" class="validate datepicker" placeholder="Data de Inicio da Contratação" /> 
				<label for="dataDeInicioDaContratacao">Data de Inicio da Contratação</label>
			</div>
			<div class="input-field s12 col l8">
                <form:select path="empresaContratante">
              		<form:option  value="${empresa.id}" label="${contratacao.empresaContratante == null ? 'Empresa Contratante' : contratacao.empresaContratante.razaoSocial}" />
					<c:forEach var="empresa" items="${requestScope.empresas}">
						<option value="${empresa.id}">${empresa.razaoSocial}</option>							
					</c:forEach>
				</form:select>
            </div>
		</div>
		<div class="row">
			<div class="input-field s12 col l6">
                <form:select path="gestorContratacao">
              		<form:option  value="${gestor.id}" label="${contratacao.gestorContratacao == null ? 'Gestor Contratante' : contratacao.gestorContratacao.nome}" />
					<c:forEach var="gestor" items="${requestScope.gestores}">
						<option value="${gestor.id}">${gestor.nome}</option>							
					</c:forEach>
				</form:select>
            </div>
			<div class="input-field s12 col l3">
				<form:input id="exameAdmissional" path="exameAdmissional" type="date" class="validate datepicker" placeholder="Exame Admissional" /> 
				<label for="exameAdmissional">Exame Admissional</label>
			</div>
			<div class="input-field s12 col l3">
				<form:input id="terminoDoContrato" path="terminoDoContrato" type="date" class="validate datepicker" placeholder="Término do Contrato" /> 
				<label for="terminoDoContrato">Término do Contrato</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l3">
				<form:select path="tipoDeContratacao">
	               	<form:option value="${tipoDeContratacao}" label="${contratacao.tipoDeContratacao == null ? 'Tipo de Contratação' : contratacao.tipoDeContratacao}" />
					<c:forEach var="tipoDeContratacao" items="${requestScope.tiposDeContratacao}">
						<option>${tipoDeContratacao}</option>							
					</c:forEach>
				</form:select>	
				<label for="tipoDeContratacao">Tipo de Contratação</label>
			</div>
			<div class="input-field col s1">
				<input type="checkbox" name="segunda" class="filled-in" id="segunda" <c:if test="${contratacao.segunda == true}">checked</c:if> />
				<label for="segunda">Seg</label>
			</div>
			<div class="input-field col s1">
				<input type="checkbox" name="terca" class="filled-in" id="terca" <c:if test="${contratacao.terca == true}">checked</c:if> />
				<label for="terca">Ter</label>
			</div>
			<div class="input-field col s1">
				<input type="checkbox" name="quarta" class="filled-in" id="quarta" <c:if test="${contratacao.quarta == true}">checked</c:if> />
				<label for="quarta">Qua</label>
			</div>
			<div class="input-field col s1">
				<input type="checkbox" name="quinta" class="filled-in" id="quinta" <c:if test="${contratacao.quinta == true}">checked</c:if> />
				<label for="quinta">Qui</label>
			</div>
			<div class="input-field col s1">
				<input type="checkbox" name="sexta" class="filled-in" id="sexta" <c:if test="${contratacao.sexta == true}">checked</c:if> />
				<label for="sexta">Sex</label>
			</div>
			<div class="input-field col s1">
				<input type="checkbox" name="sabado" class="filled-in" id="sabado" <c:if test="${contratacao.sabado == true}">checked</c:if> />
				<label for="sabado">Sáb</label>
			</div>
			<div class="input-field col s1">
			</div>
			<div class="input-field col s2">
				<form:input path='horarioDeTrabalho' type='text' class="validate timepicker" />
				<form:errors path='horarioDeTrabalho'/> 
				<label for="horarioDeTrabalho">Horário de Trabalho</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<div class="row">
					<div class="input-field col s6">
					CBO
					</div>
					<div class="input-field col s6">
					Dia do Curso
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
					Data de Início
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
			Total de Horas Semanais
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
               	<form:input path='jovem' type='hidden' value="${requestScope.jovem.id}" />
				<form:errors path='jovem'/> 
				<label for="jovem">
					<c:if test="${contratacao.jovem == null}">${requestScope.jovem.nome}</c:if>
					<c:if test="${contratacao.jovem != null}">${contratacao.jovem.nome}</c:if>
				</label>
			</div>
		</div>
		<button class="btn waves-effect waves-light right" type="submit">
			Salvar<i class="material-icons right">send</i>
		</button>
		</form:form>
	</div>
</div>
</div>

<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});

	$('.datepicker').pickadate({
		monthsFull: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
		monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
		weekdaysFull: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sabádo'],
		weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
		weekdaysLetter: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
		today: 'Hoje',
		clear: 'Limpar',
		close: 'Pronto',
		labelMonthNext: 'Próximo mês',
		labelMonthPrev: 'Mês anterior',
		labelMonthSelect: 'Selecione um mês',
		labelYearSelect: 'Selecione um ano',
		selectMonths: true,
		selectYears: 99,
	    format: 'dd/mm/yyyy' 
	});
</script>
<c:import url="../../../../partials/final.jsp"></c:import>