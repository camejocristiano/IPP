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
			<h4 class="header right black-text">Turmas</h4>
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
			<th>CURSO</th>
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
				<td>${turma.tipoTurma}</td>
				<td class="td-icon">
					<a href="/sw/frequencias/dia/${turma.id}">
						<i class="material-icons">border_color</i>
					</a>
				</td>
				<td class="td-icon">
					<a href="/sw/frequencias/mes/${turma.id}">
						<i class="material-icons">list</i>
					</a>
				</td>
				<td class="td-icon">
					<a href="/sw/frequencias/geral/${turma.id}">
						<i class="material-icons">list</i>
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>
</div>  

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>