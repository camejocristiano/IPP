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
			<c:url value="/sw/vrs" var="swVrs"></c:url>
			<a href="${swVrs}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "VR"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />

		</div><!-- // col -->
	</div><!-- // row -->
   		
   		<c:url value="/sw/vr/${vr.nomeDoJovem != null ? vr.id : null}" var="swVR"></c:url>
		<form:form role="form" commandName="vr" servletRelativeAction="${swVR}" method="POST">
   		<div class="row">
            <div class="input-field s12 col l4">
				<form:input path="diasAPagar" disabled="true" />	
            	<form:errors path="diasAPagar" ></form:errors>
            	<form:label path="diasAPagar">Dias à Pagar</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l4">
				<form:input path="valor" disabled="true" />	
            	<form:errors path="valor" ></form:errors>
            	<form:label path="valor">Valor</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l4">
				<form:input path="total" disabled="true" />	
            	<form:errors path="total" ></form:errors>
            	<form:label path="total">Total</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<div class="row">
            <div class="input-field s12 col l8">
				<form:input path="nomeDoJovem" disabled="true" />	
            	<form:errors path="nomeDoJovem" ></form:errors>
            	<form:label path="nomeDoJovem">Nome do Jovem</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="codigoDoJovem" disabled="true" />	
            	<form:errors path="codigoDoJovem" ></form:errors>
            	<form:label path="codigoDoJovem">Código do Jovem</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="nomeFantaziaEmpresa" disabled="true" />	
            	<form:errors path="nomeFantaziaEmpresa" ></form:errors>
            	<form:label path="nomeFantaziaEmpresa">Nome Fantazia Empresa</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
		<div class="row">
            <div class="input-field s12 col l8">
				<form:input path="diaSemana" disabled="true" />	
            	<form:errors path="diaSemana" ></form:errors>
            	<form:label path="diaSemana">Dia da Semana</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="dataInicioContrato" disabled="true" />	
            	<form:errors path="dataInicioContrato" ></form:errors>
            	<form:label path="dataInicioContrato">Data Início Contrato</form:label>
			</div><!-- // col -->
			<div class="input-field s12 col l2">
				<form:input path="dataFimContrato" disabled="true" />	
            	<form:errors path="dataFimContrato" ></form:errors>
            	<form:label path="dataFimContrato">Data Fim Contrato</form:label>
			</div><!-- // col -->
        </div><!-- // row -->
   		<br />
   		<br />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.vrCadastrar == true && requestScope.vr.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.vrEditar == true && requestScope.vr.id != null}">
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