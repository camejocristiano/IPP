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
			<a href="/sw/historicos/home/${jovem.id}">
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
<table id="tabelaOcorrencias" class="display">
	<thead>
    	<tr>
            <th>CÓDIGO</th>
            <th>TIPO</th>
            <th>DATA</th>
            <th>QUEM ADVERTIU</th>
            <th>MOTIVO DA ADVERTÊNCIA</th>
            <th>DETALHES</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaEditar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
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
            	<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaEditar == true}">
            		<td class="td-icon"><a href="/sw/ocorrencia/${ocorrencia.id}"><i class="material-icons" >border_color</i></a></td>
            	</c:if>
        </tr>
    </c:forEach>
    </tbody>    
</table>

            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.ocorrenciaCadastrar == true}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/ocorrencia/form/${jovem.id}" var="swOcorrenciaFormJovemId" />
            <a class="btn-floating btn-large waves-effect waves-light orange" href="${swOcorrenciaFormJovemId}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
<br />
<br />
</div><!-- // Container -->
<c:import url="../../../../partials/js.jsp"></c:import>
<c:import url="../../../../partials/footer.jsp"></c:import>
<c:import url="../../../../partials/final.jsp"></c:import> 