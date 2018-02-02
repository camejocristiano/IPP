<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<table id="tabelaUnidades" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>NOME</th>
            <th>USERNAME</th>
            <th>ADMIN</th>
            <th class="td-icon">TELEFONE</th>
            <th class="td-icon">STATUS</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="unidade" items="${requestScope.unidades}">
          <tr>
            <td>${unidade.id}</td>
            <td>${unidade.nomeFantazia}</td>
            <td>${unidade.razaoSocial}</td>
            <td>${unidade.email}</td>
            <td class="td-icon">11 879 546 213</td>
            <td class="td-icon">ATIVO</td>
            <td class="td-icon"><a href="/unidades/${unidade.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/unidade">
                <i class="material-icons">add</i>
            </a>
         </div>