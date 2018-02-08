<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../../partials/header.jsp"></c:import>

<style>
/*
 CSS INDEXES
*/
.btn-index:hover {
	background-color: #669999;
	font-weight: bolder;
	font-style: italic;
}
.card-content:hover {
	font-weight: bolder;
	background-color: #669999;
	font-style: italic;
}
</style>

<c:import url="../../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<a href="/sw/jovem/${jovem.id}">
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

		<form:form role="form" commandName="entrevista" servletRelativeAction="/sw/entrevista/${entrevista.id}" method="POST">
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
			<div class="s12 col l4">
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
			<div class="s12 col l12">
				<input type="checkbox" name="retomando" class="filled-in" id="retomando" <c:if test="${entrevista.retomando == true}">checked</c:if> />
				<label for="retomando">Retomando?</label>
			</div>
		</div>
      	<form:input path='jovem' type='hidden' value="${requestScope.jovem.id}" />
		<button class="btn waves-effect waves-light right" type="submit">
			Salvar<i class="material-icons right">send</i>
		</button>
		</form:form>
		<br />
		<br />
</div><!-- // container -->
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