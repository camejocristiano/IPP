<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaCursos" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME</th>
            <th class="hide-on-small-only">TURMAS</th>
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
            <td class="hide-on-small-only">${curso.statusDoCurso}</td>
            <td class="td-icon"><a href="/cursos/${curso.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/cursos/form">
                <i class="material-icons">add</i>
            </a>
         </div>