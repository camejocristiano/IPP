<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>
<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">Jovens</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaJovens" class="display">
        <thead>
          <tr>
            <th>MATRÍCULA</th>
            <th>CÓD.JOVEM</th>
            <th>NOME</th>
            <th>E-MAIL</th>
            <th>TELEFONE</th>
            <th>STATUS</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.jovemVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="jovem" items="${requestScope.jovens}">
          <tr>
            <td>MATRICULA</td>
            <td>${jovem.id}</td>
            <td>${jovem.nome}</td>
            <td>${jovem.username}</td>
            <td>${jovem.telefone}</td>
            <td>${jovem.status}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.jovemVisualizar == true}">
            	<c:url value="/sw/jovem/${jovem.id}" var="jovemFormId" />
            	<td class="td-icon"><a href="${jovemFormId}"><i class="material-icons" >border_color</i></a></td>
          	</c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.jovemCadastrar == true}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/jovem/form" var="jovemForm" />
            <a class="btn-floating btn-large waves-effect waves-light orange" href="${jovemForm}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>
         
    	</div>  

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>