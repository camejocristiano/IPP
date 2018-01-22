<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaContasAPagar" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>TESTE</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="conta" items="${requestScope.contasAPagar}">
          <tr>
            <td>${conta.id}</td>
            <td>${conta.test}</td>
            <td class="td-icon"><a href="/contasAPagar/${conta.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/contasAPagar/form">
                <i class="material-icons">add</i>
            </a>
         </div>