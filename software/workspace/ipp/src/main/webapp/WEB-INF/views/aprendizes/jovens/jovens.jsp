<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<table id="tabelaJovens" class="display">
        <thead>
          <tr>
            <th>MATRÍCULA</th>
            <th>CÓD.JOVEM</th>
            <th>NOME</th>
            <th>E-MAIL</th>
            <th>TELEFONE</th>
            <th>STATUS</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="jovem" items="${requestScope.jovens}">
          <tr>
            <td>MATRICULA</td>
            <td>${jovem.id}</td>
            <td>${jovem.nome}</td>
            <td>${jovem.email}</td>
            <td>${jovem.telefone}</td>
            <td>${jovem.status}</td>
            <td class="td-icon"><a href="/jovens/${jovem.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/jovens/form">
                <i class="material-icons">add</i>
            </a>
         </div>