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
		<div class="col s12">
			<ul class="tabs">
				<li class="tab col s3"><a href="#parametros">Parâmetros</a></li>
				<li class="tab col s1"><a href="#demonstrativos">D</a></li>
				<li class="tab col s1"><a href="#vts">T</a></li>
				<li class="tab col s2"><a href="#vrs">VR</a></li>
				<li class="tab col s1"><a href="#salarios1.53">13º</a></li>
				<li class="tab col s1"><a href="#pagar">P</a></li>
				<li class="tab col s2"><a href="#receber">Rec</a></li>
				<li class="tab col s1"><a href="#bancos">B</a></li>
			</ul>
			
	<br /> 
	
	<br />
		</div>
		<div id="parametros" class="col s12">
			<c:import url="parametros/parametros.jsp"></c:import>
		</div>
		<div id="demonstrativos" class="col s12">
			<c:import url="demonstrativos/demonstrativos.jsp"></c:import>
		</div>
		<div id="vts" class="col s12">
			<c:import url="vts/vts.jsp"></c:import>
		</div>
		<div id="vrs" class="col s12">
			<c:import url="vrs/vrs.jsp"></c:import>
		</div>
		<div id="salarios13" class="col s12">
			<c:import url="salarios/salarios.jsp"></c:import>
		</div>
		<div id="pagar" class="col s12">
			<c:import url="pagar/contas.jsp"></c:import>
		</div>
		<div id="receber" class="col s12">
			<c:import url="receber/contas.jsp"></c:import>
		</div>
		<div id="bancos" class="col s12">
			<c:import url="bancos/bancos.jsp"></c:import>
		</div>
	</div>
</div>

<c:import url="../../partials/js.jsp"></c:import>

<c:import url="../../partials/footer.jsp"></c:import>