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
			<c:url value="/sw/empresa/${empresa.id}" var="swEmpresaId"></c:url>
			<a href="${swEmpresaId}">
				<h4 class="header right black-text">${empresa.nomeFantazia != null ? empresa.nomeFantazia : "Empresa"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>
<table id="tabelaGestores" class="display">
        <thead>
          <tr>
            <th>DATA DO HISTÓRICO</th>
            <th>DESCRIÇÃO DO HISTÓRICO</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.historicosVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="historico" items="${requestScope.historicos}">
          <tr>
            <td>${historico.dataDoHistorico}</td>
            <td>${historico.descricaoDoHistorico}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.historicosVisualizar == true}">
            	<c:url value="/sw/historico/empresa/${historico.id}" var="swHistoricoId"></c:url>
				<td class="td-icon"><a href="${swHistoricoId}"><i class="material-icons" >border_color</i></a></td>
			</c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.historicosCadastrar == true}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/historico/empresa/form/${requestScope.empresa.id}" var="swHistoricoEmpresaId"></c:url>
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="${swHistoricoEmpresaId}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
 </div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>