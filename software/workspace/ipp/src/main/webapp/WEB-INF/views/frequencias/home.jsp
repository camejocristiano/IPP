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
			<h4 class="header right black-text">Frequências</h4>
			<br />
			<br />		
			<br />
			<hr />
			<hr />
			<br />
		</div>
	</div>

	<div class="row">
	
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/frequencias/total" var="swFrequenciasTotal"></c:url>
				<a href="${swFrequenciasTotal}">
					<div class="card-content white-text">
						<span class="card-title">Frequências Geral<i
							class="material-icons right" style="color: #eee !important;">check_box</i></span>
						<p>Manutenção de Frequências</p>
					</div>
				</a> 
				<a href="" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">...</h6>
					</div>
				</a>
			</div>
		</div>
		
		<div class="col s12 m6 l4">
			<div class="card blue-grey darken-1">
				<c:url value="/sw/frequencias/turmas" var="swFrequenciasTurmas"></c:url>
				<a href="${swFrequenciasTurmas}">
					<div class="card-content white-text">
						<span class="card-title">Frequências por Turma<i
							class="material-icons right" style="color: #eee !important;">check_box</i></span>
						<p>Manutenção de Frequências</p>
					</div>
				</a> 
				<a href="" class="btn-index">
					<div class="card-action orange-text lighten-5">
						<h6 style="color: #eee;" class="btn-index">...</h6>
					</div>
				</a>
			</div>
		</div>

	</div>
	<div class="row">
		
	
	</div>  

</div>

<c:import url="../../partials/js.jsp"></c:import>
<c:import url="../../partials/footer.jsp"></c:import>
<c:import url="../../partials/final.jsp"></c:import>