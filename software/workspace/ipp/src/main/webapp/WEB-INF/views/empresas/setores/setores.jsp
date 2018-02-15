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
<table id="tabelaSetores" class="display">
	<thead>
		<tr>
			<th>ID</th>
			<th>NOME</th>
			<th class="td-icon">EDITAR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="setor" items="${requestScope.setores}">
			<tr>
				<td>${setor.id}</td>
				<td>${setor.nome}</td>
				<c:url value="/sw/setor/${setor.id}" var="swSetorId"></c:url>
				<td class="td-icon"><a href="${swSetorId}"><i
						class="material-icons">border_color</i></a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<c:url value="/sw/setorEmpresa/${empresa.id}" var="swSetorEmpresaId"></c:url>
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="${swSetorEmpresaId}"> <i class="material-icons">add</i>
	</a>
</div>
 </div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>