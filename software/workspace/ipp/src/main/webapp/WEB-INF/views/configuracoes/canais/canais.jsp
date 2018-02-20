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
			<h4 class="header right black-text">Canais</h4>
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
            <th>ID</th>
            <th>NOME DO CANAL</th>
            <c:if test="${usuarioSessao.grupoDePermissoes.canalVisualizar == true}"></c:if>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="canal" items="${requestScope.canais}">
          <tr>
            <td>${canal.id}</td>
            <td>${canal.nomeCanal}</td>
            <c:if test="${usuarioSessao.grupoDePermissoes.canalVisualizar == true}">
            	<td class="td-icon"><a href="/sw/canal/${canal.id}"><i class="material-icons" >border_color</i></a></td>
          	</c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 

      <c:if test="${usuarioSessao.grupoDePermissoes.canalVisualizar == true}">      
		<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/sw/canal/form">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
         
         
	</div>  
<c:import url="../../../partials/js.jsp"></c:import>

<c:import url="../../../partials/footer.jsp"></c:import>