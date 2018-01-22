<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Fichas Sociais:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/fichasSociais/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<table id="tabelaFichasSociais" class="display" width="100%" cellspacing="0">
	<thead>
          <tr>
            <th>ID</th>
            <th>PARECER CONCLUSIVO</th>
            <th class="td-icon">EDITAR</th>
          </tr>
	</thead>
    <tbody>
        <c:forEach var="fichaSocial" items="${requestScope.fichasSociais}">
          <tr>
            <td>${fichaSocial.id}</td>
            <td>${fichaSocial.parecerConclusivo}</td>
            <td class="td-icon"><a href="/fichasSociais/${fichaSocial.id}"><i class="material-icons" >border_color</i></a></td>
          </tr>
          </c:forEach>
    </tbody>
</table>
<br />
<br />

<div class="row">
	<div class="input-field  s12 col l12" style="border-bottom: 2px solid orange;">
		 <h4 class="header right orange-text">Familiares:</h4>
 		 <a class="btn-floating btn-large waves-effect waves-light orange" href="/familiares/form/${jovem.id}">
		 	<i class="material-icons">add</i>
		 </a>
	</div>
</div>
<c:import url="../sociais/familiares/familiares.jsp"></c:import>
<br />
<br />