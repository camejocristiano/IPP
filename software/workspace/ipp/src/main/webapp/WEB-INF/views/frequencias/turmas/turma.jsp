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
			<h4 class="header right black-text">Turma</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

<form action="/sw/frequenciasTurma/${turma.id}" method="POST">
	<table id="tabelaTurmas" class="display centered">
		<thead>
			<tr>
				<th>ID</th>
				<th>JOVEM</th>
				<th>M</th>
				<th>T</th>
				<th>NÚMERO DA TURMA</th>
				<th>TIPO DA TURMA</th>
				<th>CURSO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matricula" items="${requestScope.matriculas}">
				<tr>
					<td>
						${matricula.id}
						<input type="hidden" name="matriculas" value="${matricula.id}">
					</td>
					<td>${matricula.jovem.nome}</td>
					<%-- <td>
						<input type="checkbox" class="filled-in" id="frequencia${matricula.id}" name="frequenciasManha" />
						<label for="frequencia${matricula.id}"></label>
					</td>
					<td>
						<input type="checkbox" class="filled-in" id="frequencia${matricula.id}" name="frequenciasTarde" />
						<label for="frequencia${matricula.id}"></label>
					</td> --%>
					<td>
						<select name="frequenciasManha">
							<c:forEach var="frequencia" items="${requestScope.enumFrequencias}">
								<option value="${frequencia}">${frequencia}</option>							
							</c:forEach>
						</select>
					</td>
					<td>
						<select name="frequenciasTarde">
							<c:forEach var="frequencia" items="${requestScope.enumFrequencias}">
								<option value="${frequencia}">${frequencia}</option>							
							</c:forEach>
						</select>	
					</td>
					<td>${matricula.turma.numeroTurma}</td>
					<td>${matricula.turma.tipoTurma}</td>
					<td>${matricula.turma.curso.nomeDoCurso}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="row">
		<div class="input-field s12 col l12">
			<input id="required" type="text" required />
			<label for="required">Digite algo para enviar a lista!</label>
		</div><!-- // col -->
	</div><!-- // row -->
	<button class="btn waves-effect waves-light right" type="submit">
		Salvar<i class="material-icons right">send</i>
	</button>
</form>
<br />
<br />
</div>
<c:import url="../../../partials/js.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>