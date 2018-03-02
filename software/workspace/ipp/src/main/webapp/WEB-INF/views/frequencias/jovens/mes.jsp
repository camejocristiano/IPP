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
			<c:url value="/sw/frequencias/mes/${matricula.turma.id}" var="swFrequenciasMesJovemId"></c:url>
			<a href="${swFrequenciasMesJovemId}">
				<h4 class="header right black-text">${matricula.jovem.nome != null ? matricula.jovem.nome : 'Jovem'}</h4>
			</a>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>


<table id="tabelaTurmas" class="display">
	<thead>
		<tr>
			<th>DIA</th>
			<th>TURNO</th>
	    	<th>FREQUÊNCIA</th>
		    <th>FALTAS</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.frequencias}" var="frequencia">
			<tr>
				<td>${frequencia.dia}</td>
				<td>${frequencia.tipoDeInsercao}</td>
				<td>${frequencia.comparecido == true ? 'C' : 'F'}</td>
				<c:if test="${frequencia.comparecido == false}">
				  	<input type="hidden" value="${total = total + 1}" />
				</c:if>
				<td class="td-icon">
					<a href="/sw/frequencia/${frequencia.id}">
						<i class="material-icons">border_color</i>
					</a>
				</td>
			</tr>
		</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>${total}</td>
			</tr>
	</tbody>

</table>
</div>  

<c:import url="../../../partials/js.jsp"></c:import>
<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>