<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Foi acrescentado direto na página habilidades;
Sem funcionamento do table jquery;
Arquivo desativado momentaneamente; -->

<table id="tabelaMatriculas" class="display">
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