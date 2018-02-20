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
			<h4 class="header right black-text">Arquivos</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaArquivos" class="display">
        <thead>
          <tr>
            <th>NOME DO ARQUIVO</th>
            <th>LOCAL DO ARQUIVO</th>
            <c:if test="${usuarioSessao.grupoDePermissoes.arquivoVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="arquivo" items="${requestScope.arquivos}">
          <tr>
            <td>${arquivo.nomeDoArquivo}</td>
            <td>${arquivo.localDoArquivo}</td>
            <c:if test="${usuarioSessao.grupoDePermissoes.arquivoVisualizar == true}">
				<c:url value="/sw/arquivo/${arquivo.nomeDoArquivo != null ? arquivo.id : null}" var="swArquivoId"></c:url>
            	<td class="td-icon"><a href="${swArquivoId}"><i class="material-icons" >border_color</i></a></td>
            </c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
    
            <c:if test="${usuarioSessao.grupoDePermissoes.arquivoCadastrar == true}">  
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/arquivo/form" var="swArquivoForm"></c:url>x
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="${swArquivoForm}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
         
         
	</div>  
<c:import url="../../../partials/js.jsp"></c:import>

<c:import url="../../../partials/footer.jsp"></c:import>