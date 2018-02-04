<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Situações Laborais:</h4>
		 <c:if test="${empty situacoesLaborais}">
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/situacoesLaborais/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
		 </c:if>
	</div>
</div>
<table id="tabelaUnidades" class="display" width="100%" cellspacing="0">
	<thead>
          <tr>
            <th>ID</th>
            <th>JOVEM</th>
            <th class="td-icon">EDITAR</th>
          </tr>
	</thead>
    <tbody>
        <c:forEach var="situacaoLaboral" items="${requestScope.situacoesLaborais}">
          <tr>
            <td>${situacaoLaboral.id}</td>
            <td>${situacaoLaboral.jovem.nome}</td>
            <td class="td-icon"><a href="/situacoesLaborais/${situacaoLaboral.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
    </tbody>
</table>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Aprendizes:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/aprendizes/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<c:import url="../laborais/aprendiz/aprendizes.jsp"></c:import>
<br />
<br />