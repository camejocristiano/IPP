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
			<a href="/sw/jovem/${jovem.id}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

		<form:form role="form" commandName="caracteristicasDomiciliares" servletRelativeAction="/sw/caracteristicaDomiciliar/${caracteristicasDomiciliares.jovem != null ? caracteristicasDomiciliares.id : null}" method="POST">
			<div class="row">
				<div class="s12 col l12">
					<div class="row">
						<div class="s12 col l3">
							<hr />
							<hr />
							<input type="checkbox" name="moraComAMaeOuResponsavel" class="filled-in" id="moraComAMaeOuResponsavel" <c:if test="${caracteristicasDomiciliares.moraComAMaeOuResponsavel == true}">checked</c:if> />
							<label for="moraComAMaeOuResponsavel">Mora com a mãe ou responsável?</label>
						</div><!-- // col -->
						<div class="s12 col l2">
							<hr />
							<hr />
							<input type="checkbox" name="temFilhos" class="filled-in" id="temFilhos" <c:if test="${caracteristicasDomiciliares.temFilhos == true}">checked</c:if> />
							<label for="temFilhos">Tem filhos?</label>
						</div><!-- // col -->
						<div class="s12 col l2">
							<hr />
							<hr />
							<input type="checkbox" name="moramComOJovem" class="filled-in" id="moramComOJovem" <c:if test="${caracteristicasDomiciliares.moramComOJovem == true}">checked</c:if> />
							<label for="moramComOJovem">Moram com o jovem?</label>
						</div><!-- // col -->
						<div class="s12 col l5">
							<hr />
							<hr />
							<div class="row">
								<div class="input-field s12 col l12">
									<form:input path='membrosDaFamiliaNoMesmoDomicilio' type='text'/>
									<form:errors path='membrosDaFamiliaNoMesmoDomicilio'/> 
									<label for="membrosDaFamiliaNoMesmoDomicilio">Número de membros da família no mesmo domicílio:</label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					<div class="row">
						<div class="s12 col l4">
							Escolaridade (Mãe/Responsável)
							<hr />
							<hr />
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="escolaridadeDaMaeOuResponsavel">
				                    	<form:option value="${caracteristicasDomiciliares.escolaridadeDaMaeOuResponsavel}" label="${caracteristicasDomiciliares.escolaridadeDaMaeOuResponsavel == null ? 'Escolaridade da mãe ou responsável' : caracteristicasDomiciliares.escolaridadeDaMaeOuResponsavel}" />
										<c:forEach var="escolaridade" items="${requestScope.escolaridades}">
											<form:option value="${escolaridade}">${escolaridade}</form:option>							
										</c:forEach>
									</form:select>	
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:input path='cursoDaMaeOuResponsavel' type='text'/>
									<form:errors path='cursoDaMaeOuResponsavel'/> 
									<label for="cursoDaMaeOuResponsavel">Curso da mãe ou responsável:</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="s12 col l12">
									<input type="checkbox" name="situacaoConcluido" class="filled-in" id="situacaoConcluido" <c:if test="${caracteristicasDomiciliares.situacaoConcluido == true}">checked</c:if> />
									<label for="situacaoConcluido">Situacao, concluido?</label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
						<div class="s12 col l4">
							Outras Características
							<hr />
							<hr />
							<div class="row">
								<div class="s12 col l12">
									<input type="checkbox" name="eArrimoDeFamilia" class="filled-in" id="eArrimoDeFamilia" <c:if test="${caracteristicasDomiciliares.eArrimoDeFamilia == true}">checked</c:if> />
									<label for="eArrimoDeFamilia">É arrimo de familia?</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:input path='rendaDomiciliar' type='text'/>
									<form:errors path='rendaDomiciliar'/> 
									<label for="rendaDomiciliar">Renda domiciliar mensal R$:</label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
						<div class="s12 col l4">
							Auxílio do Governo 
							<hr />
							<hr />
							<div class="row">
								<div class="s12 col l12">
									<input type="checkbox" name="recebeAuxilioDoGoverno" class="filled-in" id="recebeAuxilioDoGoverno" <c:if test="${caracteristicasDomiciliares.recebeAuxilioDoGoverno == true}">checked</c:if> />
									<label for="recebeAuxilioDoGoverno">Recebe auxilio do governo?</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:select path="auxilioDoGoverno">
				                    	<form:option value="${caracteristicasDomiciliares.auxilioDoGoverno}" label="${caracteristicasDomiciliares.auxilioDoGoverno == null ? 'Auxílio do Governo' : caracteristicasDomiciliares.auxilioDoGoverno}" />
										<c:forEach var="auxilioDoGoverno" items="${requestScope.auxiliosDoGoverno}">
											<form:option value="${auxilioDoGoverno}">${auxilioDoGoverno}</form:option>							
										</c:forEach>
									</form:select>	
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="input-field s12 col l12">
									<form:input path='outros' type='text'/>
									<form:errors path='outros'/> 
									<label for="outros">Outros:</label>
								</div><!-- // col -->
							</div><!-- // row -->
							<div class="row">
								<div class="s12 col l12">
									<input type="checkbox" name="jovemEOResponsavelPeloCartao" class="filled-in" id="jovemEOResponsavelPeloCartao" <c:if test="${caracteristicasDomiciliares.jovemEOResponsavelPeloCartao == true}">checked</c:if> />
									<label for="jovemEOResponsavelPeloCartao">O jovem é o responsável pelo cartão?</label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<form:hidden path="jovem" value="${jovem.id}" />
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</form:form>
		<br />
		<br />
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