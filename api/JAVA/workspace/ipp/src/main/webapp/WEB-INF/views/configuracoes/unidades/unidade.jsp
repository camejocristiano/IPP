<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>
	
<div class="container" id="main-container-content">
	<div class="row">
		<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
			 <h4 class="header right orange-text">Unidade</h4>
		</div>
	</div>
	<form:form role="form" commandName="unidade" servletRelativeAction="/unidades/${unidade.id}" method="POST">
		<div class="row">
            <div class="input-field s12 col l12">
                <div class="row">
                	<div class="input-field s12 col l6">
                    	<form:input path='nomeFantazia' type='text' required="required" />
						<form:errors path='nomeFantazia'/> 
						<label for="nomeFantazia">Nome Fantazia</label>
                    </div>
                    <div class="input-field s12 col l6">
                    	<form:input path='email' type='email' required="required" />
						<form:errors path='email'/> 
						<label for="email">Email</label>
                    </div>
				</div>
			</div>
		</div>
		<button class="btn waves-effect waves-light right" type="submit">
			Salvar<i class="material-icons right">send</i>
		</button>
	</form:form>
</div>
<br />
<br />
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