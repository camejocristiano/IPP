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
		<div class="col s12">
			<ul class="tabs">
				<li class="tab col s2"><a href="#empresa">Empresa</a></li>
				<li class="tab col s2"><a href="#gestores">Gestores</a></li>
				<li class="tab col s2"><a href="#contatos">Contatos</a></li>
				<li class="tab col s2"><a href="#representantes">Representantes</a></li>
			</ul>
			
	<br /> 
	
	<br />
		</div>
		<div id="empresa" class="col s12">
			<c:import url="form.jsp"></c:import>
		</div>
		<div id="gestores" class="col s12">
			<c:import url="../gestores/gestores.jsp"></c:import>
		</div>
		<div id="contatos" class="col s12">
			<c:import url="../contatos/contatos.jsp"></c:import>
		</div>
		<div id="representantes" class="col s12">
			<c:import url="../representantes/representantes.jsp"></c:import>
		</div>
	</div>
</div>

<c:import url="../../../partials/js.jsp"></c:import>

<c:import url="../../../partials/footer.jsp"></c:import>
<c:import url="../../../partials/final.jsp"></c:import>