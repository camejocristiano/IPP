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
			<c:url value="/sw/jovem/${jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Cursos"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

<table id="tabelaJovens" class="display">
    <thead>
          <tr>
            <th>MATRÍCULA</th>
            <th>CURSO</th>
            <th>TURMA</th>
            <th>STATUS</th>
	        <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.matriculaVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
    </thead>
	<tbody>
		<tr>
			<td colspan="5"> CURSANDO </td>
		</tr>
		<c:forEach var="matricula" items="${requestScope.matriculas}">
	        <c:if test="${matricula.statusDaMatricula == 'CURSANDO'}">
	        <tr>
	            <td>${matricula.id}</td>
	            <td>${matricula.turma.curso.nomeDoCurso}</td>
	            <td>${matricula.turma.numeroTurma}</td>
	            <td>${matricula.statusDaMatricula}</td>
	            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.matriculaVisualizar == true}">
	            	<c:url value="/sw/matriculaShow/${matricula.id}" var="swMatriculaId"></c:url>
	            	<td class="td-icon"><a href="${swMatriculaId}"><i class="material-icons" >border_color</i></a></td>
	            </c:if>
			</tr>
			</c:if>
		</c:forEach>
		<tr>
			<td colspan="5"> OUTROS </td>
		</tr>
        <c:forEach var="matricula" items="${requestScope.matriculas}">
	        <c:if test="${matricula.statusDaMatricula != 'CURSANDO'}">
	        <tr>
	            <td>${matricula.id}</td>
	            <td>${matricula.turma.curso.nomeDoCurso}</td>
	            <td>${matricula.turma.numeroTurma}</td>
	            <td>${matricula.statusDaMatricula}</td>
	            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.matriculaVisualizar == true}">
	            	<c:url value="/sw/matriculaShow/${matricula.id}" var="swMatriculaId"></c:url>
	            	<td class="td-icon"><a href="${swMatriculaId}"><i class="material-icons" >border_color</i></a></td>
	            </c:if>
			</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table> 
<br />
<br />
</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>