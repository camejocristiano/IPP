<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaGestores" class="display">
	<thead>
    	<tr>
            <th>ID</th>
            <th>JOVEM</th>
            <th class="td-icon">EDITAR</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="avaliacaoPAP" items="${requestScope.avaliacoesPAPsIPP}">
    	<tr>
            <td>${avaliacaoPAP.id}</td>
            <td>${avaliacaoPAP.jovem.nome}</td>
            <td class="td-icon"><a href="/avaliacoesPAPs/${avaliacaoPAP.id}"><i class="material-icons" >border_color</i></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>