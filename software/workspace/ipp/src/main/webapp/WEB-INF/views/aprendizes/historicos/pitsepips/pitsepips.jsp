<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaUnidades" class="display">
	<thead>
    	<tr>
            <th>ID</th>
            <th>TIPO DE AVALIAÇÂO</th>
            <th class="td-icon">EDITAR</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="avaliacaoPITEPIP" items="${requestScope.avaliacoesPITsEPIPs}">
    	<tr>
            <td>${avaliacaoPITEPIP.id}</td>
            <td>${avaliacaoPITEPIP.tipoAvaliacao}</td>
            <td class="td-icon"><a href="/avaliacoesPITsEPIPs/${avaliacaoPITEPIP.id}"><i class="material-icons" >border_color</i></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>