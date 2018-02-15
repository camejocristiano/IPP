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

<table id="tabelaContatos" class="display">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th class="td-icon">EDITAR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="contato" items="${requestScope.contatos}">
			<tr>
				<td>${contato.id}</td>
				<td>${contato.nome}</td>
				<c:url value="/sw/contatos/${contato.id}" var="swContatoId"></c:url>
				<td class="td-icon"><a href="${swContatoId}"><i
						class="material-icons">border_color</i></a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<c:url value="/sw/contatos/form" var="swContatosForm"></c:url>
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="${swContatosForm}"> <i class="material-icons">add</i>
	</a>
</div>
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>