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
			<c:url value="/sw/empresa/${empresa.id}" var="swEmpresaId"></c:url>
			<a href="${swEmpresaId}">
				<h4 class="header right black-text">${contato.nome != null ? contato.nome : 'Contato'}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/contato/${contato.nome != null ? contato.id : null}" var="swContatoId"></c:url>
		<form:form role="form" commandName="contato" servletRelativeAction="${swContatoId}" method="POST">
		<div class="row">
			<div class="input-field s12 col l7">
				<form:input path='nome' type='text' />
				<form:errors path='nome' />
				<label for="nome">Nome</label>
			</div>
			<!-- // col -->
			<div class="input-field s12 col l5">
				<form:input path='cargo' type='text' />
				<form:errors path='cargo' />
				<label for="cargo">Cargo</label>
			</div>
			<!-- // col -->
		</div>
		<!-- // row -->
		<div class="row">
			<div class="input-field s12 col l3">
				<form:input path='departamento' type='text' />
				<form:errors path='departamento' />
				<label for="departamento">Departamento</label>
			</div>
			<!-- // col -->
			<div class="input-field s12 col l6">
				<form:input path='username' type='text' />
				<form:errors path='username' />
				<label for="username">Email</label>
			</div>
			<!-- // col -->
			<div class="input-field s12 col l3">
				<form:input path='telefone' type='text' />
				<form:errors path='telefone' />
				<label for="telefone">Telefone</label>
			</div>
			<!-- // col -->
		</div>
		<!-- // row -->
		<div class="row">
			<div class="input-field s12 col l12">
				<form:textarea path='observacoes' type='text' />
				<form:errors path='observacoes' />
				<label for="observacoes">Observações</label>
			</div>
			<!-- // col -->
		</div>
		<!-- // row -->

			<input 
				name="empresa" 
				value="${empresa.id}" 
				type="hidden" />

	<br />
	<br />
	
		<c:if
			test="${requestScope.usuarioSessao.grupoDePermissoes.contatoCadastrar == true && requestScope.contato.id == null}">
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</c:if>
		<c:if
			test="${requestScope.usuarioSessao.grupoDePermissoes.contatoEditar == true && requestScope.contato.id != null}">
			<button class="btn waves-effect waves-light right" type="submit">
				Salvar<i class="material-icons right">send</i>
			</button>
		</c:if>

	</form:form>
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>