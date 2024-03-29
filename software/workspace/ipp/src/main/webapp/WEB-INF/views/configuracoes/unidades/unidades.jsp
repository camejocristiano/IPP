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
			<h4 class="header right black-text">Unidades</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

	<table id="tabelaUnidades" class="display">
        <thead>
          <tr>
            <th>CÓDIGO</th>
            <th>NOME FANTAZIA</th>
            <th>E-MAIL</th>
            <th>TELEFONE</th>
            <th>STATUS</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.unidadeVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="unidade" items="${requestScope.unidades}">
          <tr>
            <td>${unidade.id}</td>
            <td>${unidade.nomeFantazia}</td>
            <td>${unidade.email}</td>
            <td>${unidade.telefone}</td>
            <td>${unidade.status}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.unidadeVisualizar == true}">
            	<c:url value="/sw/unidade/${unidade.id}" var="swUnidade"></c:url>
				<td class="td-icon"><a href="${swUnidade}"><i class="material-icons" >border_color</i></a></td>
			</c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table>
	<c:if
		test="${requestScope.usuarioSessao.grupoDePermissoes.unidadeCadastrar == true}">
		<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/unidade/form" var="swUnidadeForm"></c:url>
			<a class="btn-floating btn-large waves-effect waves-light orange"
				href="${swUnidadeForm}"> <i class="material-icons">add</i>
			</a>
		</div>
	</c:if>


</div>  
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>