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
			<c:url value="/sw/empresa/${representanteLegal.empresa.id != null ? representanteLegal.empresa.id : empresa.id}" var="swEmpresaId"></c:url>
			<a href="${swEmpresaId}">
				<h4 class="header right black-text">${empresa.nomeFantazia != null ? empresa.nomeFantazia : representanteLegal.nome}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
		<c:url value="/sw/representante/${representanteLegal.nome != null ? representanteLegal.id : null}" var="swRepresentanteId"></c:url>
		<form:form role="form" commandName="representanteLegal" servletRelativeAction="${swRepresentanteId}" method="POST">
			<div class="row">
				<div class="input-field s12 col l6">
					<form:input path='nome' type='text' required="true" />
					<form:errors path='nome'/> 
					<label for="nome">Nome</label>
				</div>
				<div class="input-field s12 col l3">
					<form:input path='rG' type='text'/>
					<form:errors path='rG'/> 
					<label for="rG">RG</label>
				</div>
				<div class="input-field s12 col l3">
					<form:input path='cPF' type='text'/>
					<form:errors path='cPF'/> 
					<label for="cPF">CPF</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field s12 col l4">
					<form:input path='cargo' type='text'/>
					<form:errors path='cargo'/> 
					<label for="cargo">Cargo</label>
				</div>
				<div class="input-field s12 col l5">
					<form:input path='username' type='email' required="true" />
					<form:errors path='username'/> 
					<label for="username">Email</label>
				</div>
				<div class="input-field s12 col l3">
					<form:input path='telefone' type='text'/>
					<form:errors path='telefone'/> 
					<label for="telefone">Telefone</label>
				</div>
			</div>
		<div class="row">
			<c:if
				test="${requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true
	                 		   || requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesEditar == true}">
				<div class="input-field col s12 l12">
					<form:select path="grupoDePermissoes">
                		<form:option  value="${representanteLegal.grupoDePermissoes}" label="${representanteLegal.grupoDePermissoes == null ? 'Grupo De Permissoes' : representanteLegal.grupoDePermissoes.grupo}" />
						<c:forEach var="grupoDePermissoes" items="${requestScope.gruposDePermissoes}">
							<option value="${grupoDePermissoes.id}">${grupoDePermissoes.grupo}</option>							
						</c:forEach>
					</form:select>
				</div>
				<!-- // col -->
				<div class="col s12 l12">
					<a style="margin-left: 2em; float: right" class="tooltipped"
						data-position="bottom" data-delay="50"
						data-tooltip="Caso este esteja selecionado, mostrará as listas gerais, de todas as unidades.">
						<i class="material-icons" style="color: #222 !important;">info_outline</i>
					</a>
					<input type="checkbox" name="admin" class="filled-in" id="admin"
						<c:if test="${gestor.admin == true}">checked</c:if> /> 
						<label style="margin-left: 2em; float: right" for="admin">Admin</label>
				</div>
				<!-- // col -->
			</c:if>
		</div>

		<form:input path='empresa' type='hidden' value="${empresa.id}" />
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.representanteLegalCadastrar == true && requestScope.representanteLegal.id == null}">
				<button class="btn waves-effect waves-light right" type="submit">
					Salvar<i class="material-icons right">send</i>
				</button>
			</c:if>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.representanteLegalEditar == true && requestScope.representanteLegal.id != null}">
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