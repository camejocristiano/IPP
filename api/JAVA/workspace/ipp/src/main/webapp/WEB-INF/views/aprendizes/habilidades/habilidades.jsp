<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Habilidades:</h4>
			<c:if test="${empty habilidades}">
				<a class="btn-floating btn-large waves-effect waves-light orange" href="/habilidades/form/${jovem.id}">
					<i class="material-icons">add</i>
				</a>
			</c:if>
	</div>
</div>
<table id="tabelaRepresentantes" class="display" width="100%" cellspacing="0">
	<thead>
          <tr>
            <th>ID</th>
            <th>JOVEM</th>
            <th class="td-icon">EDITAR</th>
          </tr>
	</thead>
    <tbody>
        <c:forEach var="habilidade" items="${requestScope.habilidades}">
          <tr>
            <td>${habilidade.id}</td>
            <td>${habilidade.jovem.nome}</td>
            <td class="td-icon"><a href="/habilidades/${habilidade.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
    </tbody>
</table>
<br />
<br />
<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Outros Cursos:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/outrosCursos/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<table id="tabelaTurmas" class="display" width="100%" cellspacing="0">
	<thead>
          <tr>
            <th>ID</th>
            <th>NOME DO CURSO</th>
            <th>INSTITUIÇÃO</th>
            <th>DATA DE CONCLUSÃO</th>
            <th class="td-icon">EDITAR</th>
          </tr>
	</thead>
    <tbody>
        <c:forEach var="outroCurso" items="${requestScope.outrosCursos}">
          <tr>
            <td>${outroCurso.id}</td>
            <td>${outroCurso.nomeDoCurso}</td>
            <td>${outroCurso.instituicao}</td>
            <td>${outroCurso.dataDeConclusao}</td>
            <td class="td-icon"><a href="/outrosCursos/${outroCurso.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
    </tbody>
</table>
<br />
<br />