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
			<c:url value="/sw/homeCursos/${curso.id}" var="swCursoId"></c:url>
			<a href="${swCursoId}">
				<h4 class="header right black-text">${curso.nomeDoCurso != null ? curso.nomeDoCurso : "CBO"}</h4>
			</a>
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
            <th>TITULO</th>
            <th>NUMERO</th>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.cboVisualizar == true}">
            	<th class="td-icon">EDITAR</th>
            </c:if>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="cbo" items="${requestScope.cbos}">
          <tr>
            <td>${cbo.id}</td>
            <td>${cbo.titulo}</td>
            <td>${cbo.numero}</td>
            <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.cboVisualizar == true}">
            	<c:url value="/sw/cbo/${cbo.id}" var="swCbosId"></c:url>
				<td class="td-icon"><a href="${swCbosId}"><i class="material-icons" >border_color</i></a></td>
			</c:if>
          </tr>
        </c:forEach>
        </tbody>
      </table> 
      <c:if test="${requestScope.usuarioSessao.grupoDePermissoes.cboCadastrar == true}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
    	<c:url value="/sw/cbo/form" var="swCbosForm"></c:url>
		<a class="btn-floating btn-large waves-effect waves-light orange" href="${swCbosForm}">
                <i class="material-icons">add</i>
        </a>
    </div>
    </c:if>
<br />
<br />
	</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>