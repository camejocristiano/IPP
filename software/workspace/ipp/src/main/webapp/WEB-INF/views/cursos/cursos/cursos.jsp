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
			<h4 class="header right black-text">Cursos</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>
	
<table id="tabelaCursos" class="display">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME</th>
            <th class="hide-on-small-only">Nome do Curso</th>
            <th class="hide-on-small-only">STATUS</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="curso" items="${requestScope.cursos}">
          <tr>
            <td>${curso.id}</td>
            <td>${curso.nomeDoCurso}</td>
            <td class="hide-on-small-only"></td>
            <td class="hide-on-small-only">${curso.status}</td>
            <c:url value="/sw/homeCurso/${curso.id}" var="swCursoId"></c:url>
            <td class="td-icon"><a href="${swCursoId}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
			<c:url value="/sw/curso/form" var="swCursoForm"></c:url>
            <a class="btn-floating btn-large waves-effect waves-light orange" href="${swCursoForm}">
                <i class="material-icons">add</i>
            </a>
         </div>

	
</div>

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>