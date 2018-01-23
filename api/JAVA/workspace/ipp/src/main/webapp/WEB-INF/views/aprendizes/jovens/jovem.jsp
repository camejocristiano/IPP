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
				<li class="tab col s1"><a href="#jovem">Jovem</a></li>
				<c:if test="${jovem.id != null}">
					<li class="tab col s1"><a href="#cursos">Cursos IPP</a></li> 
					<li class="tab col s1"><a href="#escolaridade">Escolaridade</a></li> 
					<li class="tab col s1"><a href="#laborais">Laboral</a></li> 
					<li class="tab col s1"><a href="#domiciliares">Domiciliares</a></li>
					<li class="tab col s1"><a href="#habilidades">Habilidades</a></li> 
					<li class="tab col s1"><a href="#situacaoDeSaude">Saude</a></li> 
					<li class="tab col s1"><a href="#fichaSocial">Social</a></li> 
					<li class="tab col s1"><a href="#fichaProfissional">Profissional</a></li> 
					<li class="tab col s1"><a href="#historico">Historico</a></li> 
					<li class="tab col s1"><a href="#dadosFinanceiros">Financeiros</a></li> 
				</c:if>
			</ul>
	<br /> 
	
	<br />
		</div>
		<div id="jovem" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div>
		<c:if test="${jovem.id != null}">
			<div id="cursos" class="col s12">
				<c:import url="../cursos/cursos.jsp"></c:import>
			</div> 
			<div id="escolaridade" class="col s12">
				<c:import url="../escolaridades/escolaridades.jsp"></c:import>
			</div> 
			<div id="laborais" class="col s12">
				<c:import url="../laborais/laborais.jsp"></c:import>
			</div> 
			<div id="domiciliares" class="col s12">
				<c:import url="../domiciliares/domiciliares.jsp"></c:import>
			</div> 
			<div id="habilidades" class="col s12">
				<c:import url="../habilidades/habilidades.jsp"></c:import>
			</div> 
			<div id="situacaoDeSaude" class="col s12">
				<c:import url="../saudes/saudes.jsp"></c:import>
			</div> 
			<div id="fichaSocial" class="col s12">
				<c:import url="../sociais/sociais.jsp"></c:import>
			</div>
			<div id="fichaProfissional" class="col s12">
				<c:import url="../profissionais/profissionais.jsp"></c:import>
			</div> 
			<div id="historico" class="col s12">
				<c:import url="../historicos/historicos.jsp"></c:import>
			</div>
			<div id="dadosFinanceiros" class="col s12">
				<c:import url="../financeiros/financeiros.jsp"></c:import>
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
