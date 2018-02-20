<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../../partials/header.jsp"></c:import>
<c:import url="../../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	<div class="row">
		<div class="col s12 l12">
			<a href="/sw/fichaProfissional/home/${entrevista.jovem != null ? entrevista.jovem.id : jovem.id}">
				<h4 class="header right black-text">${jovem.nome != null ? jovem.nome : "Jovem"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

<table id="tabelaEntrevistas" class="display">
	<thead>
    	<tr>
            <th>ID</th>
            <th>Motive</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.entrevistaVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="entrevista" items="${requestScope.entrevistas}">
        <tr>
            <td>${entrevista.id}</td>
            <td>${entrevista.motivo}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.entrevistaVisualizar == true}">
    			<c:url value="/sw/entrevista/${entrevista.id}" var="swEntrevistaId"></c:url>
	        	<td class="td-icon"><a href="${swEntrevistaId}"><i class="material-icons" >border_color</i></a></td>
	        </c:if>
        </tr>
    </c:forEach>
	</tbody>
</table>

            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.entrevistaCadastrar == true}">
	<c:url value="/sw/entrevistaJovem/${jovem.id}" var="swEntrevistaJovemId"></c:url>
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="${swEntrevistaJovemId}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
<br />
<br />
</div><!-- // container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>