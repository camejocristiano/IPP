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
			<c:url value="/sw/jovem/${jovem.id}" var="swJovemJovemId"></c:url>
			<a href="${swJovemJovemId}">
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

<table id="tabelaFamiliares" class="display">
	<thead>
          <tr>
            <th>ID</th>
            <th>Nome Familiar</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.familiarVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
	</thead>
    <tbody>
        <c:forEach var="familiar" items="${requestScope.familiares}">
          <tr>
            <td>${familiar.id}</td>
            <td>${familiar.nomeFamiliar}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.familiarVisualizar == true}">
            	<c:url value="/sw/familiar/${familiar.id}" var="swFamiliarId"></c:url>
            	<td class="td-icon"><a href="${swFamiliarId}"><i class="material-icons" >border_color</i></a></td>
            </c:if>
          </tr>
        </c:forEach>
	</tbody>
</table> 

     <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.familiarCadastrar == true}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <c:url value="/sw/familiar/form/${jovem.id}" var="swArcoForm"></c:url>
			<a class="btn-floating btn-large waves-effect waves-light orange" href="${swArcoForm}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
       
         
<br />
<br />
	</div>

<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>