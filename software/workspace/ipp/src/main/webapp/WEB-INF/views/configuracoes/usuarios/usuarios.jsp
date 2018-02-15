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
			<h4 class="header right black-text">Usuários</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaUsuarios" class="display">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME</th>
            <th>E-Mail</th>
            <th class="hide-on-small-only">TELEFONE</th>
            <th class="hide-on-small-only">STATUS</th>
            <c:if test="${usuarioSessao.grupoDePermissoes.usuarioVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="usuario" items="${requestScope.usuarios}">
          <tr>
            <td>${usuario.id}</td>
            <td>${usuario.nome}</td>
            <td>${usuario.username}</td>
            <td class="hide-on-small-only">${usuario.telefone}</td>
            <td class="hide-on-small-only">${usuario.status}</td>
            <c:if test="${usuarioSessao.grupoDePermissoes.usuarioVisualizar == true}">
				<c:url value="/sw/usuario/${usuario.id}" var="swUsuario"></c:url>
            	<td class="td-icon"><a href="${swUsuario}"><i class="material-icons" >border_color</i></a></td>
            </c:if>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      	<c:if test="${usuarioSessao.grupoDePermissoes.usuarioCadastrar == true}">
			<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/usuario/form" var="swUsuarioForm"></c:url>
	            <a class="btn-floating btn-large waves-effect waves-light orange" href="${swUsuarioForm}">
	                <i class="material-icons">add</i>
	            </a>
         	</div>
		</c:if>
	</div>  
<br />
<br />
<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>