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
			<c:url value="/sw/vts" var="swVts"></c:url>
			<a href="${swVts}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "VT"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div><!-- // col -->
	</div><!-- // row -->

   		<c:url value="/sw/vt/${vt.varVT != null ? vt.id : null}" var="swVT"></c:url>
		<form:form role="form" commandName="vt" servletRelativeAction="${swVT}" method="POST">
		
   		<div class="row">
            <div class="input-field s12 col l1"> 
				<form:input path="varVT" required="true" />
				<form:errors path="varVT"></form:errors>
				<form:label path="varVT">X</form:label>				
			</div><!-- // col -->
			<div class="input-field s12 col l1"> 
				<form:input path="cod" />
				<form:errors path="cod"></form:errors>
				<form:label path="cod">Cód</form:label>				
			</div><!-- // col -->
			<div class="input-field s12 col l3">
				<form:input path="aprendiz" />
				<form:errors path="aprendiz"></form:errors>
				<form:label path="aprendiz">Aprendiz</form:label>				
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="empresa" />
				<form:errors path="empresa"></form:errors>
				<form:label path="empresa">Empresa</form:label>				
			</div><!-- // col -->
			<div class="input-field s12 col l1">
				<form:input path="mesReferente" />
				<form:errors path="mesReferente"></form:errors>
				<form:label path="mesReferente">Mês Referente</form:label>				
			</div><!-- // col -->
			<div class="input-field s12 col l3">
				<form:input path="pap" />
				<form:errors path="pap"></form:errors>
				<form:label path="pap">PAP</form:label>				
			</div><!-- // col -->
        </div><!-- // row -->
        <hr />
        <div class="row">
        	<div class="input-field s12 col l3">
				<form:input path="unico" />
				<form:errors path="unico"></form:errors>
				<form:label path="unico">Único</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="unicoIdaEVolta" />
				<form:errors path="unicoIdaEVolta"></form:errors>
				<form:label path="unicoIdaEVolta">Único Ida e Volta</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="unicoParaJovem" />
				<form:errors path="unicoParaJovem"></form:errors>
				<form:label path="unicoParaJovem">Único para Jovem</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="unicoParaSPTans" />
				<form:errors path="unicoParaSPTans"></form:errors>
				<form:label path="unicoParaSPTans">Único para SPTans</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
        <div class="row">
        	<div class="input-field s12 col l3">
				<form:input path="bom" />
				<form:errors path="bom"></form:errors>
				<form:label path="bom">Bom</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="bomIdaEVolta" />
				<form:errors path="bomIdaEVolta"></form:errors>
				<form:label path="bomIdaEVolta">Bom Ida e Volta</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="bomParaJovem" />
				<form:errors path="bomParaJovem"></form:errors>
				<form:label path="bomParaJovem">Bom para Jovem</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="bomParaCMT" />
				<form:errors path="bomParaCMT"></form:errors>
				<form:label path="bomParaCMT">Bom para CMT</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
        <div class="row">
        	<div class="input-field s12 col l3">
				<form:input path="bEM" />
				<form:errors path="bEM"></form:errors>
				<form:label path="bEM">Bem</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="bEMIdaEVolta" />
				<form:errors path="bEMIdaEVolta"></form:errors>
				<form:label path="bEMIdaEVolta">Bem Ida e Volta</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="bEMParaJovem" />
				<form:errors path="bEMParaJovem"></form:errors>
				<form:label path="bEMParaJovem">Bem para Jovem</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<hr />
   		<div class="row">
        	<div class="input-field s12 col l2">
				<form:input path="segunda" />
				<form:errors path="segunda"></form:errors>
				<form:label path="segunda">Segunda</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l2">
				<form:input path="terca" />
				<form:errors path="terca"></form:errors>
				<form:label path="terca">Terça</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l2">
				<form:input path="quarta" />
				<form:errors path="quarta"></form:errors>
				<form:label path="quarta">Quarta</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="quinta" />
				<form:errors path="quinta"></form:errors>
				<form:label path="quinta">Quinta</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="sexta" />
				<form:errors path="sexta"></form:errors>
				<form:label path="sexta">Sexta</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="sab" />
				<form:errors path="sab"></form:errors>
				<form:label path="sab">Sábado</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<div class="row">
        	<div class="input-field s12 col l3">
				<form:input path="faltasCurso" />
				<form:errors path="faltasCurso"></form:errors>
				<form:label path="faltasCurso">Faltas Curso</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="faltasEmpresa" />
				<form:errors path="faltasEmpresa"></form:errors>
				<form:label path="faltasEmpresa">Faltas Empresa</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="faltasEmpresaInjustificada" />
				<form:errors path="faltasEmpresaInjustificada"></form:errors>
				<form:label path="faltasEmpresaInjustificada">Faltas Empresa Injustificada</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l3">
				<form:input path="faltasEmpresaJustificada" />
				<form:errors path="faltasEmpresaJustificada"></form:errors>
				<form:label path="faltasEmpresaJustificada">Faltas Empresa Justificada</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<div class="row">
        	<div class="input-field s12 col l3">
				<form:input path="diasMes" />
				<form:errors path="diasMes"></form:errors>
				<form:label path="diasMes">Dias Mês</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="diasAPagar" />
				<form:errors path="diasAPagar"></form:errors>
				<form:label path="diasAPagar">Dias à Pagar</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="totalAluno" />
				<form:errors path="totalAluno"></form:errors>
				<form:label path="totalAluno">Total Aluno</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l3">
				<form:input path="totalConcessionaria" />
				<form:errors path="totalConcessionaria"></form:errors>
				<form:label path="totalConcessionaria">Total Concessionária</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
        <hr />
        <div class="row">
        	<div class="input-field s12 col l3">
				<form:input path="valorIPP" />
				<form:errors path="valorIPP"></form:errors>
				<form:label path="valorIPP">Valor IPP</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="valorEmpresa" />
				<form:errors path="valorEmpresa"></form:errors>
				<form:label path="valorEmpresa">Valor Empresa</form:label>
			</div><!-- // col -->
        	<div class="input-field s12 col l3">
				<form:input path="dataInicioContrato" />
				<form:errors path="dataInicioContrato"></form:errors>
				<form:label path="dataInicioContrato">Data Início do Contrato</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l3">
				<form:input path="dataFimContrato" />
				<form:errors path="dataFimContrato"></form:errors>
				<form:label path="dataFimContrato">Data Fim do Contrato</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
		<div class="row">
        	<div class="input-field s12 col l12">
				<form:textarea path="observacao"/>
				<form:errors path="observacao"></form:errors>
				<form:label path="observacao">Observação</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<br />
   		<br />
   			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.vtCadastrar == true && requestScope.vt.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.vtEditar == true && requestScope.vt.id != null}">
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