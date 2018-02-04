<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaTurmas" class="display" width="100%" cellspacing="0">
	<thead>
		<tr>
			<th>TURMA</th>
			<th>CURSO</th>
			<th class="td-icon">HOJE</th>
			<th class="td-icon">MÊS</th>
			<th class="td-icon">GERAL</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="turma" items="${requestScope.turmas}">
			<tr>
				<td>${turma.numeroTurma}</td>
				<td>${turma.curso.nomeDoCurso}</td>
				<td class="td-icon">
					<a href="/frequencias/turma/${turma.id}">
						<i class="material-icons">border_color</i>
					</a>
				</td>
				<td class="td-icon">
					<a href="/frequencias/mes/${turma.id}">
						<i class="material-icons">border_color</i>
					</a>
				</td>
				<td class="td-icon">
					<a href="/frequencias/geral/${turma.id}">
						<i class="material-icons">border_color</i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="/frequencias/turma/${turma.id}"> <i class="material-icons">add</i>
	</a>
</div>

<br />
<br />