<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:import url="../../../partials/header.jsp"></c:import>

<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
<form action="/frequencia/turma/${turma.id}" method="POST">
<table id="tabelaTurmas" class="display centered" width="100%" cellspacing="0">
	<thead>
		<tr>
			<th>ID</th>
			<th>Jovem</th>
			<th>Número da Turma</th>
			<th>Tipo da Turma</th>
			<th>Curso</th>
			<th>Frequência</th>
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
				<td>${matricula.turma.numeroTurma}</td>
				<td>${matricula.turma.tipoTurma}</td>
				<td>${matricula.turma.curso.nomeDoCurso}</td>
				<%-- <td>
					<input type="checkbox" class="filled-in" id="frequencia${matricula.id}" name="frequencias" />
					<label for="frequencia${matricula.id}"></label>
				</td> --%>
				<td>
					<select name="frequencias">
						<c:forEach var="frequencia" items="${requestScope.frequencias}">
							<option value="${frequencia}">${frequencia}</option>							
						</c:forEach>
					</select>	
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br />
<br />
<button class="btn waves-effect waves-light right" type="submit">
	Salvar<i class="material-icons right">send</i>
</button>
<br />
<br />
</form>
</div>
<br />
<br />
<c:import url="../../../partials/js.jsp"></c:import>
<script type="text/javascript">
	$(document).ready(function() {
		$('select').material_select();
	});
</script>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>