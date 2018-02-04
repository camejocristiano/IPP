<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaEntrevistas" class="display" width="100%" cellspacing="0">
	<thead>
    	<tr>
            <th>ID</th>
            <th>Motive</th>
            <th class="td-icon">EDITAR</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="entrevista" items="${requestScope.entrevistas}">
        <tr>
            <td>${entrevista.id}</td>
            <td>${entrevista.motivo}</td>
            <td class="td-icon"><a href="/entrevistas/${entrevista.id}"><i class="material-icons" >border_color</i></a></td>
        </tr>
    </c:forEach>
	</tbody>
</table>