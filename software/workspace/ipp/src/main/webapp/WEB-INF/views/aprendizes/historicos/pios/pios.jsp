<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaCanais" class="display">
	<thead>
    	<tr>
            <th>ID</th>
            <th>JOVEM</th>
            <th class="td-icon">EDITAR</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="avaliacaoPIO" items="${requestScope.avaliacoesPIOs}">
    	<tr>
            <td>${avaliacaoPIO.id}</td>
            <td>${avaliacaoPIO.jovem.nome}</td>
            <td class="td-icon"><a href="/avaliacoesPIOs/${avaliacaoPIO.id}"><i class="material-icons" >border_color</i></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>