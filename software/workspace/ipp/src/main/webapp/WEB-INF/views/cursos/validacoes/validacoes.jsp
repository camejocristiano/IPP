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
			<a href="/sw/cursos/${curso.id}">
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
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="validacao" items="${requestScope.validacoes}">
          <tr>
            <td>${validacao.dataDeEnvio}</td>
            <td>${validacao.dataDaValidacao}</td>
            <td>${validacao.dataDaSolicitacao}</td>
            <td>${validacao.tipoDeValidacao}</td>
            <td class="td-icon"><a href="/sw/loadValidacao/${validacao.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/sw/validacaoCurso/${curso.id}">
                <i class="material-icons">add</i>
            </a>
         </div>
         
         </div>
         
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>