<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../../partials/header.jsp"></c:import>
<c:import url="../../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">Turma ${turma.numeroTurma}</h4>
			<br /> 
			<br />		
			<br />
			<hr />
			<hr />
			<h5 class="header black-text">Orientador: ${turma.orientadorTurma.nome}</h5>
			<br />
		</div>
	</div>

<table id="tabelaTurmas" class="display">
	<thead>
		<tr>
			<th>MATRÍCULA</th>
			<th>JOVEM</th>
			<c:forEach var="frequencia" items="${requestScope.frequencias}">
			    <th>P</th>
			</c:forEach>
    		<th>TOTAL</th>
		    <th>EDIT</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="entry" items="${requestScope.hash}">
	    	<input type="hidden" value="${total = total - total}" />
		    <tr>
				<td>${entry.key.id}</td>
			    <td>${entry.key.jovem.nome}</td>
			  	<c:forEach items="${entry.value}" var="test">
			    	<td>${test.comparecido == true ? 'C' : 'F'}</td>
				    <c:if test="${test.comparecido == false}">
				    	<input type="hidden" value="${total = total + 1}" />
				    </c:if>
			    </c:forEach>
				<td>${total}</td>
				<td class="td-icon">
					<a href="/sw/frequencias/jovem/mes/${entry.key.id}">
						<i class="material-icons">border_color</i>
					</a>
				</td>
			</tr>
    	<input type="hidden" value="${totall = totall + total}" />
		</c:forEach>

	</tbody>

</table>
<br />
<br />
<h5 class="header right black-text">Total: ${totall}</h5>
<br />
<br />
</div>  

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>