<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">
	
	<div class="row">
		<div class="col s12 l12">
			<c:url value="/sw/homeCurso/${curso.id}" var="swHomeCursoCursoId"></c:url>
			<a href="${swHomeCursoCursoId}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "Validações"}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

<table id="tabelaCanais" class="display">
        <thead>
          <tr>
            <th>DATA DE ENVIO</th>
            <th>DATA DA VALIDAÇÃO</th>
            <th>DATA DA SOLICITAÇÃO</th>
            <th>TIPO</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.validacaoVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="validacao" items="${requestScope.validacoes}">
          <tr>
            <td>${validacao.dataDeEnvio}</td>
            <td>${validacao.dataDaValidacao}</td>
            <td>${validacao.dataDaSolicitacao}</td>
            <td>${validacao.tipoDeValidacao}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.validacaoVisualizar == true}">
            	<c:url value="/sw/loadValidacao/${validacao.id}" var="swLoadValidacaoId"></c:url>
            	<td class="td-icon"><a href="${swLoadValidacaoId}"><i class="material-icons" >border_color</i></a></td>
            </c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.validacaoCadastrar == true}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/sw/validacaoCurso/${curso.id}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
         
         </div>
         
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>