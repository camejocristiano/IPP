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
		<div class="input-field s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Aprendiz: <a class="header right" href="/jovens/${aprendiz.jovem != null ? aprendiz.jovem.id : jovem.id}">${aprendiz.jovem != null ? aprendiz.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="aprendiz" servletRelativeAction="/aprendizes/${aprendiz.jovem != null ? aprendiz.id : null}" method="POST">
		<div class="s12 col l12">	
			<div class="row">
				<div class="s12 col l12">
					${aprendiz.jovem != null ? aprendiz.jovem.nome : jovem.nome}
					<hr />
					<hr />
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					<input type="checkbox" name="varJaFoiAprendiz" class="filled-in" id="varJaFoiAprendiz" <c:if test="${aprendiz.varJaFoiAprendiz == true}">checked</c:if> />
					<label for="varJaFoiAprendiz">Já foi aprendiz?</label>										
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l5">
					<form:input id="dataInicio" path="dataInicio" type="date" class="validate datepicker" placeholder="Data de Início" /> 
					<form:errors path="dataInicio"></form:errors>
					<form:label path="dataInicio">Data de Início</form:label>		
				</div><!-- // col -->
				<div class="input-field s12 col l5">
					<form:input id="dataDeFim" path="dataDeFim" type="date" class="validate datepicker" placeholder="Data de Fim" /> 					
					<form:errors path="dataDeFim"></form:errors>
					<form:label path="dataDeFim">Data de Fim</form:label>		
				</div><!-- // col -->
				<div class="input-field s12 col l2">
					<input id="dataDeFim" type="text" /> 					
					<label for="dataDeFim">Dias</label>		
				</div><!-- // col -->
			</div><!-- // row -->
		</div><!-- // col -->
			<form:hidden path="jovem" value="${jovem.id}" />
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
	</div><!-- // row -->
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