<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaOcorrencias" class="display" width="100%" cellspacing="0">
	<thead>
    	<tr>
            <th>CÓDIGO</th>
            <th>TIPO</th>
            <th>DATA</th>
            <th>QUEM ADVERTIU</th>
            <th>MOTIVO DA ADVERTÊNCIA</th>
            <th>DETALHES</th>
            <th class="td-icon">EDITAR</th>
        </tr>
	</thead>
    <tbody>
    <c:forEach var="ocorrencia" items="${requestScope.ocorrencias}">
    	<tr>
            <td>${ocorrencia.id}</td>
            <td>${ocorrencia.tipo}</td>
            <td>${ocorrencia.data}</td>
            <td>${ocorrencia.responsavel.nome}</td>
            <td>${ocorrencia.titulo}</td>
            <td>${ocorrencia.descricao}</td>
            <td class="td-icon"><a href="/ocorrencias/${ocorrencia.id}"><i class="material-icons" >border_color</i></a></td>
        </tr>
    </c:forEach>
    </tbody>    
</table> 