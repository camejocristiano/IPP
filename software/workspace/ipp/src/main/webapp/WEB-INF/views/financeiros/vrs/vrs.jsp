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
            <th>INÍCIO</th>
            <th>TÉRMINO</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.vrVisualizar == true}">
            	<th class="td-icon">MÊS</th>
            	<th class="td-icon">OUTROS</th>
            </c:if>	
          </tr>
        </thead>
        <tbody>
        <c:forEach var="contratacao" items="${requestScope.contratacoes}">
          <tr>
            <td>${contratacao.fichaProfissional.jovem.nome}</td>
            <td>${contratacao.empresaContratante.nomeFantazia}</td>
            <td>${contratacao.diaDeInicioDaContratacao}/${contratacao.mesDeInicioDaContratacao}/${contratacao.anoDeInicioDaContratacao}</td>
            <td>${contratacao.diaTerminoDoContrato}/${contratacao.diaTerminoDoContrato}/${contratacao.diaTerminoDoContrato}</td>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.vrVisualizar == true}">
            	<c:url value="/sw/vr/${contratacao.id}" var="swVRId"></c:url>
            	<td class="td-icon"><a href="${swVRId}"><i class="material-icons" >border_color</i></a></td>
            	<c:url value="/sw/vrs/${contratacao.id}" var="swVRId"></c:url>
            	<td class="td-icon"><a href="${swVRId}"><i class="material-icons" >border_color</i></a></td>
            </c:if>
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