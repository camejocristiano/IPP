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
			 <h4 class="header right orange-text">Situação de Saúde: <a class="header right" href="/jovens/${outroCurso.jovem != null ? outroCurso.jovem.id : jovem.id}">${outroCurso.jovem != null ? outroCurso.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="outroCurso" servletRelativeAction="/outrosCursos/${outroCurso.jovem != null ? outroCurso.id : null}" method="POST">
		<div class="s12 col l12">	
			<div class="row">
				<div class="s12 col l12">
					${outroCurso.jovem != null ? outroCurso.jovem.nome : jovem.nome}
					<hr />
					<hr />
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					<form:input path='nomeDoCurso' type='text'/>
					<form:errors path='nomeDoCurso'/> 
					<label for="nomeDoCurso">Nome do curso:</label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l8">
					<form:input path='instituicao' type='text'/>
					<form:errors path='instituicao'/> 
					<label for="instituicao">Instituição:</label>
				</div><!-- // col -->
				<div class="s12 col l4">
					<form:input id="dataDeConclusao" path="dataDeConclusao" type="date" class="validate datepicker" placeholder="Data da Conclusão" /> 
					<form:label path="dataDeConclusao">Data de Conclusão</form:label>
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