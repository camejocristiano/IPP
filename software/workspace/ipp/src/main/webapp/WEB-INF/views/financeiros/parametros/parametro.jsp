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
		<div class="col s12 l12">
			<c:url value="/sw/parametros" var="swParametros"></c:url>
			<a href="${swParametros}">
				<h4 class="header right black-text">Parâmetros</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/parametros/${parametro.id}" var="swParametroId"></c:url>
      	<form:form role="form" commandName="parametro" servletRelativeAction="" method="POST">
	    <div class="row">
            <div class="input-field s12 col l3">
        		<form:input path='salarioMinimoFederalSMF' type='text' required="required" />
				<form:errors path='salarioMinimoFederalSMF'/> 
				<form:label path="salarioMinimoFederalSMF">Salário Mínimo Federal SMF</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='valorDoConvenioDeSaudeMenorDeIdade' type='text' required="required" />
				<form:errors path='valorDoConvenioDeSaudeMenorDeIdade'/> 
				<form:label path="valorDoConvenioDeSaudeMenorDeIdade">Conv. Saúde Menor de Idade R$</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='valorDoConvenioDeSaudeMaiorDeIdade' type='text' required="required" />
				<form:errors path='valorDoConvenioDeSaudeMaiorDeIdade'/> 
				<form:label path="valorDoConvenioDeSaudeMaiorDeIdade">Conv. Saúde Maior de Idade R$</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='seguroDeVidaPCMSO' type='text' required="required" />
				<form:errors path='seguroDeVidaPCMSO'/> 
				<form:label path="seguroDeVidaPCMSO">Seguro de Vida PCMSO</form:label>
            </div><!-- // col -->
        </div><!-- // row -->
        <div class="row">
            <div class="input-field s12 col l3">
        		<form:input path='contribuicaoSindical' type='text' required="required" />
				<form:errors path='contribuicaoSindical'/> 
				<form:label path="contribuicaoSindical">Contribuição Sindical</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='taxaAdministrativaBom' type='text' required="required" />
				<form:errors path='taxaAdministrativaBom'/> 
				<form:label path="taxaAdministrativaBom">Taxa Administrativa Bom %</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='taxaBancaria' type='text' required="required" />
				<form:errors path='taxaBancaria'/> 
				<form:label path="taxaBancaria">Taxa Bancária</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='taxaAdministrativaDeVR' type='text' required="required" />
				<form:errors path='taxaAdministrativaDeVR'/> 
				<form:label path="taxaAdministrativaDeVR">Taxa Administrativa de VR</form:label>
            </div><!-- // col -->
        </div><!-- // row -->
        <div class="row">
            <div class="input-field s12 col l3">
        		<form:input path='taxaAdministrativaDaSPTrans' type='text' required="required" />
				<form:errors path='taxaAdministrativaDaSPTrans'/> 
				<form:label path="taxaAdministrativaDaSPTrans">Taxa Administrativa da SPTrans</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='taxaBancariaDeVR' type='text' required="required" />
				<form:errors path='taxaBancariaDeVR'/> 
				<form:label path="taxaBancariaDeVR">Taxa Bancária de VR</form:label>
            </div><!-- // col -->
            <div class="input-field s12 col l3">
        		<form:input path='taxaBancariaDeVT' type='text' required="required" />
				<form:errors path='taxaBancariaDeVT'/> 
				<form:label path="taxaBancariaDeVT">Taxa Bancária de VT</form:label>
            </div><!-- // col -->
			<div class="input-field s12 col l3">
        		<form:input path='taxaDeEmissaoDeCartaoDeVR' type='text' required="required" />
				<form:errors path='taxaDeEmissaoDeCartaoDeVR'/> 
				<form:label path="taxaDeEmissaoDeCartaoDeVR">Taxa de emissão de cartão de VR</form:label>
            </div><!-- // col -->
        </div><!-- // row -->
        <button class="btn waves-effect waves-light right" type="submit">
    	     Salvar<i class="material-icons right">send</i>
     	</button>
   		</form:form>
   		<br />
   		<br />
	</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>