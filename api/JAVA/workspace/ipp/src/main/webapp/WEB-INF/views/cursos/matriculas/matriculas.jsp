<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaMatriculas" class="display" width="100%"
	cellspacing="0">
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
				<td class="td-icon"><a href="/matriculas/${matricula.id}"><i
						class="material-icons">border_color</i></a></td>
			</tr>
		</c:forEach>
	</tbody>

</table>

<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="/matriculas/form/${matricula.turma.curso.id}"> <i class="material-icons">add</i>
	</a>
</div>