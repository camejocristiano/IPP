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
		<div class="col s12">
			<ul class="tabs">
				<li class="tab col s2"><a href="#curso">Curso</a></li>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s2"><a href="#matriculas">Matrículas</a></li>
				</c:if>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s1"><a href="#turmas">Turmas</a></li>
				</c:if>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s1"><a href="#cbos">CBOS</a></li>
				</c:if>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s1"><a href="#arcos">Arcos</a></li>
				</c:if>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s1"><a href="#basicos">Básicos</a></li>
				</c:if>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s2"><a href="#especificos">Específicos</a></li>
				</c:if>
				<c:if test="${requestScope.curso.id != null}">
					<li class="tab col s2"><a href="#validacoes">Validações</a></li>
				</c:if>
			</ul>
			
	<br /> 
	
	<br />
		</div>
		<div id="curso" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div>
		<c:if test="${requestScope.curso.id != null}">
			<div id="matriculas" class="col s12">
				<c:import url="../matriculas/matriculas.jsp"></c:import>
			</div>
		</c:if>
		<c:if test="${requestScope.curso.id != null}">
			<div id="turmas" class="col s12">
				<c:import url="../turmas/turmas.jsp"></c:import>
			</div>
		</c:if>
		<c:if test="${requestScope.curso.id != null}">
			<div id="cbos" class="col s12">
				<c:import url="../cbos/cbos.jsp"></c:import>
			</div>
		</c:if>
		<c:if test="${requestScope.curso.id != null}">
			<div id="arcos" class="col s12">
				<c:import url="../arcos/arcos.jsp"></c:import>
			</div>
		</c:if>
		<c:if test="${requestScope.curso.id != null}">
			<div id="basicos" class="col s12">
				<c:import url="../matrizes/basicos/basicos.jsp"></c:import>
			</div>
		</c:if>
		<c:if test="${requestScope.curso.id != null}">
			<div id="especificos" class="col s12">
				<c:import url="../matrizes/especificos/especificos.jsp"></c:import>
			</div>
		</c:if>
		<c:if test="${requestScope.curso.id != null}">
			<div id="validacoes" class="col s12">
				<c:import url="../validacoes/validacoes.jsp"></c:import>
			</div>
		</c:if>
	</div>
</div>

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
