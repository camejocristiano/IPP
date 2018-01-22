<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>

<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<table id="tabelaTurmas" class="display" width="100%" cellspacing="0">
	<thead>
		<tr>
			<th>ID</th>
			<th>Número da Turma</th>
			<th>Curso</th>
			<th class="td-icon">EDITAR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="turma" items="${requestScope.turmas}">
			<tr>
				<td>${turma.id}</td>
				<td>${turma.numeroTurma}</td>
				<td>${turma.curso.nomeDoCurso}</td>
				<td class="td-icon"><a href="/frequencias/turma/${turma.id}"><i
						class="material-icons">border_color</i></a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="/frequencias/turma/${turma.id}"> <i class="material-icons">add</i>
	</a>
</div>
</div>

<br />
<br />
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>