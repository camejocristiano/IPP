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
			<a href="/sw/fichaProfissional/home/${contratacao.jovem != null ? contratacao.jovem.id : jovem.id}">
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

<table id="tabelaContratacoes" class="display">
    <thead>
          <tr>
            <th>ID</th>
            <th>OBSERVACOES</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.contratacaoVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
    </thead>
    <tbody>
        <c:forEach var="contratacao" items="${requestScope.contratacoes}">
          <tr>
            <td>${contratacao.id}</td>
            <td>${contratacao.observacoes}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.contratacaoVisualizar == true}">
            	<c:url value="/sw/contratacao/${contratacao.id}" var="swContratacaoId"></c:url>
            	<td class="td-icon"><a href="${swContratacaoId}"><i class="material-icons" >border_color</i></a></td>
            </c:if>
          </tr>
          </c:forEach>
	</tbody>
</table>
<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.contratacaoCadastrar == true}">
<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
	<c:url value="/sw/contratacaoJovem/${jovem.id}" var="swContratacaoJovemId"></c:url>
	<a class="btn-floating btn-large waves-effect waves-light orange" href="${swContratacaoJovemId}">
    	<i class="material-icons">add</i>
    </a>
</div>
</c:if>
</div><!-- // container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import>