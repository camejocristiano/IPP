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
			<c:url value="/sw/financeiros" var="swFinanceiros"></c:url>
			<a href="${swFinanceiros}">
				<h4 class="header right black-text">VRs</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
<table id="tabelaUsuarios" class="display">
        <thead>
          <tr>
            <th>JOVEM</th>
            <th>EMPRESA</th>
            <th>DATA_ADMISSÃO</th>
            <th>STATUS</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="contratacao" items="${requestScope.contratacoes}">
          <tr>
            <td>${contratacao.jovem.nome}</td>
            <td>${contratacao.empresaContratante.nomeFantazia}</td>
            <td>${contratacao.dataDeInicioDaContratacao}</td>
            <td>${contratacao.statusDaContratacao}</td>
            <c:url value="/sw/vr/${contratacao.id}" var="swVrId"></c:url>
            <td class="td-icon"><a href="${swVrId}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
         
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>