<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaEscolaridades" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>JOVEM</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="escolaridade" items="${requestScope.escolaridades}">
          <tr>
            <td>${escolaridade.id}</td>
            <td>${escolaridade.jovem.nome}</td>
            <td class="td-icon"><a href="/escolaridades/${escolaridade.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
            <c:if test="${empty escolaridades}">
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/escolaridades/form/${requestScope.jovem.id}">
                <i class="material-icons">add</i>
            </a>
         </div>
         </c:if>