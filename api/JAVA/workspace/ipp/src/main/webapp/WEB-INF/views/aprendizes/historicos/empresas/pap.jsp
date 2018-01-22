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
			 <h4 class="header right orange-text">Avaliação PAPEmpresa: <a class="header right" href="/jovens/${avaliacaoPAPEmpresa.jovem != null ? avaliacaoPAPEmpresa.jovem.id : jovem.id}">${avaliacaoPAPEmpresa.jovem != null ? avaliacaoPAPEmpresa.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="avaliacaoPAPEmpresa" servletRelativeAction="/avaliacoesPAPsEmpresa/${avaliacaoPAPEmpresa.jovem != null ? avaliacaoPAPEmpresa.id : null}" method="POST">
		<div class="col s12">
			<div class="row">
				<div class="input-field col s12 l12">
					<form:hidden path='jovem' value="${avaliacaoPAPEmpresa.jovem != null ? avaliacaoPAPEmpresa.jovem.id : jovem.id}" />
					<form:errors path='jovem'/> 
					<hr />
					<hr />
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Data</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h5 style="text-align: center">Avaliações</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h5 style="text-align: center">Avaliador</h5>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<h5 style="text-align: center">Nota</h5>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data1avaliacao" path="avaliacoesPAPEmpresa_data1avaliacao" type="date" class="validate datepicker" placeholder="Data 1ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data1avaliacao">Data 1ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">1ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador1avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota1avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota1avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota1avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data2avaliacao" path="avaliacoesPAPEmpresa_data2avaliacao" type="date" class="validate datepicker" placeholder="Data 2ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data2avaliacao">Data 2ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">2ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador2avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota2avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota2avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota2avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data3avaliacao" path="avaliacoesPAPEmpresa_data3avaliacao" type="date" class="validate datepicker" placeholder="Data 3ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data3avaliacao">Data 3ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">3ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador3avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota3avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota3avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota3avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data4avaliacao" path="avaliacoesPAPEmpresa_data4avaliacao" type="date" class="validate datepicker" placeholder="Data 4ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data4avaliacao">Data 4ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">4ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador4avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota4avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota4avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota4avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data5avaliacao" path="avaliacoesPAPEmpresa_data5avaliacao" type="date" class="validate datepicker" placeholder="Data 5ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data5avaliacao">Data 5ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">5ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador5avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota5avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota5avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota5avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data6avaliacao" path="avaliacoesPAPEmpresa_data6avaliacao" type="date" class="validate datepicker" placeholder="Data 6ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data6avaliacao">Data 6ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">6ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador6avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota6avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota6avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota6avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data7avaliacao" path="avaliacoesPAPEmpresa_data7avaliacao" type="date" class="validate datepicker" placeholder="Data 7ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data7avaliacao">Data 7ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">7ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador7avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota7avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota7avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota7avaliacao">Nota</form:label>
				</div> <!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field col s12 l2">
					<form:input id="avaliacoesPAPEmpresa_data8avaliacao" path="avaliacoesPAPEmpresa_data8avaliacao" type="date" class="validate datepicker" placeholder="Data 8ª Avaliação" /> 
					<label for="avaliacoesPAPEmpresa_data8avaliacao">Data 8ª Avaliação</label>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<h6 style="text-align: center">8ª-Avaliação</h6>
				</div> <!-- // col -->
				<div class="input-field col s12 l4">
					<form:input path="avaliacoesPAPEmpresa_avaliador8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_avaliador8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_avaliador8avaliacao">Avaliador</form:label>
				</div> <!-- // col -->
				<div class="input-field col s12 l2">
					<form:input path="avaliacoesPAPEmpresa_nota8avaliacao" type="text" />
					<form:errors path="avaliacoesPAPEmpresa_nota8avaliacao"></form:errors>
					<form:label path="avaliacoesPAPEmpresa_nota8avaliacao">Nota</form:label>
				</div> <!-- // col -->
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