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
				<h4 class="header right black-text">Contas à Pagar</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
	</div>
</div>

<table id="tabelaContasAPagar" class="display">
        <thead>
          <tr>
            <th>ID</th>
            <th>TESTE</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="conta" items="${requestScope.contas}">
          <tr>
            <td>${conta.id}</td>
            <td>${conta.nomeFantazia}</td>
            <c:url value="/sw/conta/${conta.id}" var="swContaId"></c:url>
            <td class="td-icon"><a href="${swContaId}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/conta/form" var="swContaForm"></c:url>
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="${swContaForm}">
                <i class="material-icons">add</i>
            </a>
         </div>
         
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>