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
		<div class="col s12 l12">
			<h4 class="header right black-text">${unidade.nomeFantazia == null ? 'Unidade' : unidade.nomeFantazia}</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


	<form:form role="form" commandName="unidade" servletRelativeAction="/sw/unidades/${unidade.id}" method="POST">
		<div class="row">
            <div class="input-field s12 col l12">
                <div class="row">
                	<div class="input-field s12 col l8">
                    	<form:input path='nomeFantazia' type='text' required="required" />
						<form:errors path='nomeFantazia'/> 
						<label for="nomeFantazia">Nome Fantazia</label>
                    </div>
                    <div class="input-field s12 col l4">
                    	<form:input id="dataDeCadastro" path="dataDeCadastro" type="date" class="validate datepicker" placeholder="Data de Cadastro" /> 
						<label path="dataDeCadastro">Data de Cadastro</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field s12 col l12">
                    	<form:input path='razaoSocial' type='text'  />
						<form:errors path='razaoSocial'/> 
						<label for="razaoSocial">Razão Social</label>
                    </div>
				</div>
				<div class="row">
                    <div class="input-field s12 col l4">
                    	<form:input path='cNPJ' type='text'  />
						<form:errors path='cNPJ'/> 
						<label for="cNPJ">CNPJ</label>
                    </div>
                    <div class="input-field s12 col l4">
                    	<form:input path='endereco' type='text'  />
						<form:errors path='endereco'/> 
						<label for="endereco">Endereço</label>
                    </div>
				</div>
				<div class="row">
                    <div class="input-field s12 col l3">
                    	<form:input path='complemento' type='text'  />
						<form:errors path='complemento'/> 
						<label for="complemento">Complemento</label>
                    </div>
                    <div class="input-field s12 col l2">
                    	<form:input path='cEP' type='text'  />
						<form:errors path='cEP'/> 
						<label for="cEP">CEP</label>
                    </div>
                    <div class="input-field s12 col l2">
                    	<form:input path='bairro' type='text'  />
						<form:errors path='bairro'/> 
						<label for="bairro">Bairro</label>
                    </div>
                    <div class="input-field s12 col l2">
                    	<form:input path='cidade' type='text'  />
						<form:errors path='cidade'/> 
						<label for="cidade">Cidade</label>
                    </div>
                    <div class="input-field s12 col l3">
                    	<form:input path='estado' type='text'  />
						<form:errors path='estado'/> 
						<label for="estado">Estado</label>
                    </div>
				</div>
				<div class="row">
                    <div class="input-field s12 col l3">
                    	<form:input path='telefone' type='text'  />
						<form:errors path='telefone'/> 
						<label for="telefone">Telefone</label>
                    </div>
                    <div class="input-field s12 col l4">
                    	<form:input path='email' type='email'  />
						<form:errors path='email'/> 
						<label for="email">Email</label>
                    </div>
                    <div class="input-field s12 col l3">
                    	<form:input path='fax' type='text' />
						<form:errors path='fax'/> 
						<label for="fax">Fax</label>
                    </div>
                    <div class="input-field s12 col l2">
                    	 <form:select path="status">
                			<form:option value="${unidade.status}" label="${unidade.status == null ? 'Status' : unidade.status}" />
							<c:forEach var="status" items="${requestScope.statuss}">
								<option>${status}</option>							
							</c:forEach>
						</form:select>
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