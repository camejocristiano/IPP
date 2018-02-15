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
				<h4 class="header right black-text">${gestor.nome != null ? gestor.nome : empresa.nomeFantazia}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
		<c:url value="/sw/contatos/${contato.nome != null ? contato.id : null}" var="swContatoId"></c:url>
		<form:form role="form" commandName="contato" servletRelativeAction="${swContatoId}" method="POST">
			<div class="row">
				<div class="input-field s12 col l12">
					<form:input path='nome' type='text'/>
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
				</div>
			</div>
	<div class="row">
		<div class="s12 col l2">
			<c:url value="/images/usuario.png" var="usuarioPng"></c:url>
			<img src="${usuarioPng}" alt="" width="175em" />
		</div><!-- // col -->
		<div class="s12 col l10">
			<div class="row">
				<div class="s12 col l3">
					select
				</div><!-- // col -->
				<div class="s12 col l3">
					select
				</div><!-- // col -->
				<div class="s12 col l3">
					select
				</div><!-- // col -->
				<div class="s12 col l3">
					data
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<%-- <form:input path='razaoSocial' type='text' />
					<form:errors path='razaoSocial' />
					<label for="razaoSocial">Razão Social</label> --%>
				</div><!-- // col -->
				<div class="s12 col l2">
					select
				</div><!-- // col -->
			</div><!-- // row -->
			<div class="row">
				<div class="input-field s12 col l6">
					<%-- <form:input path='nomeFantazia' type='text' />
					<form:errors path='nomeFantazia' />
					<label for="nomeFantazia">Nome Fantazia</label> --%>
				</div><!-- // col -->
				<div class="input-field s12 col l6">
					<%-- <form:input path='cNPJ' type='text' />
					<form:errors path='cNPJ' />
					<label for="cNPJ">CNPJ</label> --%>
				</div><!-- // col -->				
			</div><!-- // row -->
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