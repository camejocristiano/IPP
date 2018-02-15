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
			<h4 class="header right black-text">Grupos de Permissões</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

<table id="tabelaGruposDePermissoes" class="display">
	<thead>
		<tr>
			<th>ID</th>
			<th>GRUPO</th>
			<th>STATUS</th>
			<th>UNIDADE</th>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.grupoDePermissoesVisualizar == true}">
				<th class="td-icon">EDITAR</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="grupoDePermissoes"
			items="${requestScope.gruposDePermissoes}">
			<tr>
				<td>${grupoDePermissoes.id}</td>
				<td>${grupoDePermissoes.grupo}</td>
				<td>${grupoDePermissoes.status}</td>
				<td>${grupoDePermissoes.unidade.nomeFantazia}</td>
				<c:if test="${usuarioSessao.grupoDePermissoes.grupoDePermissoesVisualizar == true}">
				<c:url value="/sw/grupoDePermissoes/${grupoDePermissoes.id}" var="swGrupoDePermissoesId"></c:url>
				<td class="td-icon"><a
					href="${swGrupoDePermissoesId}"><i
						class="material-icons">border_color</i></a></td>
						</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>
	<c:if
		test="${usuarioSessao.grupoDePermissoes.grupoDePermissoesCadastrar == true}">
		<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/grupoDePermissoes/form"
				var="swGruposDePermissoesForm"></c:url>
			<a class="btn-floating btn-large waves-effect waves-light orange"
				href="${swGruposDePermissoesForm}"> <i class="material-icons">add</i>
			</a>
		</div>
	</c:if>

</div>  
<c:import url="../../../partials/js.jsp"></c:import>

<c:import url="../../../partials/footer.jsp"></c:import>