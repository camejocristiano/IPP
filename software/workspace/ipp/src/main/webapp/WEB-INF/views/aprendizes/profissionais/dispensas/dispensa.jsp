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

		<form:form role="form" commandName="dispensa" servletRelativeAction="/sw/dispensa/${dispensa.motivoDaDispensa != null ? dispensa.id : null}" method="POST">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:select path="motivoDaDispensa">
	                	<form:option value="${motivoDaDispensa}" label="${dispensa.motivoDaDispensa == null ? 'Motivo da Dispensa' : dispensa.motivoDaDispensa}" />
						<c:forEach var="motivoDaDispensa" items="${requestScope.motivosDaDispensa}">
							<option>${motivoDaDispensa}</option>							
						</c:forEach>
					</form:select>	
					<label for="motivoDaDispensa">Motivo da Dispensa</label>
				</div>
			</div>	
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input id="dataDaDispensa" path="dataDaDispensa" type="date" class="validate datepicker" placeholder="Data da Dispensa" /> 
					<label for="dataDaDispensa">Data da Dispensa</label>
				</div>
				<div class="input-field s12 col l6">
					<form:input id="exameDemissional" path="exameDemissional" type="date" class="validate datepicker" placeholder="Exame Demissional" /> 
					<label for="exameDemissional">Exame Demissional</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path='justificativaDaDispensa' />
					<form:errors path='justificativaDaDispensa'/> 
					<label for="justificativaDaDispensa">Justificativa da Dispensa</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<input type="checkbox" name="oJovemEstaCienteDaDispensa" class="filled-in" id="oJovemEstaCienteDaDispensa" <c:if test="${dispensa.oJovemEstaCienteDaDispensa == true}">checked</c:if> />
					<label for="oJovemEstaCienteDaDispensa">O Jovem Esta Ciente Da Dispensa?</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<input type="checkbox" name="haveraSubstituicao" class="filled-in" id="haveraSubstituicao" <c:if test="${dispensa.haveraSubstituicao == true}">checked</c:if> />
					<label for="haveraSubstituicao">Haverá Substituicao?</label>
					<br />
					<br />
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path='consideracoesDaDispensa' type='text'/>
					<form:errors path='consideracoesDaDispensa'/> 
					<label for="consideracoesDaDispensa">Considerações da Dispensa</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l12">
					<form:textarea path='informacoesComplementaresDaDispensa' type='text'/>
					<form:errors path='informacoesComplementaresDaDispensa'/> 
					<label for="informacoesComplementaresDaDispensa">Informações Complementares Da Dispensa</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l5">
                	<form:input path='jovem' type='hidden' value="${requestScope.jovem.id}" />
					<form:errors path='jovem'/> 
					<label for="jovem">
						<c:if test="${dispensa.jovem == null}">${requestScope.jovem.nome}</c:if>
						<c:if test="${dispensa.jovem != null}">${dispensa.jovem.nome}</c:if>
					</label>
				</div>
			</div>
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