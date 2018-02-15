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

<table id="tabelaSalarios13" class="display">
    <thead>
          <tr>
            <th>ID</th>
            <th>CURSO</th>
            <th class="td-icon">EDITAR</th>
          </tr>
    </thead>
	<tbody>
        <c:forEach var="matricula" items="${requestScope.matriculas}">
        <tr>
            <td>${matricula.id}</td>
            <td>${matricula.turma.curso.nomeDoCurso}</td>
            <c:url value="/sw/matriculaShow/${matricula.id}" var="swMatriculaId"></c:url>
            <td class="td-icon"><a href="${swMatriculaId}"><i class="material-icons" >border_color</i></a></td>
		</tr>
	</c:forEach>
	</tbody>
</table> 

</div><!-- // container -->
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>