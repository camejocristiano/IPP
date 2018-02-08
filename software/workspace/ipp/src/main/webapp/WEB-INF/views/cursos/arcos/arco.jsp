<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>

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

<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<a href="/sw/empresa/${empresa.id}">
				<h4 class="header right black-text">${gestor.nome != null ? gestor.nome : empresa.nomeFantazia}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

		<form:form role="form" commandName="arcoOcupacional" servletRelativeAction="/arcos/${arcoOcupacional.titulo != null ? arcoOcupacional.id : null}" method="POST">
		<div class="input-field s12 col l12">
			<form:input path="titulo" value="${arcoOcupacional.titulo}" />
			<form:label path="titulo">Título</form:label>
		</div>
		
		<table id="tabelaUsuarios" class="display">
        <thead>
          <tr>
          	<th>INCLUSOS</th>
            <th>TITULO</th>
            <th>NUMERO</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="cbo_arco" items="${requestScope.cbos_arco}">
          <tr>
			<td>
			<input type="checkbox" class="filled-in" name="cbos" id="cbos${cbo_arco.id}" value="${cbo_arco.id}" <c:if test="${cbo_arco.id != null}">checked</c:if> />
			<label for="cbos${cbo_arco.id}"></label>
            </td>
            <td>${cbo_arco.titulo}</td>
            <td>${cbo_arco.numero}</td>
          </tr>
        </c:forEach>
        <c:forEach var="cbo" items="${requestScope.cbos}">
          <tr>
			<td>
			<input type="checkbox" class="filled-in" name="cbos" id="cbos${cbo.id}" value="${cbo.id}" />
			<label for="cbos${cbo.id}"></label>
            </td>
            <td>${cbo.titulo}</td>
            <td>${cbo.numero}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table> 
		<br />
		<br />
		<input type="hidden" name="curso" value="${curso.id}" />
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
			<br />
			<br />
		</form:form>
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