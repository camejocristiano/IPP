<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaUsuarios" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME</th>
            <th>USERNAME</th>
            <th class="hide-on-small-only">TELEFONE</th>
            <th class="hide-on-small-only">STATUS</th>
            <th class="td-icon">EDITAR</th>
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
            <td class="td-icon"><a href="/usuarios/${usuario.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/usuarios/form">
                <i class="material-icons">add</i>
            </a>
         </div>
