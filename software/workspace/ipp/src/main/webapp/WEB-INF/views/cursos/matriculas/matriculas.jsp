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
			<c:url value="/sw/homeCurso/${curso.id}" var="swHomeCursoCursoId"></c:url>
			<a href="${swHomeCursoCursoId}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Matrículas"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaMatriculas" class="display">
	<thead>
		<tr>
			<th>ID</th>
			<th>Jovem</th>
			<th>Curso</th>
			<th>Turma</th>
			<th class="td-icon">EDITAR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="matricula" items="${requestScope.matriculas}">
			<tr>
				<td>${matricula.id}</td>
				<td>${matricula.jovem.nome}</td>
				<td>${matricula.turma.curso.nomeDoCurso}</td>
				<td>${matricula.turma.numeroTurma}</td>
				<td class="td-icon"><a href="/sw/matricula/${matricula.id}"><i
						class="material-icons">border_color</i></a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="/sw/novaMatricula/${requestScope.curso.id}"> <i class="material-icons">add</i>
	</a>
</div>

</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>
