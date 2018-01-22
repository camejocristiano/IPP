<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaMatriculas" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>CANAL</th>
            <th>JOVEM</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="canal" items="${requestScope.canais}">
          <tr>
            <td>${canal.id}</td>
            <td>${canal.canal}</td>
            <td>${canal.jovem}</td>
            <td class="td-icon"><a href="/canais/${canal.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/canal">
                <i class="material-icons">add</i>
            </a>
         </div>