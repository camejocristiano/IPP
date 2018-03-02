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
			<c:url value="/sw/empresa/${empresa.id != null ? empresa.id : null}" var="swEmpresa"></c:url>
			<a href="${swEmpresa}">
				<h4 class="header right black-text">${empresa.nomeFantazia != null ? empresa.nomeFantazia : "Empresa"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
<c:url value="/sw/historico/empresa/${historicos.id != null ? historicos.id : null}" var="swHistoricosId"></c:url>
<form:form role="form" commandName="historicos" servletRelativeAction="${swHistoricosId}" method="POST">
<!-- 
	private String dataDoHistorico;
	private String descricaoDoHistorico;
	@ManyToOne
	private Empresa empresa;

 -->
 
 			<div class="row">
				<div class="input-field s12 col l4">
					<form:input path='dataDoHistorico' type='text' class="validate datepicker" placeholder="Data do Histórico" value="${historicos.dataDoHistorico}" />
					<form:errors path='dataDoHistorico' />
					<label for="dataDoHistorico">Data do Histórico</label>
				</div><!-- // col -->
				<div class="input-field s12 col l8">
					<form:textarea path='descricaoDoHistorico' required="true" />
					<form:errors path='descricaoDoHistorico' />
					<label for="descricaoDoHistorico">Descrição do Histórico</label>
				</div><!-- // col -->
			</div><!-- // row -->
 
			<input 
				name="empresa" 
				value="${empresa.id}" 
				type="hidden" />
 
 	<br />
	<br />
	
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.historicosCadastrar == true && requestScope.historicos.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.historicosEditar == true && requestScope.historicos.id != null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
	
</form:form>
<br />
<br />

	<br />
	<br />
	
	<br />
	<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>