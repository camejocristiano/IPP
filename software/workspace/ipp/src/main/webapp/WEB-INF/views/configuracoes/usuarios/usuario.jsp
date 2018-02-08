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
			<h4 class="header right black-text">${usuario.nome != null ? usuario.nome : "Usuário"}</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	
	
      <form:form role="form" commandName="usuario" servletRelativeAction="/usuarios/${usuario.id}" method="POST">
    		<div class="row">
            <div class="input-field  s12 col l2">
              <img src="../../../assets/images/usuario.png" alt="" width="175em" />
            </div>
            <div class="input-field s12 col l10">
                <div class="row">
                  <div class="input-field s12 col l6">
                    <form:input path='nome' type='text' required="required" />
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
                  </div>
                  <div class="input-field s12 col l3">
                    <form:input id="dataDeNascimento" path="dataDeNascimento" type="date" class="validate datepicker" placeholder="Data de Nascimento" /> 
                  </div>
                  <div class="input-field s12 col l3">
                    <form:select path="sexo">
                    	<form:option value="${usuario.sexo}" label="${usuario.sexo == null ? 'Sexo' : usuario.sexo}" />
						<c:forEach var="sexo" items="${requestScope.sexo}">
							<form:option value="${sexo}">${sexo}</form:option>							
						</c:forEach>
					</form:select>	
                  </div>
                </div>
                <div class="row">
                    <div class="input-field s12 col l3">
                      	<form:input path='cPF' type='text' required="required" />
						<form:errors path='cPF'/> 
						<label for="cPF">CPF</label>
                    </div>
                    <div class="input-field s12 col l3">
                      	<form:input path='rG' type='text'/>
						<form:errors path='rG'/> 
						<label for="rG">RG</label>
                    </div>
                    <div class="input-field s12 col l3">
                      	<form:input path='orgaoEmissorRG' type='text'/>
						<form:errors path='orgaoEmissorRG'/> 
						<label for="orgaoEmissorRG">Orgão Emissor RG</label>
                    </div>
                    <div class="input-field s12 col l3">
                      <form:input path="dataDeExpedicaoRG" type="date" class="validate datepicker" placeholder="Data de Expedição RG" />
                    </div>
                </div>
            </div>
          </div>

          <div class="row">
            <div class="input-field col s12">
              <div class="row">
                <div class="input-field s12 col l3">
                    <form:select path="relacaoFuncional">
						<form:option value="${usuario.relacaoFuncional}" label="${usuario.relacaoFuncional == null ? 'Relação Funcional' : usuario.relacaoFuncional}" />
						<c:forEach var="relacaoFuncional" items="${requestScope.relacaoFuncional}">
							<option>${relacaoFuncional}</option>							
						</c:forEach>
					</form:select>
                </div>
                <div class="input-field s12 col l4">
                  <form:input path='endereco' type='text'/>
						<form:errors path='endereco'/> 
						<label for="endereco">Endereço</label>
                </div>
                <div class="input-field s12 col l1">
                  <form:input path='numero' type='text'/>
						<form:errors path='numero'/> 
						<label for="numero">Número</label>
                </div>
                <div class="input-field s12 col l2">
                  <form:input path='telefone' type='text'/>
						<form:errors path='telefone'/> 
						<label for="telefone">Telefone</label>
                </div>
                <div class="input-field s12 col l2">
                  <form:input path='celular' type='text'/>
						<form:errors path='celular'/> 
						<label for="celular">Celular</label>
                </div>
              </div>
            </div>
          </div>

          <div class="row">
              <div class="input-field col s12">
                <div class="row">                  
                  <div class="input-field s12 col l2">
                    <form:input path='complemento' type='text'/>
						<form:errors path='complemento'/> 
						<label for="complemento">Complemento</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='bairro' type='text'/>
						<form:errors path='bairro'/> 
						<label for="bairro">Bairro</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:select path="regiao">
						<form:option value="${usuario.regiao}" label="${usuario.regiao == null ? 'Região' : usuario.regiao}" />
						<c:forEach var="regiao" items="${requestScope.regiao}">
							<option>${regiao}</option>							
						</c:forEach>
					</form:select>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='cEP' type='text'/>
						<form:errors path='cEP'/> 
						<label for="cEP">CEP</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='estado' type='text'/>
						<form:errors path='estado'/> 
						<label for="estado">Estado</label>
                  </div>
                  <div class="input-field s12 col l2">
                    <form:input path='cidade' type='text'/>
						<form:errors path='cidade'/> 
						<label for="cidade">Cidade</label>
                  </div>
                </div>
              </div>
            </div>

            <div class="row">
                <div class="input-field col s12">
                  <div class="row">                  
                      <div class="input-field s12 col l2">
                        <form:select path="estadoCivil">
							<form:option value="${usuario.estadoCivil}" label="${usuario.estadoCivil == null ? 'Estado Civil' : usuario.estadoCivil}" />
							<c:forEach var="estadoCivil" items="${requestScope.estadoCivil}">
								<option>${estadoCivil}</option>							
							</c:forEach>
						</form:select>
                      </div>
                    <div class="input-field s12 col l2">
                      <form:input path='cargo' type='text'/>
						<form:errors path='cargo'/> 
						<label for="cargo">Cargo</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <form:input path='habilitacao' type='text'/>
						<form:errors path='habilitacao'/> 
						<label for="habilitacao">Habilitação</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <form:input path='disciplina' type='text'/>
						<form:errors path='disciplina'/> 
						<label for="disciplina">Disciplina</label>
                    </div>
                    <div class="input-field s12 col l2">
                      <form:input path='formacao' type='text'/>
						<form:errors path='formacao'/> 
						<label for="formacao">Formação</label>
                    </div>
                    <div class="input-field s12 col l2">
                        <form:select path="status">
                			<form:option value="${usuario.status}" label="${usuario.status == null ? 'Status' : usuario.status}" />
							<c:forEach var="status" items="${requestScope.status}">
								<option>${status}</option>							
							</c:forEach>
						</form:select>
                    </div>
                  </div>
                </div>
              </div>
          
              <div class="row">
                  <div class="input-field col s12">
                    <div class="row">                  
                      <div class="input-field s12 col l3">
                        <form:input path="dataExpedicaoCTPS" type="text" class="validate datepicker" placeholder="Data Expedição CTPS" />
                      </div>
                      <div class="input-field s12 col l3">
                      <form:input path='numeroCTPS' type='text' required="${usuario.relacaoFuncional == 'CELETISTA' || usuario.relacaoFuncional == 'PRESTADOR_DE_SERVICOS' || usuario.relacaoFuncional == 'AUTONOMO' || usuario.relacaoFuncional == 'MEI' ? 'required' : null}" />
						<form:errors path='numeroCTPS'/> 
						<label for="numeroCTPS">Número CTPS</label>
                      </div>
                      <div class="input-field s12 col l3">
                        <form:input path='serieCTPS' type='text' />
						<form:errors path='serieCTPS'/> 
						<label for="serieCTPS">Série CTPS</label>
                      </div>
                      <div class="input-field s12 col l3">
                        <form:input path='cNPJMEI' type='text'/>
						<form:errors path='cNPJMEI'/> 
						<label for="cNPJMEI">CNPJ / MEI</label>
                      </div>
                      
                    </div>
                  </div>
                </div>

                <div class="row">
                    <div class="input-field col s12">
                      <div class="row">     
                        <div class="input-field s12 col l3 border-form">Admissão
                          <form:input path="dataDeAdmissao" type="text" class="validate datepicker" placeholder="Data de Admissão" />
                          <form:input path="dataDeDesligamento" type="text" class="validate datepicker" placeholder="Data de Desligamento" />
                          <div><br><br><br></div>
                        </div>
                        <div class="input-field s12 col l5 border-form">CTPS
                          <form:input path="uFCTPS" type="text" class="validate" placeholder="CTPS-UF" />
                          <form:input id="dataExpedicaoCTPS" path="dataExpedicaoCTPS" type="date" class="validate datepicker" placeholder="Data de Expedição CTPS" /> 
                        </div>
                        <div class="input-field s12 col l4 border-form">Dados de Acesso
                          	<form:input path='email' type='text' placeholder="E-Mail" required="required" />
							<form:errors path='email'/> 
							<br />
							<form:input path='username' type='text' placeholder="Username" required="required" />
							<form:errors path='username'/> 
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  <div class="row">
	                <div class="input-field col s12">
						<form:select path="grupoDePermissoes">
                			<form:option  value="${grupoDePermissoes.id}" label="${usuario.grupoDePermissoes == null ? 'Grupo De Permissoes' : usuario.grupoDePermissoes.grupo}" />
							<c:forEach var="grupoDePermissoes" items="${requestScope.gruposDePermissoes}">
								<option value="${grupoDePermissoes.id}">${grupoDePermissoes.grupo}</option>							
							</c:forEach>
						</form:select>
					</div>
                    <div class="input-field col s12">
                    <form:textarea path="observacoes" />
                    <form:label path="observacoes"></form:label>
                    </div>
                  </div>
				  <div>
				<br>
			</div>
                  <button class="btn waves-effect waves-light right" type="submit">
                    Salvar<i class="material-icons right">send</i>
                  </button>

        </form:form>
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
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
$('.timepicker').pickatime({
	"default": 'now',
	twelvehour: false, // change to 12 hour AM/PM clock from 24 hour
	donetext: 'OK',
	autoclose: false,
	vibrate: true // vibrate the device when dragging clock hand
});
$(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });
</script>
<c:import url="../../../partials/final.jsp"></c:import>