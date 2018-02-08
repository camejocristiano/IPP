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
            <th class="td-icon">EDITAR</th>
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
            <td class="td-icon"><a href="/sw/unidades/${unidade.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/sw/unidades/form">
                <i class="material-icons">add</i>
            </a>
         </div>
         
         
	</div>  
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>