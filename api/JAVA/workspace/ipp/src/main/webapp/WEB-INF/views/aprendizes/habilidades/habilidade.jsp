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
			 <h4 class="header right orange-text">Situação de Saúde: <a class="header right" href="/jovens/${habilidades.jovem != null ? habilidades.jovem.id : jovem.id}">${habilidades.jovem != null ? habilidades.jovem.nome : jovem.nome}</a></h4>
		</div>
	</div>
	<div class="row">
		<form:form role="form" commandName="habilidades" servletRelativeAction="/habilidades/${habilidades.jovem != null ? habilidades.id : null}" method="POST">
		<div class="s12 col l12">	
			<div class="row">
				<div class="s12 col l12">
					${habilidades.jovem != null ? habilidades.jovem.nome : jovem.nome}
					<hr />
					<hr />
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" name="sabeLerEEscrever" class="filled-in" id="sabeLerEEscrever" <c:if test="${habilidades.sabeLerEEscrever == true}">checked</c:if> />
							<label for="sabeLerEEscrever">Sabe ler e escrever?</label>
						</div><!-- // col -->
					</div><!-- // row -->
					<div class="row">
						<div class="s12 col l12">
							<form:select path="habilidadeManual">
		                    	<form:option value="${habilidades.habilidadeManual}" label="${habilidades.habilidadeManual == null ? 'Habilidade Manual' : habilidades.habilidadeManual}" />
								<c:forEach var="habilidadeManual" items="${requestScope.habilidadesManuais}">
									<form:option value="${habilidadeManual}">${habilidadeManual}</form:option>							
								</c:forEach>
							</form:select>	
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					Conhecimentos de informática:
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" name="word" class="filled-in" id="word" <c:if test="${habilidades.word == true}">checked</c:if> />
							<label for="word">Word</label><br />
							<input type="checkbox" name="excel" class="filled-in" id="excel" <c:if test="${habilidades.excel == true}">checked</c:if> />
							<label for="excel">Excel</label><br />
							<input type="checkbox" name="powerPoint" class="filled-in" id="powerPoint" <c:if test="${habilidades.powerPoint == true}">checked</c:if> />
							<label for="powerPoint">PowerPoint</label><br />
							<input type="checkbox" name="outlook" class="filled-in" id="outlook" <c:if test="${habilidades.outlook == true}">checked</c:if> />
							<label for="outlook">Outlook</label><br />
							<input type="checkbox" name="access" class="filled-in" id="access" <c:if test="${habilidades.access == true}">checked</c:if> />
							<label for="access">Access</label><br />
							<div class="row">
								<div class="s12 col l4">
									<input type="checkbox" name="outrosInformatica" class="filled-in" id="outrosInformatica" <c:if test="${habilidades.outrosInformatica == true}">checked</c:if> />
									<label for="outrosInformatica">Outros</label>
								</div><!-- // col -->
								<div class="s12 col l8">
									<form:textarea path='outrosInformaticaDescricao' />
									<form:errors path='outrosInformaticaDescricao'/> 
									<label for="outrosInformaticaDescricao">Descrição Outros Informática</label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					Idiomas:
					<div class="row">
						<div class="s12 col l12">
							<input type="checkbox" name="ingles" class="filled-in" id="ingles" <c:if test="${habilidades.ingles == true}">checked</c:if> />
							<label for="ingles">Inglês</label><br />
							<input type="checkbox" name="espanhol" class="filled-in" id="espanhol" <c:if test="${habilidades.espanhol == true}">checked</c:if> />
							<label for="espanhol">Espanhol</label><br />
							<div class="row">
								<div class="s12 col l4">
									<input type="checkbox" name="outrosIdiomas" class="filled-in" id="outrosIdiomas" <c:if test="${habilidades.outrosIdiomas == true}">checked</c:if> />
									<label for="outrosIdiomas">Outros</label>
								</div><!-- // col -->
								<div class="s12 col l8">
									<form:textarea path='outrosIdiomasDescricao' />
									<form:errors path='outrosIdiomasDescricao'/> 
									<label for="outrosIdiomasDescricao">Descrição Outros Idiomas</label>
								</div><!-- // col -->
							</div><!-- // row -->
						</div><!-- // col -->
					</div><!-- // row -->
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="s12 col l12">
					Características Marcantes:
					<div class="row">
						<div class="s12 col l12">
							<form:textarea path='caracteristicasMarcantes' />
							<form:errors path='caracteristicasMarcantes'/> 
							<label for="caracteristicasMarcantes">Características Marcantes</label>
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