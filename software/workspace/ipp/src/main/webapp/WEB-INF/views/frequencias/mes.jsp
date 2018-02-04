<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table border="1">
<tr>
	<th>MATRÍCULA</th>
	<c:forEach var="cabecalho" items="${requestScope.cabecalho}">
			<th>${cabecalho.dia}</th>
			<th>M</th>
			<th>T</th>
	</c:forEach>
</tr>
<c:forEach var="frequencia" items="${requestScope.frequencias}">
<tr>
	<td>Matrícula</td>
<c:forEach var="freq" items="${frequencia}">
		<td> -> </td>
		<td>${freq.frequenciaManha}</td>
		<td>${freq.frequenciaTarde}</td>
</c:forEach>
</tr>
</c:forEach>	
</table>