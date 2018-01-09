<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h6>Entrevistas</h6>
<c:import url="../entrevistas/entrevistas.jsp"></c:import>
<br />
<hr />
<br />
<h6>Contratações</h6>
<table id="tabelaContratacoes" class="display" width="100%" cellspacing="0">
        <thead>
          <tr>
            <th>ID</th>
            <th>OBSERVACOES</th>
            <th class="td-icon">EDITAR</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="contratacao" items="${requestScope.contratacoes}">
          <tr>
            <td>${contratacao.id}</td>
            <td>${contratacao.contratacaoObservacoes}</td>
            <td class="td-icon"><a href="/contratacoes/${contratacao.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
          </tbody>
          
      </table> 
      
	<div class="fixed-action-btn" style="bottom: 45px; right: 24px;">
            <a class="btn-floating btn-large waves-effect waves-light orange"
                href="/contratacoes/form">
                <i class="material-icons">add</i>
            </a>
         </div>
<br />
<hr />
<br />
<h6>Dispensas</h6>
<c:import url="../dispensas/dispensas.jsp"></c:import> 
