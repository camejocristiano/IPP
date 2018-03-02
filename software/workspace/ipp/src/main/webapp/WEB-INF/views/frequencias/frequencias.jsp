<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="../../partials/header.jsp"></c:import>
<c:import url="../../partials/navbar.jsp"></c:import>

<div class="container" id="main-container-content">

<div class="row">
		<div class="col s12 l12">
			<h4 class="header right black-text">Turmas</h4>
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
			<th>MATRÍCULA</th>
			<th>DIA</th>
			<th>MÊS</th>
			<th>ANO</th>
			<th>TIPO_DE_INSERÇÃO</th>
			<th>FREQUÊNCIA</th>
			<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.frequenciaVisualizar == true}">
				<th class="td-icon">EDIT</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="frequencia" items="${requestScope.frequencias}">
			<tr>
				<td>${frequencia.matricula.jovem.nome}</td>
				<td>${frequencia.dia}</td>
				<td>${frequencia.mes}</td>
				<td>${frequencia.ano}</td>
				<td>${frequencia.tipoDeInsercao}</td>
				<td>${frequencia.frequencia}</td>
				<c:if test="${requestScope.usuarioSessao.grupoDePermissoes.frequenciaVisualizar == true}">
					<td class="td-icon">
						<c:url value="/sw/frequencia/${frequencia.id}" var="swFrequenciaId"></c:url>
						<a href="${swFrequenciaId}">
							<i class="material-icons">border_color</i>
						</a>
					</td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>

</table>
</div>  

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>