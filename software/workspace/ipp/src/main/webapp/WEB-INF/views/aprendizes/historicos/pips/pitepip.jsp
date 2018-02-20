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
			 <h4 class="header right orange-text">Dados Financeiros: <a class="header right" href="/jovens/${avaliacaoPITEPIP.jovem != null ? avaliacaoPITEPIP.jovem.id : jovem.id}">${avaliacaoPITEPIP.jovem != null ? avaliacaoPITEPIP.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="avaliacaoPITEPIP" servletRelativeAction="/avaliacoesPITsEPIPs/${avaliacaoPITEPIP.jovem != null ? avaliacaoPITEPIP.id : null}" method="POST">
		<div class="col s12">
			<div class="row">
				<div class="col s12">
					<form:hidden path='jovem' value="${avaliacaoPITEPIP.jovem != null ? avaliacaoPITEPIP.jovem.id : jovem.id}" />
					<form:errors path='jovem'/> 
					<form:select path="tipoAvaliacao">
						<form:option value="${avaliacaoPITEPIP.tipoAvaliacao}" label="${avaliacaoPITEPIP.tipoAvaliacao == null ? 'Tipo de Avaliação: ' : avaliacaoPITEPIP.tipoAvaliacao}" />
						<c:forEach var="tipoAvaliacao" items="${requestScope.tiposAvaliacoesEnum}">
							<option>${tipoAvaliacao}</option>							
						</c:forEach>
					</form:select>
					<label for="tipoAvaliacao">Tipo de Avaliação: </label>
					<hr />
					<hr />
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<h5 style="text-align: center">Data</h5>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h5 style="text-align: center">Avaliação</h5>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Nota</h5>
				</div><!-- // col -->
				<hr>
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPITEPIP_dataAutoAvaliacao" path="avaliacoesPITEPIP_dataAutoAvaliacao" type="date" class="validate datepicker" placeholder="Data Auto Avaliação" /> 
					<label for="avaliacoesPITEPIP_dataAutoAvaliacao">Data Auto Avaliação</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Auto Avaliação</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPITEPIP_notaAutoavaliacao" type="text" />
					<form:errors path="avaliacoesPITEPIP_notaAutoavaliacao"></form:errors>
					<form:label path="avaliacoesPITEPIP_notaAutoavaliacao">Nota Auto Avaliação</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPITEPIP_dataAvaliacaoOrientador" path="avaliacoesPITEPIP_dataAvaliacaoOrientador" type="date" class="validate datepicker" placeholder="Data Avaliação Orientador" /> 
					<label for="avaliacoesPITEPIP_dataAvaliacaoOrientador">Data Avaliação Orientador</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Orientador</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPITEPIP_notaAvaliacaoOrientador" type="text" />
					<form:errors path="avaliacoesPITEPIP_notaAvaliacaoOrientador"></form:errors>
					<form:label path="avaliacoesPITEPIP_notaAvaliacaoOrientador">Nota Orientador</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPITEPIP_dataAvaliacaoVivencia" path="avaliacoesPITEPIP_dataAvaliacaoVivencia" type="date" class="validate datepicker" placeholder="Data Avaliação Vivência" /> 
					<label for="avaliacoesPITEPIP_dataAvaliacaoVivencia">Data Avaliação Vivência</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Vivências</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPITEPIP_notaAvaliacaoVivencia" type="text" />
					<form:errors path="avaliacoesPITEPIP_notaAvaliacaoVivencia"></form:errors>
					<form:label path="avaliacoesPITEPIP_notaAvaliacaoVivencia">Nota Vivência</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPITEPIP_dataAvaliacaoMatematica" path="avaliacoesPITEPIP_dataAvaliacaoMatematica" type="date" class="validate datepicker" placeholder="Data Avaliação Matemática" /> 
					<label for="avaliacoesPITEPIP_dataAvaliacaoMatematica">Data Avaliação Matemática</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Matemática</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPITEPIP_notaAvaliacaoMatematica" type="text" />
					<form:errors path="avaliacoesPITEPIP_notaAvaliacaoMatematica"></form:errors>
					<form:label path="avaliacoesPITEPIP_notaAvaliacaoMatematica">Nota Matemática</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPITEPIP_dataAvaliacaoInformatica" path="avaliacoesPITEPIP_dataAvaliacaoInformatica" type="date" class="validate datepicker" placeholder="Data Avaliação Informática" /> 
					<label for="avaliacoesPITEPIP_dataAvaliacaoInformatica">Data Avaliação Informática</label>
				</div><!-- // col -->
				<div class="input-field col s12 l6">
					<h6 style="text-align: center">Informática</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPITEPIP_notaAvaliacaoInformatica" type="text" />
					<form:errors path="avaliacoesPITEPIP_notaAvaliacaoInformatica"></form:errors>
					<form:label path="avaliacoesPITEPIP_notaAvaliacaoInformatica">Nota Informática</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l4">
					<form:input id="avaliacoesPITEPIP_dataAvaliacaoPortugues" path="avaliacoesPITEPIP_dataAvaliacaoPortugues" type="date" class="validate datepicker" placeholder="Data Avaliação Português" /> 
					<label for="avaliacoesPITEPIP_dataAvaliacaoPortugues">Data Avaliação Português</label>
				</div><!-- // col -->
				<div class="col s12 l6">
					<h6 style="text-align: center">Português</h6>
				</div><!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPITEPIP_notaAvaliacaoPortugues" type="text" />
					<form:errors path="avaliacoesPITEPIP_notaAvaliacaoPortugues"></form:errors>
					<form:label path="avaliacoesPITEPIP_notaAvaliacaoPortugues">Nota Português</form:label>
				</div><!-- // col -->
			</div><!-- // row -->
			<hr /><hr /><br />
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