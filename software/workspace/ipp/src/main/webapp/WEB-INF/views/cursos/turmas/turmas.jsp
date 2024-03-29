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
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Turmas"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaTurmas" class="display">
	<thead>
		<tr>
			<th>TURMA</th>
			<th>DIA_DA_SEMANA</th>
			<th>ORIENTADOR</th>
			<th>HORA_DE_INÍCIO</th>
			<th>HORA_DE_TÉRMINO</th>
			<th>DATA_DE_INÍCIO</th>
			<th>DATA_DE_TÉRMINO</th>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.turmaVisualizar == true}">
				<th class="td-icon">EDITAR</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="turma" items="${requestScope.turmas}">
			<tr>
				<td>${turma.id}</td>
				<td>${turma.diaDaSemana}</td>
				<td>${turma.orientadorTurma.nome}</td>
				<td>${turma.horaInicioTurma}</td>
				<td>${turma.horaFimTurma}</td>
				<td>${turma.dataInicioTurma}</td>
				<td>${turma.dataFimTurma}</td>
				<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.turmaVisualizar == true}">
				<c:url value="/sw/turma/${turma.id}" var="swIurmaId"></c:url>
					<td class="td-icon"><a href="${swIurmaId}"><i
							class="material-icons">border_color</i></a></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>

<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.turmaCadastrar == true}">
<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
<c:url value="/sw/turmaForm/${curso.id}" var="swTurmaFormId"></c:url>
	<a class="btn-floating btn-large waves-effect waves-light orange"
		href="${swTurmaFormId}"> <i class="material-icons">add</i>
	</a>
</div>
</c:if>

<br />
<br />

	</div>
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>