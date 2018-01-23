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
			 <h4 class="header right orange-text">Situação de Saúde: <a class="header right" href="/jovens/${escolaridade.jovem != null ? escolaridade.jovem.id : jovem.id}">${escolaridade.jovem != null ? escolaridade.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="escolaridade" servletRelativeAction="/escolaridades/${escolaridade.id}" method="POST">
		<div class="s12 col l12">	
			<div class="row">
				<div class="s12 col l12">
					${escolaridade.jovem != null ? escolaridade.jovem.nome : jovem.nome}
					<hr />
					<hr />
					<div class="row">
						<div class="s12 col l4">
							<input type="checkbox" name="frequentaAEscola" class="filled-in" id="frequentaAEscola" <c:if test="${escolaridade.frequentaAEscola == true}">checked</c:if> />
							<label for="frequentaAEscola">Frequenta a escola?</label>
						</div><!-- // col -->
						<div class="input-field s12 col l4">
							<form:input path='nomeDoCurso' type='text'/>
							<form:errors path='nomeDoCurso'/> 
							<label for="nomeDoCurso">Nome do Curso:</label>
						</div><!-- // col -->
						<div class="input-field s12 col l4">
							<form:input id="dataConclusaoCurso" path="dataConclusaoCurso" type="date" class="validate datepicker" placeholder="Data de Conclusão do Curso" /> 
							<form:label path="dataConclusaoCurso">Data de Conclusão do Curso</form:label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="s12 col l4">
							<input type="checkbox" name="concluiuOEnsinoMedio" class="filled-in" id="concluiuOEnsinoMedio" <c:if test="${escolaridade.concluiuOEnsinoMedio == true}">checked</c:if> />
							<label for="concluiuOEnsinoMedio">Concluiu o ensino médio?</label>
						</div><!-- // col -->
						<div class="input-field s12 col l4">
							<form:input path='cursoEnsinoMedio' type='text'/>
							<form:errors path='cursoEnsinoMedio'/> 
							<label for="cursoEnsinoMedio">Curso Ensino Médio:</label>
						</div><!-- // col -->
						<div class="input-field s12 col l4">
							<form:input id="dataConclusaoEnsinoMedio" path="dataConclusaoEnsinoMedio" type="date" class="validate datepicker" placeholder="Data de Conclusão do Ensino Medio" /> 
							<form:label path="dataConclusaoEnsinoMedio">Data de Conclusão do Ensino Medio</form:label>
						</div><!-- // col -->
					</div><!-- // row -->
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