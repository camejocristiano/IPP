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
		<c:if test="${curso.id != null}">
			<c:url value="/sw/homeCurso/${curso.id}" var="swHomeCursoCursoId"></c:url>
			<a href="${swHomeCursoCursoId}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Matrículas"}</h4>
			</a>
		</c:if>
		<c:if test="${curso.id == null}">
			<c:url value="/sw/homeCursos" var="swHomeCursos"></c:url>
			<a href="${swHomeCursos}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Matrículas"}</h4>
			</a>
		</c:if>
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
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.matriculaVisualizar == true}">
				<th class="td-icon">EDITAR</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="matricula" items="${requestScope.matriculas}">
			<tr>
				<td>${matricula.id}</td>
				<td>${matricula.jovem.nome}</td>
				<td>${matricula.turma.curso.nomeDoCurso}</td>
				<td>${matricula.turma.numeroTurma}</td>
				<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.matriculaVisualizar == true}">
					<c:url value="/sw/matricula/${matricula.id}" var="swMatriculaId"></c:url>
					<td class="td-icon"><a href="${swMatriculaId}"><i
							class="material-icons">border_color</i></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>

<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.matriculaCadastrar == true && requestScope.curso.id != null}">
<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="/sw/novaMatricula/${requestScope.curso.id}"> <i class="material-icons">add</i>
	</a>
</div>
</c:if>

</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>
