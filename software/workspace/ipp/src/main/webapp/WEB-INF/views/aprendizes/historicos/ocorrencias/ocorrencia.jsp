<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../../partials/header.jsp"></c:import>
<c:import url="../../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
			 <h4 class="header right orange-text">Ocorrências: <a class="header right" href="/jovens/${ocorrencia.jovem != null ? ocorrencia.jovem.id : jovem.id}">${ocorrencia.jovem != null ? ocorrencia.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="ocorrencia" servletRelativeAction="/ocorrencias/${ocorrencia.jovem != null ? ocorrencia.id : null}" method="POST">
		<div class="col s12">
			<div class="row">
				<div class="col s12 l4">
					<form:input id="data" path="data" type="date" class="validate datepicker" placeholder="Data" /> 
				</div><!-- // col -->
				<div class="col s12 l4">
					<form:hidden path='jovem' value="${ocorrencia.jovem != null ? ocorrencia.jovem.id : jovem.id}" />
					<form:errors path='jovem'/> 
					 <form:select path="responsavel">
                		<form:option  value="${usuario.id}" label="${ocorrencia.responsavel == null ? 'Responsável' : ocorrencia.responsavel.nome}" />
						<c:forEach var="usuario" items="${requestScope.usuarios}">
							<option value="${usuario.id}">${usuario.nome}</option>							
						</c:forEach>
					</form:select>
					<form:label path="responsavel">Responsável</form:label>
				</div><!-- // col -->
				<div class="col s12 l4">
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="col s12 l4">
					<form:select path="tipo">
                    	<form:option value="${ocorrencia.tipo}" label="${ocorrencia.tipo == null ? 'Tipo' : ocorrencia.tipo}" />
						<c:forEach var="tipo" items="${requestScope.tiposDeOcorrencias}">
							<form:option value="${tipo}">${tipo}</form:option>							
						</c:forEach>
					</form:select>	
					<form:label path="tipo">Tipo</form:label>
				</div><!-- // col -->
				<div class="col s12 l6">
					<form:input path="titulo" type='text' />
					<form:errors path="titulo"></form:errors>
					<form:label path="titulo">Título da Ocorrência</form:label>
				</div><!-- // col -->
				<div class="col s12 l2">
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="col s12 l12">
					<form:textarea path="descricao" />
					<form:errors path="descricao"></form:errors>
					<form:label path="descricao">Descrição</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>	
		</div><!-- // col Main -->
		</form:form>
	</div><!-- // row Main -->
</div><!-- // Container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
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
<c:import url="../../../../partials/final.jsp"></c:import>