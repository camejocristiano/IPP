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
		<div class="input-field s12 col l12" style="border-top: 2px solid orange;">
			 <h4 class="header right orange-text">Situação Laboral: <a class="header right" href="/jovens/${situacaoLaboral.jovem != null ? situacaoLaboral.jovem.id : jovem.id}">${situacaoLaboral.jovem != null ? situacaoLaboral.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="situacaoLaboral" servletRelativeAction="/situacoesLaborais/${situacaoLaboral.jovem != null ? situacaoLaboral.id : null}" method="POST">
		<div class="s12 col l12">	
			<div class="row">
				<div class="s12 col l12">
					${situacaoLaboral.jovem != null ? situacaoLaboral.jovem.nome : jovem.nome}
					<hr />
					<hr />
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l3">
					<input type="checkbox" name="jaTrabalhou" class="filled-in" id="jaTrabalhou" <c:if test="${situacaoLaboral.jaTrabalhou == true}">checked</c:if> />
					<label for="jaTrabalhou">Já trabalhou?</label>
				</div><!-- // col -->
				<div class="s12 col l3">
					<input type="checkbox" name="remunerado" class="filled-in" id="remunerado" <c:if test="${situacaoLaboral.remunerado == true}">checked</c:if> />
					<label for="remunerado">Remunerado?</label>
				</div><!-- // col -->
				<div class="s12 col l3">
					<input type="checkbox" name="cTPSRegistrada" class="filled-in" id="cTPSRegistrada" <c:if test="${situacaoLaboral.cTPSRegistrada == true}">checked</c:if> />
					<label for="cTPSRegistrada">CTPS registrada?</label>
				</div><!-- // col -->
				<div class="s12 col l3">
					<input type="checkbox" name="trabalhouVoluntario" class="filled-in" id="trabalhouVoluntario" <c:if test="${situacaoLaboral.trabalhouVoluntario == true}">checked</c:if> />
					<label for="trabalhouVoluntario">Trabalhou voluntário?</label>
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
<c:import url="../../../partials/js.jsp"></c:import>
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
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>