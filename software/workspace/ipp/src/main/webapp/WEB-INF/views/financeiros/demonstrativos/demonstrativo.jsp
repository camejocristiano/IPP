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
			<c:url value="/sw/demonstrativos" var="swDemonstrativos"></c:url>
			<a href="${swDemonstrativos}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Demonstrativos"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	
		<c:url value="/sw/demonstrativo/" var="swDemonstrativo"></c:url>
		<form:form role="form" commandName="demonstrativo" servletRelativeAction="${swDemonstrativo}" method="POST">
   		<div class="row">
            <div class="input-field s12 col l1">
            	<form:input path="varDemonstrativo" />	
            	<form:errors path="varDemonstrativo" ></form:errors>
            	<form:label path="varDemonstrativo">X</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l7">
            	<form:input path="nomeDoJovem" />	
            	<form:errors path="nomeDoJovem" ></form:errors>
            	<form:label path="nomeDoJovem">Jovem</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l2">
            	<form:input path="codigoDoJovem" />	
            	<form:errors path="codigoDoJovem" ></form:errors>
            	<form:label path="codigoDoJovem">Código</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
            	<form:input path="idadeDoJovem" />	
            	<form:errors path="idadeDoJovem" ></form:errors>
            	<form:label path="idadeDoJovem">Idade</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<div class="row">
            <div class="input-field s12 col l2">
            	<form:input path="dataDaContratacao" />	
            	<form:errors path="dataDaContratacao" ></form:errors>
            	<form:label path="dataDaContratacao">Data da Contratação</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l2">
            	<form:input path="base" />	
            	<form:errors path="base" ></form:errors>
            	<form:label path="base">Base</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
            	<form:input path="seguroDeVida_PCMSO" />	
            	<form:errors path="seguroDeVida_PCMSO" ></form:errors>
            	<form:label path="seguroDeVida_PCMSO">Seguro de Vida PCMSO</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l2">
            	<form:input path="mesReferente" />	
            	<form:errors path="mesReferente" ></form:errors>
            	<form:label path="mesReferente">Mes Referente</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l2">
            	<form:input path="vt" />	
            	<form:errors path="vt" ></form:errors>
            	<form:label path="vt">VT</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
            	<form:input path="vr" />	
            	<form:errors path="vr" ></form:errors>
            	<form:label path="vr">VR</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
        <div class="row">
            <div class="input-field s12 col l4">
				<form:input path="faltas" />	
            	<form:errors path="faltas" ></form:errors>
            	<form:label path="faltas">Faltas</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l4">
				<form:input path="diasTrabalhados" />	
            	<form:errors path="diasTrabalhados" ></form:errors>
            	<form:label path="diasTrabalhados">Dias Trabalhados</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l4">
				<form:input path="valorBruto" />	
            	<form:errors path="valorBruto" ></form:errors>
            	<form:label path="valorBruto">Valor Bruto</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
        <hr />
        <div class="row">
            <div class="input-field s12 col l12">
				<form:input path="iNSS_20_porCento" />	
            	<form:errors path="iNSS_20_porCento" ></form:errors>
            	<form:label path="iNSS_20_porCento">INSS 20%</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="fGTS_2_porCento" />	
            	<form:errors path="fGTS_2_porCento" ></form:errors>
            	<form:label path="fGTS_2_porCento">FGTS 2%</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="pIS_1_porCento" />	
            	<form:errors path="pIS_1_porCento" ></form:errors>
            	<form:label path="pIS_1_porCento">PIS 1%</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="acidenteDeTrabalho_2_porCento" />	
            	<form:errors path="acidenteDeTrabalho_2_porCento" ></form:errors>
            	<form:label path="acidenteDeTrabalho_2_porCento">Acidente de Trabalho 2%</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l12">
				<form:input path="sistemaS_3_ponto_5_porCento" />	
            	<form:errors path="sistemaS_3_ponto_5_porCento" ></form:errors>
            	<form:label path="sistemaS_3_ponto_5_porCento">Sistemas 3 ponto 5%</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="salarioEducacao_1_porCento" />	
            	<form:errors path="salarioEducacao_1_porCento" ></form:errors>
            	<form:label path="salarioEducacao_1_porCento">Salário Educação 1%</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="planoDeSaude" />	
            	<form:errors path="planoDeSaude" ></form:errors>
            	<form:label path="planoDeSaude">Plano de Saúde</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="planoOdonto" />	
            	<form:errors path="planoOdonto" ></form:errors>
            	<form:label path="planoOdonto">Plano Odonto</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l12">
				<form:input path="taxaExtraAdicional_18_porCento_s_min" />	
            	<form:errors path="taxaExtraAdicional_18_porCento_s_min" ></form:errors>
            	<form:label path="taxaExtraAdicional_18_porCento_s_min">Taxa Extra Adicional 18% S/min</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
		<hr />
        <div class="row">
            <div class="input-field s12 col l12">
            	<form:input path="valorDaParceiriaEmpresa" />	
            	<form:errors path="valorDaParceiriaEmpresa" ></form:errors>
            	<form:label path="valorDaParceiriaEmpresa">Valor da Parceiria Empresa</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l12">
            	<form:input path="totalLiquedo" />	
            	<form:errors path="totalLiquedo" ></form:errors>
            	<form:label path="totalLiquedo">Total Líquedo</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l12">
            	<form:input path="diaDoCurso" />	
            	<form:errors path="diaDoCurso" ></form:errors>
            	<form:label path="diaDoCurso">Dia do Curso</form:label>
			</div><!-- // col -->
            <div class="input-field s12 col l12">
            	<form:input path="terminoDoContrato" />	
            	<form:errors path="terminoDoContrato" ></form:errors>
            	<form:label path="terminoDoContrato">Término do Contrato</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
		<br />
		<br />
		<input type="hidden" name="curso" value="${curso.id}" />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.demonstrativoCadastrar == true && requestScope.demonstrativoOcupacional.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.demonstrativoEditar == true && requestScope.demonstrativoOcupacional.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>

			<br />
			<br />
		</form:form>
</div><!-- // container -->

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>