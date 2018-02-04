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
			 <h4 class="header right orange-text">Entrevista: <a class="header right" href="/jovens/${fichaProfissional.jovem != null ? fichaProfissional.jovem.id : jovem.id}">${fichaProfissional.jovem != null ? fichaProfissional.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
<div class="row">
	<div class="input-field s12 col l12">
		<form:form role="form" commandName="entrevista" servletRelativeAction="/entrevistas/${entrevista.id}" method="POST">
		<div class="row">
			<div class="input-field s12 col l4">
				<form:input id="dataDaEntrevista" path="dataDaEntrevista" type="date" class="validate datepicker" placeholder="Data da Estrevista" /> 
				<label for="dataDaEntrevista">Data da Entrevista</label>
			</div>
			<div class="input-field s12 col l8">
                    <form:select path="empresaParaEntrevista">
                		<form:option  value="${empresa.id}" label="${entrevista.empresaParaEntrevista == null ? 'Empresa' : entrevista.empresaParaEntrevista.razaoSocial}" />
						<c:forEach var="empresa" items="${requestScope.empresas}">
							<option value="${empresa.id}">${empresa.razaoSocial}</option>							
						</c:forEach>
					</form:select>
                </div>
		</div>
		<div class="row">
			<div class="input-field s12 col l4">
				<input type="checkbox" name="aprovadoNaEntrevista" class="filled-in" id="aprovadoNaEntrevista" <c:if test="${entrevista.aprovadoNaEntrevista == true}">checked</c:if> />
				<label for="aprovadoNaEntrevista">Aprovado na Entrevista?</label>
			</div>
			<div class="input-field s12 col l8">
				<form:input path='motivo' type='text'/>
				<form:errors path='motivo'/> 
				<label for="motivo">Motivo</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field s12 col l12">
				<input type="checkbox" name="retomando" class="filled-in" id="retomando" <c:if test="${entrevista.retomando == true}">checked</c:if> />
				<label for="retomando">Retomando?</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
               	<form:input path='jovem' type='hidden' value="${requestScope.jovem.id}" />
				<form:errors path='jovem'/> 
				<label for="jovem">
					<c:if test="${entrevista.jovem == null}">${requestScope.jovem.nome}</c:if>
					<c:if test="${entrevista.jovem != null}">${entrevista.jovem.nome}</c:if>
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
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>